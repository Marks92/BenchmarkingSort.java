/* Mark Schuberth
 * Professor Abdollahzadeh
 * CS 253 - 70
 * Benchmarking insertion sort, selection sort, merge sort,
 * and Quick sort. Each function is tested with a practice array
 * to make sure the algorithm is working, an almost sorted array, 
 * as well as a randomly filled array of integers. Iterations are
 * counted and the total time in milliseconds (ms) is printed.
 * 11/5/2018
 */

import java.util.Random;

public class TimeSort 
{
	//fills almost sorted array with integers 
	//every 50th being a random number
	public static int[] almostSorted()
	{
		//initializes random 
		Random rand = new Random();
	    
		//creates an array that can hold 10,000 ints
	    int data[] = new int[10000];
	        
	    //main loop that fills the array
	    for(int i = 0; i < data.length; i++)
	    {
	        data[i] = i + 1;
	        //almost sorted but every 50 ints is a random number
	        //for example 1-49 then the 50th is random
	        if(data[i] % 50 == 0)
	        {
	            data[i] = rand.nextInt();
	        }
	    }
	    return data;
	  }
		
	//fills array with random ints 
	public static int[] randomArray()
	{
		//initializes random 
		Random rand = new Random();
		      
		//creates an array that can hold 10,000 ints
		int data[] = new int[10000];
		//main loop that fills array
		for(int i = 0;i < data.length;i++)
	    {
		   //this array is entirely filled with random ints
		   data[i] = rand.nextInt();
		}
		      
		return data;
     }
		
	//prints the list of elements when used below
	static void print(int array[])
	{
		int p = array.length;
		//goes through entire array and prints each element
		for(int i = 0; i < p; ++i)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		//practice array to show that the sorting method works
		int practiceArray[] = {9,1,7,4,8,3,2,5};
		
		System.out.println("Insertion sort on practice array, randomly filled array, and almost sorted array!");
		System.out.println("---------------------------------------------------------------------------------");
		
		Sort practice1 = new Sort();
		practice1.insertionSort(practiceArray);
		
		System.out.println("Practice run of insertion sort: ");
		print(practiceArray);
		System.out.println();
		
		System.out.println("Insertion sort of randomly filled array: \n");
		Sort random1 = new Sort();
		random1.insertionSort(randomArray());
		
		System.out.println("Insertion sort of almost sorted array: \n");
		Sort almost1 = new Sort();
		almost1.insertionSort(almostSorted());
		
		System.out.println("Selection sort on practice array, randomly filled array, and almost sorted array!");
		System.out.println("---------------------------------------------------------------------------------");
		
		System.out.println("Practice run of selection sort: ");
		print(practiceArray);
		System.out.println();
		
		Sort practice2 = new Sort();
		practice2.selectionSort(practiceArray);
		
		System.out.println("Selection sort of randomly filled array: \n");
		Sort random2 = new Sort();
		random2.selectionSort(randomArray());
		
		System.out.println("Selection sort of almost sorted array: \n");
		Sort almost2 = new Sort();
		almost2.selectionSort(almostSorted());
		
		System.out.println("Merge sort on practice array, randomly filled array, and almost sorted array!");
		System.out.println("---------------------------------------------------------------------------------");
		
		System.out.println("Practice run of Merge sort: ");
		print(practiceArray);
		System.out.println();
		
		Sort practice3 = new Sort();
		long startTime1 = System.currentTimeMillis();
		practice3.Msort(practiceArray, 0, 0);
		long endTime1 = System.currentTimeMillis();
		long elapsed1 = endTime1 - startTime1;
		
		System.out.print("Time elapsed for program run: ");
		System.out.println(elapsed1 + "ms \n");
		
		System.out.println("Merge sort of randomly filled array: \n");
		Sort random3 = new Sort();
		
		long startTime2 = System.currentTimeMillis();
		random3.Msort(randomArray(), 0, 10000-1);
		long endTime2 = System.currentTimeMillis();
		long elapsed2 = endTime2 - startTime2;
		
		System.out.print("Time elapsed for program run: ");
		System.out.println(elapsed2 + "ms \n");
		
		System.out.println("Merge sort of almost sorted array: \n");
		Sort almost3 = new Sort();
		
		long startTime3 = System.currentTimeMillis();
		almost3.Msort(almostSorted(), 0, 10000-1);
		long endTime3 = System.currentTimeMillis();
		long elapsed3 = endTime3 - startTime3;
		
		System.out.print("Time elapsed for program run: ");
		System.out.println(elapsed3 + "ms \n");
		
		System.out.println("Quick sort on practice array, randomly filled array, and almost sorted array!");
		System.out.println("---------------------------------------------------------------------------------");
		
		Sort practice4 = new Sort();
		long startTime4 = System.currentTimeMillis();
		practice4.Msort(practiceArray, 0, 0);
		long endTime4 = System.currentTimeMillis();
		long elapsed4 = endTime4 - startTime4;
		
		System.out.println("Practice run of Quick sort: ");
		print(practiceArray);
		System.out.println();
		
		System.out.print("Time elapsed for program run: ");
		System.out.println(elapsed4 + "ms \n");
		
		System.out.println("Quick sort of randomly filled array: \n");
		Sort random4 = new Sort();
		
		long startTime5 = System.currentTimeMillis();
		random4.Msort(randomArray(), 0, 10000-1);
		long endTime5 = System.currentTimeMillis();
		long elapsed5 = endTime5 - startTime5;
		
		System.out.print("Time elapsed for program run: ");
		System.out.println(elapsed5 + "ms \n");
		
		System.out.println("Quick sort of almost sorted array: \n");
		Sort almost4 = new Sort();
		
		long startTime6 = System.currentTimeMillis();
		almost4.Msort(almostSorted(), 0, 10000-1);
		long endTime6 = System.currentTimeMillis();
		long elapsed6 = endTime6 - startTime6;
		
		System.out.print("Time elapsed for program run: ");
		System.out.println(elapsed6 + "ms \n");
	}
}
