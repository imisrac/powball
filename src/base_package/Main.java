/**
 * 
 */
package base_package;

import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * @author imisrac
 *
 */
public class Main {

	protected static int windowX = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-200, windowY = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()-200;
	protected static JFrame mainFrame;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mainFrame = new JFrame("Powball!");
		mainFrame.setLayout(null);
		mainFrame.setSize(windowX+3, windowY+32);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//starts with menu
		Menu menu = new Menu();
		mainFrame.add(menu);
		mainFrame.setVisible(true);
		}

}
