/**
 * @author Julio Johnson Lopez
 * @author Michelle Dong
 */

 package Pieces;
public class Queen extends Piece{
    
    private String displayString;
    private char color = 'w';
    private char piece = 'Q';


    public Queen(char color){
        this.displayString  = color + "Q";
        this.color = color;
    }

    public Queen(boolean color){
        if(!color){
            this.color = 'b';
            this.isWhite =false;
        }

        this.displayString  = this.color + "Q";
    }

    
    /** 
     * @return char piece
     */
    public char getPiece() {
        return piece;
    }

    
    /** 
     * @param piece gets set
     */
    public void setPiece(char piece) {
        this.piece = piece;
    }

    
    /** 
     * @return String displayString
     */
    public String getDisplayString() {
        return displayString;
    }

    
    /** 
     * @param displayString gets set
     */
    public void setDisplayString(String displayString) {
        this.displayString = displayString;
    }

    
    /** 
     * @return char color
     */
    public char getColor() {
        return color;
    }

    
    /** 
     * @param color gets set
     */
    public void setColor(char color) {
        this.color = color;
    }

    
    /** 
     * @param origx location
     * @param origy location
     * @param newx location
     * @param newy location
     * @return boolean whether move is valid
     */
    public static boolean checkMoveValidity(int origx, int origy, int newx, int newy)
    {
        if(Rook.checkMoveValidity(origx, origy, newx, newy)){
            return true;
        }
        if(Bishop.checkMoveValidity(origx, origy, newx, newy)){
            return true;
        }

        return false;
    }
}
