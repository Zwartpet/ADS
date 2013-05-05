/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ADSopdracht2;

/**
 *
 * @author John
 */
public class Word {
        String word;
    int pos;
    int pos2;
    int palin = 0;
    int length;
    
    public Word(){
        word = "example";
        pos = pos2 = length = word.length();
    }
    
    public Word(String woord){
        word = woord;
        pos = pos2 = length = word.length();
    }
    
    public Word(String woord, int num){
        word = woord;
        length = word.length();
        pos = pos2 = num;
    }
    
    public void print(){ 
        int r;
        if(pos > 0){
            r = pos - 1;
            r %= word.length();
            pos--;
            print();//deze regel onder sout(s.charAt(r)) zetten voor opdracht 2.1.2
            System.out.print(word.charAt(r)); 
        }else if(pos <= word.length()){
            pos = pos2;
        }
    }
    
    public void printr(){ 
        int r;
        if(pos > 0){
            r = pos - 1;
            r %= word.length();
            pos--; 
            System.out.print(word.charAt(r)); 
            printr();//deze regel onder sout(s.charAt(r)) zetten voor opdracht 2.1.2
        }else if(pos <= word.length()){
            pos = pos2;
        }
    }
    
    public void checkPalin(){
        length -= 1;
        if(length >= palin){
            if(word.charAt(length) == word.charAt(palin)){
                palin++;
                checkPalin();
            }else{
                System.out.println("Geen palindroom");
            }
        }else if(length < palin){
            System.out.println("Palindroom!");
            palin = 0;
        }
    }
}
