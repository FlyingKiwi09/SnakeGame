import java.util.ArrayList;

import ecs100.UI;



public class World {
	
	
	private static final int WORLD_WIDTH = 200;
	private static final int WORLD_HEIGTH = 200;
	private ArrayList<Snake> snakes;
	
	public World() {
		this.snakes = new ArrayList<Snake>();
	}

	public ArrayList<Snake> getSnakeHeads() {
		return snakes;
	}

	public void setSnakeHeads(ArrayList<Snake> snakes) {
		this.snakes = snakes;
	}
	
	
	public void drawWorld() {
		UI.drawRect(10, 10, WORLD_WIDTH, WORLD_HEIGTH);
		for (Snake snake : snakes) {
				snake.draw();
		}
	}
		
	public void updateWorld() {
		for (Snake snake : snakes) {
			
			int p = 1 + (int) (Math.random() * 4);
			if (p == 1) {
				snake.addSegment();
			}
			
			snake.randomMove();

		}
	}
	
}
