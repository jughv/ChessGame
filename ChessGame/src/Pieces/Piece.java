package Pieces;
public class Piece{
    public int x,y;
    //private boolean startingPostion = true;
    public boolean ifMoved = false;
    public boolean isEmpty = true;
    public boolean isWhite = true;
    private String displayString;
    private char color = 'w';
    private char piece;


    public void setifMoved(){
        this.ifMoved = true;
    }

    public boolean getifMoved(){
        return this.ifMoved;
    }

    public void setX(int i){
        this.x = i;
    }

    public void setY(int i){
        this.y = i;
    }

    public int getX(){
        return this.x; 
    }

    public int getY(){
        return this.y;
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

    public void ifEmpty(){
        if(isEmpty){
            if(isWhite){
            this.displayString= "  ";
            } else {
                this.displayString = "##";
            }
        }
    }

    
}
