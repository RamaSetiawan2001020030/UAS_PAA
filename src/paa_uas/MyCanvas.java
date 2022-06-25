/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paa_uas;

  
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MyCanvas extends JFrame{
    
    private int [][] maze = 
        { 
        {1, 1, 1, 0, 0, 1, 1, 1, 0, 1},
        {1, 2, 0, 0, 0, 0, 0, 0, 0, 1},
        {1, 0, 0, 0, 1, 0, 1, 1, 0, 8},
        {1, 0, 0, 1, 1, 0, 1, 1, 0, 1},
        {1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
        {1, 1, 1, 1, 0, 1, 1, 1, 0, 1},
        {1, 1, 1, 1, 0, 1, 0, 0, 0, 1},
        {1, 1, 0, 1, 1, 1, 1, 0, 0, 1},
        {1, 1, 0, 0, 1, 0, 0, 0, 0, 1},
        {1, 1, 0, 1, 0, 1, 0, 1, 1, 1}
        };  
    
    boolean repaint = false;
       public MyCanvas() {
        Image img = Toolkit.getDefaultToolkit().getImage("kurir.jpg");
        setTitle("Smart kurir");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setContentPane(new JPanel() {
         @Override
         public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, null);
         }
      });
      pack();
      setVisible(true);
    }
       
       
@Override
public void paint(Graphics g) {
super.paint(g);
g.translate(70, 70);      //posii kotak maze

        if (repaint == true) {  
            for (int row = 0; row < maze.length; row++) {
                for (int col = 0; col < maze[0].length; col++) {
                    Color color;
                    switch (maze[row][col]) {
                        case 1:
                            color = Color.black;       // balok/ dinding
                            break;
                        case 8:
                            color = Color.RED;          // titik destinasi
                           
                            break;
                        case 2:
                            color = Color.YELLOW;      //titik awal
                            break;
                        default:
                            color = Color.WHITE;     
                    }
                    g.setColor(color);
                    g.fillRect(40 * col, 40 * row, 40, 40);     
                    g.setColor(Color.white);                    
                    g.drawRect(40 * col, 40 * row, 40, 40);    

}}}

        if (repaint == false) {   
            //direction
            //int i;
            //int j;
            for (int row = 0; row < maze.length; row++) {
                for (int col = 0; col < maze[0].length; col++) {
                    Color color = null;
                    switch (maze[row][col]) {
                        case 1:
                          color = Color.BLACK;  
                            break;
                        case 8:
                          color = Color.RED;
                         g.drawString("selesai", 325, 102);
                         
                          g.setColor(new Color(255,215,0)); //bendera 
                         int []a = {60,30,20};
                         int []b = {70,90,70};
                         g.fillPolygon(a,b,3);
                         g.drawPolygon (a,b,3);
             
                            break;
                        case 2:
                            color = Color.YELLOW;
                             g.drawString("mulai", 5, 62);
                          //  g.fillOval(20 * col, 20 * row, 20, 20);
    
                        /*
                        //arah gerak
                        switch (direction)
                        case 0:
                        	depan = north;
                                kiri = west;
                                kanan = east;
                                break;
                        case1:
                                depan = north;
                                kiri = west;
                                kanan = east;
                                break;
                        case2:
                        	depan = north;
                                kiri = west;
                                kanan = east;
                                break;
                        case3:
                                depan = north;
                                kiri = west;
                                kanan = east;
                                break;

                        //finish
                        if(depan !=null &&maze[depan.I][depan.J] == -2);
                        	break;
                        if(kanan !=null &&maze[kanan.I][kanan.J] == -2);
                        	break;
                        if(kiri !=null &&maze[kiri.I][kiri.J] == -2);
                        	break;
                        if(depan !=null &&maze[depan.I][depan.J] == -2);
                    	break;
 */
                            break;
                        case 9:
                            color = Color.green;  
                            break;
                        default:
                            color = Color.WHITE;   
                    }
                    g.setColor(color);
                    g.fillRect(40 * col, 40 * row, 40, 40);  
                   g.setColor(Color.gray);                  
                    g.drawRect(40 * col, 40 * row, 40, 40); 
                    
         
}}}}
       
        public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyCanvas MyCanvas = new MyCanvas();
                MyCanvas.setVisible(true);
            }
        });
    }
}


