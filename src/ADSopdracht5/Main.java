/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ADSopdracht5;

/**
 *
 * @author John
 */
public class Main {

    public static int COLUMN = 5;//kolm
    public static int ROW = 5;// rij
    public static int NUMBER_OF_SQUARES = COLUMN * ROW;
    Matrix matrix = new Matrix(NUMBER_OF_SQUARES, COLUMN, ROW);
    StackX stack = new StackX(NUMBER_OF_SQUARES);
    Vertex[] vertexList = new Vertex[NUMBER_OF_SQUARES];
    public static String[] letter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};//label van het board
    int count;

    public static void main(String[] args) {
        new Main();
    }

    Main() {

        matrix.printMatrix();
        for (int i = 0; i < NUMBER_OF_SQUARES; i++) {//vertexList vullen
            int x = i / ROW;
            int y =i%ROW;
            String label = letter[x] + (1 + y);
            vertexList[i] = new Vertex(label);
        }
        count = 0;
        System.out.println("Hier onder print ik de sprongen als de paard bij A1 zou beginen ");
        System.out.println("Paarde sprong op een 5 * 5 board");
        double startTime = System.currentTimeMillis();
        checkStack(0);// 0 is A1
        double estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(count);
        System.out.println("The run time is :" + estimatedTime);

    }

    public void checkStack(int x) {
        stack.push(x);
        if (vertexList[x].wasVisited) {//bugA
            stack.pop();
            return;
        } else if (stack.isFull()) {//bugB in de if en if else bugA en bugA warren omgedraid nu is het goed 
            //printStack();//hier kan je mogelijk tours uitprinten  
            count++;
            stack.pop();
            return;
        }
        //printStack();//hier kan je het route uitprinten van elke route 
        vertexList[x].wasVisited = true;

        for (int i = 0; i < matrix.size(); i++) {
            if (matrix.isNeighbour(x, i) == 1) {
                checkStack(i);
            }
        }
        stack.pop();
        vertexList[x].wasVisited = false;

    }

    public void printStack() {
        for (int i = 0; i <= stack.top; i++) {
            System.out.print(vertexList[stack.st[i]].label + " ");// het veld van de stack.st daarvan het label 
        }
        System.out.println("");
    }
}
