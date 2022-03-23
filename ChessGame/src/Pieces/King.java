package Pieces;
public class King extends Piece{ 
    
    //private boolean ifMoved = false;
    //private static final int max = 2;
    //private int x,y;

    private String displayString;
    private char color;
    private char piece = 'K';

    public King(char color){
        this.displayString  = color + "K";
        this.color = color;
    }

    public King(boolean color){
        if(!color){
            this.color = 'b';
            this.isWhite =false;
        }

        this.displayString  = this.color + "K";
    }

    public String getDisplayString() {
        return displayString;
    }

    public void setDisplayString(String displayString) {
        this.displayString = displayString;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public char getPiece() {
        return piece;
    }

    public void setPiece(char piece) {
        this.piece = piece;
    }


    public static boolean checkMoveValidity(int origx, int origy, int newx, int newy)
    {
        int rowDiff = Math.abs(origx-newx);
        int colDiff = Math.abs(origy-newy);
        if(newx < 0 || newy < 0 || newx > 7 || newy > 7)
            return false;
        if(colDiff > 1 || rowDiff > 1)
            return false;
        return true;

    }

    

}