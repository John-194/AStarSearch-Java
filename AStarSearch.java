package AStar;

import java.util.*;

public class AStarSearch {
	int[] start;
	int[] end;
	int[][] graph;
	int[][] path;
	private ArrayList <Node> visited;
	
	AStarSearch(int[] start, int[] end, int[][] graph) {
		this.start = start;
		this.end = end;
		this.graph = graph;
		this.start();
	}

	public void start() {
		this.visited = new ArrayList<>();
		PriorityQueue<Node> open = new PriorityQueue<Node>(); // .poll() is like .pop
		open.add(new Node(start));
		Node currentNode;
		while (!open.isEmpty()){
			
			currentNode = open.poll();
			this.draw(currentNode);
			if (Arrays.equals(currentNode.pos, this.end)){
				this.finish(currentNode);
				return;
			}
			open.addAll(this.returnUnvisitedNeighbors(currentNode));
			visited.add(currentNode);
		}
		this.path = new int[][] {};
	} 

	private ArrayList<Node> returnUnvisitedNeighbors(Node currentNode) {
		ArrayList<Node> neighbors = new ArrayList<>();
		int[][] coordsToAdd = {{0,-1},{1,0},{0,1},{-1,0}};
		
		for (int[] coord: coordsToAdd) {
			int[] newCoords = {currentNode.row+coord[0], currentNode.col+coord[1]};
			if (passable(newCoords) && !beenThere(newCoords))
				neighbors.add(new Node(newCoords, this.end, currentNode));
		}
		
		return neighbors;
	}
	
	private boolean beenThere(int[] coords) {
		for (Node node: this.visited) 
			if (Arrays.equals(node.pos, coords))
				return true;
		return false;
	}

	private boolean passable(int[] coords) {
		int row = coords[0];
		int col = coords[1];
		return (row != -1 && col != -1 && 
				row != this.graph.length && col != this.graph[0].length && 
				this.graph[row][col] != 1);
	}
	
	private void finish(Node current_node){
			ArrayList<int[]> path = new ArrayList<int[]>();
			while (current_node != null) {
				path.add(0, current_node.pos);
				current_node = current_node.parent;
			}
			this.path = new int [path.size()][2];
			for (int i=0;i<path.size();i++) {
				this.path[i] = path.get(i);
			}
	}
	private void draw(Node currentNode) {
		for (int row=0;row<this.graph.length;row++) {
			for (int col=0;col<this.graph[0].length;col++)
				if (currentNode.row == row &&  currentNode.col == col) 
					System.out.print("X"+" ");
				else if (this.start[0] == row &&  this.start[1] == col) 
					System.out.print("S"+" ");
				else if (this.end[0] == row &&  this.end[1] == col) 
					System.out.print("E"+" ");
				else if (graph[row][col] == 0)
					System.out.print(" "+" ");
				else 
					System.out.print(this.graph[row][col]+" ");
			System.out.println();
		}
		System.out.println("=======================================");
	}
}
