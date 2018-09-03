abstract class Shape
{
	String color;
	boolean filled;

//getters and setters
	String getColor()
	{
		return this.color;
	}

	void setColor(String c)
	{
		this.color = c;
	}

	boolean isFilled()
	{
		return filled;
	}

	void setFilled(boolean f)
	{	
		this.filled = f;
	}

//abstarct methods
	abstract double getArea();
	abstract double getPerimeter();
}

class Circle extends Shape
{
	double radius;

	Circle(double r)
	{
		this.radius = r;
	}

	Circle(double r, String c, boolean f)
	{
		this.radius = r;
		this.color = c;
		this.filled = f;
	}

//getters and setters
	double getRadius()
	{
		return radius;
	}

	void setRadius(double r)
	{
		this.radius = r;
	}

//definig abstract methods
	double getArea()
	{
		double res = 3.14*radius*radius;
		return res;
	}

	double getPerimeter()
	{
		double res = 2*3.14*radius;
		return res;
	}
}

class Rectangle extends Shape
{
	double length;
	double width;

	Rectangle(double l, double w)
	{
		this.length = l;
		this.width = w;
	}

	Rectangle(double l, double w, String c, boolean f)
	{
		this.length = l;
		this.width = w;
		this.color = c;
		this.filled = f;
	}

//getters and setters
	double getWidth()
	{
		return width;
	}

	void setWidth(double w)
	{
		this.width = w;
	}

	double getLength()
	{
		return length;
	}

	void setLength(double l)
	{
		this.length = l;
	}

//definig abstract methods
	double getArea()
	{
		double res = length*width;
		return res;
	}

	double getPerimeter()
	{
		double res = 2*(length + width);
		return res;
	}
}

class Square extends Rectangle
{
	Square(double side)
	{
		super(side, side);
	}

	Square(double side, String c, boolean f)
	{
		super(side, side, c, f);
	}

//getters and setters
	double getSide()
	{
		return length;
	}

	void setSide(double side)
	{
		this.length = side;
		this.width = side;
	}

//definig abstract methods
	double getArea()
	{
		double res = length*width;
		return res;
	}

	double getPerimeter()
	{
		double res = 2*(length + width);
		return res;
	}
}

public class Assignment_7_1_1601me01
{
	public static void main(String[] args) 
	{
	// ans of 1
		Shape circle = new Circle(5, "red", true);
		double circ_area = circle.getArea();
		double circ_peri = circle.getPerimeter();
		String circ_color = circle.getColor();
		boolean circ_filled = circle.isFilled();

		System.out.println("Area of circle is: " + Double.toString(circ_area));
		System.out.println("Perimeter of circle is: " + Double.toString(circ_peri));
		System.out.println("Color of circle is: " + circ_color);
		System.out.println("Circle is filled: " + Boolean.toString(circ_filled));
		System.out.println("");

	//ans of 2
		Shape circle1 = new Circle(10, "blue", false);
		Circle circle2 = (Circle)circle1;

		double circ2_area = circle2.getArea();
		double circ2_peri = circle2.getPerimeter();
		String circ2_color = circle2.getColor();
		boolean circ2_filled = circle2.isFilled();

		System.out.println("Area of circle is: " + Double.toString(circ2_area));
		System.out.println("Perimeter of circle is: " + Double.toString(circ2_peri));
		System.out.println("Color of circle is: " + circ2_color);
		System.out.println("Circle is filled: " + Boolean.toString(circ2_filled));
		System.out.println("");

	// ans of 3
		Shape rect = new Rectangle(2, 5, "Green", true);
		double rect_area = rect.getArea();
		double rect_peri = rect.getPerimeter();
		String rect_color = rect.getColor();
		boolean rect_filled = rect.isFilled();

		System.out.println("Area of Rectangle is: " + Double.toString(rect_area));
		System.out.println("Perimeter of Rectangle is: " + Double.toString(rect_peri));
		System.out.println("Color of Rectangle is: " + rect_color);
		System.out.println("Rectangle is filled: " + Boolean.toString(rect_filled));
		System.out.println("");
	
	//ans of 4
		Shape rect1 = new Rectangle(9, 10, "Sky", false);
		Rectangle rect2 = (Rectangle)rect1;

		double rect2_area = rect2.getArea();
		double rect2_peri = rect2.getPerimeter();
		String rect2_color = rect2.getColor();
		boolean rect2_filled = rect2.isFilled();

		System.out.println("Area of Rectangle is: " + Double.toString(rect2_area));
		System.out.println("Perimeter of Rectangle is: " + Double.toString(rect2_peri));
		System.out.println("Color of Rectangle is: " + rect2_color);
		System.out.println("Rectangle is filled: " + Boolean.toString(rect2_filled));
		System.out.println("");

	// ans of 5
		Shape square = new Square(6, "Orange", false);
		double square_area = square.getArea();
		double square_peri = square.getPerimeter();
		String square_color = square.getColor();
		boolean square_filled = square.isFilled();

		System.out.println("Area of Square is: " + Double.toString(square_area));
		System.out.println("Perimeter of Square is: " + Double.toString(square_peri));
		System.out.println("Color of Square is: " + square_color);
		System.out.println("Square is filled: " + Boolean.toString(square_filled));
		System.out.println("");

	// ans of 6
		Shape sq1 = new Square(9, "Yellow", false);
		Square sq2 = (Square)sq1;

		double sq2_area = sq2.getArea();
		double sq2_peri = sq2.getPerimeter();
		String sq2_color = sq2.getColor();
		boolean sq2_filled = sq2.isFilled();

		System.out.println("Area of Square is: " + Double.toString(sq2_area));
		System.out.println("Perimeter of Square is: " + Double.toString(sq2_peri));
		System.out.println("Color of Square is: " + sq2_color);
		System.out.println("Square is filled: " + Boolean.toString(sq2_filled));
		System.out.println("");
	
	// ans of 7
		Rectangle sq3 = new Square(7, "Violet", true);
		double sq3_area = sq3.getArea();
		double sq3_peri = sq3.getPerimeter();
		String sq3_color = sq3.getColor();
		boolean sq3_filled = sq3.isFilled();

		System.out.println("Area of Square is: " + Double.toString(sq3_area));
		System.out.println("Perimeter of Square is: " + Double.toString(sq3_peri));
		System.out.println("Color of Square is: " + sq3_color);
		System.out.println("Square is filled: " + Boolean.toString(sq3_filled));
		System.out.println("");
	}
}