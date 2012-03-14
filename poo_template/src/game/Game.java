package game;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;

public class Game 
{
	private Canvas canvas;
	
	private static Game instance;
	
	long lastTime;
	
	int fps;
	long a, b;
	
	Image image;
	float x, y;
	int w, h;
	
	private Game()
	{
		GraphicsEnvironment ge   = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd        = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();	
		
		this.canvas = new Canvas(gc);
		
		this.lastTime = System.nanoTime();
		
		this.image = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/background_opening.png"));		
		this.x = this.y = 0;
		this.w = 800;
		this.h = 600;
		
		instance = null;
	}
	
	public static Game getInstance()
	{
		if (instance == null)
		{
			instance = new Game();			
		}
		return instance;
	}
	
	public Canvas getCanvas() 
	{
		return canvas;
	}
		
	public void run()   
	{	
		long currentTime = 0;
		
		SceneManager.Setup();
		
		while (true)
		{
			currentTime = System.nanoTime();
			
			// ESCREVA SEU CODIGO AQUI
			
			//Update
			SceneManager.Update();
			
			//Draw
			//this.canvas.getGraphics().drawImage(this.image, (int)this.x, (int)this.y, this.w, this.h, null);
			SceneManager.Draw(this.canvas.getGraphics());
			
			this.canvas.swapBuffers();
								
			this.lastTime = currentTime;
						
			// FPS
			a = System.nanoTime();
			fps++;
			if (a - b >= 1000000000)
			{
				this.canvas.setTitle("fps: " + fps);
				fps = 0;
				b = a;
			}			
			
			try 
			{
				Thread.sleep(33);
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
		}
	}
}
