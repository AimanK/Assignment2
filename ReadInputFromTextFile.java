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
    
    public static void main(String[] args)
    {
        new ReadInputFromTextFile();
        
        /*
        ReadInputFromTextFile ob = new ReadInputFromTextFile();
    
        int verticesNum = ob.verticesNumber();
    
        System.out.println(verticesNum);
        */
       
        /*
        Dijkstra newd = new Dijkstra();
        
        System.out.println(newd.verticesNum);
        System.out.println(newd.s);
        System.out.println(newd.t);
        */
        
        
        
        
         Graph graphy = new Graph(numberOfVertices);
         
        
         System.out.println(graphy.verticesNumber);
         
         System.out.println(matrix[1][0]);
         
         System.out.println(Arrays.toString(graphy.findAdjacencyVertices(0)));
         
         
         
         
         
         
        
        
    }
    
    public ReadInputFromTextFile()
    {
        readGraph();
        //verticesNumber();
    }
    
    /**
     * Reads graph from text file (entries as given in COP4534 3rd assignment)
     * and prints it
     */
    public static void readGraph()
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
        
       //  int mat_i_j=0;
        
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
        
        // System.out.println(matrix[2][1]);
        
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
