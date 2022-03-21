package GameModel;
//board tiles, has the placeholders on where they are, file and rank

public abstract class  BoardSquare{
	public int row, column;
	
	public BoardSquare(int row, int column) {
		this.row = row;
		this.column = column;
	}
}