class Volume
{
	public Volume(int a, int b, int c) //for cuboid
	{
		int result = a*b*c;
		System.out.println("Volume is cuboid is: " + Integer.toString(result));
	}

	public Volume(int r, int h) //for Cylinder 
	{
		float result = (float)3.16*((float)r)*((float)r)*((float)h);
		System.out.println("Volume is cylinder is: " + Float.toString(result));
	}

	public Volume(int r) //for Sphere 
	{
		float result = (float)3.16*((float)r)*((float)r)*((float)r);
		System.out.println("Volume is sphere is: " + Float.toString(result));
	}
}

public class Assignment_6_3_1601me01
{
	public static void main(String[] args) 
	{
		Volume cuboid = new Volume(2,3,4);	
		Volume cylinder= new Volume(2,1);	
		Volume sphere = new Volume(2);	
	}
	
}