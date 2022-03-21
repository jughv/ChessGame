package Pieces;
public class Queen extends Piece{
    
    private String displayString;
    private char color;

    public Queen(char color){
        this.displayString  = color + "Q";
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
