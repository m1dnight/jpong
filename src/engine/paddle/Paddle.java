package engine.paddle;

import java.awt.Color;
import java.awt.Graphics;

import engine.Collision;
import engine.Draw;

public class Paddle implements Collision, Draw
{
	private int    height;
	private int    width;
	
	// Current status variables.
	private double y_loc;       // Y location in the plane.
	public double getX_loc()
	{
		return x_loc;
	}
	public void setX_loc(double x_loc)
	{
		this.x_loc = x_loc;
	}

	private double x_loc;
	private double speed;     // Double value indicating the speed of the ball. (> 1)

	
	//---- CONSTRUCTORS ------------------------------------------------------//
	public Paddle(int y_loc, int x_loc, double speed, int height, int width)
	{
		this.speed  = speed; // Set default speed.
		this.y_loc  = y_loc;
		this.x_loc  = x_loc;
		this.height = height;
		this.width  = width;
	}
	//---- COLLIDABLE INTERFACE METHODS --------------------------------------//
	@Override
	public boolean collidesWith(Collision object)
	{
		for(int x = (int) this.x_loc; x <= this.x_loc + this.width; x++)
		{
			for(int y = (int) this.y_loc; y < this.y_loc + this.height; y++)
				if(object.inHitbox(x, y)) return true;
		}
		return false;
	}

	@Override
	public boolean inHitbox(int x, int y)
	{
		// Determine if given x and y coordinates are in our hitbox.
		boolean inx = x > this.x_loc && x < this.x_loc + this.width;
		boolean iny = y > this.y_loc && y < this.y_loc + this.height;
		return inx && iny;
	}
	//---- DRAW INTERFACE ----------------------------------------------------//
	public void draw(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect((int)this.x_loc, (int)this.y_loc, width, height);
	}
	//---- LOGIC METHODS -----------------------------------------------------//

	public void moveDown()
	{
		this.y_loc += 1;
		
	}
	public void moveUp()
	{
		this.y_loc -= 1;
		
	}
	

	//---- GETTERS AND SETTERS -----------------------------------------------//
	public double getY_loc()
	{
		return y_loc;
	}
	public int getY()
	{
		return (int) Math.round(y_loc);
	}
	public void setY_loc(double y_loc)
	{
		this.y_loc = y_loc;
	}
	public double getSpeed()
	{
		return speed;
	}
	public void setSpeed(double speed)
	{
		this.speed = speed;
	}
	
	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}
	
}