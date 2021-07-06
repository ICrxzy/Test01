public class Gameloop implements Runnable{
	private Game game;
	
	private boolean running;
	private final double updateRate = 1.0d/60.0d;
	
	private long nextStatTime;
	private int framesPerSecond, updatesPerSecond;
	
	public Gameloop(Game game) {
		this.game = game;
	}
	
	@Override
	public void run() {
		running = true;
		double accum = 0;
		long currentTime, lastUpdate = System.currentTimeMillis();
		nextStatTime = System.currentTimeMillis() + 1000;
		
		while(running) {
			currentTime = System.currentTimeMillis();
			double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
			accum += lastRenderTimeInSeconds;
			lastUpdate = currentTime;
			
			while(accum > updateRate) {
				Update();
				accum -= updateRate;
			}
			Render();
			printStats();
		}
	}
	private void Render() {
		game.Render();
		framesPerSecond++;
	}
	private void Update() {
		game.Update();
		updatesPerSecond++;
	}
	private void printStats() {
		if(System.currentTimeMillis() > nextStatTime) {
			System.out.println(String.format(String.format("FPS: %d, UPS: %d", framesPerSecond, updatesPerSecond)));
			framesPerSecond = 0;
			updatesPerSecond = 0;
			nextStatTime = System.currentTimeMillis() + 1000;
		}
	}
}
