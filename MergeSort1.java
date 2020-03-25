/**************************************************************
It's a basic implementation of merge sort where we create extra
space every time instead of keeping one large space at once.It
sorts array in 	ASCENDING ORDER
**************************************************************/

import java.util.Scanner;

public class MergeSort1
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
		if(arr.length == 1)
			return ;
		else
		{
			int low  = 0;
			int mid  = arr.length/2;
			int high = arr.length;
			int[] arr1half = subarray(arr,0,mid); //returns subarray containing elements in first half i.e[low,mid)
			int[] arr2half = subarray(arr,mid,high); //returns subarray with elements from second half i.e[mid,high)
			//Now let's take recursive leap of faith
			MergeSort(arr1half);//sort first half
			MergeSort(arr2half);//sort second half
			merge(arr,arr1half,arr2half);//merge the two halfs into original array
		}
	}

	private static int[] subarray(int[] originalArr,int start,int end)
	{
		int[] arr = new int[end-start];
		for(int i=start;i<end;i++)
			arr[i-start] = originalArr[i];

		return arr;
	}

	private static void merge(int[] arr,int[] arr1half,int[] arr2half)
	{
		int i=0,i1=0,i2=0;
		int len=arr.length, len1=arr1half.length, len2=arr2half.length;
		while(i<len)
		{
			if((i1 < len1) && ((i2==len2) || (arr1half[i1] < arr2half[i2])))
			{
				arr[i++] = arr1half[i1++];
			}
			else
				arr[i++] = arr2half[i2++];

		}
	}

}