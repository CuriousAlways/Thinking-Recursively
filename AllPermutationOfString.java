import java.util.Scanner;

public class AllPermutationOfString
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter String: ");
		String str = input.next();

		printAllPremutation(str); 
	}

	public static void printAllPremutation(String str)
	{
		printAllPremutation("",str);
	}


	private static void printAllPremutation(String prefix,String str)
	{
		if(str.length()==0)
			System.out.println("->"+prefix);
		else
		{
			for(int i=0;i<str.length();i++)
			{
				char ch = str.charAt(i);
				String remaining = str.substring(0,i) + str.substring(i+1,str.length());
				printAllPremutation(prefix+ch,remaining);
			}
		}
	}
}