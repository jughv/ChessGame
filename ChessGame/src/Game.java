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



    public void play() {
        gameBoard.drawBoard();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;



        while (!wWin && !bWin && !draw){

            input = null;

            boolean check = false; //check for a check here
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

            
            if(!parseString(input)){
                System.out.println("Invalid move, try again");
                continue;
            }

            check = false;//gameboard.detectCheck(!whiteTurn);
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


    public boolean parseString(String input){
        char[] temp = input.toCharArray();
        int oldx, oldy, newx, newy;

        if (input == "resign" || input == "Resign"){
            if(wturn){
                System.out.println("Black Wins!");
            } else{
                System.out.println("White Wins!");
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
            oldy = column.get(temp[0]);
        }

        if(!row.containsKey(temp[1])){ //checks if in row map
            return false;
        } else{
            oldx = column.get(temp[1]);
        }

        if(!column.containsKey(temp[3])){ //checks if in column map
            return false;
        } else{
            newy = column.get(temp[3]);
        }

        if(!row.containsKey(temp[4])){ //checks if in row map
            return false;
        } else{
            newx = row.get(temp[4]);
        }

        if (Chessboard.getPieceFromBoard(oldx, oldy).getPiece() == 'p'){//if pawn
            if(Pawn.checkMoveValidity(oldx, oldy, newx, newy)){
                Chessboard.movePiece(oldx, oldy, newx, newy);
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
}
