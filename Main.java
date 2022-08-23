package AStar;

public class Main {

	public static void main(String[] args) {
		int[][] graph = {
				{1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			    {1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			    {1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
			    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			    {0, 0, 0, 1, 0, 1, 1, 0, 0, 0},
			    {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
			    {0, 0, 0, 1, 0, 0, 1, 1, 1, 0},
			    {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			    {0, 0, 0, 1, 1, 1, 0, 1, 1, 1},
			    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		int[] start = {1,1};
		int[] end = {7,4};
		AStarSearch search = new AStarSearch(start, end, graph);
		
		for (int[] coord: search.path) 
			graph[coord[0]][coord[1]] = 2;
		
		for (int[] coord : search.path) 
			System.out.print("["+coord[0]+", "+coord[1]+"] ");
		
		System.out.println("\n");
		for (int[] row : graph) {
			for (int col: row)
				if (col == 1)
					System.out.print("1 ");
				else if (col == 0)
					System.out.print("  ");
				else if (col == 2)
					System.out.print("+ ");
			System.out.println();
		}

	}

}
