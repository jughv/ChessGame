/**
 * @author Julio Johnson Lopez
 * @author Michelle Dong
 */

 package ChessModel;

//import ChessModel.Pieces.Piece;
import GameModel.BoardSquare;
//elaborates on game model stuff
import Pieces.*;

public class ChessBoardSquare extends BoardSquare {
	public char color;
	public char rank, file;
	public Piece piece;
	//where is it (rank file) what is it (black white)+ (type of piece) the marriage of empty lot and what it is
	public ChessBoardSquare(int row, int column, Piece piece, char color) {
		super(row, column);
		this.piece = piece;
		this.rank = Character.forDigit((8 -row), 10);
		this.file = (char) (column + 'a');
		this.color = color;
	}

}
