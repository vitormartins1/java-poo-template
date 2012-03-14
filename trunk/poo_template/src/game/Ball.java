package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ball extends GameObject implements KeyListener
{
	float speedX;
	float speedY;
	
	int previousVectorY;
	int previousVectorX;
	
	boolean stop;
	
	public Ball(float x, float y, int w, int h, String image, float speed)
	{
		super(x, y, w, h, image);
		Game.getInstance().getCanvas().addKeyListener(this);
		this.speedX = this.speedY = speed;
		stop = false;
	}
	
	@Override
	public void Update()
	{
		this.x += this.speedX;
		this.y += this.speedY;
		
		if (stop)
		{
			speedX = 0;
			speedY = 0;
		}
		else
		{
			this.Collision();
		}		
	}
	
	private void Collision()
	{	
		if (this.x < 8)
			SceneManager.ChangeScene(2);
			//this.speedX *= -1;
		else if (this.x > 800 - 21)
			SceneManager.ChangeScene(2);
			//this.speedX *= -1;
		
		if (this.y < 15 + w)//26 + w/2)
			this.speedY *= -1;
		else if (this.y > 600 - 21)//13 - w/2)
		{
			this.speedY *= -1;
			//SceneManager.ChangeScene(2);
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_P)
		{
			stop = true;
			
			if (speedX > 0)
				previousVectorX = 1;
			else
				previousVectorX = -1;
			
			if (speedY > 0)
				previousVectorY = 1;
			else
				previousVectorY = -1;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_O)
		{
			x = 400;
			y = 300;
			speedX = 10;
			speedY = 10;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_P)
		{
			stop = false;
			speedX = 1 * previousVectorX;
			speedY = 1 * previousVectorY;
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}
}
