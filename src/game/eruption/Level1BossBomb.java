package game.eruption;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
/*This class is for creating the enemy bomb when the handler 
adds this object into the game and it is also part of the GameObject abstract class */
public class Level1BossBomb extends GameObject
{
	private double x,y;
	private SpriteTextures texture;
	private ObjectHandler handler;
	private ID id;
	private Random r = new Random();
	private int yVel;
	/* /* The constructor initializes the variables for this object depending on 
	 * what was passed in and also this has yVel parameter which will be used
	 * to have different speeds for the enemy bomb */
	public Level1BossBomb(double x,double y,SpriteTextures texture,ObjectHandler handler,ID id,int yVel)
	{
		super(x,y,id);
		this.x = x;
		this.y = y;
		this.handler = handler;
		this.texture = texture;
		this.yVel = yVel;
	}
	/* This creates a rectangle around the bomb 
	 * which is used to check collision with the player */
	public Rectangle getRect()
	{
		return new Rectangle((int)x,(int)y,50,50);
	}
	/* This method is called 60 times per second and 
	 * it makes the enemy bomb fall down(at different speeds depending on yVel)  
	 * the object is removed when it is passed the y value of
	 * the game screen */
	public void update()
	{
		y+=yVel;
		if(y>800)
			handler.removeObject(this);
	}
	/* This method is also called 60 times per second 
	 * and it takes the values and draws the enemy bomb into the game
	 * with it's updated locations(x and y) */
	public void render(Graphics g) 
	{
		g.drawImage(texture.bomb,(int)x,(int)y,50,50,null);
	}
	/* These two methods are not needed(yet) but since 
	 * this class extends the abstract class GameObject we 
	 * need to have these methods */
	public double getX() 
	{
		return 0;
	}
	public double getY() 
	{
		return 0;
	}

}