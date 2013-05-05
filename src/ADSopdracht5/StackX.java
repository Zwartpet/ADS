/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ADSopdracht5;

/**
 *
 * @author John
 */
class StackX
{   
   private int numSquares;//moet veranderen naar NUMBER_OF_SQUARES warde
   public int[] st;
   public int top;
// ------------------------------------------------------------
   public StackX(int numSquares)           // constructor
      {
       this.numSquares = numSquares;
      st = new int[numSquares];    // make array
      top = -1;
      }
// ------------------------------------------------------------
   public void push(int j)   // put item on stack
      { st[++top] = j; }
// ------------------------------------------------------------
   public int pop()          // take item off stack
      { return st[top--]; }
// ------------------------------------------------------------
   public int peek()         // peek at top of stack
      { return st[top]; }
// ------------------------------------------------------------
   public boolean isEmpty()  // checks if its empty 
      { return (top == -1); }
   
   public boolean isFull(){  // checks if its full    
       return top == numSquares-1;
   }   
   
// ------------------------------------------------------------
   }  // end class StackX
