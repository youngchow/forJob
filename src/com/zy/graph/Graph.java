package com.zy.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 图的深度优先遍历
 * 
 * @author allzhou
 *
 */
public class Graph {

	// 存储节点信息
	private char[] vertices;

	// 存储边信息（邻接矩阵）
	private int[][] arcs;

	// 图的节点数
	private int vexnum;

	// 记录节点是否已被遍历
	private boolean[] visited;

	// 初始化
	public Graph(int n) {
		vexnum = n;
		vertices = new char[n];
		arcs = new int[n][n];
		visited = new boolean[n];
		for (int i = 0; i < vexnum; i++) {
			for (int j = 0; j < vexnum; j++) {
				arcs[i][j] = 0;
			}
		}
	}

	// 添加边（无向图）
	public void addEdge(int i, int j) {
		// 边的头尾不能为同一节点
		if (i == j) {
			return;
		}
		arcs[i][j] = 1;
		arcs[j][i] = 1;
	}

	// 设置节点集
	public void setVertices(char[] vertices) {
		this.vertices = vertices;
	}

	// 设置节点访问标记
	public void setVisited(boolean[] visited) {
		this.visited = visited;
	}

	// 打印遍历节点
	public void visit(int i) {
		System.out.print(vertices[i] + " ");
	}

	// 从第i个节点开始深度优先遍历）
	public void traverse(int i) {
		// 标记第i个节点已遍历
		visited[i] = true;
		// 打印当前遍历的节点
		visit(i);
		// 遍历邻接矩阵中第i个节点的直接联通关系
		for (int j = 0; j < vexnum; j++) {
			// 目标节点与当前节点直接联通，并且该节点还没有被访问，递归
			if (arcs[i][j] == 1 && visited[j] == false) {
				traverse(j);
			}
		}
	}

	// 图的深度优先遍历（递归）
	public void DFSTraverse() {
		// 初始化节点遍历标记
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		// 从没有被遍历的节点开始深度遍历
		for (int i = 0; i < vexnum; i++) {
			if (! visited[i]) {
				// 若是连通图，只会执行一次
				traverse(i);
			}
		}
	}

	// 图的深度优先遍历（非递归）
	public void DFSTraverse2() {
		// 初始化节点遍历标记
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < vexnum; i++) {
			if (!visited[i]) {
				visited[i] = true;
				visit(i);
				stack.push(i);
			}
			while(! stack.isEmpty()){
				int k = stack.pop();
				for(int j = 0; j < vexnum; j++){
					if(arcs[k][j] == 1 && visited[j] == false){
						visited[j] = true;
						visit(j);
						stack.push(j);
						break;
					}
				}
			}
		}
	}

	// 图的广度优先遍历
		public void BFSTraverse() {
			// 初始化节点遍历标记
			for (int i = 0; i < vexnum; i++) {
				visited[i] = false;
			}
			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i = 0; i < vexnum; i++) {
				if (!visited[i]) {
					visited[i] = true;
					visit(i);
					queue.add(i);
				}
				while(! queue.isEmpty()){
					int k = queue.poll();
					for(int j = 0; j < vexnum; j++){
						if(arcs[k][j] == 1 && visited[j] == false){
							visited[j] = true;
							visit(j);
							queue.add(j);
						}
					}
				}
			}
		}
	
	public static void main(String[] args) {
		Graph g = new Graph(6);
		char[] vertices = { '1', '2', '3', '4', '5', '6'};
		g.setVertices(vertices);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);
		g.addEdge(2, 1);
		g.addEdge(3, 5);
		g.addEdge(2, 4);
		g.addEdge(4, 5);

		System.out.print("深度优先遍历（递归）：");
		g.DFSTraverse();

		System.out.println();

		System.out.print("深度优先遍历（非递归）：");
		g.DFSTraverse2();
		
		System.out.println();

		System.out.print("广度优先遍历（非递归）：");
		g.BFSTraverse();
	}
}
