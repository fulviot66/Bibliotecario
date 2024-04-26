package com.fulviotarable;

// Il Controllore coordina le interazioni
// tra la Vista e il Modello
import java.io.*;

/**
 *
 * @author Fulvio
 */
public class BibliotecarioControllore {
// Dichiara l'uso di un Array per contenere la Libreria    
    public static String [] Libreria;
    static int contaLibri;

// Dichiara l'uso di un Array per contenere l'Elenco Libri    
    public static String [] elencoLibri;
    static int righeElenco;
    
// Dichiara un flag che indica se il libro è stato trovato
    public static boolean LT = false;
    
// Variabili di istanza
    private static BibliotecarioVista BV;
    private static BibliotecarioModello BM;
    
    public BibliotecarioControllore(BibliotecarioVista BV, BibliotecarioModello BM) {
        this.BV = BV;
        this.BM = BM;        
    }

// Carica in memoria il file Elenco-Libri.txt che è stato selezionato dal FileChooser    
    @SuppressWarnings("empty-statement")
    public static void caricaElencoLibri(File fileSelezionato) throws FileNotFoundException, IOException {
// Svuota l'Area Testo dei Libri NON Trovati
        BV.areaTestoLibriNonTrovati.setText("");        
        
        try {
            
// Inizializa l'Array per contenere l'Elenco dei Libri da cercare    
        elencoLibri = new String [1000];
        righeElenco=0;
            FileReader fr = new FileReader(fileSelezionato);
            BufferedReader br = new BufferedReader(fr);
// Crea i buffer per popolare le aree di testo
            StringBuilder righeDaCercare = new StringBuilder();

/* Metodo di lettura suggerito, da valutare per una successiva implementazione
            
            String line;
        while ((line = br.readLine()) != null) {
// usa line
}
*/            
            while (true) {
// Legge dal file la prossima linea
                String riga = br.readLine();
                elencoLibri [righeElenco] = riga;
                righeElenco ++;
// Invoca il metodo di popolazione dell'Area Testo dei Libri Da Cercare
                popolaAreaTestoLibriDaCercare(righeDaCercare, riga);

//                System.out.println(riga);

                if (riga == null) {
                    break;
                }
            }
        } catch (IOException IOEx) {
            System.out.println(IOEx);
        }
    }

    public static void popolaAreaTestoLibriDaCercare(StringBuilder righeDaCercare, String riga) {
        if(riga==null){riga="";}
        righeDaCercare.append(riga).append("\r").append("\n");
        BV.areaTestoLibriDaCercare.setText(righeDaCercare.toString());                
    }
/**
 * Carica in memoria i titoli di tutti i Libri presenti in Libreria
 * @param posizioneLibreria
 * @throws java.io.FileNotFoundException
 */
    public static void caricaLibreria(String posizioneLibreria)throws FileNotFoundException, NullPointerException       
        {            
// Inizializa l'Array per contenere la Libreria    
        Libreria = new String [500000];
        contaLibri=0;
            File dir = new File(posizioneLibreria);            
            System.out.println(posizioneLibreria);
                elencaFile(dir);
        }    
            
/**
 * Esplora tutto il contenuto delle sotto cartelle a partire
 * dal percorso indicato nel campo Posizione Libreria
 * @param dir 
 */
    public static void elencaFile(File dir) 
    {
//        System.out.println("metodo elencaFile");
        File[] entries = dir.listFiles();

        if (entries != null) 
//            System.out.println("entries != null");
        {            
            for (File entrie : entries) 
            {                
                if (entrie.isDirectory()) 
                {
//                    System.out.println("entrie.isDirectory");
                    elencaFile(entrie); // ricorsione
                } 
                    else
                {
                    Libreria[contaLibri] = entrie.getName();
//                System.out.println(contaLibri);
                contaLibri ++;
//                BV.statoRicerca.setIndeterminate(true);
                }
            }
        }
    // Scrive nella barra di stato quanti libri ha trovato
                    BV.totaleLibriPresenti.setText("   "+contaLibri);                            
    }

    public static void cercaInLibreria()
    {
/**
 * Il metodo si basa sul confronto di ogni singolo elemento presente
 * nell'array elencoLibri con tutti gli elementi dell'array Libreria.
 * Il criterio di comparazione dice che se la stringa composta da
 * Autore - Titolo dell'array elencoLibri NON corrisponde nella stessa 
 * lunghezza di caratteri a quella presente nell'array Libreria,
 * allora la corrispondenza NON è stata tovata, quindi il Titolo del 
 * Libro va ricopiato nell'area di testo dei LIBRI NON TROVATI
 */
        StringBuilder righeNonTrovate = new StringBuilder();
        String riga = new String();
        
        for(int rigaElenco=0;rigaElenco<righeElenco;rigaElenco++)
        {
// Corpo del ciclo
            riga = elencoLibri[rigaElenco];
                estraiDatiLibroDaElenco(riga);

// Testa, se il libro è stato trovato, non scrive nulla        
                if(LT) riga="";
            righeNonTrovate.append(riga).append("\r").append("\n");
// Reimposta il flag per il confronto successivo
            LT=false;
        }        
// Popola l'Area Testo dei Libri NON Trovati
        BV.areaTestoLibriNonTrovati.setText(righeNonTrovate.toString());        
    }
    
/**
 *
 * @param record
 * @throws StringIndexOutOfBoundsException
 * @throws NullPointerException
 */
    @SuppressWarnings("empty-statement")
    public static void estraiDatiLibroDaElenco(String record) throws StringIndexOutOfBoundsException, NullPointerException
//    public static void estraiDatiLibroDaElenco(String record) throws NullPointerException
    {
//      System.out.println(record);
// Estrae il campo Autore dal record        
    try
        {    
/*
        int inizioAutore = 0;        
        int fineAutore = record.indexOf('\u002D');
        String Autore = record.substring(inizioAutore, fineAutore - 1);
*/
        
int inizioAutore = 0;
String Autore;
int fineAutore;
// identifica il primo trattino tra Autore e Titolo
   if(record.indexOf('\u002D') > 0)   
      {
      fineAutore = record.indexOf('\u002D');
      Autore = record.substring(inizioAutore, fineAutore - 1);
      }
   else Autore = "AUTORE NON VALIDO";        
        
// Estrae il campo Titolo dal record
        int inizioTitolo = record.indexOf('\u002D');
        int fineTitolo = record.lastIndexOf('\u002D');
        String titoloSporco = record.substring(inizioTitolo + 2, fineTitolo - 2);
        int inizioEstensione = titoloSporco.lastIndexOf('\u002E');
        String Titolo = titoloSporco.substring(0, inizioEstensione - 7);

// Estrae il campo Anno dal record
        int inizioAnno = titoloSporco.lastIndexOf('\u0028');
        int fineAnno = titoloSporco.lastIndexOf('\u0029');
        String Anno = titoloSporco.substring(inizioAnno + 1, fineAnno);

// Crea un oggetto Libro che abbia come proprietà i dati appena raccolti
        Libro libroDaCercare = new Libro();
        libroDaCercare.setAutoreLibro(Autore);
        libroDaCercare.setTitoloLibro(Titolo);
        
            confrontaLibro(libroDaCercare);        
        }
        
        catch (StringIndexOutOfBoundsException | NullPointerException SIEx)
            {
/*
                BV.mostraMessaggioErrore("IL FILE DA ANALIZZARE NON HA TUTTE LE\n RIGHE A POSTO, CONTROLLALO E POI RICARICALO");
*/
            }
    } 
    
    public static void confrontaLibro(Libro libroDaCercare)
    {
//    System.out.println("INIZIO CONFRONTO");
// Verranno confrontati tutti i caratteri che formano la stringa Autore - Titolo
        String Autore = libroDaCercare.getAutoreLibro();
        String Titolo = libroDaCercare.getTitoloLibro();
        String ricerca = Autore + " - " + Titolo;

// Esempio di confronto con il metodo regionMatches()
//      String s1 = "Pallone";
//      String s2 = "Pallore";
//      boolean b = s1.regionMatches(true, 2, s2, 2, 3); // true perché llo uguali
    try{
            for(int i=0;i<contaLibri;i++)
                {
                boolean compara = Libreria[i].regionMatches(true,0,ricerca,0,ricerca.length());
                    if (compara) 
                    {
                    System.out.println(i+"\t"+ricerca+"\t"+Libreria[i]+"\t"+"LIBRO TROVATO!");
                    i=contaLibri;
                        LT=true;
                    }                 
                }
        }
        catch (NullPointerException | StringIndexOutOfBoundsException NPEx) 
                {
/*
                BV.mostraMessaggioErrore("IL FILE DA ANALIZZARE NON HA TUTTE LE\n RIGHE A POSTO, CONTROLLALO E POI RICARICALO");
*/
                }
            }
}