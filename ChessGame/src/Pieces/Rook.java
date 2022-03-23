package Pieces;
public class Rook extends Piece{

    private String displayString;
    private char color;
    private char piece = 'R';


    public Rook(char color){
        this.displayString  = color + "R";
        this.color = color;
    }

    public Rook(boolean color){
        if(!color){
            this.color = 'b';
            this.isWhite =false;
        }

        this.displayString  = this.color + "R";
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
