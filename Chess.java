import java.io.*;
import java.util.*;
public class Chess {
    public static void main(String[] args) {
	if (args.length < 2 || args.length > 2) {
	   // System.out.println("Usage: java Chess layout moves");
       System.out.println("No, try the following format: java Chess layout moves");
	}
	Piece.registerPiece(new KingFactory());
	Piece.registerPiece(new QueenFactory());
	Piece.registerPiece(new KnightFactory());
	Piece.registerPiece(new BishopFactory());
	Piece.registerPiece(new RookFactory());
	Piece.registerPiece(new PawnFactory());
	Board.theBoard().registerListener(new Logger());
	// args[0] is the layout file name
	// args[1] is the moves file name
	// Put your code to read the layout file and moves files
	// here.

	File layout = new File(args[0]); 
    File moves = new File(args[1]);

    try {
        Scanner layoutScanner = new Scanner(layout);
        Scanner movesScanner = new Scanner(moves);
        while (layoutScanner.hasNextLine()){
            if (layoutScanner.nextLine().charAt(0) != '#'){
                if (layoutScanner.nextLine().charAt(2) != '=') throw new RuntimeException();
                String location = layoutScanner.nextLine().substring(0,2); //a1
                String colorAndKind = layoutScanner.nextLine().substring(3,5);//wr
                Piece newPiece = Piece.createPiece(colorAndKind);//string color, and kind
                Board.theBoard().addPiece(newPiece, location); 
            }
        }

        while (movesScanner.hasNextLine()) {
            if (movesScanner.nextLine().charAt(0) != '#'){
                if (movesScanner.nextLine().charAt(2) != '-')throw new RuntimeException();
                String from = movesScanner.nextLine().substring(0,2);
                String to = movesScanner.nextLine().substring(3,5);
                Board.theBoard().movePiece(from, to);
            }
        }
    } catch (FileNotFoundException e){}

	System.out.println("Final board:");
	Board.theBoard().iterate(new BoardPrinter());
    }
}