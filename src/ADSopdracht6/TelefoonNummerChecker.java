/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ADSopdracht6;

/**
 *
 * @author John
 */

import java.util.regex.Pattern;

/**
 *
 * 6A. Gebruik het Regexp java package om een Java methode
 *   boolean checkNummer(String telNr)
 * te maken die controleert of een telefoonnummer voldoet aan de regels voor een normaal Nederlands
 * telefoonnummer. We willen geen servicenummers (0800 0900 112 enz). Wel mobiel.
 * Gebruik de unittest om de methode te testen met deze testwaarden.
 * Een netnummer is 3 of 4 cijfers inclusief de 0. Bij 4 cijfers zijn de middelste nooit 0.
 * Er mag een streepje na de 06 of het netnummer.
 * Een abonneenummer begint nooit met een 0. 
 */
public class TelefoonNummerChecker {

    boolean checkNummer(String telNr) {
        // TODO: maar de regex zodanig dat controle op nl telefoonnummers werkt.
        // kijk op opta.nl voor meer info maar maak de regex zo kort mogelijk.
        String rex = "^([0|+]((6|[1-9]{2}[1-9])|(6|[1-9]{2}[1-9])-)[1-9][0-9]{5,7})|[1-9][0-9]{5,7}$"; // AANPASSEN!
        
        //0612345678
        //0299123456
        //0299-356778
        //06-12345678
        //+31299123456
        //+31612345678
        //0031612345678
        //0031299123456
        
        return Pattern.matches(rex, telNr);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // controleren via Unit Test!
        
    }
}
