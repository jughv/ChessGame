import ChessModel.ChessBoard;
import java.util.*;
//import GameModel.GameBoard;


public class Game {
    private static HashMap<Character,Integer> column = new HashMap<Character,Integer>();
    private static HashMap<Character,Integer> row = new HashMap<Character,Integer>();
    private ChessBoard gameBoard;

    public Game(){
        gameBoard = new ChessBoard();
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
        Game.row.put('1', 0);
        Game.row.put('2', 1);
        Game.row.put('3', 2);
        Game.row.put('4', 3);
        Game.row.put('5', 4);
        Game.row.put('6', 5);
        Game.row.put('7', 6);
        Game.row.put('8', 7);
    }



    public void play() {
        setColumn();
        setRow();
        gameBoard.printChessBoard();
    }
}
