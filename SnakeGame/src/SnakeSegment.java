import ecs100.UI;

public class SnakeSegment {
	private int x, y;
	private boolean isHead, isTail;
	private Direction direction;
	private SnakeSegment next;
	public static int gap = 10;
	
	// empty constructor for creating snake bodies
	public SnakeSegment() {
		
	}
	
	// constructor for new snake (head)
	public SnakeSegment(int x, int y, boolean isHead, boolean isTail, Direction direction, SnakeSegment next) {
		this.x = x;
		this.y = y;
		this.isHead = isHead;
		this.isTail = isTail;
		this.direction = direction;
		this.next = next;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isHead() {
		return isHead;
	}

	public void setHead(boolean isHead) {
		this.isHead = isHead;
	}

	public boolean isTail() {
		return isTail;
	}

	public void setTail(boolean isTail) {
		this.isTail = isTail;
	}

	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public SnakeSegment getNext() {
		return next;
	}

	public void setNext(SnakeSegment next) {
		this.next = next;
	}
	
	public void draw() {
		if (this.next==null) {
			if (isHead) {
				UI.drawString("S", this.x, this.y);
			} else if (isTail) {
				UI.drawString("o", this.x, this.y);
			}
		} else {
			if (isHead) {
				UI.drawString("S", this.x, this.y);
				this.next.draw();
			} else {
				UI.drawString("O", this.x, this.y);
				this.next.draw();
			}
		}
	}
	
	public void setRandomDirection() {
		// before setting the new random direction for the head, pass along all the current directions
		if (this.next!=null) {
			this.next.setSegments(this.direction);
		}
		// then get a new random direction for head
		int d = 1 + (int) (Math.random() * 4);
		Direction direction = this.direction;
		switch (d) {
			case 1:
				direction =  Direction.UP;
				break;
			case 2:
				direction =   Direction.DOWN;
				break;
			case 3:
				direction =   Direction.LEFT;
				break;
			case 4:
				direction =   Direction.RIGHT;
				break;
		}
		this.setDirection(direction);
	}

	// passes the direction of the current object along to its next segment
	public void setSegments(Direction direction) {
		if (this.next!=null) {
			this.next.setSegments(this.direction);
		} 
		this.setDirection(direction);
	}
	
	// iterates through the snake sgements (using recursion) and updates its coords
	public void updateCoords() {
		if (this.next!=null) {
			next.updateCoords();
		}
		switch (this.direction) {
		case UP:
			this.y = this.y - gap;
			break;
		case DOWN:
			this.y = this.y + gap;
			break;
		case LEFT:
			this.x = this.x - gap;
			break;
		case RIGHT:
			this.x = this.x + gap;
			break;
		}
	}
	
	// iterates through the snake segments to the end and then adds the new segment
	public void addSegment(SnakeSegment s) {
		if (this.next==null) {
			// set direction
			s.setDirection(this.direction);
			// sets x/y			
			switch (this.direction) {
				case UP:
					s.setY(this.y+gap);
					s.setX(this.x);
					break;
				case DOWN:
					s.setY(this.y-gap);
					s.setX(this.x);
					break;
				case LEFT:
					s.setX(this.x+gap);
					s.setY(this.y);
					break;
				case RIGHT:
					s.setX(this.x-gap);
					s.setY(this.y);
					break;
			}
			s.setTail(true);
			s.setHead(false);
			this.setTail(false);
			this.next = s;
			
		} else {
			this.next.addSegment(s);
		}
	}
}
