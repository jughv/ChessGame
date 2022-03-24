/**
 * @author Julio Johnson Lopez
 * @author Michelle Dong
 */

 package Chess;
import ChessModel.*;
import Pieces.*;

import java.io.*;
import java.util.*;
//import GameModel.GameBoard;


public class Game {
    private static HashMap<Character,Integer> column = new HashMap<Character,Integer>();
    private static HashMap<Character,Integer> row = new HashMap<Character,Integer>();
    private Chessboard gameBoard;
    public boolean wturn = true;
    private boolean wWin = false;
    private boolean bWin = false;
    private boolean draw = false;

    public Game(){
        gameBoard = new Chessboard();
        setColumn();
        setRow();
    }
   
    
    
    /** 
     * @return HashMap<Character, Integer> returns the Hashmap representing columns
     */
    public static HashMap<Character, Integer> getColumn() {
        return column;
    }

    public static void setColumn() {
        Game.column.put('a', 0);
        Game.column.put('b', 1);
        Game.column.put('c', 2);
        Game.column.put('d', 3);
        Game.column.put('e', 4);
        Game.column.put('f', 5);
        Game.column.put('g', 6);
        Game.column.put('h', 7);
    }
    
    /** 
     * @return HashMap<Character, Integer> returns the hashmap representing rows
     */
    public static HashMap<Character, Integer> getRow() {
        return row;
    }
    public static void setRow() {
        Game.row.put('1', 7);
        Game.row.put('2', 6);
        Game.row.put('3', 5);
        Game.row.put('4', 4);
        Game.row.put('5', 3);
        Game.row.put('6', 2);
        Game.row.put('7', 1);
        Game.row.put('8', 0);
    }

    /** 
     * Controls the game, prints out when the user needs to insert imputs, runs a check detecter and controls the pace of the game.
     */

    public void play() {
        gameBoard.drawBoard();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;



        while (!wWin && !bWin && !draw){

            input = null;

            boolean check = detectCheck(wturn); //check for a check here
            if(check){
                if(wturn){
                    System.out.println("White king is in check");
                } else{
                    System.out.println("Black king is in check");
                }
            }
		    	 
		    if (wturn){		
		    	System.out.print("White player's turn: ");	
		    }else{
		    	System.out.print("Black player's turn: ");
		    }

            try{
            input = br.readLine();
            } catch (IOException e){
                System.out.println("Invalid input, try again");
                continue;
            }

            
            if(!parseString(input,wturn)){
                System.out.println("Invalid move, try again");
                continue;
            }

            check = detectCheck(!wturn);
		    	 if (check == true) {
		    		 if (!wturn) {
		    			System.out.println("Checkmate");
		    			System.out.println("Black wins");
		    		 }else {
		    			System.out.println("Checkmate");
		    			System.out.println("White wins");
		    		 }
		    		 System.exit(1);
		    	 }

            if(wturn){
                wturn = false;
            }else{
                wturn = true;
            }
            System.out.println();
            gameBoard.drawBoard();

        }//end while shlooop


        if(wWin){ //white dub
            System.out.println("White Wins");
        }
        if(bWin){ //black dub
            System.out.println("Black Wins");
        }
        if(draw){ //draw
            System.out.println("draw");
        }
    }//end play


    
    /** 
     * @param input User inputted string
     * @param wturn whether it is white or black turn
     * @return boolean returns true or false depending on if the move was made
     * This method parses the String and returns whether a move was made or if another input must be inputted
     */
    public boolean parseString(String input, boolean wturn){

       
        
        char[] temp = input.toCharArray();
        int oldx, oldy, newx, newy;
        
        if (temp.length < 5){
            return false;
        }

        if (temp.length == 6){
            if(temp[0] == 'r' || temp[0] == 'R' && temp[1]=='e' && temp[2]=='s' && temp[3]=='i' && temp[4] == 'g' && temp[5] == 'n'){
                if(wturn){
                    System.out.println("Black wins");
                    System.exit(1);
                } else{
                    System.out.println("White wins");
                    System.exit(1);
                }
            }
        }

        if (temp.length >=10){
            if(temp[6] == 'd' && temp[7]=='r' && temp[8]=='a' && temp[9]=='w'){
                System.out.println("draw");
                System.exit(1);
            }
            
        }

        if(!column.containsKey(temp[0])){ //checks if in column map
            return false;
        } else{
            oldx = column.get(temp[0]);
        }

        if(!row.containsKey(temp[1])){ //checks if in row map
            return false;
        } else{
            oldy = row.get(temp[1]);
        }

        if(!column.containsKey(temp[3])){ //checks if in column map
            return false;
        } else{
            newx = column.get(temp[3]);
        }

        if(!row.containsKey(temp[4])){ //checks if in row map
            return false;
        } else{
            newy = row.get(temp[4]);
        }

        if (Chessboard.getPieceFromBoard(oldx, oldy)== null){
            return false;
        }

        if(wturn && Chessboard.getPieceFromBoard(oldx, oldy).getColor()== 'b' ||
        !wturn && Chessboard.getPieceFromBoard(oldx, oldy).getColor()== 'w'){
            return false;
        }

        if (Chessboard.getPieceFromBoard(oldx, oldy).getPiece() == 'p'){//if pawn
            if(Pawn.checkMoveValidity(oldx, oldy, newx, newy)){
                
                Chessboard.movePiece(oldx, oldy, newx, newy);
                if(Chessboard.checkPromotion(newx, newy)){ //promote
                    if(temp.length == 7){ // type to promote to
                        Chessboard.promotion(newx, newy,Chessboard.getPieceFromBoard(newx, newy).getColor(), temp[6]);
                    } else { //null to queen
                        Chessboard.promotion(newx, newy,Chessboard.getPieceFromBoard(newx, newy).getColor());
                    }
                }
                return true;
            }
        }
        if (Chessboard.getPieceFromBoard(oldx, oldy).getPiece() == 'N'){//knight
            if(Knight.checkMoveValidity(oldx, oldy, newx, newy)){
                Chessboard.movePiece(oldx, oldy, newx, newy);
                return true;
            }
        }
        if (Chessboard.getPieceFromBoard(oldx, oldy).getPiece() == 'K'){//king
            if(King.checkMoveValidity(oldx, oldy, newx, newy)){
                if(Chessboard.getPieceFromBoard(oldx, oldy).isCastletime()){
                    Chessboard.getPieceFromBoard(oldx, oldy).setCastletime(false); // revert back from castle time
                    Chessboard.castle(oldx, oldy, newx, newy);
                    return true;
                }
                Chessboard.movePiece(oldx, oldy, newx, newy);
                return true;
            }
        }
        if (Chessboard.getPieceFromBoard(oldx, oldy).getPiece() == 'B'){//bishop
            if(Bishop.checkMoveValidity(oldx, oldy, newx, newy)){
                Chessboard.movePiece(oldx, oldy, newx, newy);
                return true;
            }
        }
        if (Chessboard.getPieceFromBoard(oldx, oldy).getPiece() == 'Q'){//queen
            if(Queen.checkMoveValidity(oldx, oldy, newx, newy)){
                Chessboard.movePiece(oldx, oldy, newx, newy);
                return true;
            }
        }
        if (Chessboard.getPieceFromBoard(oldx, oldy).getPiece() == 'R'){//rook
            if( Rook.checkMoveValidity(oldx, oldy, newx, newy)){
                Chessboard.movePiece(oldx, oldy, newx, newy);
                return true;
            }
        }

        return false;
    }
    
    /** 
     * @param oldX original x location
     * @param oldYoriginal y location
     * @param newX new x location
     * @param newY new y location
     * @return boolean returns whether the path is clear or not
     */
    //newstuff from 7:55pm onwards, test push
        //are there collisions in piece moves?
        public static boolean isPathClear(int oldX, int oldY, int newX, int newY){
            //char pieceName = Chessboard.board[oldX][oldY].getPiece();
            
            int deltaX;
            int deltaY;
            
            deltaX = newX-oldX;
            deltaY = newY-oldY;
            
            int tempx = oldX;
            int tempy = oldY;
            int dx = 0;
            int dy = 0;
            
            if (deltaX > 0) {dx = 1;}
            
            else if (deltaX < 0) {dx = -1;}
            
            if (deltaY > 0) {dy = 1;}
    
            else if (deltaY < 0) {dy = -1;}
                    
            boolean pathIsClear = true;
                    
            if (deltaY == 0) {
                tempx = tempx + dx;
                for (int i = 0; i < Math.abs(deltaX)-1; i++) {
                    if (Chessboard.getPieceFromBoard(tempx, tempy) != null) {
                        pathIsClear = false;
                        break;
                    }		
                    tempx = tempx + dx;
                } 
                return pathIsClear;
            }
    
            if (deltaX == 0) {
                tempy = tempy + dy;
                for (int i = 0; i < Math.abs(deltaY)-1; i++) {
                    if (Chessboard.getPieceFromBoard(tempx, tempy) != null) {
                        pathIsClear = false;
                        break;
                    }
                    tempy = tempy + dy;
                }
                return pathIsClear;
            }	
            if (deltaX != 0 && deltaY != 0) {
                tempx = tempx + dx;
                tempy = tempy + dy;
                for (int i = 0; i < Math.abs(deltaY)-1; i++) {
                    if (Chessboard.getPieceFromBoard(tempx, tempy) != null) {
                        pathIsClear = false;
                        break;
                    }
                    tempx = tempx + dx;
                    tempy = tempy + dy;
                } 
            }
            
            return pathIsClear;
            
        }
        
        /** 
         * @param whiteturn method asking whos turn it is
         * @return boolean returns the whether the king in question is in check
         */
        //Checks if King is in Check
        public boolean detectCheck(boolean whiteturn) {
            int kingLocX = 0;
            int kingLocY = 0;
            
                
            if (wturn == true) {//if whiteturn is false, check if the white is in check
                for (int y = 0; y < 8; y++){
                    for (int x = 0; x < 8; x++){
                        if ((Chessboard.getPieceFromBoard(x, y) != null)&&(Chessboard.getPieceFromBoard(x, y).getPiece()=='k') &&(Chessboard.getPieceFromBoard(x, y).getColor() == 'w')) {
                                kingLocX = x;
                                kingLocY = y;
                                break;
                            }
                    }
                }
                //white king in check
                for (int y = 0; y < 8; y++){
                    for (int x = 0; x < 8; x++){ 
                        if ((Chessboard.getPieceFromBoard(x, y) != null)&&(Chessboard.getPieceFromBoard(x, y).getColor() == 'b')) {
                                if (Chessboard.getPieceFromBoard(x, y).checkMoveValidity(x, y, kingLocX, kingLocY, true)) {
                                    if (isPathClear(x, y, kingLocX, kingLocY)) {return true;}
                                }
                            
                        }
                    }
                }
            }
            
            
            if (wturn == false) {//if whiteturn is true, check if the black is in check
                for (int y = 0; y < 8; y++){
                    for (int x = 0; x < 8; x++){
                        if ((Chessboard.getPieceFromBoard(x, y) != null)&&(Chessboard.getPieceFromBoard(x, y).getPiece()=='k' && Chessboard.getPieceFromBoard(x, y).getColor() == 'b')) {
                                kingLocX = x;
                                kingLocY = y;
                                break;
                            
                        }
                    }
                }
                //black king in chcek
                for (int y = 0; y < 8; y++){
                    for (int x = 0; x < 8; x++){
                        if ((Chessboard.getPieceFromBoard(x, y) != null)&&(Chessboard.getPieceFromBoard(x, y).getColor() == 'w')) {
                                if (Chessboard.getPieceFromBoard(x, y).checkMoveValidity(x, y, kingLocX, kingLocY, true)) {
                                    if (isPathClear(x, y, kingLocX, kingLocY)) {return true;}
                                }
                            }
                        
                    }
                }
            }
            
        
            return false;
        }
}
