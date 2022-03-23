package ChessModel;

import java.util.HashMap;

import GameModel.*;
import Pieces.*;
public class Chessboard{
	
	private static Piece[][] board;
	
	public Chessboard(){
		board = new Piece[8][8];
		initializeBoard();
	}
	
	public void initializeBoard(){
		//initialize the board
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				board[i][j] = null;
			}
		}
		//for the pawns
        for(int i=0; i<8;i++){
		board[i][1] = new Pawn(false);}
        board[0][6] = new Pawn(true);

		//white pieces
		board[0][0] = new Rook(false);
		board[1][0] = new Knight(false);
		board[2][0] = new Bishop(false);
		board[3][0] = new Queen(false);
		board[4][0] = new King(false);
		board[5][0] = new Bishop(false);
		board[6][0] = new Knight(false);
		board[7][0] = new Rook(false);
		//black pieces
		board[0][7] = new Rook(true);
		board[1][7] = new Knight(true);
		board[2][7] = new Bishop(true);
		board[3][7] = new Queen(true);
		board[4][7] = new King(true);
		board[5][7] = new Bishop(true);
		board[6][7] = new Knight(true);
		board[7][7] = new Rook(true);
	
		
	}
	public void drawBoard(){
		String[][] result = new String[8][8];
		
		//make the tiles white or black
		boolean white = true;
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				if (white){
					result[i][j] = "  |";
					white = false;
				}else{
					result[i][j] = "##|";
					white = true;
				}
			}
			white = !(white);
		}	
		
		// draw the pieces in the right locations
		for (int y = 0; y < 8; y++){
			for (int x = 0; x < 8; x++){
				
				if (Chessboard.board[x][y] != null){
					result[x][y] = Chessboard.board[x][y].getDisplayString() + "|";
				}
			}
		}
		
		//print out the whole board  
		System.out.println("_________________________");
		for (int y = 0; y < 8; y++){
			System.out.print("|");
			for (int x = 0; x < 8; x++){
				System.out.print(result[x][y]);
			}
			 System.out.print("  " + (8-y));
			 System.out.println();
		}
		System.out.println("\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'\'"); 
		System.out.println(" a  b  c  d  e  f  g  h"); 
	}


	public static Piece getPieceFromBoard(int x, int y){
        return Chessboard.board[x][y];
    }

	public static void movePiece(int oldx,int oldy, int newx, int newy){
		Chessboard.board[newx][newy] = getPieceFromBoard(oldx, oldy);
		Chessboard.board[oldx][oldy] = null;
	}
}