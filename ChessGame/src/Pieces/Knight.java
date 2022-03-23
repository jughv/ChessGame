package Pieces;
public class Knight extends Piece{

    private String displayString;
    private char color;
    private char piece = 'N';


    public Knight(char color){
        this.displayString  = color + "N";
        this.color = color;
    }

    public Knight(boolean color){
        if(!color){
            this.color = 'b';
            this.isWhite =false;
        }

        this.displayString  = this.color + "N";
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
    
}
