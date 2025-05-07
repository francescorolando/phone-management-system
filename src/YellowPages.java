import java.util.ArrayList;
import java.util.HashMap;

public class YellowPages {
    private int id;
    private static int conteggio = 0;
    private HashMap<String, PhoneService> elencoPhoneService;

    // COSTRUTTORE ------------------------------------------------------------------
    public YellowPages() {
        conteggio ++;
        this.id = conteggio;
        this.elencoPhoneService = new HashMap<String, PhoneService>();
    }

    // METODI ------------------------------------------------------------------------

    // aggiungere una città e il suo phone service
    // --> restituisce TRUE o FALSE (errore)
    public boolean inserisciPhoneService(String citta, PhoneService phoneService) {
        // CONTROLLA:
        // - che la città (chiave) non sia già presente nell'elenco
        // - che la stringa (città) inserita non sia vuota
        // - che il phoneService sia valido
        if (this.elencoPhoneService.containsKey(citta) || citta.isEmpty() || phoneService == null) {
            return false;
        }
        else {
            this.elencoPhoneService.put(citta, phoneService);
            return true;
        }
    }

    // trovare nome e indirizzo del phone service data la città
    public void infoPhoneService(String citta) {
        if (citta.isEmpty()) {
            System.out.println("La città che hai inserito è vuota!");
        }
        else if (this.elencoPhoneService.isEmpty()) {
            System.out.println("Questo elenco è vuoto!");
        }
        else if (!this.elencoPhoneService.containsKey(citta)) {
            System.out.println("Non esiste nessun Phone Service nella città che hai inserito!");
        }
        else {
            System.out.println("Informazioni sul phone service di " + citta + ":");
            System.out.println(
                    "Nome: " + this.elencoPhoneService.get(citta).getNome() +
                    ", Indirizzo: " + this.elencoPhoneService.get(citta).getIndirizzo()
            );
            System.out.println("------------------------------------------------");
        }
    }

    // elimina un phone service data la città
    // --> restituisce il PhoneService eliminato oppure NULL
    public PhoneService eliminaPhoneService(String citta) {
        if (citta.isEmpty() || this.elencoPhoneService.isEmpty() || !this.elencoPhoneService.containsKey(citta)) {
            return null;
        }
        else {
            return this.elencoPhoneService.remove(citta);
        }
    }

    // PRIMA VERSIONE:
    // elenca le città in cui è presente un phone service (IN GENERALE)
    // restituisce un'ArrayList di stringhe oppure NULL
    public ArrayList<String> elencoCittaRegistrate() {
        if (!this.elencoPhoneService.isEmpty()) {
            ArrayList<String> elenco = new ArrayList<>();
            for ( String citta : this.elencoPhoneService.keySet() ) {
                elenco.add(citta);
            }
            return elenco;
        }
        else {
            return null;
        }
    }

    // SECONDA VERSIONE:
    // elenca tutte le città in cui è presente un DETERMINATO phone service
    // restituisce un'ArrayList di stringhe oppure NULL
    public ArrayList<String> elencoCittaRegistrate(PhoneService ps) {
        if (!this.elencoPhoneService.isEmpty() && ps != null){
            ArrayList<String> elenco = new ArrayList<>();
            for ( String citta : this.elencoPhoneService.keySet() ) {
                if (this.elencoPhoneService.get(citta).equals(ps)) {
                    elenco.add(citta);
                }
            }

            // se l'elenco è vuoto restituisco NULL
            if (elenco.isEmpty()) {
                return null;
            }
            else {
                return elenco;
            }
        }
        else {
            return null;
        }
    }


    // GETTER E SETTER ---------------------------------------------------------------
    public HashMap<String, PhoneService> getElencoPhoneService() {
        return this.elencoPhoneService;
    }
}
