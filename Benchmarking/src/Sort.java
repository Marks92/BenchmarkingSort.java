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

public class Sort 
{
	int count = 0;
	
	//insertion sort algorithm
	public void insertionSort(int data[])
	{
		//start of the time measurement in ms
	    long startTime = System.currentTimeMillis();
		int n = data.length;
		
		//main loop that sorts each individual index
		//starting from the first element 
		for(int k = 1; k < n; k++)
		{
			int current = data[k];
			int j = k;
			//sorts each element from left to right
			while(j > 0 && data[j-1] > current)
			{
				//the lowest element is moved to the left
				data[j] = data[j-1];
				//list is decremented until it is sorted
				j--;
				//count the number of moves
				count++;
			}
			data[j] = current;
		}
		//end of the time measurement in ms
		long endTime = System.currentTimeMillis();
		//elapsed time is end time - start time
		long elapsed = endTime - startTime;
		//prints the time it took to sort based on time elapsed
		System.out.print("Time elapsed for program run: ");
		System.out.println(elapsed + "ms \n");
		
		//prints the number of moves made to sort 
		System.out.print("Iterations of insertion sort: ");
		System.out.println(count + "\n");
	}
	
	//selection sort algorithm
	public void selectionSort(int data[])
	{
		//start of time measurement in ms
		long startTime = System.currentTimeMillis();
		int n = data.length;
		
		//main loop that goes through entire list
		for(int i = 0; i < n - 1; i++)
		{
			int min = i;
			//nested loop that sorts each element of the array
			//from smallest to largest element
			for(int j = i + 1; j < n; j++)
			{
				if(data[j] < data[min])
				{
					min = j;
				}
				//swap the lowest value with first element
				int temp = data[min];
				data[min] = data[i];
				data[i] = temp;
				count++;
			}
		}
		//end of time measurement in ms
		long endTime = System.currentTimeMillis();
		//elapsed time that it took to sort the entire list
		long elapsed = endTime - startTime;
		//prints the elapsed time
		System.out.print("Time elapsed for program run: ");
		System.out.println(elapsed + "ms \n");
		
		//prints the number of moves it took to sort the list
		System.out.print("Iterations of selection sort: ");
		System.out.println(count + "\n");
	}
	
	//first part of merge sort that creates 2 sub arrays, finds the middle,
	//and then puts the first array as n1 while the second array is n2
	public void mergeSort(int data[], int left, int mid, int right) 
    { 
        //Below finds the size of both subarrays 
		//that with be merged 
        int sub1 = mid - left + 1; 
        //the second sub array 
        int sub2 = right - mid; 
  
        //temp arrays n1 and n2
        int L[] = new int [sub1]; 
        int R[] = new int [sub2]; 
  
        //below copies the data to the temp arrays
        for (int i = 0; i < sub1; i++) 
        {
            L[i] = data[left + i]; 
        }
        for (int j = 0; j < sub2; j++)
        {
            R[j] = data[mid + 1 + j]; 
        }
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = left; 
        
        //searches through both temp arrays
        while (i < sub1 && j < sub2) 
        { 
            if (L[i] <= R[j]) 
            { 
                data[k] = L[i]; 
                i++; 
            } 
            else
            { 
                data[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        //Copy remaining elements of L[] if any 
        while (i < sub1) 
        { 
            data[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        //Copy remaining elements of R[] if any 
        while (j < sub2) 
        { 
            data[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    //main function for merge sort
	//that does the heavy lifting
    public void Msort(int data[], int left, int right) 
    { 
    	 //if the left side is less than the right
        if (left < right) 
        { 
            // Find the middle point 
            int mid = (left + right)/2; 
  
            // Sort first and second halves 
            Msort(data, left, mid); 
        
            Msort(data , mid + 1, right); 
            
            // Merge the sorted halves into one array recursively
            mergeSort(data, left, mid, right); 
        } 
    }
	
	//quicksort algorithm
    int quickSort(int data[], int l, int p) 
    { 
    	  //creates the pivot for the quick sort
        int pivot = data[p];  
        int i = (l - 1); // index of smaller element 
        //if j is less than the pivot then continue
        for (int j = l; j < p; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (data[j] <= pivot) 
            { 
                i++; 
  
                // swap data[i] and data[j] 
                int temp = data[i]; 
                data[i] = data[j]; 
                data[j] = temp; 
            } 
        } 
  
        // swap data[i+1] and data[h] (or pivot) 
        int temp = data[i + 1]; 
        data[i + 1] = data[p]; 
        data[p] = temp; 
  
        return i + 1; 
    } 
  
  
    //The main function that implements QuickSort() 
     // data[] is the array that will sorted, 
     // l is the start index, h  is the last index 
    void Qsort(int data[], int l, int p) 
    { 
        if (l < p) 
        { 
            //part is partitioning index, data[part] is  
              //now at right place 
            int part = quickSort(data, l, p); 
  
            // Recursively sort elements before 
            // partition and after partition 
            Qsort(data, l, part - 1); 
            Qsort(data, part + 1, p); 
        } 
    } 
	
}
