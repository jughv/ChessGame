package Pieces;

import ChessModel.Chessboard;
import GameModel.GameBoard;

public class Knight extends Piece{

    private String displayString;
    private char color = 'w';
    private char piece = 'N';


    public Knight(char color){
        this.displayString  = color + "N";
        this.color = color;
    }

    public Knight(boolean color){
        if(!color){
            this.color = 'b';
            this.isWhite =false;
        }

        this.displayString  = this.color + "N";
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
    
    public static boolean checkMoveValidity(int origx, int origy, int newx, int newy)
    {
        int dx = newx-origx;
		int dy = newy-origy;

        Piece current = Chessboard.getPieceFromBoard(origx,origy);
		
		if(current.getColor() == 'b'){//Checks if color is black
			dx = -1 * dx;
		}
		
		//checks if it works
		if((Math.abs(dx)==1 && Math.abs(dy)==2) || (Math.abs(dx)==2 && Math.abs(dy)==1)){
			
			if(Chessboard.isSpotEmpty(newx, newy)){ //If the space is empty 
				return true;
				
			}else if(!(Chessboard.isSpotEmpty(newx,newy)) && !(Chessboard.getPieceFromBoard(newx, newy).getColor()==current.getColor())){
				//moveCount++;
				return true;
			}
		}
		
		return false;
	}
    
}
