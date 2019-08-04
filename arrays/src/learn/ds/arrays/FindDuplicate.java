package learn.ds.arrays;

public class FindDuplicate
{
	// Function to find a duplicate element in a limited range array
	public static int findDuplicate(int[] A)
	{
		// create an visited array of size n+1
		// we can also use map instead of visited array
		boolean visited[] = new boolean[A.length + 1];

		// for each element of the array mark it as visited and
		// return the element if it is seen before
		for (int i = 0; i < A.length; i++)
		{
			// if element is seen before
			if (visited[A[i]]) {
				return A[i];
			}

			// mark element as visited
			visited[A[i]] = true;
		}

		// no duplicate found
		return -1;
	}
	
	// Function to print duplicates 
   static void printRepeating(int arr[], int size) 
    { 
        int i;   
        System.out.println("The repeating elements are : "); 
     
        for (i = 0; i < size; i++) 
        { 
            if (arr[Math.abs(arr[i])] >= 0) 
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])]; 
            else
                System.out.print(Math.abs(arr[i]) + " "); 
        }          
    }  

	// main function
	public static void main (String[] args)
	{
		// input array contains n numbers between [1 to n - 1]
		// with one duplicate, where n = A.length
		//int[] A = { 500, 2, 3, 4, 4 };
		
		int A[] = {1, 2, 3, 1, 3, 6, 6}; 

		//System.out.println("Duplicate element is " + findDuplicate(A));
		
		printRepeating(A, A.length);
	}
}
