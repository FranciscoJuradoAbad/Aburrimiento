package paqueteGame;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Raqueta {

	private static final int Y = 330;
	private static final int WHITH = 60;
	private static final int HEIGHT = 10;
	int x = 0;
	int xa = 0;
	private Principal game;

	public Raqueta(Principal game) {
		this.game = game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - WHITH)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, 330, 60, 10);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -game.speed;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = game.speed;
	}
	public Rectangle getBounds() {
		return new Rectangle(x, Y, WHITH, HEIGHT);
	}

	public int getTopY() {
		return Y - HEIGHT;
	}
}
