public class Telefono implements Comparable<Telefono>{
    protected int id;
    protected static int conteggio = 0;
    protected Produttore produttore;
    protected int memoria;
    protected Persona proprietario;
    protected int passaggiProprieta;
    protected int valore;

    // COSTRUTTORE ---------------------------------------------------------------
    public Telefono(Produttore produttore, int memoria, int valore, Persona proprietario) {
        conteggio++;
        this.id = conteggio;
        this.produttore = produttore;
        this.memoria = memoria;
        this.valore = valore;
        this.proprietario = proprietario;
        this.passaggiProprieta = 0;
    }

    // METODI --------------------------------------------------------------------
    // stampa i dati di un telefono
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
                "TIPO: TELEFONO, " +
                "Marca: " + marca +
                ", Memoria: " + this.memoria +
                " GB, Valore: " + this.valore +
                " €, Proprietario: " + proprietario +
                ", Passaggi di proprietà: " + this.passaggiProprieta + ".";
    }

    // aumenta o diminuisce la memoria
    public void modificaMemoria(int x) {
        this.memoria = this.memoria + x;
    }

    // modifica proprietario (e numero di passaggi di proprietà)
    public boolean modificaProprietario(Persona proprietario) {
        // aumento i passaggi di proprietà solo se:
        // - il nuovo proprietario non è nullo
        // - il nuovo proprietario non è uguale al precedente
        if (proprietario != null && proprietario != this.proprietario) {
            aumentoPassaggiProprieta();
        }
        this.proprietario = proprietario;
        return true;
    }

    // stampo il numero di telefoni creati
    public static void conteggio() {
        String daStampare = "Numero di telefoni creati: " + conteggio;
        System.out.println(daStampare);
    }

    // aumento passaggi di proprietà (privato)
    private void aumentoPassaggiProprieta() {
        this.passaggiProprieta++;
    }

    // GETTER E SETTER -----------------------------------------------------------
    public int getId() {
        return id;
    }
    public static int getConteggio() {
        return conteggio;
    }
    public Produttore getProduttore() {
        return produttore;
    }
    public int getMemoria() {
        return memoria;
    }
    public Persona getProprietario() {
        return proprietario;
    }
    public int getPassaggiProprieta() {
        return passaggiProprieta;
    }
    public int getValore() {return valore; }

    public void setProduttore(Produttore produttore) {
        this.produttore = produttore;
    }
    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }


    // COMPARE TO --------------------------------------------------------------------
    @Override
    public int compareTo(Telefono telefono) {
        if (this.memoria < telefono.getMemoria()) {
            return -1;
        }
        else if (this.memoria > telefono.getMemoria()) {
            return 1;
        }
        else {
            return 0;
        }
    }

}
