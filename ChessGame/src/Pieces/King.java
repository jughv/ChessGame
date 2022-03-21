package Pieces;
public class King extends Piece{ //implements Movement?
    
    //private boolean ifMoved = false;
    //private static final int max = 2;
    //private int x,y;

    private String displayString;
    private char color;

    public King(char color){
        this.displayString  = color + "K";
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