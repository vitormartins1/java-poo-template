package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pallet extends GameObject implements KeyListener
{
	float maxPositionY;
	float minPositionY;
	
	boolean upPressedPlayer;
	boolean downPressedPlayer;
	
	boolean goingUpComputer;
	
	private float velocity;
	
	public Pallet(float x, float y, int w, int h, String image)
	{
		super(x, y, w, h, image);
		
		Game.getInstance().getCanvas().addKeyListener(this);
		maxPositionY = 600 - w/2;
		minPositionY = w/2;
		velocity = 6;
		
	}

	@Override
	public void Update()
	{
		System.out.println("Level_01");
		
		if (upPressedPlayer)
			this.y -= velocity;
		
		if (downPressedPlayer)
			this.y += velocity;
		
		FixedLimits();
		
	}
	
	private void FixedLimits()
	{
		if (this.y < 0 + 24)
			this.y = 0 + 24;
		else if (this.y + this.h > 600)
			this.y = 600 - this.h;
	}
	
	public void ComputerBehavior()
	{
		if (this.y < 0 + 24)
		{
			this.y = 0 + 24;
			goingUpComputer = false;
		}
		else if (this.y + this.h > 600)
		{
			this.y = 600 - this.h;
			goingUpComputer = true;
		}
		
		if (goingUpComputer)
		{
			this.y -= velocity;
		}
		else
		{
			this.y += velocity;
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
			upPressedPlayer = true;
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			downPressedPlayer = true;
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
			upPressedPlayer = false;
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			downPressedPlayer = false;
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}
	
	enum STATE
	{
		PLAYER,
		PLAYER2,
		COMPUTER,
	}
}
