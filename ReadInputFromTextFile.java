/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aimankayad
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Illustrates reading graph from text file.
 * 
 * @author Prof. Hernandez
 */

public class ReadInputFromTextFile
{
    
   static int numberOfVertices = 0;
   static int s = 0;
   static int t = 0;
   
    static int[][] matrix;
    
    // static int p[];
    
    public static void main(String[] args)
    {
        new ReadInputFromTextFile();
        
        
        
        
        Graph graphy = new Graph(numberOfVertices);
        
        
        int p[] = new int[numberOfVertices];
       
        int d[] = new int[numberOfVertices]; 
         
        
       // System.out.println(graphy.verticesNumber);
         
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                 graphy.addEdge(i, j, matrix[i][j]);
            }
            
        }
        
        System.out.println();
        
        System.out.println("Graph class read: \n" + graphy.toString());
        
        System.out.println("Adjacency vertex results: ");
        
     for (int i = 0; i < numberOfVertices; i++) 
     {
      System.out.println(i + ": " + Arrays.toString(graphy.findAdjacencyVertices(i)));
     }
     
    
     
     System.out.println("Finding shortest paths from vertex " + s + " to all vertices...");
    
     graphy.allShortestPaths(p, d, s);
     
     System.out.println("Applying Dijkstra's algorithm from vertex: " + s + " to " + t);
     
     System.out.println(Arrays.toString(graphy.getPath(s, t, p)));
   //  System.out.println(Arrays.toString(p)); // previous vertex on the path
   //  System.out.println(Arrays.toString(d)); // weights on the path
     
       

       
    }
    
    public ReadInputFromTextFile()
    {
        readGraph();
    }
    
    /**
     * Reads graph from text file (entries as given in COP4534 3rd assignment)
     * and prints it
     */
    public void readGraph()
    {
        File input = new File("/Users/aimankayad/Desktop/graph.txt");

        Scanner in = null;
        try
        {
            in = new Scanner(input);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found!");
        }

        // int numberOfVertices = 0;
        
        // int mat_i_j=0;
        
        while (in.hasNextLine())
        {
            numberOfVertices = in.nextInt();
            System.out.println(numberOfVertices);
             
            matrix = new int[numberOfVertices][numberOfVertices];
           
           
            for(int i = 0; i < numberOfVertices; i++)
            {
                for(int j = 0; j < numberOfVertices; j++)
                {
                    matrix[i][j] = in.nextInt();
                    
                   
                    System.out.print(matrix[i][j] + " ");
                }
                
               System.out.println();
            }
            
            s = in.nextInt();
            t = in.nextInt();
            System.out.println( s + " " +  t);
        }
        
        System.out.println("Closing Scanner...");
        in.close();
        System.out.println("Scanner Closed");
        
    }
    
    
    public static int verticesNumber() 
    {
       return numberOfVertices;
    }
    
    public static int sValue() 
    {
        return s;
    }
    
    public static int tValue() 
    {
        return t;
    }
       
    
}
