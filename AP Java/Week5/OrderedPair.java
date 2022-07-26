package week5;

public class OrderedPair {
	private int x;
	private int y;
	
	public OrderedPair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//other methods ...
	
	/** @return this OrderedPair in String form */
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
