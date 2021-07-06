public class Game {
	private Display display;
	
	public Game(int width, int height) {
		display = new Display(width, height);
	}
	public void Update() {
		
	}
	public void Render() {
		display.Render(this);
	}
}
