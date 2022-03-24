/**
 * @author Julio Johnson Lopez
 * @author Michelle Dong
 */

 package Pieces;

import ChessModel.Chessboard;
//import GameModel.GameBoard;

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

    
    /** 
     * @return char for piece
     */
    public char getPiece() {
        return piece;
    }

    
    /** 
     * @param piece gets set
     */
    public void setPiece(char piece) {
        this.piece = piece;
    }

    
    /** 
     * @return String retrun displayString
     */
    public String getDisplayString() {
        return displayString;
    }

    
    /** 
     * @param displayString gets set
     */
    public void setDisplayString(String displayString) {
        this.displayString = displayString;
    }

    
    /** 
     * @return char color gets returned
     */
    public char getColor() {
        return color;
    }

    
    /** 
     * @param color gets set
     */
    public void setColor(char color) {
        this.color = color;
    }
    
    
    /** 
     * @param origx location
     * @param origy location
     * @param newx location
     * @param newy location
     * @return boolean whether move is valid
     */
    public static boolean checkMoveValidity(int origx, int origy, int newx, int newy)
    {
        int dx = newx-origx;
		int dy = newy-origy;

        Piece current = Chessboard.getPieceFromBoard(origx,origy);
		
		if(current.getColor() == 'w'){//Checks if color is white
			dx = -1 * dx;
		}
		
		//checks if it works
		if((Math.abs(dx)==1 && Math.abs(dy)==2) || (Math.abs(dx)==2 && Math.abs(dy)==1)){
			
			if(Chessboard.isSpotEmpty(newx, newy)){ //If the space is empty 
				return true;
				
			}else if(!(Chessboard.isSpotEmpty(newx,newy)) && !(Chessboard.getPieceFromBoard(newx, newy).getColor()==current.getColor())){
				return true;
			}
		}
		
		return false;
	}
    
}
