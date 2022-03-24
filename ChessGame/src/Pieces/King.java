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

    public boolean isCastletime() {
        return castletime;
    }

    public void setCastletime(boolean castletime) {
        this.castletime = castletime;
    }
    

    

}
