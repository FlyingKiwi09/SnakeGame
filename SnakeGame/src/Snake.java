
public class Snake {

	public SnakeSegment head;
	
	
	public Snake() {
		this.head = new SnakeSegment(100, 100, true, true, Direction.UP, null);
	}
	
	public void draw() {
		this.head.draw();
	}
	
	public void addSegment() {
		SnakeSegment newSegment = new SnakeSegment();
		this.head.addSegment(newSegment);
	}
	
	public void randomMove() {
		this.head.setRandomDirection();
		this.head.updateCoords();
	}
}
