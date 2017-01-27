
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author moraj0721
 */
public class Doctor {

    private int row;
    private int col;
    private boolean crash = false;//boolean for doctors state;

    /**
     * constructor for doctor
     *
     * @param row the row that is being passed through
     * @param col the col that is being passed through
     */
    public Doctor(int row, int col) {
        this.row = row;
        this.col = col;

    }

    /**
     * method that moves the doctor based on the click
     *
     * @param newRow the row that is passed through
     * @param newCol the col that is passed through
     */
    public void move(int newRow, int newCol) {
        //if the click cordinates that are passed through are one sapce away from doctors current postion move doctor to that space
        if (this.row - newRow <= 1
                && this.row - newRow >= -1
                && this.col - newCol <= 1
                && this.col - newCol >= -1) {

            //new spot for doctor 
            this.row = newRow;
            this.col = newCol;

            //otherwise spawn doctor at a random location 
        } else {
            this.row = (int) (Math.random() * 12);
            this.col = (int) (Math.random() * 12);
        }

    }

    /**
     * returns current row of the doctor
     *
     * @return the current row of doc
     */
    public int getRow() {
        return this.row;

    }

    /**
     * return the current col of doc
     *
     * @return the current col of doc
     */
    public int getCol() {
        return this.col;

    }
}
