/*****************************************************************************************
Find all permutations of digit where every digit can be replaced with following characters
2 -> a,b,c
3 -> d,e,f
4 -> g,h,i
5 -> j,k,l
6 -> m,n,o
7 -> p,q,r
8 -> s,t,u
9 -> v,w,x
******************************************************************************************/

import java.util.Scanner;

public class Telephone
{

	static long count = 0L;

	public static boolean format(String number)
	{
		for(int i=0;i<number.length();i++)
			if(number.charAt(i)=='0' || number.charAt(i)=='1')
				return false;
		return true;
	}

	public static String convert(String number)
	{
		char[] arr = number.toCharArray();
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = (char)('a'+(((arr[i]-'0')-2)*3));
		}
		return new String(arr);
	}


	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number : ");
		String number = input.next();

		if(format(number)) //verify only accepted digit are present
		{
			String str = convert(number);
			System.out.println("original -> "+str);
			combination(str);
		}
		else
		{
			System.out.println("Invalid number");
		}
	}

	public static void combination(String str)
	{
		combination(str,0);
	}

	private static void combination(String str,int i)
	{
		if(i<str.length())
		{
			
			for(int j=0;j<3;j++)
			{
				combination(str,i+1);
				if(i == str.length()-1)
				{
					permute("",str);
				}
				str = str.substring(0,i)+(char)(str.charAt(i)+1)+str.substring(i+1,str.length());//to accomodate every character corrosponoding to a digit
			}
			str = str.substring(0,i)+(char)(str.charAt(i)-3)+str.substring(i+1,str.length()); //backtrack
		}
	}

	private static void permute(String prefix,String str)
	{
		if(str.length()==0)
		{
			//System.out.println("Inside permte");
			System.out.println(++count+" ->\t"+prefix);
			return ;
		}

		for(int i=0;i<str.length();i++)
		{
			char ch = str.charAt(i);
			String rem = str.substring(0,i)+str.substring(i+1,str.length());
			permute(prefix+ch,rem); 
		}
	}

	
}