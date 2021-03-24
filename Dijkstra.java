/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aimankayad
 */
public class Dijkstra 
{
       ReadInputFromTextFile ob = new ReadInputFromTextFile();
    
        int verticesNum = ob.verticesNumber();
        
        int s = ob.sValue();
        
       
        int t = ob.tValue();    
        
        int[][] matrix2 = new int[verticesNum][verticesNum];
        
        int i = 0;
        
    
    //int verticesNum = r;
    
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
        boolean[] visited = new boolean[verticesNum];
        
        for (int i = 0; i < verticesNum;)
    }
}
