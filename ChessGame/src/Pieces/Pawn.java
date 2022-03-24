/**
 * @author Julio Johnson Lopez
 * @author Michelle Dong
 */

 package Pieces;

import ChessModel.Chessboard;

public class Pawn extends Piece{

    //private static final int MAX_AMOUNT = 16;
    
    private String displayString;
    private char color = 'w';
    private char piece = 'p';
    boolean EnPassant;


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

    
	/** 
	 * @return String gets returned
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
	 * @return char piece
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
	 * @return boolean whether move is valid
	 */
	public static boolean checkMoveValidity(int origx, int origy, int newx, int newy){
        int dx = newy-origy;
		int dy = newx-origx;
		
		boolean isBlack = false;
        Pawn current = (Pawn)Chessboard.getPieceFromBoard(origx,origy);

		
		if(current.getColor() == 'w'){
			dx= -1 * dx;
			isBlack = true;
		}
		
		
		if(dy == 0 && dx == 2 && current.getifMoved() == false){
			if(Chessboard.isSpotEmpty(newx,newy)){
				if(!isBlack){
					if(Chessboard.isSpotEmpty(newx - 1, newy)){
						current.setEnPassant();
                        current.setifMoved();
						//moveCount++;
						return true;
					}
				}else{
					
					if(Chessboard.isSpotEmpty(newx + 1, newy)){
						current.setEnPassant();
                        current.setifMoved();
						//moveCount++;
						return true;
					}	
				}
			}
		}
		else if(dy == 0 && dx == 1){
			if(Chessboard.isSpotEmpty(newx,newy)){
                current.setifMoved();
				//moveCount++;
				return true;
			}
		}
		else if((dy == 1 || dy == -1) && dx == 1 ){
			if(!(Chessboard.isSpotEmpty(newx,newy))){
				if(Chessboard.getPieceFromBoard(newx, newy).getColor() != current.getColor()){
					//moveCount++;
					return true;
				}
			}
			else{
				Pawn p;
				if(current.getColor() == 'b'){
					if(!(Chessboard.isSpotEmpty(newx + 1, newy))){
						p = (Pawn)Chessboard.getPieceFromBoard(newx + 1, newy);
						
						if(p.getPiece() == 'p'){
							if(p.isEnPassant()){
                                Chessboard.emptySpot(newx+1, newy);
								return true;
							}
							else{
								return false;
							}
						}
					}
				}
				else{
					if(!(Chessboard.isSpotEmpty(newx - 1, newy))){
						p = (Pawn)Chessboard.getPieceFromBoard(newx - 1, newy);
						
						if(p.getPiece() == 'p'){
							if(((Pawn)p).isEnPassant()){
                                Chessboard.emptySpot(newx-1, newy);
								return true;
							}
							else{
								return false;
							}
						}
					}
				}
			}
		}
		
		return false;
    }
    
	/** 
	 * @return boolean if enPassant is actives
	 */
	public boolean isEnPassant() {
        return EnPassant;
    }
    public void setEnPassant() {
        if(this.EnPassant == true){
            this.EnPassant = false;
        } else {
            this.EnPassant = true;
        }
    }

    

    
}
