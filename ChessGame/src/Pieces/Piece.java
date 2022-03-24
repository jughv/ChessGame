/**
 * @author Julio Johnson Lopez
 * @author Michelle Dong
 */

 package Pieces;

import ChessModel.Chessboard;

public class Piece{
    public int x,y;
    //private boolean startingPostion = true;
    private boolean ifMoved = false;
    public boolean isEmpty = true;
    public boolean isWhite = true;
    private String displayString;
    private char color;
    private char piece;
    private boolean castletime;


    public void setifMoved(){
        this.ifMoved = true;
    }

    
    /** 
     * @return boolean if it was moved
     */
    public boolean getifMoved(){
        return this.ifMoved;
    }

    
    /** 
     * @param i is x
     */
    public void setX(int i){
        this.x = i;
    }

    
    /** 
     * @param i is y
     */
    public void setY(int i){
        this.y = i;
    }

    
    /** 
     * @return int x
     */
    public int getX(){
        return this.x; 
    }

    
    /** 
     * @return int y
     */
    public int getY(){
        return this.y;
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

    public void ifEmpty(){
        if(isEmpty){
            if(isWhite){
            this.displayString= "  ";
            } else {
                this.displayString = "##";
            }
        }
    }

    
    /** 
     * @param x location
     * @param y location
     * @param kingLocX location
     * @param kingLocY location
     * @param b location
     * @return boolean location
     */
    public boolean checkMoveValidity(int x, int y, int kingLocX, int kingLocY, boolean b) {
        //return Chessboard.getPieceFromBoard(x2, y2);
        if (Chessboard.getPieceFromBoard(x, y).getPiece() == 'N'){//knight
            if(Knight.checkMoveValidity(x, y, kingLocX, kingLocY)){
                //Chessboard.movePiece(oldx, oldy, newx, newy);
                return true;
            }
        }

        if (Chessboard.getPieceFromBoard(x, y).getPiece() == 'K'){//king
            if(King.checkMoveValidity(x, y, kingLocX, kingLocY)){
                //Chessboard.movePiece(oldx, oldy, newx, newy);
                return true;
            }
        }
        if (Chessboard.getPieceFromBoard(x, y).getPiece() == 'B'){//bishop
            if(Bishop.checkMoveValidity(x, y, kingLocX, kingLocY)){
                //Chessboard.movePiece(oldx, oldy, newx, newy);
                return true;
            }
        }
        if (Chessboard.getPieceFromBoard(x, y).getPiece() == 'Q'){//queen
            if(Queen.checkMoveValidity(x, y, kingLocX, kingLocY)){
                //Chessboard.movePiece(oldx, oldy, newx, newy);
                return true;
            }
        }
        if (Chessboard.getPieceFromBoard(x, y).getPiece() == 'R'){//rook
            if( Rook.checkMoveValidity(x, y, kingLocX, kingLocY)){
                //Chessboard.movePiece(oldx, oldy, newx, newy);
                return true;
            }
        }

        return false;
    }

    
    /** 
     * @param b whether castle is occuring
     */
    public void setCastletime(boolean b) {
        this.castletime = b;
    }

    
    /** 
     * @return boolean castleing is happening
     */
    public boolean isCastletime() {
        return castletime;
    }
}
