package estimatingpi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author ldbruby95
 */
public class EstimatingPi extends JApplet implements Runnable{
    

    
    public static void Go(double r, int n) {
        //r is radius
        //n is number of points to be made
        int count = 0;
        double I;
        double AoS = (2.0*r) * (2.0*r); // area of square;
        double pi;
        
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Random rd = new Random();
            
        int m = 0;
        for (int i = 0; i < n; i++) {
            m++;
            // calculating pi, how many have we done so far
            double x = rd.nextDouble()*2*r - r;
            double y = rd.nextDouble()*2*r - r; 
            if (inCircleHuh(x,y,r)) {
                count++;
            }
            I = AoS * ((double) count / (double) m);        
            pi = I/(r*r);       
            System.out.println(pi);
            
        }
        
    }
    
    public static boolean inCircleHuh(double x, double y, double r) {
        //System.out.println("x = " + x + ", y = " + y);
        return (Math.sqrt(x * x + y * y)) <= (r); 
    }
    
   
    public static void main(String[] args) {
        Go(1.0,1000);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
