//set is represented by string
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class AllSubset
{
	public static void main(String[] args)
	{
		Scanner input = new  Scanner(System.in);
		System.out.print("Enter set : ");
		String set = input.next();

		subset(set);
	}	


	public static void subset(String set)
	{
		Set<String> powerset = new HashSet<>();
		subset(set,powerset);
		for(String subset : powerset)
			System.out.println(subset);
	}

	private static void subset(String setrep,Set<String> powerset)
	{
		if(setrep.length() == 0)
			return;
		else
		{
			powerset.add(setrep);//to exclude redundant addition we use set adt to store 
			for(int i=0;i<setrep.length();i++)
			{
				String reducedset = setrep.substring(0,i)+setrep.substring(i+1,setrep.length());
				subset(reducedset,powerset);
			}
		}
	}
}