package estimatingpi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author ldbruby95
 */
public class EstimatingPi extends JPanel {

    static int W = 500 + 15;
    static int H = 500 + 30; // plus 30 because frame cuts a bit short due to
    // panel title
    static double r = 250;
    static double mypi;
    ArrayList<Point> pts = new ArrayList<>();
    //ArrayList pts = new ArrayList();
    int count = 0;
    double I;
    double AoS = (2.0 * r) * (2.0 * r); // area of square;
    Color c;
    Random rd;

    public EstimatingPi() {
        this.pts = new ArrayList();
        this.rd = new Random();

    }

    public class Point {

        double xp;
        double yp;
        boolean inside;

        public Point(double xp, double yp, boolean inside) {
            this.xp = xp;
            this.yp = yp;
            this.inside = inside;
        }

    }

    public static boolean inCircleHuh(double x, double y, double r) {
        //System.out.println("x = " + x + ", y = " + y);
        return (Math.sqrt(x * x + y * y)) <= (r);
    }
    
   int m = 0;

    public void timer() {
        
            m++;
            // calculating pi, how many have we done so far
            double x = rd.nextDouble() * 2 * r - r;
            double y = rd.nextDouble() * 2 * r - r;
            boolean inside = inCircleHuh(x, y, r);

            pts.add(new Point(x, y, inside));

            if (inside) {
                count++; // how many points have you added so far?

            }
            I = AoS * ((double) count / (double) m);
            mypi = I / (r * r);
            System.out.println("total points: " + m  + ", mypi: " + mypi);
            
            
        this.revalidate();
        this.repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (Point pt : pts) {

            //object cannot be converted to EstimatingPi.Point???
            if (pt.inside) {
                c = Color.BLUE;
                
            } else {
                c = Color.MAGENTA;//new Color(255,20,147); //;
            }
            
            int x = ((int) Math.round(pt.xp) + (int) Math.round(r));
            int y = ((int) Math.round(pt.yp) + (int) Math.round(r));
            
            g.setColor(c);
            g.fillOval(x, y, 5, 5);
        }
        
        String s = "pi: " + mypi;
        String ss = "points: " + m;
        g.setColor(Color.BLACK);
        g.setFont(new Font("default", Font.BOLD, 16));
        g.drawChars(s.toCharArray(), 0, s.length(), 5, H-60);
        g.drawChars(ss.toCharArray(),0, ss.length(), 5, H-45);
        

    }

    private static void makeGUI() {
        JFrame f = new JFrame("Estimating Pi using Monte Carlo Technique - LB");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(EstimatingPi.W, EstimatingPi.H);
        final EstimatingPi ep = new EstimatingPi();
        f.add(ep);
        
        int delay = 70;

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ep.timer();
            }
        };
        new Timer(delay, taskPerformer).start();

        f.setVisible(true);
        

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                makeGUI();
            }
        });
    }

}
