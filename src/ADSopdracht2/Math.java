/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ADSopdracht2;

/**
 *
 * @author John
 */
public class Math {

    int x, y, i = 0;

    public Math() {
        x = y = 0;
    }

    public Math(int a, int b) {
        x = a;
        y = b;
    }

    public int doMath() {
        if (i < y) {
            return (x + doMath(i + 1));
        } else if (y < i) {
            return (0 - x - doMath(i - 1));
        } else {
            return 0;
        }
    }

    public int doMath(int j) {
        if (j < y) {
            return (x + doMath(j + 1));
        } else if (y < j) {
            return (x + doMath(j - 1));
        } else {
            return 0;
        }
    }
}
