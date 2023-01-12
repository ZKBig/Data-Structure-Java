package com.victor.graph;

public class graphTest {
	public static void main(String[] args) {
		Graph g = new Graph(5);
		String[] nodes = {"A", "B", "C", "D", "E"};
		for(String vertex : nodes) {
			g.InsertVertex(vertex);
		}
		
		g.InsertEdge(0, 1, 1);
		g.InsertEdge(0, 2, 1);
		g.InsertEdge(1, 2, 1);
		g.InsertEdge(1, 3, 1);
		g.InsertEdge(1, 4, 1);
		
		g.showGraph();
		
		g.BFS();

	}

}
