import java.util.*;

public class Queen extends Piece {
    public Queen(Color c) { 
        if (c == Color.BLACK || c == Color.WHITE) color = c;
        else throw new UnsupportedOperationException();
    }
  

    public String toString() {
	 if (color == Color.WHITE) return "wq";
     else  return "bq";
    }

    public List<String> moves(Board b, String loc) {
	  
        ArrayList<String> returned = new ArrayList<String>();
        returned = diagonalMoves(b,loc,returned);  
        returned.addAll(movesDown(b,loc,returned));
        returned.addAll(movesLeft(b,loc,returned));
        returned.addAll(movesRight(b,loc,returned)); 
        returned.addAll(movesUp(b,loc,returned));
        return returned;    
    }

}