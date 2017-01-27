
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
        //creates game board
        Board board = new Board(12, 12);

        //creates 3 daleks
        Dalek[] dalek = new Dalek[3];

        //places daleks on board
        for (int i = 0; i <= 2; i++) {
            int dalCol = (int) (Math.random() * 12);
            int dalRow = (int) (Math.random() * 12);
            dalek[i] = new Dalek(dalRow, dalCol);

        }

        //generates random position for Doc to spawn in
        int docRow = (int) (Math.random() * 12);
        int docCol = (int) (Math.random() * 12);

        //creates new Doc
        Doctor Doc = new Doctor(docRow, docCol);

        //checks to see if the Doc has landed on any of the daleks 
        //if Doc lands on dalek 1 
        while (Doc.getRow() == dalek[0].getRow() && Doc.getCol() == dalek[0].getCol()) {
            //remove the Doc
            board.removePeg(Doc.getRow(), Doc.getCol());
            //puts Doc at a new location 
            Doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        }

        //check if Doc lands on dalek 2
        while (Doc.getRow() == dalek[1].getRow() && Doc.getCol() == dalek[1].getCol()) {
            //remove doc
            board.removePeg(Doc.getRow(), Doc.getCol());
            //place Doc at new location 
            Doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        }

        //check docc and  dalek 3
        while (Doc.getRow() == dalek[2].getRow() && Doc.getCol() == dalek[2].getCol()) {
            // remove Doc 
            board.removePeg(Doc.getRow(), Doc.getCol());
            // place Doc at new location
            Doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        }

        //checks to see if any of the daleks have crashed with each other if so respawn the dalek that has not crashed
        
        //checks daleks at positions 1 and 2 
        while (dalek[0].getRow() == dalek[1].getRow() && dalek[0].getCol() == dalek[1].getCol()) {
            //removes dalek 
            board.removePeg(dalek[0].getRow(), dalek[0].getCol());
            //Create a new location for the Dalek 1
            dalek[0] = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        }

        //check dalek 1 and 3 
        while (dalek[0].getRow() == dalek[2].getRow() && dalek[0].getRow() == dalek[2].getCol()) {
            //removes dalek's peg
            board.removePeg(dalek[0].getRow(), dalek[0].getCol());
            //places dalek 1 again 
            dalek[0] = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        }

        //checks dalek 2 and 3 
        while (dalek[1].getRow() == dalek[2].getRow() && dalek[1].getCol() == dalek[2].getCol()) {
            // Remove Dalek 2 peg
            board.removePeg(dalek[1].getRow(), dalek[1].getCol());
            // Create a new location for Dalek 2
            dalek[1] = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        }

        //places all pegs before the game starts 
        //place Doc 
        board.putPeg(Color.GREEN, Doc.getRow(), Doc.getCol());
        //place all dalkes
        for (int i = 0; i <= 2; i++) {
            board.putPeg(Color.BLACK, dalek[i].getRow(), dalek[i].getCol());
        }
        board.displayMessage("Click on any position to move the doctor. Don't Lose!");

        //game loop
        while (true) {

            //checks if daleks have capatured the Doctor
            if (dalek[0].getRow() == Doc.getRow() && dalek[0].getCol() == Doc.getCol()
                    || dalek[1].getRow() == Doc.getRow() && dalek[1].getCol() == Doc.getCol()
                    || dalek[2].getRow() == Doc.getRow() && dalek[2].getCol() == Doc.getCol()) {

                //place peg where Doc and dalek crash into eachother 
                board.putPeg(Color.YELLOW, Doc.getRow(), Doc.getCol());

                //tells player that they have lost 
                board.displayMessage("Oh no! The Doctor has been captured!");

                //ends the game
                break;

            }

            //checks if any of the daleks have crashed with eachother
            if (dalek[0].getCol() == dalek[1].getCol() && dalek[0].getRow() == dalek[1].getRow()
                    && dalek[0].getRow() == dalek[2].getRow() && dalek[0].getCol() == dalek[2].getCol()
                    && dalek[1].getRow() == dalek[2].getRow() && dalek[1].getCol() == dalek[2].getCol()) {

                //makes all the daleks crash 
                dalek[0].crash();
                dalek[1].crash();
                dalek[2].crash();

                //places a peg where they have crashed 
                board.putPeg(Color.RED, dalek[0].getRow(), dalek[0].getCol());
                // Tells player they have won  
                board.displayMessage("All Daleks have crashed! WINNER! (Feel good about it)");
                // Ends game if all daleks have crashed 
                break;
            }

            //check to see if dalek 1 and 2 have crashed. If so, put peg at crash site 
            if (dalek[0].getRow() == dalek[1].getRow() && dalek[0].getCol() == dalek[1].getCol()) {
                //dalek 1 and 2 crash
                dalek[0].crash();
                dalek[1].crash();
                //puts red peg at crash site 
                board.putPeg(Color.RED, dalek[0].getRow(), dalek[0].getCol());
            }

            //check to see if dalek 1 and 3 have crashed 
            if (dalek[0].getRow() == dalek[2].getRow() && dalek[0].getCol() == dalek[2].getCol()) {
                //dalek 1 and 3 crash
                dalek[0].crash();
                dalek[2].crash();
                //put red  peg a crash site 
                board.putPeg(Color.RED, dalek[2].getRow(), dalek[2].getCol());
            }

            //checks to see if dalek 2 and 3 have crashed 
            if (dalek[1].getRow() == dalek[2].getRow() && dalek[1].getCol() == dalek[2].getCol()) {
                //dalek 2 and 3 crash 
                dalek[1].crash();
                dalek[2].crash();
                //puts a red peg at crash site
                board.putPeg(Color.RED, dalek[1].getRow(), dalek[1].getCol());
            }

            //gets cordinates of the click 
            Coordinate click = board.getClick();
            //removes previous Doc peg 
            board.removePeg(Doc.getRow(), Doc.getCol());
            //moves Doc to the location
            Doc.move(click.getRow(), click.getCol());
            //puts Doc at new location 
            board.putPeg(Color.GREEN, Doc.getRow(), Doc.getCol());

            //daleks turn, move all the daleks towards Doc 
            //if dalek has not crashed move dalek
            //goes through all daleks 
            for (int i = 0; i <= 2; i++) {

                //if no daleks have crashed, move the daleks 
                if (dalek[i].hasCrashed() == false) {
                    //remove dalek peg 
                    board.removePeg(dalek[i].getRow(), dalek[i].getCol());
                    //moves daleks toward Doc
                    dalek[i].moveTowards(Doc);

                }

            }

            //places all daleks again 
            for (int i = 0; i <= 2; i++) {
                board.putPeg(Color.black, dalek[i].getRow(), dalek[i].getCol());

            }

        }

    }

}
