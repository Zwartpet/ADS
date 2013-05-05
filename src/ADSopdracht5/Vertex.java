/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ADSopdracht5;

/**
 *
 * @author John
 */
class Vertex
   {
   public String label;        // label is voor het veld adres op het schakelboard 
   public boolean wasVisited; // 
   
// ------------------------------------------------------------
   public Vertex(String lab)   // constructor
      {
       
      label = lab;
      wasVisited = false;
      }
}
