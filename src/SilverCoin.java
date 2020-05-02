import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
/*This class is for creating the Silver Coin when the handler 
adds this object into the game as it is part of the GameObject abstract class */
public class SilverCoin extends GameObject
{
	private double x,y;
	private SpriteTextures texture;
	private ObjectHandler handler;
	private Random r = new Random();
	private int timer = 60;
	private double yVel = r.nextInt(10)+7;
	private ID id;
	private Color color = new Color(192,192,192);
	/* The constructor initializes the variables for this object depending on 
	 * what was passed in */
	public SilverCoin(double x,double y,SpriteTextures texture,ObjectHandler handler,ID id)
	{
		super(x,y,id);	
		this.x = x;
		this.y = y;
		this.texture = texture;
		this.handler = handler;
	}
	/* This creates a rectangle around the silver coin 
	 * which is used to check collision with the player */
	public Rectangle getRect()
	{
		return new Rectangle((int)x,(int)y,36,36);
	}
	/* This method is called 60 times per second and 
	 * it makes the silver coin fall down and it also adds
	 * a trail using the Trail class and it removes 
	 * the object when it is passed the y value of
	 * the game screen */
	public void update() 
	{
		y+=yVel;
		if(y>=832)
			handler.removeObject(this);	
		handler.addObject(new Trail((int)x+10,(int)y-15,ID.Trail,color,16,16,0.08f,handler));
	}
	/* This method is also called 60 times per second 
	 * and it takes the values and draws the silver coin into the game
	 * with it's updated locations(x and y) */
	public void render(Graphics g) 
	{
		g.drawImage(texture.silverCoin,(int)x,(int)y,36,36,null);
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