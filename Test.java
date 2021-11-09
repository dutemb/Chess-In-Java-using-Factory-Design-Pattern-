import java.util.*;
public class Test {

    // Run "java -ea Test" to run with assertions enabled (If you run
    // with assertions disabled, the default, then assert statements
    // will not execute!)

    public static void test1() {
	Board b = Board.theBoard();
	Piece.registerPiece(new PawnFactory());
	Piece p = Piece.createPiece("bp");
    Piece f = Piece.createPiece("wp");
    //Piece t = Piece.createPiece("sp"); //should throw an exception
	b.addPiece(f, "a3");
    b.addPiece(p, "b4");
    //b.addPiece()
	assert b.getPiece("a3") == f;
     //b.addPiece(f,"a3"); should be an error
    // b.addPiece(f,"u3"); //should throw an exception because u is not in scope
    // b.addPiece(f,"b9");
    // b.addPiece(f,"b0");
    List<String> list = f.moves(b, "a3");
    System.out.println(Arrays.toString(list.toArray()));
    b.clear();
    }

    public static void test2(){
         Board b = Board.theBoard();
         Piece.registerPiece(new KingFactory());
         Piece.registerPiece(new PawnFactory());
         Piece bk = Piece.createPiece("bk");
         Piece wk = Piece.createPiece("wk");

        // b.addPiece(wk,"h5");

        // //TEST EDGES
        // List<String> list = bk.moves(b, "h5");
        //System.out.println(Arrays.toString(list.toArray()));


        // //TEST IF THERE'S A TEAMMATE
        b.addPiece(wk,"h8");
         Piece pawn = Piece.createPiece("wp");
         b.addPiece(pawn, "h7");
        List<String> clist = wk.moves(b, "h8");
        System.out.println(Arrays.toString(clist.toArray()));
        b.clear();

       

    }

     public static void test3(){
         Board b = Board.theBoard();
         Piece.registerPiece(new RookFactory());
         Piece.registerPiece(new PawnFactory());
         Piece bq = Piece.createPiece("br");
         Piece wr = Piece.createPiece("wr");
     
        b.addPiece(bq, "a5");
        List<String> crlist = wr.moves(b, "a5");
        System.out.println(Arrays.toString(crlist.toArray())); 
        b.clear();    

    }

    public static void test4(){
         Board b = Board.theBoard();
         Piece.registerPiece(new BishopFactory());
         Piece.registerPiece(new PawnFactory());
         Piece bq = Piece.createPiece("bb");
         Piece wr = Piece.createPiece("wb");
     
        b.addPiece(bq, "e5");
        List<String> crlist = wr.moves(b, "e5");
        System.out.println(Arrays.toString(crlist.toArray()));
        b.clear();     

    }

    public static void test5(){
         Board b = Board.theBoard();
         Piece.registerPiece(new QueenFactory());
         Piece.registerPiece(new PawnFactory());
         Piece bq = Piece.createPiece("bq");
         Piece toad= Piece.createPiece("bp");
     
        b.addPiece(bq, "f1");
        b.addPiece(toad,"f5");
        List<String> crlist = bq.moves(b, "f1");
        System.out.println(Arrays.toString(crlist.toArray())); 
        b.clear();

    }

     public static void test6(){
         Board b = Board.theBoard();
         Piece.registerPiece(new KnightFactory());
         Piece.registerPiece(new PawnFactory());
         Piece bq = Piece.createPiece("bn");
         Piece toad= Piece.createPiece("bp");
         Piece paprika= Piece.createPiece("wn");
     
        //b.addPiece(bq, "e3");
        b.addPiece(toad,"f5");
        b.addPiece(paprika,"e3");
        List<String> crlist = paprika.moves(b, "e3");
        System.out.println(Arrays.toString(crlist.toArray()));   
        b.clear();  

    }
    
    public static void main(String[] args) {
	test1();
    test2();
    test3();
    test4();
    test5();
    test6();
    }

}