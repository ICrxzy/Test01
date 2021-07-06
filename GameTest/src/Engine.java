public class Engine {
	public static void main(String[] args) {
		System.out.println("Engine Starting...");
		new Thread(new Gameloop(new Game(800, 600))).start();
		System.out.println("Engine Online");
	}
}