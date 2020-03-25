/*****************************************************************************
In this implementation extra space in only created once which is used for 
merging sorted array
*****************************************************************************/

import java.util.Scanner;

public class MergeSort2
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter size of array : ");
		int size = input.nextInt();
		int[] arr = new int[size];
		System.out.print("Enter array  : ");
		for(int i=0; i<size;i++)
			arr[i] = input.nextInt();

		MergeSort(arr);

		System.out.print("Sorted array : ");
		for(int i=0;i<size;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public static void MergeSort(int[] arr)
	{
		MergeSort(arr,0,arr.length);
	}

	private static void MergeSort(int[] arr,int start,int end)
	{
		if(start==end-1) //only one element in array so its already sorted
			return ;

		else
		{
			int mid = (start+end)/2;
			MergeSort(arr,start,mid); //sort [start,mid) part of array
			MergeSort(arr,mid,end);   //sort [mid,end) part of array

			merge(arr,start,mid,end);

		}
	}

	private static void merge(int[] arr,int start,int mid,int end)
	{
		int[] tarr = new int[end-start]; //extra space is created only once since when this function returns tarr goes out of scope and is collected by java garbage collection
		int i =start,j=mid,k=0;

		//merging two sorting segment into temporary array
		while(k<tarr.length)
		{
			if((i<mid) &&(j==end || arr[i]<arr[j]))
				tarr[k++] = arr[i++];
			else
				tarr[k++] = arr[j++];
		}

		//copying into original array
		for(k=start;k<end;k++)
			arr[k] = tarr[k-start];
	}
}
