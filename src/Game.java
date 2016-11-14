
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author moraj0721
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Create the game board
        Board board = new Board(12, 12);
        
        
        
        //Set random location for the doctor
        int docCol = (int) (Math.random() * 12);
        int docRow = (int) (Math.random() * 12);
        Doctor doc = new Doctor(docCol, docRow);
        board.putPeg(Color.GREEN, doc.getCol(), doc.getRow());
        
        //Set a random locatins for the Daleks
        
        //Dalek 1
        int randCol1 = (int) (Math.random() * 12);
        int randRow1 = (int) (Math.random() * 12);
        Dalek kip1 = new Dalek(randCol1, randRow1);
        
        //Dalek 2
        int randCol2 = (int) (Math.random() * 12);
        int randRow2 = (int) (Math.random() * 12);
        Dalek kip2 = new Dalek(randCol2, randRow2);
        
        //Dalek 3
        int randCol3 = (int) (Math.random() * 12);
        int randRow3 = (int) (Math.random() * 12);
        Dalek kip3 = new Dalek(randCol3, randRow3);
        
        board.putPeg(Color.BLACK, kip1.getCol(), kip1.getRow());
        board.putPeg(Color.BLACK, kip2.getCol(), kip1.getRow());
        board.putPeg(Color.BLACK, kip3.getCol(), kip1.getRow());

        //put a message on the board
        board.displayMessage("Please click the board.");
        
        //get a click on the board
        
        

    }
}
