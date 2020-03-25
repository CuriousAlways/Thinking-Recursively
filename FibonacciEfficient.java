import java.util.Scanner;

public class FibonacciEfficient
{
	static long niteration=0L;

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("which fibonnaci term to find : ");
		int n = input.nextInt();
		System.out.println("fab("+n+") ");


		fibonacci(n);


	}

	public static void fibonacci(int n)
	{
		if(n<0)
			System.out.println("Invalid Input");
		else
		{
			System.out.println("----------------- Efficient Method -----------------");
			System.out.println("value : "+fibonacciEff(n,0L,1L));
			System.out.println("No. of iterations used : "+niteration);

			System.out.println("----------------- Inefficient Method -----------------");
			niteration = 0; 
			System.out.println("value : "+fibonnaciIneff(n));
			System.out.println("No. of iterations used : "+niteration);

		}
		
			
	}

	public static long fibonacciEff(int n,long a,long b) //implements efficients algo for fibonacci sequence
	{
		niteration++;
		if(n==0)
			return a; 

		return fibonacciEff(n-1,b,a+b);
	}

	public static long fibonnaciIneff(int n)
	{
		niteration++;
		if(n==0)
			return 0;
		if(n==1)
			return 1;

		return fibonnaciIneff(n-1) + fibonnaciIneff(n-2);
	}
}