public class Main {
    public static void main(String[] args) {

        // creo le persone
        Persona persona1 = new Persona("Rossi", "Piazza Castello");
        Persona persona2 = new Persona("Bianchi", "Via Roma");
        Persona persona3 = new Persona("Ferrari", "Viale Piave");
        Persona persona4 = new Persona("Colombo", "Via De Gasperi");
        Persona persona5 = new Persona("Verdi", "Via Torino");

        // creo le case produttrici
        Produttore produttore1 = new Produttore("Samsung", "Corea del Sud");
        Produttore produttore2 = new Produttore("Apple", "USA");
        Produttore produttore3 = new Produttore("Nokia", "Finlandia");
        Produttore produttore4 = new Produttore("Huawei", "Cina");

        // creo i telefoni, i tablet e i telefoni di lavoro
        Telefono telefono1 = new Telefono(produttore1, 128, 899, persona1);
        Telefono telefono2 = new Telefono(produttore3, 256, 450, persona2);
        Telefono telefono3 = new Telefono(produttore3, 128, 550, persona2);
        Tablet tablet1 = new Tablet(produttore2, 128, 1200, persona1, "bluetooth", 120);
        Tablet tablet2 = new Tablet(produttore1, 64, 600, persona3, "wireless", 80);
        TelefonoLavoro telefonoLavoro1 = new TelefonoLavoro(produttore4, 256, 500, persona1, "Wind");
        TelefonoLavoro telefonoLavoro2 = new TelefonoLavoro(produttore2, 128, 700, persona4, "Tim");

        System.out.println(System.lineSeparator());
        System.out.println("------ Stampo le informazioni dei dispositivi ------");
        System.out.println(telefono1.informazioni());
        System.out.println(telefono2.informazioni());
        System.out.println(telefono3.informazioni());
        System.out.println(tablet1.informazioni());
        System.out.println(tablet2.informazioni());
        System.out.println(telefonoLavoro1.informazioni());
        System.out.println(telefonoLavoro2.informazioni());


        // creo un'istanza di PhoneServiceList
        PhoneServiceList ps1 = new PhoneServiceList(persona4, "Vodafone Store", "Piazza Castello");

        // creo un'istanza di PhoneServiceList che rimarrà VUOTA
        PhoneServiceList ps2 = new PhoneServiceList(persona3, "Negozio Centro", "Via Torino");


        System.out.println(System.lineSeparator());
        System.out.println("------ Inserisco i dispositivi dentro l'array (restituisce indici) ------");
        System.out.println(ps1.aggiungiTelefono(telefono1));
        System.out.println(ps1.aggiungiTelefono(telefono2));
        System.out.println(ps1.aggiungiTelefono(tablet1));
        System.out.println(ps1.aggiungiTelefono(tablet2));
        System.out.println(ps1.aggiungiTelefono(telefonoLavoro1));
        System.out.println(ps1.aggiungiTelefono(telefonoLavoro2));


        System.out.println(System.lineSeparator());
        System.out.println("------ Stampo i dati di ognuno dei telefoni dell'array ------");
        System.out.println("------ ps1 -------");
        ps1.stampaDatiTelefoni();
        System.out.println("------ ps2 -------");
        // array vuoto (nessun telefono registrato)
        ps2.stampaDatiTelefoni();


        System.out.println(System.lineSeparator());
        System.out.println("------ Aggiungo telefono3 all'array ------");
        System.out.println(ps1.aggiungiTelefono(telefono3));
        System.out.println("------ (a) Rimuovo telefono2 dall'array & (b) Genero un errore (indice inesistente) ------");
        System.out.println(ps1.rimuoviTelefono(1));
        System.out.println(ps1.rimuoviTelefono(300));
        System.out.println("------ Stampo i dati di ognuno dei telefoni dell'array ------");
        ps1.stampaDatiTelefoni();


        System.out.println(System.lineSeparator());
        System.out.println("------ Trovo i telefoni di alcune persone (INDICI) ------");
        System.out.println(ps1.trovaTelefoniDiPersona(persona1));
        System.out.println(ps1.trovaTelefoniDiPersona(persona2));
        System.out.println(ps1.trovaTelefoniDiPersona(persona3));
        System.out.println(ps1.trovaTelefoniDiPersona(persona4));
        // persona senza telefoni nel phone service "ps1"
        System.out.println(ps1.trovaTelefoniDiPersona(persona5));
        // array senza telefoni (ps2)
        System.out.println(ps2.trovaTelefoniDiPersona(persona1));


        System.out.println(System.lineSeparator());
        System.out.println("------ Visualizzo il proprietario di un telefono dato l'indice ------");
        System.out.println(ps1.trovaProprietarioTelefono(0).getCognome());


        System.out.println(System.lineSeparator());
        System.out.println("------ Ordina i telefoni per memoria ------");
        System.out.println(ps1.ordinaTelefoniPerMemoria());
        ps1.stampaDatiTelefoni();

        System.out.println(System.lineSeparator());
        System.out.println("------ Telefono con la memoria più grande ------");
        System.out.println(ps1.memoriaMaggiore().informazioni());

        System.out.println(System.lineSeparator());
        System.out.println("------ Telefono con la memoria più piccola ------");
        System.out.println(ps1.memoriaMinore().informazioni());

        System.out.println(System.lineSeparator());
        System.out.println("------ Modifico il proprietario di telefono dato l'indice (telefono di lavoro) ------");
        System.out.println(ps1.modificaProprietarioTelefono(persona3, 3));
        System.out.println(telefonoLavoro2.informazioni());
        System.out.println("------ Modifico il proprietario di un altro telefono dato l'indice ------");
        System.out.println(ps1.modificaProprietarioTelefono(persona3, 2));
        System.out.println(tablet1.informazioni());

        System.out.println(System.lineSeparator());
        System.out.println("------ Trovo la memoria di un telefono dato l'indice ------");
        System.out.println(ps1.trovaMemoriaTelefono(3));

        System.out.println(System.lineSeparator());
        System.out.println("------ Trovo la media della quantità di memoria dei telefoni gestiti dal service ------");
        System.out.println(ps1.mediaMemoriaTelefoni());

        System.out.println(System.lineSeparator());
        System.out.println("------ Tutti i telefoni di una determinata marca ------");
        System.out.println(ps1.trovaTelefoniDiMarca(produttore1));
        System.out.println(ps1.trovaTelefoniDiMarca(produttore2));
        System.out.println(ps1.trovaTelefoniDiMarca(produttore3));
        System.out.println(ps1.trovaTelefoniDiMarca(produttore4));

        System.out.println(System.lineSeparator());
        System.out.println("------ Tutti i telefoni con unico proprietario ------");
        System.out.println(ps1.trovaTelefoniUnicoProprietario());
        // nessun telefono registrato in ps2
        System.out.println(ps2.trovaTelefoniUnicoProprietario());


        // creo un'istanza di YellowPages
        YellowPages yellowPages = new YellowPages();

        // creo un'istanza di YellowPages che rimarrà VUOTA
        YellowPages yellowPages2 = new YellowPages();

        // creo alcuni PhoneService
        PhoneService ps3 = new PhoneService(persona1, "TIM Store", "Lungo Dora Siena", 10);
        PhoneService ps4 = new PhoneService(persona2, "Wind Mobile", "Piazzale Maggio", 10);
        PhoneService ps5 = new PhoneService(persona5, "Casa del Telefono", "Piazza Contessa", 10);
        PhoneService ps6 = new PhoneService(persona2, "Apple Store", "Via Napoli", 10);
        PhoneService ps7 = new PhoneService(persona1, "Store Viale Milano", "Viale Milano", 10);

        System.out.println(System.lineSeparator());
        System.out.println("------ Inserisco le città e i phone service ------");
        System.out.println(yellowPages.inserisciPhoneService("Torino", ps3));
        System.out.println(yellowPages.inserisciPhoneService("Milano", ps4));
        System.out.println(yellowPages.inserisciPhoneService("Roma", ps3));
        System.out.println(yellowPages.inserisciPhoneService("Napoli", ps6));
        System.out.println(yellowPages.inserisciPhoneService("Biella", ps3));
        System.out.println(yellowPages.inserisciPhoneService("Venezia", ps3));
        System.out.println(yellowPages.inserisciPhoneService("Firenze", ps7));
        System.out.println("------ Inserisco le città e i phone service (città già registrata) ------");
        System.out.println(yellowPages.inserisciPhoneService("Torino", ps5));

        System.out.println(System.lineSeparator());
        System.out.println("------ Stampo i dati di alcuni PhoneService data la città (e alcuni errori) ------");
        yellowPages.infoPhoneService("Torino");
        yellowPages.infoPhoneService("Milano");
        yellowPages.infoPhoneService("Biella");
        // città vuota
        yellowPages.infoPhoneService("");
        // YellowPages vuoto
        yellowPages2.infoPhoneService("Biella");
        // città non registrata
        yellowPages.infoPhoneService("Cagliari");

        System.out.println(System.lineSeparator());
        System.out.println("------ Elimino alcuni PhoneService data la città (genero alcuni errori) ------");
        System.out.println(yellowPages.eliminaPhoneService("Venezia"));
        System.out.println(yellowPages.eliminaPhoneService("Firenze"));
        // città vuota
        System.out.println(yellowPages.eliminaPhoneService(""));
        // YellowPages vuoto
        System.out.println(yellowPages2.eliminaPhoneService("Biella"));
        // città non registrata
        System.out.println(yellowPages.eliminaPhoneService("Cagliari"));

        System.out.println(System.lineSeparator());
        System.out.println("------ Elenco delle città in cui è presente un PhoneService ------");
        System.out.println(yellowPages.elencoCittaRegistrate());

        System.out.println(System.lineSeparator());
        System.out.println("------ Elenco delle città in cui è presente un determinato PhoneService (genero alcuni errori) ------");
        System.out.println(yellowPages.elencoCittaRegistrate(ps3));
        System.out.println(yellowPages.elencoCittaRegistrate(ps4));
        System.out.println(yellowPages.elencoCittaRegistrate(ps5)); // nessuna città
        System.out.println(yellowPages.elencoCittaRegistrate(ps6));
        System.out.println(yellowPages.elencoCittaRegistrate(ps7)); // nessuna città
        System.out.println(yellowPages.elencoCittaRegistrate(null)); // phoneservice nullo
        System.out.println(yellowPages2.elencoCittaRegistrate(ps3)); // YellowPages vuoto



    }
}