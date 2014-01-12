/*
 * Main del progetto Statistiche
 */

package statistiche;

/**
 *
 * @author Sandro
 */
public class Statistiche {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] libri = { "data/davidcopperfield.txt",
                           "data/warandpeace.txt",
                           "data/ipromessisposi.txt", 
                           "data/miseriaenobilta.txt" };
        
        for (int i = 0; i < libri.length; i++) {
            ContaLettere cl = new ContaLettere();
            System.out.printf("%25s...\t", libri[i]);
            if ( cl.addLibro(libri[i])<0 ) System.out.println("File " + libri[i] + " non trovato!");
            cl.print();
        }
        
    }

}
