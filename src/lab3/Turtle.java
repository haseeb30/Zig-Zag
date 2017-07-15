
package lab3;

import princeton.introcs.StdDraw;
import java.awt.Color;

/**
 * A class that supports turtle graphics. A turtle moves between two points in a
 * straight line drawing the line as it moves.
 * 
 * <p>
 * A turtle has-a <code>Point2</code> instance that represents the position of
 * the turtle, and a <code>Color</code> instance that represents the current pen
 * color. The turtle maintains ownership of its position at all times.
 * 
 * 
 * @author EECS2030 Fall 2016-17
 * 
 */

public class Turtle {
	private Point2 position;
	private double angle;
	private Color penColor;

	public Turtle() {

		this.position = new Point2(0.5, 0.5);
		this.angle = 0.0;
		this.penColor = Color.BLACK;

	};

	public Turtle(Turtle other) {

		Point2 newp = new Point2(other.getPosition().getX(), other.getPosition().getY());
		this.position = newp;

		this.angle = other.getAngle();
		this.penColor = other.getPenColor();

	}

	public Turtle(Point2 position) {

		if (position.getX() > 1 || position.getX() < 0 || position.getY() > 1 || position.getY() < 0) {
			throw new IllegalArgumentException();
		}
		Point2 newp = new Point2(position.getX(), position.getY());
		this.position = newp;
		this.angle = 0.0;
		this.penColor = Color.BLACK;

	}

	public Turtle(Point2 position, double angle) {
		if (position.getX() > 1 || position.getX() < 0 || position.getY() > 1 || position.getY() < 0) {
			throw new IllegalArgumentException();

		}
		Point2 newp = new Point2(position.getX(), position.getY());
		this.position = newp;
		this.penColor = Color.BLACK;
		this.angle = Math.toDegrees(angle);

	}

	public Turtle(Point2 position, double angle, Color c) {
		if (position.getX() > 1 || position.getX() < 0 || position.getY() > 1 || position.getY() < 0) {
			throw new IllegalArgumentException();
		}
		Point2 newp = new Point2(position.getX(), position.getY());
		this.position = newp;

		if (c == null) {
			throw new IllegalArgumentException();
		}

		this.penColor = Color.BLACK;
		this.angle = angle;
	}

	public void move(double distance) {
		 double x0=position.getX();
		 double y0=position.getY();
		Vector2 vectormove = Vector2.dirVector(this.angle);
		vectormove = vectormove.multiply(distance);
		this.position.add(vectormove);
		double x1 = position.getX();
		double y2 = position.getY();
		StdDraw.setPenColor(this.penColor);
		StdDraw.line(x0, y0, x1, y2);

		// position.add(Vector2.dirVector(angle).multiply(distance));
	}

	public void turnLeft() {

		angle = angle + 90;
		if (angle > 360) {
			angle = angle - 360;
		}
	}

	public void turnRight() {

		angle = angle - 90;
		if (angle < 360) {
			angle = angle + 360;
		}
	}

	public void turn(double delta) {
		angle = angle + delta;
		
			
			if (angle > 360) {
				angle = angle - 360;
			}
		  if(angle<-360){
			  angle=angle +360;
		  }

		
}
			
				
	

	/**
	 * Sets the pen color.
	 * 
	 * @param c
	 *            the new pen color
	 * @throws IllegalArgumentException
	 *             if the pen color c is null
	 */
	public void setPenColor(Color c) {
		if (c == null) {
			throw new IllegalArgumentException();
		} else
			this.penColor = c;

	}

	/**
	 * Compares this turtle with another object for equality. This turtle can be
	 * equal to only other turtles.
	 * 
	 * <p>
	 * Two turtles are equal if their positions, directions, and pen colors are
	 * all equal; otherwise, the turtles are not equal.
	 * 
	 * @param obj
	 *            An object to compare for equality.
	 * @return True if the position, direction, and pen color of this turtle are
	 *         equal to the position, direction, and pen color of the other
	 *         turtle, and false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Turtle other = (Turtle) obj;
		if (Double.doubleToLongBits(angle) != Double.doubleToLongBits(other.angle)) {
			return false;
		} else if (!penColor.equals(other.penColor)) {
			return false;
		} else if (!position.equals(other.position)) {
			return false;
		}
		return true;
	}

	public Color getPenColor() {
		return this.penColor;
	}

	public Point2 getPosition() {
		return this.position;
	}

	public double getAngle() {
		return this.angle;
	}

	/**
	 * Returns a hash code for this turtle.
	 * 
	 * @return a hash code for this turtle
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(angle);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((penColor == null) ? 0 : penColor.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	/**
	 * Returns a string representation of this turtle. The string representation
	 * is:
	 * 
	 * <ol>
	 * <li>the position of the turtle (as given by <code>Point2.toString</code>
	 * ), followed by
	 * <li>a comma and a space, followed by
	 * <li>the direction, followed by
	 * <li>a space, the string "degrees", a space, and a comma, followed by
	 * <li>the pen color (as given by <code>Color.toString</code>)
	 * </ol>
	 * 
	 * @return a string representation of this turtle
	 */
	@Override
	public String toString() {
		String s = String.format("%s, %f degrees, %s", this.getPosition(), this.getAngle(), this.getPenColor());
		return s;
	}

}