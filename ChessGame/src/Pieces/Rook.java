package Pieces;

import ChessModel.Chessboard;

public class Rook extends Piece{

    private String displayString;
    private char color = 'w';
    private char piece = 'R';


    public Rook(char color){
        this.displayString  = color + "R";
        this.color = color;
    }

    public Rook(boolean color){
        if(!color){
            this.color = 'b';
            this.isWhite =false;
        }

        this.displayString  = this.color + "R";
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

		if(Math.abs(dy) > 0 && dx == 0){ //horizontal

			
			
			if(dy > 0){ //to the right
				for(int i = origy + 1 ; i < newy; i++){
					if(!(Chessboard.isSpotEmpty(origx, i))){
						return false;
					}
				}
			}
			
			
			if(dy < 0){ // to the left
				for(int i = origy - 1; i > newy; i--){
					if(!(Chessboard.isSpotEmpty(origx, i))){
						return false;
					}
				}
			}
			
			
			if(Chessboard.isSpotEmpty(newx, newy)){
				//moveCount++;
                current.setifMoved();
				return true;
			}
			else if(!(Chessboard.getPieceFromBoard(newx, newy).getColor() == current.getColor())){//checks if oppocolor
				//moveCount++;
                current.setifMoved();
				return true;
			}

		}
		else if(Math.abs(dx) > 0 && dy == 0){//vertical
			
			if(dx > 0){ //up
				for(int i = origx + 1; i < newx; i++){
					if(!(Chessboard.isSpotEmpty(i, origy))){
						return false;
					}
				}
			}
			
			if(dx < 0){ //down
				for(int i = origx - 1; i > newx; i--){
					if(!(Chessboard.isSpotEmpty(i, origy))){
						return false;
					}
				}
			}
			
			
			if(Chessboard.isSpotEmpty(newx, newy)){
				//moveCount++;
				return true;
			}else if(!(Chessboard.getPieceFromBoard(newx, newy).getColor()==current.getColor())){ //checks if oppocolor
				//moveCount++;
                current.setifMoved();
				return true;
			}
		}
		
		return false;

    }
    
}
