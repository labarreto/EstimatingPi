/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estimatingpi;

/**
 *
 * @author ldbruby95
 */
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
