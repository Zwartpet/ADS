/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ADSopdracht3;

/**
 *
 * @author John
 */
public class ParsePost {
      private StackY theStack;
    private String input;
//--------------------------------------------------------------

    public ParsePost(String s) {
        input = s;
    }
//--------------------------------------------------------------

    public int doParse() {
        theStack = new StackY(20);             // make new stack
        char ch;
        int j;
        int num1, num2, interAns;

        for (j = 0; j < input.length(); j++) // for each char,
        {
            ch = input.charAt(j);              // read from input
            //theStack.displayStack("" + ch + " ");  // *diagnostic*
            if (ch >= '0' && ch <= '9') {
                theStack.push((int)(ch - '0'));
            } //   push it
            else // it's an operator
            {
                num2 = theStack.pop();          // pop operands
                num1 = theStack.pop();
                switch (ch) // do arithmetic
                {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                }  // end switch
                theStack.push(interAns);        // push result
            }  // end else
        }  // end for
        interAns = theStack.pop();            // get answer
        return interAns;
    }  // end doParse() 
}
