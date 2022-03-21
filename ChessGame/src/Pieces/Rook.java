package Pieces;
public class Rook extends Piece{

    private String displayString;
    private char color;

    public Rook(char color){
        this.displayString  = color + "R";
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
    
}
