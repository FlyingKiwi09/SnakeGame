import ecs100.UI;

public class Main {
	


	public static void main(String[] args) {
		UI.initialise();
		World theWorld = new World();
		theWorld.getSnakeHeads().add(new Snake());
		
		for (int i = 0; i < 100; i++) {
			theWorld.updateWorld();
			UI.clearPanes();
			theWorld.drawWorld();
			UI.sleep(300);
		}
	}
}
