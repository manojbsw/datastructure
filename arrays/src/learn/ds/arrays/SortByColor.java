package learn.ds.arrays;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue,
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.

Example :

Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]

https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * @author manoj
 *
 */
public class SortByColor {

	public static void main(String[] args) {
		int arr[] = {0, 0, 1, 1, 0, 2, 1, 2, 2}; 
        int arr_size = arr.length; 
        sort012(arr, arr_size); 
        Arrays.stream(arr).forEach(s -> System.out.println(s));

	}
	
	 // Sort the input array, the array is assumed to 
    // have values in {0, 1, 2} 
    static void sort012(int a[], int arr_size) 
    { 
        int lo = 0; 
        int hi = arr_size - 1; 
        int mid = 0,temp=0; 
        while (mid <= hi) 
        { 
            switch (a[mid]) 
            { 
            case 0: 
            { 
                temp   =  a[lo]; 
                a[lo]  = a[mid]; 
                a[mid] = temp; 
                lo++; 
                mid++; 
                break; 
            } 
            case 1: 
                mid++; 
                break; 
            case 2: 
            { 
                temp = a[mid]; 
                a[mid] = a[hi]; 
                a[hi] = temp; 
                hi--; 
                break; 
            } 
            } 
        } 
    } 

}
