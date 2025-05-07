public class Persona {
    private int id;
    private static int conteggio = 0;
    private String cognome;
    private String indirizzo;

    // COSTRUTTORE ----------------------------------------------------------
    public Persona(String cognome, String indirizzo) {
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        conteggio++;
        this.id = conteggio;
    }

    // METODI ----------------------------------------------------------------

    // restituisce i dati della persona
    public String informazioni() {
        return this.id + ") Cognome: " + this.cognome + " - Indirizzo: " + this.indirizzo + ".";
    }

    // stampa il numero di persone registrate
    public static void stampaConteggio() {
        String daStampare = "Numero di persone registrate: " + conteggio + ".";
        System.out.println(daStampare);
    }


    // GETTER E SETTER ------------------------------------------------------
    public int getId() {
        return this.id;
    }
    public static int getConteggio() {
        return conteggio;
    }
    public String getCognome() {
        return cognome;
    }
    public String getIndirizzo() {
        return indirizzo;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
