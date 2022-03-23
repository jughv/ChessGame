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

    public char getPiece() {
        return piece;
    }

    public void setPiece(char piece) {
        this.piece = piece;
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
