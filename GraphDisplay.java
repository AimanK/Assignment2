/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aimankayad
 */
    
import javax.swing.*;
import java.awt.*;

public class GraphDisplay extends JPanel
{
    
    private static final int SIZE = 256;
    private int a = SIZE / 2;
    private int b = a;
    private int r = 4 * SIZE / 5;
    private int n;
    
    
    
    public GraphDisplay(int n) 
    {
        this.setPreferredSize(new Dimension(SIZE, SIZE));
        this.n = n;
    }
           
    public void paint(Graphics g)
    {    
        
        int leftX = 100;
        int topY = 100;
        int width = 50;
        int height = 50;
        int labelX = 17;
        int labelY = 31;
        int gridWidth = 150;
        
        
       // int radius = width/2;
       
       
       
       g.setColor(Color.black);
       a = getWidth() / 2;
       b = getHeight() / 2;
       int m =  Math.min(a, b);
       r = 4 * m / 5;
       int r2 = Math.abs(m - r) / 2;
      // g.drawOval(a - r, b - r, 2 * r, 2 * r);
      g.setColor(Color.GREEN);
      
      //Drawing the vertices
       for (int i = 0; i < n; i++) {
           double t = 2 * Math.PI * i / n;
           int x = (int) Math.round(a + r * Math.cos(t));
           int y = (int) Math.round(b + r * Math.sin(t));
           g.fillOval(x - r2, y - r2, 2 * r2, 2 * r2);
       }
       
         
     
       
       
       //Placing the numbers on the vertices
       for (int i = 0; i < n; i++) {
           double t = 2 * Math.PI * i / n;
           int x = (int) Math.round(a + r * Math.cos(t));
           int y = (int) Math.round(b + r * Math.sin(t));
           
           g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
           g.setColor(Color.BLACK);
           g.drawString(String.valueOf(i), x - 8 , y + 5);
       }
       
       
       //Drawing lines between the vertices
       for (int i = 0; i < n; i++) {
        double t = 2 * Math.PI * i / n;   
        int x = (int) Math.round(a + r * Math.cos(t));
        int y = (int) Math.round(b + r * Math.sin(t));
           
        g.setColor(Color.BLACK);
        g.drawLine(x , y, a, b);
        // g.drawLine(x, y, y , m );
      // g.drawLine(x, y, 2 * r , 2 * r ); // very close
      //  g.drawLine(x, y, 2 * r - r2 , 2 * r - r2); // very close
      //  g.drawLine(x, y, x + (x * r2), y + (y * r2));
       //  g.drawLine(x + r, r - y, x, y);
       //  g.drawLine(x + 1, r - 1, x, y);
       // g.drawOval(a - r, b - r, 2 * r, 2 * r);
       // g.drawLine(a - r, b - r, 2 * r , 2 * r );
       }
       
       /*
       //Drawing lines around the vertices
       for (int i = 0; i < n; i++) {
        double t = 2 * Math.PI * i / n;   
        
        int x = (int) Math.round(a + r * Math.cos(t));
        int y = (int) Math.round(b + r * Math.sin(t));
        
           
        g.setColor(Color.BLACK);
       // g.drawLine(x, y, 2 * r , 2 * r ); // very close
       // g.drawLine(x, y, 2 * r - r2 , 2 * r - r2); // very close
       // g.drawLine(x + r, r - y, x, y);
       // g.drawLine(x + 1, r - 1, x, y);
          g.drawLine(x, y, m, m);
       }
       */
       
       
      
       
       
       
       /*
        
        //draw vertex 1
        g.setColor(Color.ORANGE);
        g.fillOval(leftX, topY, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(leftX, topY, width, height);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        g.drawString("1", leftX+labelX, topY+labelY);

        //draw vertex 2
        g.setColor(Color.ORANGE);
        g.fillOval(leftX+gridWidth, topY, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(leftX+gridWidth, topY, width, height);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        g.drawString("2", leftX+gridWidth+labelX, topY+labelY);

        //draw edge (1, 2)
        g.setColor(Color.BLACK);
        g.drawLine(leftX+width, topY+height/2, leftX+gridWidth, topY+height/2);
        
        */
    }
}
