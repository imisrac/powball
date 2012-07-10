/**
 * 
 */
package base_package;

import javax.swing.ImageIcon;


/**
 * @author imisrac
 *
 */
public class Ball extends Sprite implements Runnable {

	protected double dx;
	protected int dy;
	 
    // Private constructor prevents instantiation from other classes
    public Ball() {
    	this.image = new ImageIcon("ball.png").getImage();
    	this.width = this.image.getWidth(null);
    	this.height = this.image.getHeight(null);
    	
    	resetState();
    }
    
    /**
	 * @param d the dx to set
	 */
	public void setDx(double d) {
		this.dx = d;
	}

	/**
	 * @param dy the dy to set
	 */
	public void setDy(int dy) {
		this.dy = dy;
	}

	/**
	 * @return the dx
	 */
	public double getDx() {
		return dx;
	}

	/**
	 * @return the dy
	 */
	public int getDy() {
		return dy;
	}

	private void resetState() {
		this.x = 200;
		this.y = 200;
		this.dx = 1;
		this.dy = -1;
	}

	@Override
	public void run() {
		this.x += this.dx;
		this.y += this.dy;
		
		if (x<=0 || x+width>=Main.windowX)
		{
			dx=-1*dx;
		}
		if (y<=0)
		{
			dy=1;
		}
	}

}
