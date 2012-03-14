package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public abstract class GameObject
{
	protected Image image;
	protected float x;
	protected float y;
	protected int w;
	protected int h;
	
	public GameObject (float x, float y, int w, int h, String image)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		this.image = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(image));
	}
	
	public void Update()
	{
		
	}
	
	public void Draw(Graphics graphics)
	{
		graphics.drawImage(this.image, (int)x, (int)y, w, h, null);
	}
}
