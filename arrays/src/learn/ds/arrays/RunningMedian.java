package learn.ds.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This problem was asked by Microsoft.

Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

2
1.5
2
3.5
2
2
2

https://www.youtube.com/watch?v=VmogG01IjYc
 * @author manoj
 *
 */
public class RunningMedian {

	public static void main(String[] args) {

		int arr[] = {2, 1, 5, 7, 2, 0, 5};
		double[] ar = runningMedian(arr);
		for(int i=0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}

	public static double[] runningMedian(int arr[]) {
		
		PriorityQueue<Integer> lower = new PriorityQueue<>(
		
					new Comparator<Integer>() {
						public int compare(Integer o1, Integer o2) {
							return -1 * o1.compareTo(o2);
						}
					}
		) ;
		PriorityQueue<Integer> higher = new PriorityQueue<>();
		double median[] = new double[arr.length];
		for(int i=0; i< arr.length; i++) {
			
			int number = arr[i];
			
			addNumbers(number, higher, lower);
			rebalanceHeap(higher,lower);
			
			median[i] = findMedian(higher, lower);
		}
		
 		return median;
	}
	
	public static void addNumbers(int number, PriorityQueue<Integer> higher, PriorityQueue<Integer> lower) {
		
		if(lower.size() == 0 || number < lower.peek()) {
			lower.add(number);
		}
		else {
			higher.add(number);
		}
		
	}
	
   public static void rebalanceHeap(PriorityQueue<Integer> higher, PriorityQueue<Integer> lower) {
		
		PriorityQueue<Integer> biggerHeap = lower.size() > higher.size() ? lower : higher;
		PriorityQueue<Integer> smallerHeap = lower.size() > higher.size() ? higher : lower;
	   
		if(biggerHeap.size() - smallerHeap.size() >= 2) {
			
			smallerHeap.add(biggerHeap.poll());
		}
		
	   /*if(Math.abs(lower.size() - higher.size()) >= 2) {
			
			if(lower.size() > higher.size()) {
				higher.add(lower.poll());
			}
			else {
				lower.add(higher.poll());
			}
			
		}*/
		
	}
   
   public static double findMedian(PriorityQueue<Integer> higher, PriorityQueue<Integer> lower) {
	   
	   PriorityQueue<Integer> biggerHeap = lower.size() > higher.size() ? lower : higher;
	   PriorityQueue<Integer> smallerHeap = lower.size() > higher.size() ? higher : lower;
		
		if(biggerHeap.size() == smallerHeap.size()) {
			return (double)(smallerHeap.peek() + biggerHeap.peek())/2;
		}
		else {
				return biggerHeap.peek();
			
		}
	}
}
