package game;

public class PalletComputer extends GameObject
{
	boolean goingUpComputer;
	
	float velocity;
	
	public PalletComputer(float x, float y, int w, int h, String image)
	{
		super(x, y, w, h, image);
		
		velocity = 6;
	}
	
	@Override
	public void Update()
	{
		ComputerBehavior();
	}
	
	public void FixedLimits()
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
	}
	
	public void ComputerBehavior()
	{	
		FixedLimits();
		
		if (goingUpComputer)
		{
			this.y -= velocity;
		}
		else
		{
			this.y += velocity;
		}
	}
}
