package learn.ds.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class TopologicalSort {

	public static void main(String[] args) {

		int n = 7;
		Graph g = new  Graph(n);
		
		g.addEdge(0, 1);
		g.addEdge(2, 1);
		g.addEdge(1, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		g.addEdge(2, 6);
		g.addEdge(6, 4);
		
		
		
		Set<Integer> set = new HashSet<>(6);
		Deque<Integer> stack = new ArrayDeque(6);
		
		for(int i =0; i<n; i++) {
			
			if(set.contains(i)) {
				continue;
			}
			topologicalSort(set, stack, i, g);
		}
		while(stack.size() != 0) {
			System.out.println(stack.pop());
		}
	}
	
	
	
	public static void topologicalSort(Set<Integer> set, Deque<Integer> stack, int node, Graph g) {
		
		set.add(node);
		
		Set<Integer> adjs = g.getAdjacencyVertex(node);
		
		for(Integer i : adjs) {
			
			if(!set.contains(i)) {
				topologicalSort(set, stack, i, g);
			}
			
		}
		
		
		  stack.push(node);
		}
		
		
		

}
