
public class Tile {
	private int value;
	private boolean isDown;
	private boolean selected;
	
	/**
	 * constructor for tile
	 * @param v number value of the tile
	 */
	public Tile(int v) {
		value = v;
		isDown = false;
		selected = false;
	}
	
	/**
	 * Shuts the tile
	 */
	public void shut() {
		isDown = true;
	}
	
	/**
	 * Opens the tile 
	 */
	public void putUp() {
		isDown = false;
	}
	
	/**
	 * Check if the tile is down
	 * @return boolean state of isDown
	 */
	public boolean isDown() {
		return isDown;
	}
	
	/**
	 * Selects the tile
	 */
	public void select() {
		selected = true;
	}
	
	/**
	 * Deselects the tile
	 */
	public void deselect() {
		selected = false;
	}
	
	/**
	 * Checks if the tile is selected
	 * @return boolan sate of selected
	 */
	public boolean isSelected() {
		return selected;
	}
	
	/**
	 * Gets the value of the tile
	 * @return the value of the tile
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Outputs the tile in a understandable format for the data
	 */
	@Override
	public String toString() {
		String state = "";
		if (isDown) {
			state = "D";
		}
		else {
			state = "U";
		}
		return "" + value + ":" + state;
	}
	
}
