package game;

import java.awt.Graphics;

public class GameOver extends Scene
{

	int time;
	Background background;
	
	public GameOver()
	{
		time = 0;
		this.background = new Background(0,0,800,600, "/images/background_gameover.png");
	}

	@Override
	public void Update()
	{
		System.out.println("GameOver");
		
		if (time++ > 100)
		{
			SceneManager.ChangeScene(0);
		}
	}

	@Override
	public void Draw(Graphics graphics)
	{
		this.background.Draw(graphics);
	}
}
