package base_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {

	protected Paddle mypaddle;
	protected Timer timer;
	protected Ball myball;
	protected Vector<Brick> bricks;
	protected boolean ingame;
	private String message = new String();
	
	public GamePanel() {
		//set the panel
		this.setSize(Main.windowX, Main.windowY);
		this.setBackground(Color.BLUE);
		this.setLayout(null);
		this.setFocusable(true);
		this.setDoubleBuffered(true);
	}
	
	@Override
	public void run() {
		//initiation
		initGame();
		this.requestFocusInWindow();
		this.setVisible(true);
	}
	
	private void initGame() {
		this.mypaddle = new Paddle();
		this.myball = new Ball();
		this.bricks = new Vector<Brick>();
		this.ingame = true;
		for (int i=0;i<Main.windowX-125;i=i+125)
		{
			for (int j=0;j<3;j++)
			{
				Brick b = new Brick(i, j*30);
				bricks.add(b);
			}
		}
		this.timer = new Timer();
		this.timer.scheduleAtFixedRate(new ScheduleTask(), 1000, 10);
	}
	
	class ScheduleTask extends TimerTask {

		@Override
		public void run() {
			new Thread(myball).start();
			new Thread(mypaddle).start();
			collosionDetect();
			GamePanel.this.addKeyListener(mypaddle);

			repaint();
		}
		
	}
	
	public void collosionDetect() {
		//if the ball fall down, the game ending with failure
		if (myball.getRect().getMaxY()>=getHeight())
		{
			stopGame();
			this.message = "Vesztettél!";
		}
		//if all of the bricks destroyed, the game ending wiht success
		boolean allDestroyed = true;
		for (Brick b : bricks)
		{
			if (!b.isDestroyed())
			{
				allDestroyed = false;
			}
		}
		if (allDestroyed)
		{
			stopGame();
			this.message = "Győztél!";
		}
		//paddle and ball
		if (myball.getRect().intersects(mypaddle.getRect()))
		{
			//accelerated version
			int quarter = mypaddle.getWidth()/4;
			if (myball.getRect().getMaxY()<=mypaddle.getY()+3 && myball.getRect().getMaxY()>=mypaddle.getY())
			{
				myball.setDy(-1);
				if (myball.getRect().getCenterX() < mypaddle.getX()+quarter)
				{
					myball.setDx(myball.getDx()-0.2);
				}
				if (myball.getRect().getCenterX() > mypaddle.getRect().getMaxX()-quarter)
				{
					myball.setDx(myball.getDx()+0.2);
				}
			}
			else
			{
				if (myball.getRect().getMaxX()<=mypaddle.getX()+3 && myball.getRect().getMaxX()>=mypaddle.getX())
				{
					myball.setDx(-2);
				}
				if (myball.getX()<=mypaddle.getRect().getMaxX() && myball.getX()>=mypaddle.getRect().getMaxX()-3)
				{
					myball.setDx(2);
				}
			}
		}
		//ball and bricks
		for (Brick b : bricks)
		{
			if (!b.isDestroyed() && b.getRect().intersects(myball.getRect()))
			{
				//simplest version
				if (myball.getRect().getY()<=b.getRect().getMaxY())
				{
					myball.setDy(1);
					b.setDestroyed(true);
				}
			}
		}
	}
	
	private void stopGame() {
		this.ingame = false;
		this.timer.cancel();
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//if the game has started
		if (ingame)
		{
			//clear the background (blue)
			//g.setColor(Color.white);
			//g.fillRect(0, 0, getWidth(), getHeight());
			//paint the ball
			g.drawImage(myball.getImage(), myball.getX(), myball.getY(), myball.getWidth(), myball.getHeight(), this);
			//paint the paddle
			g.drawImage(mypaddle.getImage(), mypaddle.getX(), mypaddle.getY(), mypaddle.getWidth(), mypaddle.getHeight(), this);
			//paint the bricks
			for (Brick b : bricks) {
				if (!b.isDestroyed())
				{
					g.drawImage(b.getImage(), b.getX(), b.getY(), b.getWidth(), b.getHeight(), this);
				}
			}
		}
		//if the game has stopped
		else
		{
			g.setColor(Color.black);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
			g.drawString(this.message, getWidth()/2-50, getHeight()/2);
		}
		
		//Toolkit.getDefaultToolkit().sync();
		//g.dispose();
	}

}
