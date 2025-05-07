import java.util.ArrayList;
import java.util.Collections;

public class PhoneServiceList {
    private static int conteggio = 0;
    private int id;
    private Persona titolare;
    private String nome;
    private String indirizzo;
    private ArrayList<Telefono> telefoni;


    // COSTRUTTORE ---------------------------------------------------------------------------
    public PhoneServiceList(Persona titolare, String nome, String indirizzo) {
        conteggio++;
        this.id = conteggio;
        this.titolare = titolare;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.telefoni = new ArrayList<Telefono>();
    }

    // METODI ------------------------------------------------------------------------------

    // aggiunge un telefono
    // --> restituisce l'indice in cui il telefono è stato inserito, oppure -1 in caso di errore
    public int aggiungiTelefono(Telefono telefono) {
        if (telefono != null) {
            this.telefoni.add(telefono);
            return this.telefoni.indexOf(telefono);
        } else {
            return -1;
        }
    }

    // rimuove un telefono
    //  --> restituisce il telefono rimosso oppure NULL in caso di errore
    public Telefono rimuoviTelefono(int indice) {
        if (indice >= 0 && indice < this.telefoni.size()) {
            return this.telefoni.remove(indice);
        } else {
            return null;
        }
    }

    // restituisce il proprietario del telefono dato l'indice
    // --> restituisce null in caso di errore (indice non valido o lista vuota)
    public Persona trovaProprietarioTelefono(int indice) {
        if (indice >= 0 && indice < this.telefoni.size()) {
            return this.telefoni.get(indice).getProprietario();
        } else {
            return null;
        }
    }

    // cercare tutte i telefoni (i loro indici) posseduti da una certa persona
    // --> restituisce arraylist di indici (interi) OPPURE null in caso di errore
    public ArrayList<Integer> trovaTelefoniDiPersona(Persona proprietario) {
        ArrayList<Integer> indici = new ArrayList<>();
        if (!this.telefoni.isEmpty() && proprietario != null) {
            for (int i = 0; i < this.telefoni.size(); i++) {
                if (this.telefoni.get(i).getProprietario().equals(proprietario)) {
                    indici.add(i);
                }
            }

            // verifico che la persona in questione abbia almeno un telefono (ArrayList non vuoto)
            if(!indici.isEmpty()) {
                return indici;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    // stampa i dati di tutti i telefoni
    public void stampaDatiTelefoni() {
        if (this.telefoni.isEmpty()) {
            System.out.println("Il phone service " + this.nome + " non ha telefoni registrati.");
        } else {
            System.out.println("Elenco e dati dei telefoni del phone service " + this.nome + ": ");
            for (int i = 0; i < this.telefoni.size(); i++) {
                System.out.println("[indice:" + i + "] " + this.telefoni.get(i).informazioni());
            }
        }
    }

    // modifica il proprietario di un telefono dato l'indice
    // --> restituisce TRUE o FALSE (errore)
    public boolean modificaProprietarioTelefono(Persona nuovoProprietario, int indice) {
        if (indice >= 0 && indice < this.telefoni.size() && nuovoProprietario != null) {
            return this.telefoni.get(indice).modificaProprietario(nuovoProprietario);
        } else {
            return false;
        }
    }

    // trova la memoria di un telefono dato l'indice
    // --> restituisce -1 in caso di indice non valido
    public int trovaMemoriaTelefono(int indice) {
        if (indice >= 0 && indice < this.telefoni.size()) {
            return this.telefoni.get(indice).getMemoria();
        } else {
            return -1;
        }
    }

    // trovare la media della quantità di memoria dei telefoni gestiti dal service
    // --> restituisce -1 in caso di errore (nessun telefono registrato)
    public double mediaMemoriaTelefoni() {
        if (!this.telefoni.isEmpty()) {
            double somma = 0;
            for (Telefono telefono : this.telefoni) {
                somma += telefono.getMemoria();
            }
            return somma / this.telefoni.size();
        } else {
            return -1;
        }
    }

    // trovare tutti i telefoni di una data marca
    // --> restituisce un arraylist di Telefono oppure NULL in caso di errore
    public ArrayList<Telefono> trovaTelefoniDiMarca(Produttore marca) {
        ArrayList<Telefono> lista = new ArrayList<>();
        if (!this.telefoni.isEmpty() && marca != null) {
            for (Telefono telefono : this.telefoni) {
                if (telefono.getProduttore().equals(marca)) {
                    lista.add(telefono);
                }
            }
            // controllo che ci sia almeno un telefono di quella marca (lista NON vuota)
            if (lista.isEmpty()) {
                return null;
            }
            else {
                return lista;
            }
        }
        else {
            return null;
        }
    }

    // trovare i telefoni che non hanno mai cambiato utilizzatore (unico proprietario)
    // --> restituisce un arraylist di Telefono OPPURE null in caso di errore
    public ArrayList<Telefono> trovaTelefoniUnicoProprietario() {
        ArrayList<Telefono> lista = new ArrayList<>();
        if (!this.telefoni.isEmpty()) {
            for (Telefono telefono : this.telefoni) {
                if (telefono.getPassaggiProprieta() == 0) {
                    lista.add(telefono);
                }
            }
            // controllo che la lista non sia vuota (nessun telefono unico proprietario)
            if (lista.isEmpty()) {
                return null;
            }
            else {
                return lista;
            }
        }
        else {
            return null;
        }
    }

    // trovare il telefono con memoria più PICCOLA
    // --> restituisce un Telefono oppure NULL in caso di errore (arraylist vuoto)
    public Telefono memoriaMinore() {
        if (!this.telefoni.isEmpty()) {
            ArrayList<Telefono> arrayOrdinato = this.ordinaTelefoniPerMemoria();
            return arrayOrdinato.get(0);
        } else {
            return null;
        }
    }

    // trovare il telefono con memoria più GRANDE
    // --> restituisce un Telefono oppure NULL in caso di errore (arraylist vuoto)
    public Telefono memoriaMaggiore() {
        if (!this.telefoni.isEmpty()) {
            ArrayList<Telefono> arrayOrdinato = this.ordinaTelefoniPerMemoria();
            return arrayOrdinato.get(this.telefoni.size() - 1);
        } else {
            return null;
        }
    }

    // ordinare i telefoni in base alla memoria crescente
    // restituisce l'ArrayList ordinato in base alla memoria
    public ArrayList<Telefono> ordinaTelefoniPerMemoria() {
        Collections.sort(this.telefoni);
        return this.telefoni;
    }

    // GETTER e SETTER ---------------------------------------------------------------------
    public Persona getTitolare() {
        return titolare;
    }
    public void setTitolare(Persona titolare) {
        this.titolare = titolare;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
