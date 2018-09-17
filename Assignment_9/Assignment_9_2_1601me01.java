class Point
{
	double x;
	double y;

	Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
}

abstract class Shape
{
	Point point;

	Shape(Point point)
	{
		this.point = point;
	}

	public void moveBy(double dx, double dy)
	{
		point.x += dx;
		point.y += dy;
	}

	abstract public void getCenter();	
}

class Circle extends Shape
{
	double radius;

	Circle(Point center, double radius)
	{
		super(center);
		this.radius = radius;

		System.out.println("coordinate of the center of the circle is: (" + center.x + ", " + center.y + ") and of radius " + radius);
	}

	public void getCenter()
	{
		System.out.println("coordinate of center of circle is : (" + point.x + ", " + point.y + ")");
	}
}

class Rectangle extends Shape
{
	double width;
	double height;

	Rectangle(Point topLeft, double width, double height)
	{
		super(topLeft);
		this.width = width;
		this.height = height;

		System.out.println("coordinate of top left corner is: (" + topLeft.x +  ", " + topLeft.y + ")");
		System.out.println("coordinate of bottom right corner is: (" + (topLeft.x+width) + ", " + (topLeft.y-height) + ")");
	}

	public void getCenter()
	{
		System.out.println("coordinate of center of rectengle is : (" + (point.x+ width/2) + ", " + (point.y-height/2) + ")");
	}
}

class Line extends Shape
{
	Point to;

	Line(Point from, Point to)
	{
		super(from);
		this.to = to;

		System.out.println("coordinate of line is from: (" + from.x+ ", " + from.y + ") to (" + to.x+ ", " + to.y + ")");
	}

	public void getCenter()
	{
		System.out.println("coordinate of center of line is : (" + (point.x+to.x)/2 + ", " + (point.y+to.y)/2 + ")");
	}
}

class Assignment_9_2_1601me01
{
	public static void main(String[] args) 
	{
		Point point = new Point(0,0);
		Point point2 = new Point(5,5);

		Circle circle = new Circle(point, 5);
		Rectangle rect = new Rectangle(point, 5,5);
		Line line = new Line(point, point2);

		System.out.println();

		circle.getCenter();
		rect.getCenter();
		line.getCenter();
	}
}