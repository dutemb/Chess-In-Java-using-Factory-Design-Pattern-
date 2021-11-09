import java.util.*;
abstract public class Piece {
    protected Color color;
    private static HashMap < Character, PieceFactory > info = new HashMap < > ();


    public static void registerPiece(PieceFactory pf) {
        Character ch = pf.symbol();
        info.put(ch, pf);
    }

    public static Piece createPiece(String name) {
        Color col;

        if (name.charAt(0) == 'w') col = Color.WHITE;
        else if (name.charAt(0) == 'b') col = Color.BLACK;
        else throw new RuntimeException();
        
        Character type = name.charAt(1);
        return info.get(type).create(col);
    }

    public Color color() {
        return color;
    }

    abstract public String toString();

    abstract public List < String > moves(Board b, String loc);

    protected boolean isValidMove(String loc){
        int f = loc.charAt(0) - 97;
        int r = loc.charAt(1) - 49;
         if ( f>7 || f < 0) return false;
         if ( r>7 || r< 0) return false;
         return true;
    }

    protected ArrayList <String> movesRight(Board b, String loc, ArrayList past){
        int column = loc.charAt(0) - 97;
        int row = loc.charAt(1) - 49;

        ArrayList<String> returned = new ArrayList<>();
        
         for (int i = column+1; i <8; i++) {
            char oneChar = (char)(i+97);
            String move = "" + oneChar +loc.charAt(1);

            if(isValidMove(move) && !past.contains(move)){
            Piece p1 = b.getPiece(move);
            if (p1 == null) {
                returned.add(move);
            } else if (p1.color != color) {
                returned.add(move);
                break;
            } else {
                break;
            }
         }
      }
      return returned;
    }

 
        protected ArrayList <String> movesLeft(Board b, String loc, ArrayList past){
        int column = loc.charAt(0) - 97;
        int row = loc.charAt(1) - 49;

        ArrayList<String> returned = new ArrayList<>();
        
         for (int i = column-1; i >-1; i--) {
            char oneChar = (char)(i+97);
            String move = "" + oneChar +loc.charAt(1);

            if(isValidMove(move) && !past.contains(move)){
            Piece p1 = b.getPiece(move);
            if (p1 == null) {
                returned.add(move);
            } else if (p1.color != color) {
                returned.add(move);
                break;
            } else {
                break;
            }
         }
      }
      return returned;
    }


        protected ArrayList <String> movesUp(Board b, String loc, ArrayList past){
        int column = loc.charAt(0) - 97;
        int row = loc.charAt(1) - 49;

        ArrayList<String> returned = new ArrayList<>();

         for (int i = row+1; i <8; i++) {
            char oneChar = (char)(i+49);
            String move = "" + loc.charAt(0) + oneChar;
            if(isValidMove(move) && !(past.contains(move))){
            Piece p1 = b.getPiece(move);
            if (p1 == null) {
                returned.add(move);
            } else if (p1.color != color) {
                returned.add(move);
                break;
            } else {
                break;
            }
         }
      }
      return returned;
    }

    
    protected ArrayList <String> movesDown(Board b, String loc, ArrayList past){
        int column = loc.charAt(0) - 97;
        int row = loc.charAt(1) - 49;

        ArrayList<String> returned = new ArrayList<>();
        
         for (int i = row-1; i >-1; i--) {
            char oneChar = (char)(i+49);
            String move = "" + loc.charAt(0) + oneChar;

            if(isValidMove(move) && !past.contains(move)){
            Piece p1 = b.getPiece(move);
            if (p1 == null) {
                returned.add(move);
            } else if (p1.color != color) {
                returned.add(move);
                break;
            } else {
                break;
            }
         }
      }
      return returned;
    }

     
    protected ArrayList<String> diagonalMoves(Board b, String loc, ArrayList past){

        int column = loc.charAt(0) - 97;
        int row = loc.charAt(1) - 49;

        ArrayList<String> returned = new ArrayList<>();

        for (int j = column - 1, i = row - 1; j > -1 && i > -1; j--, i--) {
            char newRow = (char)(i+49);
            char newCol = (char)(j+97);
            String move = "" + newCol + newRow;

            if(isValidMove(move) && !past.contains(move)){
            Piece p1 = b.getPiece(move);
            if (p1 == null) {
                returned.add(move);
            } else if (p1.color != color) {
                returned.add(move);
                break;
            } else {
                break;
            }
         }
        }

        for (int j = column + 1, i = row - 1; j < 8 && i > -1; j++, i--) {
           char newRow = (char)(i+49);
            char newCol = (char)(j+97);
            String move = "" + newCol + newRow;

            if(isValidMove(move) && !past.contains(move)){
            Piece p1 = b.getPiece(move);
            if (p1 == null) {
                returned.add(move);
            } else if (p1.color != color) {
                returned.add(move);
                break;
            } else {
                break;
            }
         }

      }

         for (int j = column + 1, i = row + 1; j < 8 && i < 8; j++, i++) {
            char newRow = (char)(i+49);
            char newCol = (char)(j+97);
            String move = "" + newCol + newRow;

            if(isValidMove(move) && !past.contains(move)){
            Piece p1 = b.getPiece(move);
            if (p1 == null) {
                returned.add(move);
            } else if (p1.color != color) {
                returned.add(move);
                break;
            } else {
                break;
            }
         }

      }


       for (int i = column - 1, j = row + 1; i >-1 && j < 8; j++, i--) {
            char newRow = (char)(j+49);
            char newCol = (char)(i+97);
            String move = "" + newCol + newRow;

            if(isValidMove(move) && !past.contains(move)){
            Piece p1 = b.getPiece(move);
            if (p1 == null) {
                returned.add(move);
            } else if (p1.color != color) {
                returned.add(move);
                break;
            } else {
                break;
            }
         }

      }

      return returned;
    }
    
}