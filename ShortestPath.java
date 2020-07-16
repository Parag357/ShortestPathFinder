package pp2;

//A Java program for Dijkstra's single source shortest path algorithm. 
//The program is for adjacency matrix representation of the graph 
import java.util.*; 
class ShortestPath { 
	
	static int vtx ; // for total vertices
	public ShortestPath(int v)
	{
		vtx=v;
	}
	// A utility function to find the vertex with minimum distance value, 
	// from the set of vertices not yet included in shortest path tree 
	 
	int minDistance(int dist[], Boolean sptSet[]) 
	{ 
		// Initialize min value 
		int min = Integer.MAX_VALUE, min_index = -1; 

		for (int v = 0; v < vtx; v++) 
			if (sptSet[v] == false && dist[v] <= min) { 
				min = dist[v]; 
				min_index = v; 
			} 

		return min_index; 
	} 

	// A utility function to print the constructed distance array 
	void printSolution(int dist[],int src,int dest,int parent[]) 
	{ 
		System.out.println("the minimum distance between source: "+src+" and destination: "+dest+" is: "+dist[dest]+" units."); 
		System.out.println("the shortest path between the two cities is: ");
		int i=dest;
		System.out.print("city"+i+" ");
		while(parent[i]!=-1)
		{
			i=parent[i];
			System.out.print("city"+i+" ");
		}
	} 

	/* Function that implements shortest path between a source and a sink vertex
	 for a graph represented using adjacency matrix 
	 representation */
	void dijkstra(int graph[][], int src, int dest) 
	{ 
		int dist[] = new int[vtx]; // The output array dist will hold 
		// the shortest distance from source to every ith vertex in the array.
        int parent[] = new int[vtx]; 	// Array to store the cities included in shorted path  
		// sptSet[i] will true if vertex i is included in shortest 
		// path tree or shortest distance from src to dests is finalized 
		Boolean sptSet[] = new Boolean[vtx]; 

		// Initialize all distances as INFINITE and stpSet[] as false 
		for (int i = 0; i < vtx; i++) { 
			dist[i] = Integer.MAX_VALUE; 
			sptSet[i] = false; 
		} 

		// Distance of source vertex from itself is always 0 
		dist[src] = 0; 
		parent[src]=-1;
		// Find shortest path for all vertices 
		for (int count = 0; count < vtx-1; count++) { 
			// Pick the minimum distance vertex from the set of vertices 
			// not yet processed. u is always equal to src in first 
			// iteration. 
			int u = minDistance(dist, sptSet); 

			// Mark the picked vertex as processed 
			sptSet[u] = true; 

			// Update dist value of the adjacent vertices of the 
			// picked vertex. 
			for (int v = 0; v < vtx; v++) 

				// Update dist[v] only if is not in sptSet, there is an 
				// edge from u to v, and total weight of path from src to 
				// v through u is smaller than current value of dist[v] 
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) 
				{
					parent[v]=u;
					dist[v] = dist[u] + graph[u][v]; 
				}
		} 

		// print the constructed distance array 
		printSolution(dist,src,dest,parent); 
	} 

	// Driver method 
	public static void main(String[] args) 
	{ 
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the total number of cities: ");
		int n= sc.nextInt();
		int a[][]=new int[n][n];
		System.out.println("enter the distances from each city to every other city");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				System.out.println("enter the distance of city "+i+" from city "+j+" : ");
				a[i][j]=sc.nextInt();
			}
		System.out.println("displaying the distances from each city to every other city");
		System.out.println("this is the adjacency matrix representation of the graph with all the cities as nodes and distance between every city as weighted ,undirected edges");
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
		int src=-1,dest=-1;
		while(!(src>=0 && src<n))
		{
			System.out.println("enter the source city between 0 to "+(n-1)+" : ");
			src= sc.nextInt();
		}
		while(!(dest>=0 && dest<n))
		{
			System.out.println("enter the destination city between 0 to "+(n-1)+" : ");
			dest= sc.nextInt();
		}
		// user input finishes...
		
		ShortestPath t = new ShortestPath(n); 
		t.dijkstra(a, dest,src); 
	} 
} 
/* this is a sample test case i.
0 4 0 0 0 0 0 8 0
4 0 8 0 0 0 0 11 0 
0 8 0 7 0 4 0 0 2
0 0 7 0 9 14 0 0 0
0 0 0 9 0 10 0 0 0 
0 0 4 14 10 0 2 0 0
0 0 0 0 0 2 0 1 6 
8 11 0 0 0 0 1 0 7 
0 0 2 0 0 0 6 7 0 
*/