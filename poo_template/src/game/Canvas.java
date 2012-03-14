package game;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Canvas extends JFrame
{
	private static final long serialVersionUID = 1L;

	private Graphics g;
	private BufferStrategy bs;
	
	public Canvas(GraphicsConfiguration gc)
	{
		super(gc);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		setTitle("POO Template");
		
		createBufferStrategy(2);
		this.bs = getBufferStrategy();		
		
		setFocusable(true);
	}	
	
	public Graphics getGraphics()
	{
		try
		{
			this.g = this.bs.getDrawGraphics();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return this.g;
	}
	
	public void swapBuffers()
	{
		this.bs.show();
		this.g.dispose();
		Toolkit.getDefaultToolkit().sync();
	}
}