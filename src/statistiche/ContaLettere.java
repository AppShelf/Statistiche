/*
 * ContaLettere
 * Mantiene statistiche sulla frequenza delle lettere presenti nel testo.
 */
package statistiche;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Belluzzi Fioravanti 3Ai
 */
public class ContaLettere {
    
    char[] alfabeto;
    int[] contatori;
    long totale;
    
    public ContaLettere(){
        alfabeto = new char[26];
        contatori = new int[26];
        for (int i = 0; i < 26; i++) {
            alfabeto[i] = (char)('a' + i);
            contatori[i] = 0;
        }
        totale = 0;
    }

    public long getTotale() {
        return totale;
    }
    
    public void add(String frase){
        String fraseminuscola = frase.toLowerCase();
        for (int i = 0; i < fraseminuscola.length(); i++) {
            char c = fraseminuscola.charAt(i);
            if (c >= 'a' && c <= 'z') {
                totale++;
                contatori[c - 'a'] ++;
            }
        }
    }
    
    public int addLibro(String filename) {
        int righe = 0;
        String riga;
        File f = new File(filename);
        Scanner lettore;
        try {
            lettore = new Scanner(f);
            while (lettore.hasNext()) {
                riga = lettore.nextLine();
                add(riga);
                righe++;
            }
        } catch (FileNotFoundException ex) {
            return -1;
        }
        return righe;
    }
    
    public void print(){
        float percentuale;
        System.out.printf( "[%,10d] -->\t", totale );
        if (totale>0) {
            for (int i = 0; i < 26; i++) {
                percentuale = ( (float)contatori[i] / totale ) *100;
                System.out.printf( "%c: %,7d - %2.2f%%\t", alfabeto[i], contatori[i], (float)percentuale );
            }
        }
        System.out.println();
    }
    
}
