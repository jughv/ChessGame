/**
 * @author Julio Johnson Lopez
 * @author Michelle Dong
 */

 package GameModel;
//things to go on the placeholder locations of the board squares, wouldn't work without it
public abstract class GamePiece {
	public String name;
	public char color;
	
	public GamePiece(String name, char color) {
		this.name = name;
		this.color = color;
	}
	
	/** 
	 * @return char color
	 */
	//color of it, planning ahead for pieces goo
	public char getColor() {
		return this.color;
	}
	
	/** 
	 * @return char piece name
	 */
	//name of it, planning ahead for pieces goo
	public char getNameI() {
		return this.name.charAt(0);
	}
	
	

}
