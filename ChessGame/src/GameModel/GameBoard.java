/**
 * @author Julio Johnson Lopez
 * @author Michelle Dong
 */

 package GameModel;
//big board, has all the ranks and files where the squares are held
public abstract class GameBoard {
	public int columns;
	public int rows;
	
	public GameBoard(int columns, int rows) {
		this.columns = columns;
		this.rows = rows;
	}
}
