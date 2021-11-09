import java.util.*;

public class King extends Piece {
    public King(Color c) { 
        if(c == Color.WHITE || c == Color.BLACK) color = c;
        else throw new UnsupportedOperationException();        
    }
 

    public String toString() {
	    if(color == Color.WHITE) return "wk";
        else return "bk";
    }

    public List<String> moves(Board b, String loc) {
	List<String> returned = new ArrayList<String>();
    int col = loc.charAt(0);
    int row = loc.charAt(1);

    int[] hor = {-1,-1,-1,1,1,1,0,0};
    int[] vert = {0,-1,1,0,1,-1,-1,1};

    for(int i = 0; i < 8;i++){
        int resC = col + hor[i];
        int resR = row + vert[i];
        String curMove = ""+(char)resC+(char)resR;
        if(isValidMove(curMove)){
           Piece piece = b.getPiece(curMove);
           if(piece == null)returned.add(curMove);
           else if(piece !=null && piece.color() != color) returned.add(curMove);
        }
    }
    return returned;
    }

}