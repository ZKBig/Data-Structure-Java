package com.victor.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
	
	private int vertexNum;
	private ArrayList<String> vertexes;
	private int[][] Edges;
	private boolean isVisited[];
	private int NumOfEdges;
	
	public Graph(int n) {
		this.vertexNum = n;
		this.Edges = new int[n][n];
		this.isVisited = new boolean[n];
		this.vertexes = new ArrayList<String>(n);
	}
	
	public int getNumOfVertex() {
		return vertexes.size();
	}
	
	public int getNumOfEdges() {
		return NumOfEdges;
	}
	
	public String getValueByIndex(int i) {
		return vertexes.get(i);
	}
	
	//insert the vertex
	public void InsertVertex(String v) {
		vertexes.add(v);
	}
	
	//add edges
	public void InsertEdge(int v1, int v2, int weight) {
		Edges[v1][v2]=weight;
		Edges[v2][v1]=weight;
		NumOfEdges++;
	}
	
	//show the graph
	public void showGraph() {
		for(int[] link : Edges) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	private int getFirstNeighbor(int index){
		for(int j=0; j<vertexes.size(); j++) {
			if(Edges[index][j]>0) {
				return j;
			}
		}
		return -1;
	}
	
	//get next adjacent node according to the last node
	private int getNextNeighbor(int v1, int v2) {
		for(int j=v2+1; j<vertexes.size(); j++) {
			if(Edges[v1][j]>0) {
				return j;
			}
		}
		return -1;
	}
	
	//深度优先搜索核心代码
	private void dfs(boolean[] isVisited, int i) {
		//visit the node
		System.out.print(getValueByIndex(i)+"->");
		//set the node to be visited
		isVisited[i]=true;
		//find the next node
		int w = getFirstNeighbor(i);
		while(w!=-1) {
			if(!isVisited[w]) {
				dfs(isVisited, w);
			}
			//if node w is visited, we will find the next node
			w=getNextNeighbor(i, w);
		}
	}
	
	//如果图不联通，那么要加上这几行代码
	public void DFS() {
		for(int i=0; i<getNumOfVertex(); i++) {
			if(!isVisited[i]) 
				dfs(isVisited, i);
		}
	}
	
	//广度优先搜索核心代码
	private void bfs(boolean[] isVisited, int i) {
		int u;
		int w;
		//创建队列
		LinkedList<Integer> queue = new LinkedList<>();
		//把第i个点加入队列
		queue.addLast(i);
		//访问第i个点
		System.out.print(getValueByIndex(i)+"->");
		while(!queue.isEmpty()) {
			//弹出第i个点
			u = (Integer)queue.removeFirst();
			//将第i个点设置为已被访问
			isVisited[u]=true;
			//找到第i个点的第一个邻接点w
			w=getFirstNeighbor(u);
			while(w!=-1) {
				if(!isVisited[w]) {
					queue.addLast(w);
					isVisited[w]=true;
					System.out.print(getValueByIndex(w)+"->");
				}
				w=getNextNeighbor(i, w);
			}
		}
	}
	
	public void BFS() {
		for(int i=0; i<getNumOfVertex(); i++) {
			if(!isVisited[i]) {
				bfs(isVisited, i);
			}
		}
	}

}
