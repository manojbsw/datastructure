package learn.ds.arrays;

public class LongestIncreasingSubSequence {

	// Binary search (note boundaries in the caller) 
    // A[] is ceilIndex in the caller 
    static int CeilIndex(int A[], int l, int r, int key) 
    { 
        while (r - l > 1) { 
            int m = l + (r - l) / 2; 
            if (A[m] >= key) 
                r = m; 
            else
                l = m; 
        } 
  
        return r; 
    } 
  
    static int LongestIncreasingSubsequenceLength(int A[], int size) 
    { 
        // Add boundary case, when array size is one 
  
        int[] tailTable = new int[size]; 
        int len; // always points empty slot 
  
        tailTable[0] = A[0]; 
        len = 1; 
        for (int i = 1; i < size; i++) { 
            if (A[i] < tailTable[0]) 
                // new smallest value 
                tailTable[0] = A[i]; 
  
            else if (A[i] > tailTable[len - 1]) 
                // A[i] wants to extend largest subsequence 
                tailTable[len++] = A[i]; 
  
            else
                // A[i] wants to be current end candidate of an existing 
                // subsequence. It will replace ceil value in tailTable 
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i]; 
        } 
  
        return len; 
    } 
  
    // Driver program to test above function 
    public static void main(String[] args) 
    { 
        int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 }; 
        int n = A.length; 
        System.out.println("Length of Longest Increasing Subsequence is " + LongestIncreasingSubsequenceLength(A, n)); 
        
        System.out.println("Working solution " );
        LIS(A);
    } 
    
    
    public static void LIS(int X[])
	{
		int parent[]= new int[X.length]; //Tracking the predecessors/parents of elements of each subsequence.
		int increasingSub[]= new int[X.length + 1]; //Tracking ends of each increasing subsequence.
		int length = 0; //Length of longest subsequence.
		
		for(int i=0; i<X.length; i++)
		{
			//Binary search
			int low = 1;
			int high = length;
			while(low <= high)
			{
				int mid = (int) Math.ceil((low + high)/2);
				
				if(X[increasingSub[mid]] < X[i])
					low = mid + 1;
				else
					high = mid - 1;
			}
			
			int pos = low;
			//update parent/previous element for LIS
			parent[i] = increasingSub[pos-1];
			//Replace or append
			increasingSub[pos] =  i;
			
			//Update the length of the longest subsequence.
			if(pos > length)
				length=pos;
		}
		
		//Generate LIS by traversing parent array
		int LIS[] = new int[length];
		int k 	= increasingSub[length];
		for(int j=length-1; j>=0; j--)
		{
			LIS[j] =  X[k];
			k = parent[k];
		}
		
		
		for(int i=0; i<length; i++)
		{
			System.out.println(LIS[i]);
		}
	
		
	}

}
