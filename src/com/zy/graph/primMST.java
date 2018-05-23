package com.zy.graph;
/**
 * 普利姆最小生成树
 * @author allzhou
 *
 */
public class primMST {

	//图的顶点数量
	private static final int Vertices = 5;
	
	//从不包含在MST中找出最小key值的顶点
	int minKey(int[] key, Boolean mstSet[]){
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		for(int v = 0; v < Vertices; v++){
			if(mstSet[v] == false && key[v] < min){
				min = key[v];
				min_index = v;
			}
		}
		return min_index;
	}
	
	//打印存储在parent[]中的构建的MST
	void printMST(int parent[], int n, int graph[][]){
		System.out.println("Edge  Weight");
		for(int i = 1; i < Vertices; i++){
			System.out.println(parent[i] + " - " + i + "  " + graph[i][parent[i]]);
		}
	}
	
	//采用邻接矩阵的方式从图中构建和打印最小生成树
	void primMSTAL(int graph[][]){
		//存储构建的MST
		int parent[] = new int[Vertices];
		//Key values used to pick minimum weight edge in cut
		int key[] = new int[Vertices];
		// To represent set of vertices not yet included in MST
        Boolean mstSet[] = new Boolean[Vertices];
        // Initialize all keys as INFINITE
        for(int i = 0; i < Vertices; i++){
        		key[i] = Integer.MAX_VALUE;
        		mstSet[i] = false;
        }
        // Always include first 1st vertex in MST.
        key[0] = 0;     // Make key 0 so that this vertex is
                        // picked as first vertex
        parent[0] = -1; // First node is always root of MST
        // The MST will have V vertices
        for (int count = 0; count < Vertices-1; count++)
        {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mstSet);
 
            // Add the picked vertex to the MST Set
            mstSet[u] = true;
 
            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 0; v < Vertices; v++)
 
                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][v] != 0 && mstSet[v] == false &&
                    graph[u][v] <  key[v])
                {
                    parent[v]  = u;
                    key[v] = graph[u][v];
                }
        }
 
        // print the constructed MST
        printMST(parent, Vertices, graph);
	}
	public static void main(String[] args) {
			 /* Let us create the following graph
	        2    3
	     (0)--(1)--(2)
	     |    / \   |
	     6| 8/   \5 |7
	     | /      \ |
	     (3)-------(4)
	          9          */
	     primMST t = new primMST();
	     int graph[][] = new int[][] {
									 {0, 2, 0, 6, 0},
					                 {2, 0, 3, 8, 5},
					                 {0, 3, 0, 0, 7},
					                 {6, 8, 0, 0, 9},
					                 {0, 5, 7, 9, 0},
	                                };
	
	     // Print the solution
	     t.primMSTAL(graph);
	}
}
