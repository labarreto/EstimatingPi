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
public class EstimatingPi {

    static double r = 360;
    int n;
    double mypi;
    ArrayList pts = new ArrayList();
    int count = 0;
    double I;
    double AoS = (2.0 * r) * (2.0 * r); // area of square;

    Random rd = new Random();

    public EstimatingPi(ArrayList pts, double mypi, int n) {
        this.pts = pts;
        this.mypi = mypi;
        this.n = n;

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
        for (int i = 0; i < n; i++) {
            n++;
            // calculating pi, how many have we done so far
            double x = rd.nextDouble() * 2 * r - r;
            double y = rd.nextDouble() * 2 * r - r;
            boolean inside = inCircleHuh(x, y, r);

            this.pts.add(new Point(x, y, inside));
            if (inside) {
                count++; // how many points have you added so far?
            }
            I = AoS * ((double) count / (double) n);
            mypi = I / (r * r);
        }
    }

    public void paint() {

    }
    
    // ----------------------------------------------------------------------- //

    public static void Go(double r, int n) {
        //r is radius
        //n is number of points to be made
        //these will all become fields

        ArrayList pts = new ArrayList();

        int count = 0;
        double I;
        double AoS = (2.0 * r) * (2.0 * r); // area of square;
        double pi;

        Random rd = new Random();

        int m = 0;

        for (int i = 0; i < n; i++) {
            m++;
            // calculating pi, how many have we done so far
            double x = rd.nextDouble() * 2 * r - r;
            double y = rd.nextDouble() * 2 * r - r;
            boolean inside = inCircleHuh(x, y, r);
            // this.pts.add(new Point(x, y, inside));
            if (inside) {
                count++;
            }
            I = AoS * ((double) count / (double) m);
            pi = I / (r * r);
            System.out.println(pi);

        }

    }



}
