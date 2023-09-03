import java.io.*;
import java.util.*;

class checkPasswordStrength
{
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception
	{
		String password = bf.readLine();

		checkStrength(password);
	}

	static void checkStrength(String pass)
	{
		int N = pass.length();

		boolean hasLowerCase = false;
		boolean hasUpperCase = false;
		boolean hasNumeric = false;
		boolean hasSpecialChar = false;

		if(N < 2)
		{
			System.out.println("Very Week");
			return;
		}

		int point = 0;
		for(int i=0; i<N; i++)
		{
			char c = pass.charAt(i);
			int t = (int)c;
			if(Character.isLowerCase(c))
				hasLowerCase = true;
			else if(Character.isUpperCase(c))
				hasUpperCase = true;
			else if(t>=48 && t<=57)
				hasNumeric = true;
			else if(c=='!' || c=='~' || c=='`' || c=='#' || c=='$' || c=='%' || c=='^' || c=='&' || c=='*' || c=='(' || c==')' || c=='-' || c=='+' || c=='_' || c=='=')
				hasSpecialChar = true;
		}

		if(hasNumeric)
			point++;

		if(hasSpecialChar)
			point++;

		if(hasUpperCase)
			point++;

		if(hasLowerCase)
			point++;

		if(point==1)
			System.out.println("Week");
		else if(point==2)
			System.out.println("Medium");
		else if(point==3)
			System.out.println("Strong");
		else if(point>3)
			System.out.println("Very Strong");
	}
}