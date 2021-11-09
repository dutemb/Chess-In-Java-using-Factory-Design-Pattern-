import java.util.*;

public class Pawn extends Piece {
    public Pawn(Color c) {
        if (c == Color.WHITE || c == Color.BLACK) color = c;
        else throw new IllegalArgumentException();

    }
    // implement appropriate methods

    public String toString() {
        if (color == Color.WHITE) return "wp";
        else return "bp";
    }

    public ArrayList < String > moves(Board b, String loc) {
        ArrayList < String > returned = new ArrayList < String > ();
        int colum = loc.charAt(0);
        int row = loc.charAt(1);

        if (color == Color.WHITE) {
            returned = movesWhite(row, colum, b);
        } else if (color == Color.BLACK) {
            returned = movesBlack(row, colum, b);
        }
        return returned;
    }


    private ArrayList < String > movesWhite(int row, int colum, Board b) {
        ArrayList < String > returned = new ArrayList < String > ();
            String move1 = "" + (char)(colum - 1) + (char)(row + 1);
            String move2 = "" + (char)(colum + 1) + (char)(row + 1);
            String move3 = "" + (char)colum + (char)(row + 1);
            String move4 = "" + (char)colum + (char)(row + 2);

            if(isValidMove(move1)){
                Piece p1 = b.getPiece(move1);
                if (p1 != null && p1.color() != color) {
                    returned.add(move1);
                }
            } 
            
            if(isValidMove(move2)){
                Piece p2 = b.getPiece(move2);
                if (p2 != null && p2.color() != color) {
                    returned.add(move2);
                }
            }

            if(isValidMove(move3)) {
                Piece p3 = b.getPiece(move3);
                if (p3 == null) {
                    returned.add(move3);
                    if(isValidMove(move4)){
                        Piece p4 = b.getPiece(move4);
                        if (p4 == null && (char)row == '2') returned.add(move4);
                    }
                 
                }
            } 

        return returned;

    }



    private ArrayList < String > movesBlack(int row, int col, Board b) {
        ArrayList < String > returned = new ArrayList < String > ();

        String move1 = "" + (char)(col - 1) + (char)(row - 1);
        String move2 = "" + (char)(col + 1) + (char)(row - 1); //diagonal
        String move3 = "" + (char)col + (char)(row - 1);
        String move4 = "" + (char)col + (char)(row - 2);


        if (isValidMove(move1)) {
            Piece p1 = b.getPiece(move1);
            if (p1 != null && p1.color() != color) {
                returned.add(move1);
            }
        }

        if (isValidMove(move2)) {
            Piece p2 = b.getPiece(move2);
            if (p2 != null && p2.color() != color) {
                returned.add(move2);
            }
        }

        if (isValidMove(move3)) {
            Piece p3 = b.getPiece(move3);
            if (p3 == null) {
                returned.add(move3);
                if (isValidMove(move4)) {
                    Piece p4 = b.getPiece(move4);
                    if (p4 == null && (char) row == '7') {
                        returned.add(move4);
                    }
                }
            }
        }

        return returned;
    }

}
