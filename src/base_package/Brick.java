/**
 * 
 */
package base_package;

import javax.swing.ImageIcon;

/**
 * @author imisrac
 *
 */
public class Brick extends Sprite {
	
	protected boolean isDestroyed;

	/**
	 * 
	 */
	public Brick(int x, int y) {
		this.x = x;
		this.y = y;
		this.isDestroyed = false;
		this.image = new ImageIcon("brick.png").getImage();
		this.width = this.image.getWidth(null);
		this.height = this.getImage().getHeight(null);
	}

	/**
	 * @return the isDestroyed
	 */
	public boolean isDestroyed() {
		return isDestroyed;
	}

	/**
	 * @param isDestroyed the isDestroyed to set
	 */
	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
	
	
	
}
