package Pieces;
public class Knight extends Piece{

    private String displayString;
    private char color;

    public Knight(char color){
        this.displayString  = color + "N";
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
