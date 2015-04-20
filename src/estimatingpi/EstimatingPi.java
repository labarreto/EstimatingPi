package estimatingpi;


import java.util.*;
import javax.swing.*;
import java.awt.*;

public class EstimatingPi{
    
    int radius;
    int scale;
    
    int center;
    int pin;
    double pi;

    static Graphics gC; // circle

    static Graphics point;
    
    public static void makeGUI() {
        JFrame fr = new JFrame("Estimating Pi");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(720,720);
    }

    public void Go(double r, int n) {

        radius = (int) r;
        
        //basically, size of frame should be size of square. 
        
        
        //r is radius
        //n is number of points to be made
        int count = 0;
        double I;
        double AoS = (2.0 * r) * (2.0 * r); // area of square;
        double pi;

        int pW = 1;
        int pH = 1;


        
        int cornerX = 0; // top corner to be at 0,0
        int cornerY = 0; // top corner to be at 0,0
        // these will have problems with loosing significance. 
        int width = (int) r*2; 
        int height = (int) r*2;
        
        Color color = Color.magenta;
        
        
        gC.drawOval(cornerX, cornerY, width, height);

        
        JPanel panel = new JPanel();

        //creating frame
        JFrame f = new JFrame();
        //setting size of the frame
        f.setSize(720,720);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Random rd = new Random();

        int m = 0;

        for (int i = 0; i < n; i++) {
            m++;
            // calculating pi, how many have we done so far
            double x = rd.nextDouble() * 2 * r - r;
            double y = rd.nextDouble() * 2 * r - r;

            if (inCircleHuh(x, y, r)) {

                color = Color.BLUE;

                count++;
                point.setColor(color);
                point.drawOval(((int) Math.round(((x + r) * (360.0/r)))) , 
                        ((int) Math.round(((y + r) * (360.0/r)))), 
                        1, 1);
                //width and height are 1 because it's tiny point. 
                //draws point each time x, y changes. 
                
            }
            
            
            
            I = AoS * ((double) count / (double) m);
            pi = I / (r * r);
            System.out.println(pi);

            JLabel label = new JLabel("Count: " + count + ", Pi estimate: " + pi);
            f.add(label, JLabel.BOTTOM);
            //adding label
            f.setVisible(true);
        }

    }
   
    
    public static boolean inCircleHuh(double x, double y, double r) {
        //System.out.println("x = " + x + ", y = " + y);
        return (Math.sqrt(x * x + y * y)) <= (r);
    }

    public static void drawCircle(Graphics g, int x, int y, int radius) {

        int diameter = radius * 2;

        //shift x and y by the radius of the circle in order to correctly center it
        g.fillOval(x - radius, y - radius, 360, 360);

    }

    public void paintComponent(Graphics g) {

    }

    public void main(String[] args) {
        Go(1.0, 1000);
        public void run() {
           makeGUI();
        }
    }


}



