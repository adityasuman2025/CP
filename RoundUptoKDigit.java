import java.util.*;
import java.io.*;
import java.lang.*;

class RoundUptoKDigit
{
	public static void main(String[] args) {
		int n = 2;
		double d = Math.sqrt(n);

		System.out.println(d);

		//for rouding off the number to 6 digit (1000000.0) after decimal
		System.out.println(Math.round(d*1000000.0)/1000000.0);
	}
}