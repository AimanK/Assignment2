

import java.util.Arrays;

/**
 *
 * @author aimankayad
 */
public class Graph implements GraphInterface
{
    int verticesNumber;
    static int[][] matrix; //adjacency matrix
    
   // static int[] p;
   // static int[] d;
    
   // p = new int[verticesNumber];
    
    
    //d = new int[verticesNumber]; 
   
    
    public Graph()
    {
        verticesNumber = 5;
        matrix = new int[verticesNumber][verticesNumber];
    }
    
    public Graph(int n)
    {
        verticesNumber = n;
        matrix = new int[verticesNumber][verticesNumber];
    }
    
    public void addEdge(int v, int w, int weight)
    {
        matrix[v][w] = weight;
        matrix[w][v] = weight;
    }
    
    public void removeEdge(int v, int w)
    {
        matrix[v][w] = 0;
        matrix[w][v] = 0;        
    }
    
    /**
     * Finds vertices adjacent to a given vertex.
     * 
     * @param v given vertex
     * @return list of vertices adjacent to v stored in an array;
     *          size of array = number of adjacent vertices
     */
    public int[] findAdjacencyVertices(int v)
    {
        int[] vert = new int[verticesNumber];
        int total = 0;
        
        for (int i=0; i<verticesNumber; i++)
        {
            if (matrix[v][i] != 0)
            {
                vert[total] = i;
                total++;
            }
        }
        
        return Arrays.copyOf(vert, total);        
    }
    
    public String toString()
    {
        String s = "";
        
        for (int i=0; i<verticesNumber; i++)
        {
            for (int j=0; j<verticesNumber; j++)
            {
                s += matrix[i][j] + " ";
            }
            s += "\n";
        }
        
        return s;
    }
    
    /**
     * Calculates the shortest paths from a given vertex to
     * all vertices.
     * 
     * @param p paths (p[i] contains previous vertex in the
     * shortest path from v)
     * 
     * @param d distances (d[i] contains the shortest distance
     * from v)
     * 
     * @param v given vertex
     */
    public void allShortestPaths(int[] p, int[] d, int v) 
    {
        boolean[] visited = new boolean[verticesNumber];
        
        for (int i = 0; i < verticesNumber; i++) {
            visited[i] = false; // not yet visited
            p[i] = -1; // previous vertex in unknown
            d[i] = Integer.MAX_VALUE; //d[i] = INFINITY
        }
        
        d[v] = 0;
        
        for (int i = 0; i < verticesNumber - 1; i++) 
        {
            int w = minDistance(visited, d);
            visited[w] = true;
            
            int[] adj = findAdjacencyVertices(w);
            for(int u : adj) 
            {
                if (!visited[u]) 
                 {
                    if (d[w] + matrix[w][u] < d[u]) 
                    {
                        d[u] = d[w] + matrix[w][u];
                        p[u] = w;
                    }
                  }
            }
        }
    }
    
    private int minDistance(boolean[] visited, int[] distance) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < verticesNumber; i++) {
             if (!visited[i]) {
                 if (distance[i] <= min) {
                     min = distance[i];
                     index = i;
                 }
             }
        }
        
        return index;
    }
    
    
    /**
     * Returns shortest path between given source and target vertices.
     * 
     * @param p paths (p[i] contains previous vertex in the shortest path
     *   from source vertex)
     */
    public int[] getPath(int s, int t, int[] p) 
    {
        
        int[] shortestPath = new int[p.length]; 
        
        int current = t;
        int total = 0;
        while (current != s) 
        {
            shortestPath[total] = current;
            current = p[current];
            total++;
        }
       shortestPath[total++] = s;
       shortestPath = Arrays.copyOf(shortestPath, total);
       
       //reverses array
       for(int i = 0; i < total/2; i++) 
       {
           int temp = shortestPath[i];
           shortestPath[i] = shortestPath[total - 1 - i];
           shortestPath[total - 1 - i] = temp;
       }
       
       return shortestPath;
    }

    
}
