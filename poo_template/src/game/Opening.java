package game;

import java.awt.Graphics;

public class Opening extends Scene
{
	int time;
	
	Background background;
	
	public Opening()
	{
		time = 0;
		this.background = new Background(0,0, 800,600, "/images/background_opening.png");
	}
	
	@Override
	public void Update()
	{
		System.out.println("Opening");
		
		if (time++ > 100)
		{
			SceneManager.ChangeScene(1);
		}
	}

	@Override
	public void Draw(Graphics graphics)
	{
		this.background.Draw(graphics);
	}

}
