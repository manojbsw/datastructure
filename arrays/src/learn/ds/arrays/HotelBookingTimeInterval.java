package learn.ds.arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/hotel-bookings-possible/
 * 
 * For time serires
 *  https://www.geeksforgeeks.org/merging-intervals/
 * @author manoj
 *
 */
public class HotelBookingTimeInterval {

	public static void main(String[] args) {

		//Num of rooms
		int k=3;
		
		int[] arrival = {1,3,5};
		int[] departure = {2,6,8};
		
		System.out.println(manageBooking(k, arrival, departure));
	}

	public static boolean manageBooking(int rooms, int[] arrival, int[] departure) {
		
		List<TimeTuple> list = new ArrayList<TimeTuple>(arrival.length);
		Deque<TimeTuple> stack = new ArrayDeque<>();
		for(int i=0; i<arrival.length; i++) {
			list.add(new TimeTuple(arrival[i], departure[i]));
		}
		
		Collections.sort(list, new Comparator<TimeTuple>() {

			@Override
			public int compare(TimeTuple o1, TimeTuple o2) {
				return o1.arrival-o2.arrival;
			}
		});
		
		stack.push(list.get(0));
		for(int i=1; i<list.size(); i++) {
			
			TimeTuple tuple = stack.peek();
			TimeTuple current = list.get(i);
			
			if(tuple.departure < current.arrival) {
				stack.push(current);
			}
			else {
				int interval = tuple.departure - current.arrival;
				if(interval >= rooms) {
					return false;
				}
			}
			
		}
		return true;
		
		
	}
	
	//Time series merging
  public static Deque timeSeriesMerging(int[] arrival, int[] departure) {
		
		List<TimeTuple> list = new ArrayList<TimeTuple>(arrival.length);
		Deque<TimeTuple> stack = new ArrayDeque<>();
		for(int i=0; i<arrival.length; i++) {
			list.add(new TimeTuple(arrival[i], departure[i]));
		}
		
		Collections.sort(list, new Comparator<TimeTuple>() {

			@Override
			public int compare(TimeTuple o1, TimeTuple o2) {
				return o1.arrival-o2.arrival;
			}
		});
		
		stack.push(list.get(0));
		for(int i=1; i<list.size(); i++) {
			
			TimeTuple tuple = stack.peek();
			TimeTuple current = list.get(i);
			
			if(tuple.departure < current.arrival) {
				stack.push(current);
			}
			else if(tuple.arrival <= current.arrival && tuple.departure <= current.arrival && tuple.departure < current.arrival) {
				tuple = stack.pop();
				tuple.departure = current.departure;
				stack.push(tuple);
			}
			
		}
		return stack;
		
		
	}
	
}

class TimeTuple {
	
	public int arrival;
	public int departure;
	public TimeTuple(int arrival, int departure) {
		this.arrival = arrival;
		this.departure = departure;
	}
	
}