package paqueteGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Principal extends JPanel {

	Bola bola = new Bola(this);
	Raqueta raq = new Raqueta(this);
	
	
	int speed = 1;

	private int getScore() {
		return speed - 1;
	}
	private void mover(){
		bola.move();
		raq.move();
	}
	
	public Principal() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				raq.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				raq.keyPressed(e);
			}
		}
		);
		setFocusable(true);
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
		
		bola.paint(g2d);
		raq.paint(g2d);
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "your score is: " + getScore(),
				"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	public static void main(String[] args) throws InterruptedException{

		
		JFrame frame = new JFrame("Pantalla");
		Principal juego = new Principal();
		frame.add(juego);
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		while(true){
			juego.mover();
			juego.repaint();
			Thread.sleep(10);
			
		}
	}

}
