package game;

import java.awt.Graphics;

public class Level_01 extends Scene
{
	int time;
	
	Background background;
	
	Pallet palletPlayer;
	PalletComputer palletComputer;
	Ball ball;
	
	public Level_01()
	{
		time = 0;
		this.background = new Background(0,0,800,600, "/images/background_level.png");
		this.palletPlayer = new Pallet(765, 300, 10, 100, "/images/pallet.png");
		this.palletComputer = new PalletComputer(15, 300, 10,100, "/images/pallet.png");
		this.ball = new Ball(400, 300, 13, 13, "/images/ball.png", 7);
	}

	@Override
	public void Update()
	{
		System.out.println("Level_01");
		
		/*if (time++ > 100)
		{
			SceneManager.ChangeScene(2);
		}*/
		
		if (Collision.collision(this.ball, this.palletPlayer))
			this.ball.speedX *= -1;
		
		if (Collision.collision(this.ball, this.palletComputer))
			this.ball.speedX *= -1;
		
		this.palletPlayer.Update();
		this.palletComputer.Update();
		this.ball.Update();
	}

	@Override
	public void Draw(Graphics graphics)
	{
		this.background.Draw(graphics);
		this.palletPlayer.Draw(graphics);
		this.palletComputer.Draw(graphics);
		this.ball.Draw(graphics);
	}
}