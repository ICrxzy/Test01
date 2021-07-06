import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Display extends JFrame {
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	
	public Display(int width, int height) {
		setTitle("Test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setFocusable(false);
		add(canvas);
		pack();
		
		canvas.createBufferStrategy(3);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void Render(Game game) {
		BufferStrategy buffStrat = canvas.getBufferStrategy();
		Graphics gfx = buffStrat.getDrawGraphics();
		
		gfx.setColor(Color.YELLOW);
		gfx.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		gfx.dispose();
		buffStrat.show();
	}
}
