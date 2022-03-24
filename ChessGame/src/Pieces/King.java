/**
 * @author Julio Johnson Lopez
 * @author Michelle Dong
 */

 package Pieces;

import Chess.Game;
import ChessModel.Chessboard;

public class King extends Piece{ 
    
    //private boolean ifMoved = false;
    //private static final int max = 2;
    //private int x,y;

    private String displayString;
    private char color = 'w';
    private char piece = 'K';
    private boolean castletime = false;

    public King(char color){
        this.displayString  = color + "K";
        this.color = color;
    }

    public King(boolean color){
        if(!color){
            this.color = 'b';
            this.isWhite =false;
        }

        this.displayString  = this.color + "K";
    }

    
    /** 
     * @return String displayString
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
     * @return char color
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
     * @return char piece character
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
     * @param origx location
     * @param origy location
     * @param newx location
     * @param newy location
     * @return boolean if move is valid
     */
    public static boolean checkMoveValidity(int origx, int origy, int newx, int newy){
        
		int dx = newy-origy;
		int dy = newx-origx; 
        Piece current = Chessboard.getPieceFromBoard(origx,origy);
		
		// Makes sure King only moves 1 space in any direction
		if(Math.abs(dx) <= 1 && Math.abs(dy) <= 1){
			
			
			// Checks is space is empty or not
			if(Chessboard.isSpotEmpty(newx, newy)){

				return true;
			}else if(!(Chessboard.getPieceFromBoard(newx, newy).getColor()==current.getColor())){
				//piece is opposite color 
				return true;
			}
			
			
			
		}
		else if(Math.abs(dx) == 0 && Math.abs(dy) >= 2 && current.getifMoved() == false){
			
			Piece p;
			
			if(dy > 0){
				if(Game.isPathClear(origx, origy, newx,newy)){ //if path is clear lets go
					p = Chessboard.getPieceFromBoard(newx, newy);
					
					if(p == null)
						return false;
					
					if(p.getPiece() =='R' && p.getColor() == current.getColor()){
						if(p.getifMoved() == false){
                            current.setCastletime(true);
							return true;
						}
					}
				}
				
			}
		}
	
		return false;
    }

    
    /** 
     * @return boolean if castle is right
     */
    public boolean isCastletime() {
        return castletime;
    }

    
    /** 
     * @param castletime gets set to argument
     */
    public void setCastletime(boolean castletime) {
        this.castletime = castletime;
    }
    

    

}
