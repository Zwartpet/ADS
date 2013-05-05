/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ADSopdracht1;

/**
 *
 * @author John
 */
public class World {

    int aantalobjecten;
    int aantalopeenplek;

    public int getAantalopeenplek() {
        return aantalopeenplek;
    }

    public int getAantalobjecten() {
        return aantalobjecten;
    }
    int xmax;
    int ymax;
    int[][] matrix;

    public World() {//STANDAARD WERELED MET EEN DEMENTIE VAN  30*30 
        xmax = 30;
        ymax = 30;
        matrix = new int[xmax][ymax];
        init();
    }

    public World(int a, int b) {

        xmax = a;
        ymax = b;
        matrix = new int[xmax][ymax];
        init();
    }

    public void addobject(Obj obj) {
        int x, y;
        x = obj.getX();
        y = obj.getY();
        if (x < xmax && y < ymax) {
            matrix[x][y] += 1;
            aantalobjecten += 1;
            if (matrix[x][y] > aantalopeenplek) {
                aantalopeenplek = matrix[x][y];
            }
        } else {
            System.out.println(x + " " + y + " " + xmax + " " + ymax);
        }

    }

    public void printworld() {
        for (int i = 0; i < xmax; i++) {
            for (int j = 0; j < ymax; j++) {
                System.out.print(matrix[i][j] + "  ");

            }
            System.out.println("");
        }

    }

    public void init() {
        aantalopeenplek = 0;
        aantalobjecten = 0;
        for (int i = 0; i < xmax; i++) {
            for (int j = 0; j < ymax; j++) {
                matrix[i][j] = 0;
            }

        }

    }
    public int gettiles(int x, int y){
        
       return matrix[x][y]; 
    }
}
