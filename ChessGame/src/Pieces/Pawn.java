package Pieces;

//import ChessModel.ChessBoard;

public class Pawn extends Piece{

    //private static final int MAX_AMOUNT = 16;
    
    private String displayString;
    private char color;
    private char piece = 'p';


    public Pawn(char color){
        this.displayString  = color + "p";
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



    public boolean Shmovement(int origx, int origy, int newx, int newy){
        //ChessBoard.
        if(){ //if white piece in new position
            System.out.println("Illegal move, try again");
            return false;
        }

        if(origy!=newy){ //if colomn is != must be overtaking a piece
            
        }

        if(this.ifMoved){
            //if(origx)
            
        }
    }

}
