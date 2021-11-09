import java.util.*;
public class Board {

    //singleton-only allowed to create 1 instance of class
    private Piece[][] pieces = new Piece[8][8];
    private static Board b = null;
    private LinkedList<BoardListener> observers = new LinkedList<BoardListener>();
    private Board() {}

    public static Board theBoard() {
        if (b != null) return b;
        b = new Board();
        return b;
    }

    // Returns piece at given loc or null if no such piece
    // exists
    public Piece getPiece(String loc) {
        
        int f = loc.charAt(0) - 97;
       // System.out.println("getPiece in Board.java prints file: "+ f);
        int r = loc.charAt(1) - 49;
        checkBounds(f,r);
       // System.out.println("getPiece in Board.java prints row: "+ r);
        return pieces[f][r];
    }

    public void addPiece(Piece p, String loc) {
        //checkBounds(loc);
        int f = loc.charAt(0) - 97;
        int r = loc.charAt(1) - 49;
        checkBounds(f,r);
        if (pieces[f][r] == null) {
            pieces[f][r] = p;
        } else {
            throw new UnsupportedOperationException();
        }
    }
    private void checkBounds( int f, int r) {
        if ( f>7 || f < 0) throw new IndexOutOfBoundsException();
        if ( r>7 || r < 0) throw new IndexOutOfBoundsException();
    }

    public void movePiece(String from, String to) {
        Piece fromP = getPiece(from);
        Piece toP = getPiece(to);

        if (fromP == null) throw new UnsupportedOperationException();
        List < String > moves = fromP.moves(b, from);
        if (!moves.contains(to)) throw new UnsupportedOperationException();

        for(BoardListener o : observers){
            o.onMove(from,to,fromP);
        }

        if(toP != null){
           for(BoardListener k : observers){
              k.onCapture(fromP,toP);
           }
        }

        deletePiece(to);
        addPiece(fromP, to);
        deletePiece(from);

    }

    private void deletePiece(String loc) {
        if (pieces[loc.charAt(0) - 97][loc.charAt(1) - 49] != null)
            pieces[loc.charAt(0) - 97][loc.charAt(1) - 49] = null;
    }

    public void clear() {
        int size = pieces.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                pieces[i][j] = null;
            }
        }
    }

    public void registerListener(BoardListener bl) {
        observers.add(bl);
    }

    public void removeListener(BoardListener bl) {
        observers.remove(bl);
    }

    public void removeAllListeners() {
        observers.clear();
    }

    public void iterate(BoardExternalIterator bi) {
          for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String move = "" + (char)(j + 97) + (char)(i + 49);
                Piece piece = getPiece(move);
                bi.visit(move, piece);
            }
        }
    }
}