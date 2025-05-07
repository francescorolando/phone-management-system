public class Produttore {
    private int id;
    private static int conteggio = 0;
    private String nome;
    private String nazione;

    // COSTRUTTORE ----------------------------------------------------------
    public Produttore(String nome, String nazione) {
        this.nome = nome;
        this.nazione = nazione;
        conteggio++;
        this.id = conteggio;
    }

    // METODI ---------------------------------------------------------------

    // restituisce dati del produttore
    public String informazioni() {
        return this.id + ") Nome Produttore: " + this.nome + " - Nazione: " + this.nazione + ".";
    }

    // GETTER E SETTER -----------------------------------------------------
    public int getId() {
        return id;
    }
    public static int getConteggio() {
        return conteggio;
    }
    public String getNome() {
        return nome;
    }
    public String getNazione() {
        return nazione;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNazione(String nazione) {
        this.nazione = nazione;
    }
}


