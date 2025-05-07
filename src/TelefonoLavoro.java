public class TelefonoLavoro extends Telefono{
    private String aziendaIntestataria;

    // COSTRUTTORE --------------------------------------------------------------
    public TelefonoLavoro(Produttore produttore, int memoria, int valore, Persona proprietario, String azienda) {
        super(produttore, memoria, valore, proprietario);
        this.aziendaIntestataria = azienda;
    }

    // METODI --------------------------------------------------------------------

    // restituisce i dati di un telefono di lavoro
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
                "TIPO: TELEFONO di LAVORO, " +
                "Marca: " + marca +
                ", Memoria: " + this.memoria +
                " GB, Valore: " + this.valore +
                " €, Proprietario: " + proprietario +
                ", Passaggi di proprietà: " + this.passaggiProprieta +
                ", Azienda intestataria: " + this.aziendaIntestataria + ".";
    }

    // override del metodo "modificaProprietario" -> non si può fare nel telefono di lavoro
    @Override
    public boolean modificaProprietario(Persona proprietario) {
        System.out.println("Non si può modificare il proprietario di un telefono di lavoro!");
        return false;
    }

    // GETTER E SETTER --------------------------------------
    public String getAziendaIntestataria() {
        return aziendaIntestataria;
    }
    public void setAziendaIntestataria(String aziendaIntestataria) {
        this.aziendaIntestataria = aziendaIntestataria;
    }
}

