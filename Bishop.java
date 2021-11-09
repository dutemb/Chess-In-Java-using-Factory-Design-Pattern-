import java.util.*;

public class Bishop extends Piece {
    public Bishop(Color c) { 
        if (c == Color.BLACK || c == Color.WHITE) color = c;
        else throw new UnsupportedOperationException();
    }
    // implement appropriate methods

    public String toString() {
        if (color == Color.WHITE) return "wb";
        else  return "bb";
    }

    public List<String> moves(Board b, String loc) {
        ArrayList<String> returned = new ArrayList<String>();
        returned = diagonalMoves(b,loc,returned);
	    return returned;
    }

}