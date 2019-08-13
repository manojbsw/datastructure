package learn.ds.graph;
/**
 * https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/
 * @author manoj
 *
 */
public class ColorVertex {

	private static int Vertex = 4;
	public static void main(String[] args) {

		int[][] graph = { {0,1,1,1}, {1,0,1,0}, {1,1,0,1}, {1,0,1,0}};
		//Max color can be applied
		int color = 3;
		
		int[] vertex_colors = new int[Vertex];
		//Initialize each vertex with 0 color
		for(int i=0; i < Vertex; i++) {
			vertex_colors[i] = 0;
		}
		System.out.println(colorGraphUtil(graph, vertex_colors, color, 0));
	}

	public static boolean colorGraphUtil(int[][] graph, int[] vertex_color, int color, int v) {
		
		if(v == Vertex) {
			return true;
		}
		
		for(int c=1; c<=color; c++) {
			
			
			if(isSafe(graph, vertex_color, c, v)) {
				vertex_color[v] = c;
				if(colorGraphUtil(graph, vertex_color, color, v+1)) {
					return true;
				}
				
			}
			vertex_color[v] = 0;
		}
		return false;
	}
	
	public static boolean isSafe(int[][] graph, int[] vertex_color, int c, int v) {
		
		for(int i=0; i<Vertex; i++) {
			
			if(graph[v][i] == 1 && vertex_color[i] == c) {
				return false;
			}
			
		}
		return true;
	}
}
