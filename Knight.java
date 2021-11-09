import java.util.*;

public class Knight extends Piece {
    public Knight(Color c) { 
       if (c == Color.BLACK || c == Color.WHITE) color = c;
       else throw new UnsupportedOperationException();
    }
    // implement appropriate methods

    public String toString() {
	  if (color == Color.WHITE) return "wn";
      else return "bn";
    }

    public List<String> moves(Board b, String loc) {
	    ArrayList<String> returned = new ArrayList<String>();
        int col = loc.charAt(0);
        int row = loc.charAt(1);
       
        int[] horizontal = {-2,-2,-1,-1,1,1,2,2};
        int[] vertical = {-1,1,-2,2,-2,2,-1,1};

        for (int i = 0; i < 8; i++) {
            int c = col + horizontal[i];
            int r = row + vertical[i];
            String move = "" + (char)c + (char)r;
            if(isValidMove(move)){
                Piece p = b.getPiece(move);
                if (p == null) returned.add(move);
                else {
                    if (p.color() != color) returned.add(move);
                }
            }
        }
 
        return returned;
    }

}