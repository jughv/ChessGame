package Pieces;
public class Bishop extends Piece{

    private String displayString;
    private char color;
    private char piece = 'B';

    public Bishop(char color){
        this.displayString  = color + "B";
        this.color = color;
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
    
}
