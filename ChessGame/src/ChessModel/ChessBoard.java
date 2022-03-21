package ChessModel;

//import java.util.*;

//import ChessModel.Pieces.*;
import GameModel.GameBoard;
import Pieces.*;





public class ChessBoard extends GameBoard{
    public static final int numRanks = 8;
    public static final int numFiles = 8;
    public static final String BLACK_SQUARE = "##";
    public static final char BLACK = 'b';
    public static final String WHITE_SQUARE = "  ";
    public static final char WHITE = 'w';

    public static final String FILE_ROW = " a  b  c  d  e  f  g  h";

//the array that starts this mess
    public ChessBoardSquare[][] chessBoard;
//make an empty one and then think abt pieces/ prints later
    public ChessBoard() {
        super(numRanks, numFiles);
        this.chessBoard = new ChessBoardSquare[numRanks][numFiles];
        initializeEmptyBoard();
        initializeChessBoard();
    }
//where colorT is for tracking if it's black or white
//credit to Gerard Taylor on youtube for inspiration for the idea I was so close to bashing my head in
    public void initializeEmptyBoard()  {
        int colorT = 1;
        for(int i = 0; i < rows; i++) {
            colorT--;
            for(int k =0; k < columns; k++) {
                if(colorT%2==0) {
                    this.chessBoard[i][k] = new ChessBoardSquare(i, k, null, WHITE);
                    colorT++;
                }
                else {
                    this.chessBoard[i][k] = new ChessBoardSquare(i, k, null, BLACK);
                    colorT++;
                }
            }
        }
    }

    public void initializeChessBoard() {
        // Initialize Pawns for both sides, make sure that there aren't only 7 this time
        //need to get these pieces made, originally just substituted them with print statements
        for(int i = 0; i < numRanks; i++ ) {
            this.chessBoard[1][i].piece = new Pawn(BLACK);
            this.chessBoard[6][i].piece = new Pawn(WHITE);
        }
        // Initiaze black pieces 
        //need to get these pieces made, originally just substituted them with print statements
        this.chessBoard[0][0].piece = new Rook(BLACK);
        this.chessBoard[0][1].piece = new Knight(BLACK);
        this.chessBoard[0][2].piece = new Bishop(BLACK);
        this.chessBoard[0][3].piece = new Queen(BLACK);
        this.chessBoard[0][4].piece = new King(BLACK);
        //think about castling in a bit, maybe a check to see if the king has moved? Doesn't have to be if it's in the starting square, just if it's moved
        this.chessBoard[0][5].piece = new Bishop(BLACK);
        this.chessBoard[0][6].piece = new Knight(BLACK);
        this.chessBoard[0][7].piece = new Rook(BLACK);

        //Initialize white pieces
        //need to get these pieces made, originally just substituted them with print statements
        this.chessBoard[7][0].piece = new Rook(WHITE);
        this.chessBoard[7][1].piece = new Knight(WHITE);
        //think about castling in a bit, maybe a check to see if the king has moved? Doesn't have to be if it's in the starting square, just if it's moved
        this.chessBoard[7][2].piece = new Bishop(WHITE);
        this.chessBoard[7][3].piece = new Queen(WHITE);
        this.chessBoard[7][4].piece = new King(WHITE);
        this.chessBoard[7][5].piece = new Bishop(WHITE);
        this.chessBoard[7][6].piece = new Knight(WHITE);
        this.chessBoard[7][7].piece = new Rook(WHITE);
    }
//remember to make sure that the squares are alternating correctly this time
    public void printChessBoardEmpty() {
        for(int i = 0; i < rows; i++) {
            System.out.println("");
            for(int k =0; k < columns; k++) {
                System.out.print(this.chessBoard[i][k].file +""+ this.chessBoard[i][k].rank + " ");
            }
        }
    }
    public void printChessBoard() {

    	System.out.print("\n");
        for(int i = 0; i < rows; i++) {
            for(int k =0; k < columns; k++) {
                if(this.chessBoard[i][k].piece!=null)System.out.print(this.chessBoard[i][k].piece.getDisplayString());
                else if(this.chessBoard[i][k].color == BLACK)System.out.print(BLACK_SQUARE);
                else System.out.print(WHITE_SQUARE);
                System.out.print(" ");
            }
            System.out.print(8-i + "\n");
        }
        System.out.println(FILE_ROW);

    }

}
