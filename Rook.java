import java.util.*;
import java.util.ArrayList;
public class Rook extends Piece {
    public Rook(Color c) { 
      if (c == Color.BLACK || c == Color.WHITE) color = c;
      else throw new UnsupportedOperationException();
    }

    public String toString() {
	  if (color == Color.WHITE) return "wr";
      else  return "br";
    }

    public List<String> moves(Board b, String loc) {
	    ArrayList < String > returned = new ArrayList<String>();
      returned = movesUp(b,loc, returned);
      returned.addAll(movesDown(b,loc,returned));
      returned.addAll(movesLeft(b,loc,returned));
      returned.addAll(movesRight(b,loc,returned));

      return returned;
    }



}