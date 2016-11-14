
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moraj0721
 */
public class Dalek {
    private int row;
    private int col;
    private Color colour;
    
    public Dalek(int row, int col){
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
    }
    
    public void move(int newRow, int newCol){
        
    }
    
    public int getCol(){
        return this.col;
    }
    
    public int getRow(){
        return this.row;
    }
}
