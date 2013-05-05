/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ADSopdracht2;

/**
 *
 * @author John
 */
public class Main {
        public static void main(String[] args) {
        Word word = new Word("TONYynot");
        Math math = new Math(9, 8);
        word.print();
        System.out.println("");
        word.printr();
        System.out.println("");
        word.checkPalin();
        System.out.println(math.doMath());
        
    }
}
