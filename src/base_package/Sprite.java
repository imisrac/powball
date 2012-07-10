/**
 * 
 */
package base_package;

import java.awt.Image;
import java.awt.Rectangle;

/**
 * @author imisrac
 *
 */
public abstract class Sprite {

	protected int x,y, width, height;
	protected Image image;
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}
	/**
	 * @return the rectangle of the sprite
	 */
	public Rectangle getRect() {
		return new Rectangle((int)x, (int)y, width, height);
	}
}
