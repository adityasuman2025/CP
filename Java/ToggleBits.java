/*
Given a number N.
Toggle all its bits, and the number then generated was to represented in decimal format.
Like 4=100 after toggling 011,so ans is 3
*/

class ToggleBits
{
	public static void main(String[] args) 
	{		
		int num = 4;
		String orgBinary = Integer.toBinaryString(num);
		int len = orgBinary.length();

		System.out.println("original num binary representation: " + orgBinary);

		int invertedNum = ~num; //~ is known as complement, it toggle bits of (32-bit) binary representation of a number 
		String invertedBinary = Integer.toBinaryString(invertedNum);
		int len2 = invertedBinary.length();

		System.out.println("inverted num binary representation: " + invertedBinary);

		String ans = invertedBinary.substring(len2-len); //we need only bits of length of org binary no i.e len	
		System.out.println("inverted num binary representation: " + ans);
		System.out.println("New number: " + Integer.parseInt(ans, 2));
	}
}