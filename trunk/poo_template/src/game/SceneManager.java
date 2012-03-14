package game;

import java.awt.Graphics;

public class SceneManager {
	
	private SceneManager()
	{
		
	}
	
	private static Scene scene;
	
	//private static SCENE currentScene;
	
	public static void Setup()
	{
		scene = new Opening();
		//currentScene = SCENE.OPENING;
	}
	
	public static void ChangeScene(int button)
	{
		switch (button)
		{
			case 0:
			{
				scene = new Opening();
				//currentScene = SCENE.OPENING;
				break;
			}
			
			case 1:
			{
				scene = new Level_01();
				//currentScene = SCENE.LEVEL;
				break;
			}
			
			case 2:
			{
				scene = new GameOver();
				//currentScene = SCENE.GAMEOVER;
				break;
			}
		}
	}
	
	public static void Update()
	{
		scene.Update();
	}
	
	public static void Draw(Graphics g)
	{
		scene.Draw(g);
	}
	
	enum SCENE
	{
		OPENING,
		LEVEL,
		GAMEOVER,
	}
}
