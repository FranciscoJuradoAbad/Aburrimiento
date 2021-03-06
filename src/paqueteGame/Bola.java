package paqueteGame;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bola {
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Principal game;

	public Bola (Principal game) {
		this.game= game;
	}

	void move() {
		if (x + xa < 0)
			xa = game.speed;
		else if (x + xa > game.getWidth() - DIAMETER)
			xa = -game.speed;
		else if (y + ya < 0)
			ya = game.speed;
		else if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		else if (collision()){
			ya = -game.speed;
			y = game.raq.getTopY() - DIAMETER;
			game.speed++;
		}
		x = x + xa;
		y = y + ya;
	}
	private boolean collision() {
		return game.raq.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}
