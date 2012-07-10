/**
 * 
 */
package base_package;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

/**
 * @author imisrac
 *
 */
public class Paddle extends Sprite implements KeyListener, Runnable {
	
	private int dx;
	
	public Paddle() {
		this.image = new ImageIcon("paddle.png").getImage();
		this.height = this.image.getHeight(null);
		this.width = this.image.getWidth(null);
		this.y = Main.windowY-this.height;
		
		resetState();
	}
	
	private void resetState() {
		this.x = Main.windowX/2-80;
		this.dx = 0;
	}

	@Override
	public void keyPressed(KeyEvent ev) {
		int keycode = ev.getKeyCode();
		
		if (keycode == KeyEvent.VK_LEFT)
		{
			this.dx = -2;
		}
		if (keycode == KeyEvent.VK_RIGHT)
		{
			this.dx = 2;
		}
	}

	@Override
	public void keyReleased(KeyEvent ev) {
		int keycode = ev.getKeyCode();

		if (keycode == KeyEvent.VK_LEFT)
		{
			this.dx = 0;
		}
		if (keycode == KeyEvent.VK_RIGHT)
		{
			this.dx = 0;
		}		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		this.x += this.dx;
		
		if (this.x<=0)
		{
			this.x = 0;
		}
		if (this.x+this.width>=Main.windowX)
		{
			this.x=Main.windowX-this.width;
		}		
	}
}
