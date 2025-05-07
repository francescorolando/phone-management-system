public class Tablet extends Telefono {
    private String tipoTastiera;
    private int valoreTastiera;
    private int valoreTotale;

    // "valore" è ereditato da telefono e rappresenta il valore del dispositivo in sé
    // "valoreTastiera" è il valore della tastiera ed è proprio della classe Tablet
    // "valoreTotale" è il valore complessivo di Tablet (somma del valore del dispositivo in sé e del valore della tastiera)

    // COSTRUTTORE ---------------------------------------------------------------
    public Tablet(Produttore produttore, int memoria, int valore, Persona proprietario, String tipoTastiera, int valoreTastiera) {
        super(produttore, memoria, valore, proprietario);
        this.tipoTastiera = tipoTastiera;
        this.valoreTastiera = valoreTastiera;
        this.valoreTotale = valore + valoreTastiera;
    }

// METODI --------------------------------------------------------------------

    // restituisce i dati di un tablet
    @Override
    public String informazioni() {
        // prima di prendere i valori, verifico che questi fossero assegnati
        String marca;
        String proprietario;
        if (this.produttore != null) {
            marca = this.produttore.getNome();
        }
        else {
            marca = "[nessuno]";
        };
        if (this.proprietario != null) {
            proprietario = this.proprietario.getCognome();
        }
        else {
            proprietario = "[nessuno]";
        };
        return this.id + ") " +
                "TIPO: TABLET, " +
                "Marca: " + marca +
                ", Memoria: " + this.memoria +
                " GB , Valore totale: " + this.valoreTotale +
                " €, Valore dispositivo: " + this.valore +
                " €, Valore tastiera: " + this.valoreTastiera +
                " €, Tipo tastiera: " + this.tipoTastiera +
                ", Proprietario: " + proprietario +
                ", Passaggi di proprietà: " + this.passaggiProprieta + ".";
    }

    // metodo per cambiare il valore della tastiera (e che cambia anche il valore totale)
    // restituisce FALSE se il valore della tastiera inserito è negativo
    public boolean cambiaValoreTastiera(int valoreTastiera) {
        // verifico che il valore della tastiera sia maggiore o uguale a 0
        if (valoreTastiera >= 0) {
            this.valoreTastiera = valoreTastiera;
            this.valoreTotale = this.valore + this.valoreTastiera;
            return true;
        }
        else {
            return false;
        }
    }


    // GETTER E SETTER ----------------------------------------------------------------
    public String getTipoTastiera() {
        return tipoTastiera;
    }
    public int getValoreTastiera() {
        return valoreTastiera;
    }
    public int getValoreTotale() {
        return valoreTotale;
    }

    public void setTipoTastiera(String tipoTastiera) {
        this.tipoTastiera = tipoTastiera;
    }
    public void setValoreTastiera(int valoreTastiera) {
        this.valoreTastiera = valoreTastiera;
        this.valoreTotale = this.valore + this.valoreTastiera;
    }
}


