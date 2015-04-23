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

    static int W = 720;
    static int H = 720;
    static double r = 360;
    int n = 40;
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

    public void timer() {
        int m = 0;
        int count = 0;
        
        n++;

        for (int i = 0; i < n; i++) {
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
            System.out.println("total points: " + n  + ", mypi: " + mypi);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (Point pt : pts) {

            //object cannot be converted to EstimatingPi.Point???
            if (pt.inside) {
                c = Color.BLUE;
                
            } else {
                c = Color.MAGENTA;
            }
            
            int x = ((int) Math.round(pt.xp) + 360);
            int y = ((int) Math.round(pt.yp) + 360);
            
            g.setColor(c);
            g.fillOval(x, y, 5, 5);
        }
        //JLabel l = new JLabel("pi = " + mypi);

    }

    private static void makeGUI() {
        JFrame f = new JFrame("Plot");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(EstimatingPi.W, EstimatingPi.H);
        final EstimatingPi ep = new EstimatingPi();
        f.add(ep);

//        JLabel text = new JLabel("pi = " + mypi);
//        f.add(text, BorderLayout.SOUTH);
//        f.setVisible(true);
        int delay = 140;

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ep.timer();
            }
        };
        new Timer(delay, taskPerformer).start();

        JLabel text = new JLabel("pi = " + mypi);
        f.add(text, BorderLayout.SOUTH);
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
