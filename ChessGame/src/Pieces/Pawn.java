package Pieces;

import ChessModel.Chessboard;

public class Pawn extends Piece{

    //private static final int MAX_AMOUNT = 16;
    
    private String displayString;
    private char color;
    private char piece = 'p';


    public Pawn(char color){
        this.displayString  = color + "p";
        this.color = color;
    }
    public Pawn(boolean color){
        if(!color){
            this.color = 'b';
            this.isWhite =false;
        }

        this.displayString  = this.color + "p";
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



    public static boolean checkMoveValidity(int origx, int origy, int newx, int newy){
        //ChessBoard.
        Piece oldPiece = Chessboard.getPieceFromBoard(newx,newy);
        if(Chessboard.getPieceFromBoard(newx,newy).getColor() != Chessboard.getPieceFromBoard(origx,origy).getColor()){ //if white piece in new position
            System.out.println("Illegal move, try again");
            return false;
        }

        if(origy!=newy){ //if colomn is != must be overtaking a piece
            
        }

        if(oldPiece.getifMoved()){
            
            
        }
        return false;
    }

    
}
