/*en
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ADSopdracht1;
import java.util.Random;

/**
 *
 * @author John
 */
public class Main {
    public static int AANTAL_OBJECTEN = 50;
    public static int XMAX = 20;
    public static int YMAX = 20;
    Obj[] obj_array;
    World w;
    Random rnd = new Random();
    public Main() {
        w = new World(XMAX, YMAX);//HIER GEEF JE MEE DEMENSIES VAN DE WERELD
        setup(XMAX, YMAX);
        System.out.println("wereld met objecten");
        w.printworld();//hier print ik de wereled zodat het geen effect kan hebben op opdracht 1b vraag a
        System.out.println("hieronder is opdracht 1b");
        System.out.println("practicum 1b vraag a. Er staan " + opdrachta() + " objecten aan de onderste helft van de wereld");
        opdrachtb();
        System.out.println("opdrach 1b vraag c. Het aantal tiles waar 2 of meer objecten op staan is: " + opdrachtc());
        System.out.println("opdracht 1b vraag d. Er zijn " + opdrachtd() + " lege tiles in de wereld");
        opdrachte();
        System.out.println("opdracht 1b vraag f. de langste, aaneengesloten rij tiles (in horizontale richting) die elk minstens één object bevat is " + opdrachtf());
        System.out.println("Hier onder is opdracht 1a");
        System.out.println("Het aantal objecten op het veld is: " + w.getAantalobjecten());
        System.out.println("Het meeste aantal objecten op een tile: " + w.getAantalopeenplek());
        System.out.println("De kans berekent in een empirische methode: " + berekenkansempirisch());
        System.out.println("De kans berekent in een wiskundig formule: " + berekenkanswiskundig());
    }
    public static void main(String[] args) {
        new Main();
    }
    public double berekenkansempirisch() {//kans brekenen door 1000000 keer te loopen
        double startTime = System.currentTimeMillis();
        double aantalkeren;
        aantalkeren = 0;
        for (int i = 0; i < 1000000; i++) {
            w.init();
            setup(XMAX, YMAX);
            if (w.getAantalopeenplek() > 1) {
                aantalkeren += 1;
            }
        }
        double estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("the timer voor de empirisch: " + estimatedTime + " millieseconds");
        return aantalkeren / 1000000;
    }
    public double berekenkanswiskundig() {//kans brekenen door 
        double startTime = System.currentTimeMillis();
        double resultaat = 1;
        for (int i = 0; i < AANTAL_OBJECTEN; i++) {//50 want we hebben 50 objecten
            resultaat = resultaat * (400 - i) / 400;//400 want 20*20 is 400 
        }
        double estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("the timer voor de wiskundig : " + estimatedTime + " millieseconds");
        return 1 - resultaat;
    }
    public void setup(int xmax, int ymax) {
        obj_array = new Obj[AANTAL_OBJECTEN];
        for (int i = 0; i < AANTAL_OBJECTEN; i++) {
            obj_array[i] = new Obj(rnd.nextInt(xmax), rnd.nextInt(ymax));
            w.addobject(obj_array[i]);
        }
    }
    public int opdrachta() {
        double startTime = System.currentTimeMillis();
        int resultaat = 0;
        for (int i = 10; i < XMAX; i++) {
            for (int j = 0; j < YMAX; j++) {
                resultaat += w.gettiles(i, j);
            }
        }
        double estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("the timer voor opdracht a : " + estimatedTime + " millieseconds");
        return resultaat;
    }
    public void opdrachtb() {
        double startTime = System.currentTimeMillis();
        int teller;
        System.out.println("opdracht 1b vraag b.");
        for (int i = 0; i < XMAX; i++) {
            teller = 0;
            for (int j = 0; j < YMAX; j++) {
                teller += w.gettiles(i, j);
            }
            System.out.println("Op rij " + (i + 1) + " staat er  " + teller + " object(en)");
        }
        double estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("the timer voor opdracht b : " + estimatedTime + " millieseconds");
    }
    public int opdrachtc() {
        double startTime = System.currentTimeMillis();
        int resultaat = 0;
        for (int i = 0; i < XMAX; i++) {
            for (int j = 0; j < YMAX; j++) {
                if (w.gettiles(i, j) > 1) {
                    resultaat += 1;
                }
            }
        }
        double estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("the timer voor opdracht c : " + estimatedTime + " millieseconds");
        return resultaat;
    }
    public int opdrachtd() {
        double startTime = System.currentTimeMillis();
        int resultaat = 0;
        for (int i = 0; i < XMAX; i++) {
            for (int j = 0; j < YMAX; j++) {
                if (w.gettiles(i, j) == 0) {
                    resultaat++;
                }
            }
        }
        double estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("the timer voor opdracht d : " + estimatedTime + " millieseconds");
        return resultaat;
    }
    public void opdrachte() {
        double startTime = System.currentTimeMillis();
        System.out.println("opdracht 1b vraag E:");
        for (int i = 0; i < XMAX; i++) {
            for (int j = 0; j < YMAX; j++) {
                if (w.gettiles(i, j) > 0) {
                    System.out.println("Het eerste object van links staat op rij " + i + " op tile " + j);
                    break;
                }
            }
        }
        double estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("the timer voor opdracht e : " + estimatedTime + " millieseconds");
    }
    public int opdrachtf() {
        double startTime = System.currentTimeMillis();
        int resultaat = 0;
        int lengtehuidigerij;
        for (int i = 0; i < XMAX; i++) {
            lengtehuidigerij = 0;
            for (int j = 0; j < YMAX; j++) {

                if (w.gettiles(i, j) > 0) {
                    lengtehuidigerij += 1;
                    if (lengtehuidigerij > resultaat) {
                        resultaat = lengtehuidigerij;
                    }

                } else {
                    lengtehuidigerij = 0;
                }
            }
        }
        double estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("the timer voor opdracht f : " + estimatedTime + " millieseconds");
        return resultaat;
    }
}
