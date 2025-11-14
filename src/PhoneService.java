import java.util.Arrays;

public class PhoneService {
    private static int conteggio = 0;
    private int id;
    private Persona titolare;
    private String nome;
    private String indirizzo;
    private Telefono[] telefoni;
    private int numeroTelefoni;

    // COSTRUTTORE ---------------------------------------------------------------------------
    // dimensione array inserita come parametro
    public PhoneService(Persona titolare, String nome, String indirizzo, int dimensione) {
        conteggio ++;
        this.id = conteggio;
        this.titolare = titolare;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.telefoni = new Telefono[dimensione];
        this.numeroTelefoni = 0;
    }


    // METODI ------------------------------------------------------------------------------
    // aggiunge uno slot all'interno dell'array
    private void espandi() {
        Telefono[] telefoniTemp = new Telefono[this.telefoni.length + 1];
        for (int i = 0; i < this.telefoni.length; i ++) {
            telefoniTemp[i] = this.telefoni[i];
        }
        this.telefoni = telefoniTemp;
    }

    // aggiunge un telefono in fondo alla lista
    // --> restituisce -1 in caso di errore (tentato di inserire telefono nullo)
    public int aggiungiTelefono(Telefono telefono) {
        if (telefono != null) {
            if (numeroTelefoni == telefoni.length) {
                this.espandi();
            };
            this.telefoni[numeroTelefoni] = telefono;
            return numeroTelefoni ++;
        }
        else {
            return -1;
        }
    }


    // visualizzare il proprietario del telefono dato l'indice nel vettore
    // --> restituisce il proprietario (Persona) OPPURE null in caso di errore
    public Persona trovaProprietarioTelefono(int indice) {
        if (indice >= 0 && indice < this.numeroTelefoni) {
            return this.telefoni[indice].getProprietario();
        }
        else {
            return null;
        }
    }

    // cercare tutte i telefoni (i loro indici) posseduti da una certa persona
    // --> restituisce vettore di indici (interi) OPPURE null in caso di errore
    public int[] trovaTelefoniDiPersona(Persona proprietario) {
        // verifico che nell'array dei telefoni ce ne sia almeno uno
        // verifico che il proprietario sia diverso da null
        if (this.numeroTelefoni > 0 && proprietario != null) {
            int count1 = 0;
            int count2 = 0;
            // cerco le dimensioni giuste per l'array (= corrispondenti al numero di telefoni di quel determinato proprietario)
            for (int i = 0; i < this.numeroTelefoni; i ++) {
                if (this.telefoni[i].getProprietario().equals(proprietario)) {
                    count1 ++;
                }
            }
            // inizializzo il vettore con il numero di posizioni necessarie (verificate con il ciclo for)
            int[] vettoreIndici = new int[count1];

            // riempio il vettore con gli indici dei telefoni di quel determinato Proprietario
            for (int i = 0; i < this.numeroTelefoni; i ++) {
                if (this.telefoni[i].getProprietario().equals(proprietario)) {
                    vettoreIndici[count2] = i;
                    count2 ++;
                }
            }

            // se il proprietario non ha telefoni nel phone service, setto il vettore a null
            if (count1 == 0) {
                vettoreIndici = null;
            }

            return vettoreIndici;
        }
        else {
            return null;
        }
    }

    // stampare i dati di tutti i telefoni
    public void stampaDatiTelefoni() {
        // verifico che nell'array dei telefoni ce ne sia almeno uno
        if (this.numeroTelefoni == 0) {
            System.out.println("Questo phone service non ha telefoni registrati.");
        }
        else {
            System.out.println("Elenco e dati dei telefoni del phone service " + this.nome + ": ");
            for (int i = 0; i < numeroTelefoni; i ++) {
                System.out.println("[indice:" + i + "] " + this.telefoni[i].informazioni());
            }
        }
    }

    // modificare il proprietario di un telefono dato il suo indice
    // --> restituisce TRUE o FALSE (errore)
    public boolean modificaProprietarioTelefono(Persona nuovoProprietario, int indice) {
        if (indice >= 0 && indice < this.numeroTelefoni && nuovoProprietario != null) {
            // controllo di non aver modificato un telefono di lavoro
          return this.telefoni[indice].modificaProprietario(nuovoProprietario);
        }
        else {
            return false;
        }
    }

    // trova la memoria di un telefono dato l'indice
    // --> restituisce -1 in caso di indice non valido
    public int trovaMemoriaTelefono(int indice) {
        if (indice >= 0 && indice < this.numeroTelefoni) {
            return this.telefoni[indice].getMemoria();
        }
        else {
            return -1;
        }
    }

    // trovare la media della quantità di memoria dei telefoni gestiti dal service
    // --> restituisce -1 in caso di errore (nessun telefono registrato)
    public double mediaMemoriaTelefoni() {
        if (this.numeroTelefoni > 0) {
            double somma = 0;
            for (int i = 0; i < numeroTelefoni; i++) {
                somma += telefoni[i].getMemoria();
            }

            return somma / numeroTelefoni;
        }
        else {
            return -1;
        }
    }

    // trovare tutti i telefoni di una data marca
    // --> restituisce un array di Telefono[] OPPURE null in caso di errore
    public Telefono[] trovaTelefoniDiMarca(Produttore marca) {
        int count1 = 0;
        int count2 = 0;

        // verifico che ci sia almeno un telefono registrato
        // verifico che la marca non sia nulla
        if (this.numeroTelefoni > 0 && marca != null) {
            for (int i = 0; i < this.numeroTelefoni; i ++) {
                if (this.telefoni[i].getProduttore().equals(marca)) {
                    count1 ++;
                }
            }

            // inizializzo il vettore con la dimensione corretta (individuata nel ciclo for)
            Telefono[] telefoniMarca = new Telefono[count1];
            for (int i = 0; i < this.numeroTelefoni; i ++) {
                if (this.telefoni[i].getProduttore().equals(marca)) {
                    telefoniMarca[count2] = this.telefoni[i];
                    count2 ++;
                }
            }

            // se non ci sono telefoni di quella marca, l'array è nullo
            if (count1 == 0) {
                telefoniMarca = null;
            }

            return telefoniMarca;
        }
        else {
            return null;
        }
    }

    // trovare i telefoni che non hanno mai cambiato utilizzatore (unico proprietario), restituendo il vettore di tali telefoni
    // --> restituisce un array di Telefono[] OPPURE null in caso di errore
    public Telefono[] trovaTelefoniUnicoProprietario() {
        int count1 = 0;
        int count2 = 0;

        // verifico che ci sia almeno un telefono registrato
        // verifico che la marca non sia nulla
        if (this.numeroTelefoni > 0) {
            for (int i = 0; i < this.numeroTelefoni; i ++) {
                if (this.telefoni[i].getPassaggiProprieta() == 0) {
                    count1 ++;
                }
            }

            // inizializzo il vettore con la dimensione corretta (individuata nel ciclo for)
            Telefono[] telefoniProprietarioUnico = new Telefono[count1];

            for (int i = 0; i < this.numeroTelefoni; i ++) {
                if (this.telefoni[i].getPassaggiProprieta() == 0) {
                    telefoniProprietarioUnico[count2] = this.telefoni[i];
                    count2 ++;
                }
            }

            // se non ci sono telefoni di quella marca, l'array è nullo
            if (count1 == 0) {
                telefoniProprietarioUnico = null;
            }

            return telefoniProprietarioUnico;
        }
        else {
            return null;
        }
    }

    // trovare il telefono con memoria più PICCOLA
    // --> restituisce un Telefono oppure NULL in caso di errore (array vuoto)
    public Telefono memoriaMinore() {
        if(this.numeroTelefoni <= 0) {
            return null;
        }
        else {
            Telefono[] arrayOrdinato = this.ordinaTelefoniPerMemoria();
            return arrayOrdinato[0];
        }
    }

    // trovare il telefono con memoria più GRANDE
    // --> restituisce un Telefono oppure NULL in caso di errore (array vuoto)
    public Telefono memoriaMaggiore () {
        if(this.numeroTelefoni <= 0) {
            return null;
        }
        else {
            Telefono[] arrayOrdinato = this.ordinaTelefoniPerMemoria();
            return arrayOrdinato[this.numeroTelefoni - 1];
        }
    }


    // ordinare i telefoni in base alla memoria crescente (usando i metodi forniti dalla classe Arrays)
    public Telefono[] ordinaTelefoniPerMemoria() {
        Arrays.sort(this.telefoni);
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

