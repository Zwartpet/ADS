/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ADSopdracht4;


import java.util.Scanner;

/**
 *
 * @author John
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    Scanner input = new Scanner(System.in);
    Tree tree = new Tree();
    String postfix;
    int cursor;
    Node current;
    ParsePost pp;

    public static void main(String[] args) {

        new Main();
    }

    public Main() {
        System.out.print("Enter a postfix expression: ");
        postfix = input.nextLine();
        cursor = postfix.length() - 1;
        tree.root = readExpression();
        tree.displayTree();
        System.out.println("");
        tree.traverse(1);
        System.out.println("");
        tree.traverse(2);
        System.out.println("");
        tree.traverse(3);
        pp = new ParsePost(postfix);
        System.out.println("the answer is: " + pp.doParse());
    }
    public boolean isOperator(char x) {
        return x == '*' || x == '-' || x == '+' || x == '/' || x == '^';
    }
    public Node readExpression() {

        Node result;
        result = new Node();
        char in = postfix.charAt(cursor);
        if (isOperator(in)) {
            cursor--;
            result.rightChild = readExpression();   // rechts
            result.leftChild = readExpression();   // links
        } else {
            cursor--;
        }
        result.iData = in;
        return result;
    }
}
