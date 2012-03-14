package game;

public class Collision
{
	public static boolean collision(GameObject go1, GameObject go2)
	{
		return go1.x < go2.x + go2.w &&
			   go2.x < go1.x + go1.w &&
			   go1.y < go2.y + go2.h &&
			   go2.y < go1.y + go1.h;			   
	}
}
