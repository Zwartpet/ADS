/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ADSopdracht3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author John
 */
public class Calc {


    public static void main(String[] args) throws IOException {
        String som, input, output;
        int guessed = 0, answer = 0;
        
        Random rand = new Random();
        char[] operators = {'+', '-', '*'};
        char[] operatorkeuze = {' ', ' ', ' '};
        int check[] = {0, 0, 0, 0}; 
        char[] check2 = {' ', ' ', ' '};
        for (int i = 0; i < 3; i++) {
            operatorkeuze[i] = operators[rand.nextInt(3)];
        }
        
        int[] getallen = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] getalkeuze = {0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            getalkeuze[i] = getallen[rand.nextInt(9)];
        }
        
        som = "" + getalkeuze[0] + operatorkeuze[0] + getalkeuze[1] + operatorkeuze[1] + getalkeuze[2] + operatorkeuze[2] + getalkeuze[3];
        InToPost theTrans = new InToPost(som);
        output = theTrans.doTrans();
        ParsePost parse = new ParsePost(output);
        int x = parse.doParse();

        System.out.println(som + " <- Het antwoord, uitgeprint om te testen");
        
        Arrays.sort(getalkeuze);
        for (int i = 0; i < getalkeuze.length; i++) {
            System.out.print(getalkeuze[i] + " ");
        }
        System.out.print(" ");
        Arrays.sort(operatorkeuze);
        for (int i = 0; i < operatorkeuze.length; i++) {
            System.out.print(operatorkeuze[i] + " ");
        }
        
        //System.out.println(som + " = " + x);
        System.out.println(" " + x);
        System.out.println("First try:");
        while (guessed == 0) {
            input = getString();
            InToPost theTrans2 = new InToPost(input);
            output = theTrans2.doTrans();
            ParsePost parse2 = new ParsePost(output);
            answer = parse2.doParse();
            char letter;
            int j = 0, n = 0, valid = 0;
            for (int i = 0; i < input.length(); i++) {
                input = input.trim();
                letter = input.charAt(i);
                boolean isDigit = (letter >= '0' && letter <= '9');
                if(isDigit){
                    check[j] = letter - '0';
                    j++;
                }else if(n<3){
                    check2[n] = letter;
                    n++;
                }
            }
            Arrays.sort(check);
            Arrays.sort(check2);
            
            if(Arrays.equals(check, getalkeuze) && Arrays.equals(check2, operatorkeuze)){
                valid = 1;
            }else{
                valid = 0;
            }
            
            if(answer == x && valid == 1){
                System.out.println("Succes!");
                guessed = 1;
            }else{
                System.out.println("Incorrect, try again:");
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
