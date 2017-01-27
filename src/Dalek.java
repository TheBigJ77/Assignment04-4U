
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

    private boolean dCrash = false;

    /**
     * class for Daleks row and col
     *
     * @param row random row
     * @param col random col
     */
    public Dalek(int row, int col) {
        this.row = row;
        this.col = col;

    }

    /**
     * move towards the doctor method
     *
     * @param doc the doctor that Daleks are moving toward
     */
    public void moveTowards(Doctor doc) {
        //if dalek has not crashed
        int docRow = doc.getRow();
        int docCol = doc.getCol();
        
        //if daleks row is more than doctors row, -1 from daleks row 
        if (this.row > docRow) {
            this.row -= 1;

        //if daleks row  is less  than doctors col, +1 to daleks row
        } else if (this.row < docRow) {
            this.row += 1;
        }

        //if daleks col is more than doctors col, -1 from daleks col
        if (this.col > docCol) {
            this.col -= 1;
        
        //if daleks col row is less than doctors col, +1 to daleks col
        } else if (this.col < docCol) {
            this.col += 1;

        }

    }

    /**
     * returns the current row of dalek
     *
     * @return the current row of dalek
     */
    public int getRow() {
        return this.row;

    }

    /**
     * return the current row of dalek
     *
     * @return the current row of dalek
     */
    public int getCol() {
        return this.col;
    }

    /**
     * checks if dalek has crashed
     *
     * @return ture of false (
     */
    public boolean hasCrashed() {
        return this.dCrash;

    }

    /**
     * checks to see if daleks have collided
     *
     */
    public void crash() {
        this.dCrash = true;

    }
}
