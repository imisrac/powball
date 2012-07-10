/**
 * 
 */
package base_package;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author imisrac
 *
 */
@SuppressWarnings("serial")
public class Menu extends JPanel implements ActionListener {

	protected JButton playButton;
	protected JButton helpButton;
	protected JButton okButton;
	protected JButton exitButton;
	protected JLabel titleLabel;
	protected JTextArea helpArea;
	private GamePanel gamepanel;
	private Thread game;
	
	
	
	/**
	 * 
	 */
	public Menu() {
		initButtons();
		titleLabel = new JLabel("Powball játék");
		
		this.setSize(Main.windowX, Main.windowY);
		this.setBackground(Color.BLUE);
		this.setLayout(new FlowLayout());
		
		gamepanel = new GamePanel();
		game = new Thread(gamepanel);
		
		add(titleLabel);
		add(playButton);
		
		this.setVisible(true);
	}
	
	private void initButtons() {
		playButton = new JButton("Start");
		playButton.addActionListener(this);
		helpButton = new JButton("Segítség");
		helpButton.addActionListener(this);
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		exitButton = new JButton("Kilép");
		exitButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(playButton))
		{
			Main.mainFrame.remove(this);
			Main.mainFrame.add(gamepanel);
			game.start();
			this.setEnabled(false);
		}
	}

}
