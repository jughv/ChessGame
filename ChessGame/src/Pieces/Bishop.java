package Pieces;

import ChessModel.Chessboard;

public class Bishop extends Piece{

    private String displayString;
    private char color = 'w';
    private char piece = 'B';

    public Bishop(char color){
        this.displayString  = color + "B";
        this.color = color;
    }

    public Bishop(boolean color){
        if(!color){
            this.color = 'b';
            this.isWhite =false;
        }

        this.displayString  = this.color + "B";
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

    public static boolean checkMoveValidity(int origx, int origy, int newx, int newy)
    {
        int dx = newx-origx;
		int dy = newy-origy;

        Piece current = Chessboard.getPieceFromBoard(origx,origy);
		
		if(Math.abs(dy)-Math.abs(dx)==0){ //dif in abs of x and y must be 0 for it to b a diagonal path
			
			//Move top right
			if( dx > 0 && dy > 0){
				for(int i = origx + 1, j = origy + 1; i < newx || j < newy; i++, j++){
					if(!Chessboard.isSpotEmpty(i, j)){
						return false;
					}
				}
			}
			
			//Move top left
			if( dx > 0 && dy < 0){
				for(int i = origx + 1, j = origy - 1; i < newx || j > newy; i++, j--){
					if(!Chessboard.isSpotEmpty(i, j)){
						return false;
					}
				}
			}
			
			//Move bottom right
			if( dx < 0 && dy > 0){
				for(int i = origx - 1 , j = origy + 1; i > newx || j < newy; i--, j++){
					if(!Chessboard.isSpotEmpty(i, j)){
						return false;
					}
				}
			}
			//Move bottom left
			if( dx < 0 && dy < 0 ){
				for(int i = origx - 1, j = origy - 1; i > newx || j > newy; i--, j--){
					if(!Chessboard.isSpotEmpty(i, j)){
						return false;
					}
				}
			}
			
			/*
			 * Checks if new spot is free
			 */
			if(Chessboard.isSpotEmpty(newx, newy)){
				return true;
			}else if(!(Chessboard.getPieceFromBoard(newx, newy).getColor()==current.getColor())){ //Checks if piece to be captured is the opposite color.
				return true;
			}
			
			
		}
		
		
		
		return false;
    }
    
}
