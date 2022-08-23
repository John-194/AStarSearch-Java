package AStar;

class Node implements Comparable<Node>{
	int h; // Manhattan Distance to end (estimated distance, heuristic 
	int g; // distance from start, distance between nodes
	int f;
	private int[] endPosition;  // Goal
	Node parent;
	// Coordinates
	int row, col;
	int[] pos = new int[2];
	
	Node(int[] position, int[] endPosition, Node parent){
		this.row = this.pos[0] = position[0];
		this.col = this.pos[1] = position[1];
		this.endPosition = endPosition;
		this.parent = parent;
		this.calc_fgh();
	}
	
	Node(int[] position) {
		this.row = this.pos[0] = position[0];
		this.col = this.pos[1] = position[1];
		this.endPosition = null;
		this.parent = null;
		this.f = this.h = Integer.MAX_VALUE;
		this.g = 0;
	}

	boolean equals(Node other) {
		return (this.row == other.col && this.col==other.col);
	}
	
	void changeParent(Node parent) {
		this.parent = parent;
		this.calc_fgh();
	}
	
	private void calc_fgh() {
		this.g = this.parent.g + 1;
		this.h = Math.abs(this.pos[0]-this.endPosition[0]) + Math.abs(this.pos[1]-this.endPosition[1]); 
		this.f = g + h;
	}

	@Override
	public int compareTo(Node other) {
        return this.f - other.f;
	}
	
	@Override
	public String toString() {
		return "["+this.row+", "+this.col+"] g = "+this.g+"; h = "+this.h+"; f = "+this.f;
	}	
}


