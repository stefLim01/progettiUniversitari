import java.util.*;
import java.sql.*;

public class progettoJDBC {
    public static void main(String[] args) {
        int query;
        System.out.println("inserire un' interrogazione : ");
        Scanner inputquery = new Scanner(System.in);
        query = inputquery.nextInt();
        switch (query) {
            case 1:
                progettoJDBC.registrazioneCliente();
                break;
            case 2:
                progettoJDBC.registrazioneStruttura();
                break;
            case 3:
                progettoJDBC.prenotazioneStruttura();
                break;
            case 4:
                progettoJDBC.assegnazioneTessera();
                break;
            case 5:
                progettoJDBC.strutturePerCitta();
                break;
            case 6:
                progettoJDBC.struttureDisponibili();
                break;
            case 7:
                progettoJDBC.prezzoStruttureDisponibili();
                break;
            case 11:
                progettoJDBC.distanzaPuntoDiInteresse();
            case 13:
                progettoJDBC.prenotazioni_ostelli_appartamenti();
        }
    }

    public static void registrazioneCliente() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/app_viaggi"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC";

            String usernome = "root";
            String pwd = "password";

            con = DriverManager.getConnection(url, usernome, pwd);
        } catch (Exception e) {
            System.out.println("connessione fallita!");
        }

        try {
            String query = "INSERT INTO `app_viaggi`.`cliente` " +
                    "(`nome`, `cognome`, `codiceFiscale`, `email`," +
                    " `dataNascita`, `telefono`," +
                    " `prenotazioniEffettuate`)" +
                    " VALUES ('giuseppe', 'verdi', 'GSPVRD01D10R717S'," +
                    " 'giuseppeverdi@gmail.com'," +
                    " '1980-03-24', '3558790998', '2');";

            Statement pquery = con.createStatement();
            ResultSet result = pquery.executeQuery(query);
            System.out.println("registrazione di un cliente : ");
            while (result.next()) {
                String nome = result.getString("nome");
                String cognome = result.getString("cognome");
                String codiceFiscale = result.getString("codiceFiscale");
                String email = result.getString("email");
                String dataNascita = result.getString("dataNacita");
                String telefono = result.getString("telefono");
                String prenotazioniEffettuate = result.getString("prenotazioniEffettuate");

                System.out.println(nome + "\t" + cognome + "\t" + codiceFiscale
                        + "\t" + email + "\t" + dataNascita + "\t" + telefono +
                        "\t" + prenotazioniEffettuate);
            }
        } catch (Exception e) {
            System.out.println("errore nell' interrogazione");
        }
    }

    public static void registrazioneStruttura() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/app_viaggi"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC";

            String usernome = "root";
            String pwd = "password";

            con = DriverManager.getConnection(url, usernome, pwd);
        } catch (Exception e) {
            System.out.println("connessione fallita!");
        }

        try {
            String query = "INSERT INTO `app_viaggi`.`struttura` " +
                    "(`nome`, `indirizzo`, `descrizioneServizi`, `annoIscrizione`, " +
                    "`telefono`, `tipo`, `prezzo`, `numeroOspiti`, `tipoStanza`)" +
                    " VALUES ('garden', 'via roma', 'wifi incluso', '2000'," +
                    " '0373698013', 'hotel', '100', '3', 'tripla');";

            Statement pquery = con.createStatement();
            ResultSet result = pquery.executeQuery(query);
            System.out.println("risultato registrazione struttura nel database agenzia_viaggi : ");
            while (result.next()) {
                String nome = result.getString("nome");
                String indirizzo = result.getString("indirizzo");
                String descrizioneServizi = result.getString("descrizioneServizi");
                String annoIscrizione = result.getString("annoIscrizione");
                String telefono = result.getString("telefono");
                String tipo = result.getString("tipo");
                String prezzo = result.getString("prezzo");
                String numeroOspiti = result.getString("numeroOspiti");
                String tipoStanza = result.getString("tipoStanza");

                System.out.println(nome + "\t" + indirizzo + "\t" + descrizioneServizi
                        + "\t" + annoIscrizione + "\t" + telefono + "\t" + tipo + "\t" + prezzo +
                        "\t" + numeroOspiti + "\t" + tipoStanza);
            }
        } catch (Exception e) {
            System.out.println("errore nell' interrogazione");
        }
    }

    public static void prenotazioneStruttura() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/app_viaggi"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC";

            String usernome = "root";
            String pwd = "password";

            con = DriverManager.getConnection(url, usernome, pwd);
        } catch (Exception e) {
            System.out.println("connessione fallita!");
        }

        try {
            String query = "INSERT INTO `app_viaggi`.`prenotazione` " +
                    "(`codicePrenotazione`, `checkIn`, `checkOut`," +
                    " `noteCliente`, `prezzoTotale`, `cliente`) VALUES " +
                    "('05459', '2018-03-23', '2018-04-02'," +
                    " 'camera singola', '100', 'paolo');";

            Statement pquery = con.createStatement();
            ResultSet result = pquery.executeQuery(query);
            System.out.println("prenotazione di una struttura ricettiva da parte di un cliente : ");
            while (result.next()) {
                String codicePrenotazione = result.getString("codicePrenotazione");
                String checkIn = result.getString("checkIn");
                String checkOut = result.getString("checkOut");
                String noteCliente = result.getString("noteCliente");
                String prezzoTotale = result.getString("prezzoTotale");
                String cliente = result.getString("cliente");

                System.out.println(codicePrenotazione + "\t" + checkIn + "\t" + checkOut
                        + "\t" + noteCliente + "\t" + prezzoTotale + "\t" + cliente + "\t");
            }
        } catch (Exception e) {
            System.out.println("errore nell' interrogazione");
        }
    }

    public static void assegnazioneTessera() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/app_viaggi"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC";

            String usernome = "root";
            String pwd = "password";

            con = DriverManager.getConnection(url, usernome, pwd);
        } catch (Exception e) {
            System.out.println("connessione fallita!");
        }

        try {
            String query = "INSERT INTO `app_viaggi`.`tessera` \n" +
                    "(`codiceCliente`, `periodoValidita`, `dataScadenza`,\n" +
                    "`tipo`, `sconto`, `nome_cliente`) VALUES \n" +
                    "('36754', '20', '2018-12-12', 'premium', '15', 'paolo');";

            Statement pquery = con.createStatement();
            ResultSet result = pquery.executeQuery(query);
            System.out.println("attribuzione ad un cliente di una tessera con fidelizzazione premium : ");
            while (result.next()) {
                String codiceCliente = result.getString("codiceCliente");
                String periodoValidita = result.getString("periodoValidita");
                String dataScadenza = result.getString("dataScadenza");
                String tipo = result.getString("tipo");
                String sconto = result.getString("sconto");
                String nome_cliente = result.getString("nome_cliente");

                System.out.println(codiceCliente + "\t" + periodoValidita + "\t" + dataScadenza
                        + "\t" + tipo + "\t" + sconto + "\t" + "\t" + nome_cliente);
            }
        } catch (Exception e) {
            System.out.println("errore nell' interrogazione");
        }
    }

    public static void strutturePerCitta(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/app_viaggi"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC";

            String usernome = "root";
            String pwd = "password";

            con = DriverManager.getConnection(url, usernome, pwd);
        } catch (Exception e) {
            System.out.println("connessione fallita!");
        }

        try {
            String query = "select nome, indirizzo\n" +
                    "from struttura natural join puntoInteresse\n" +
                    "where citta = 'roma';";

            Statement pquery = con.createStatement();
            ResultSet result = pquery.executeQuery(query);
            System.out.println("visualizzazione di tutte le strutture ricettive per citta' : ");
            while (result.next()) {
                String nome = result.getString("nome");
                String indirizzo = result.getString("indirizzo");

                System.out.println(nome + "\t" + indirizzo + "\t");
            }
        } catch (Exception e) {
            System.out.println("errore nell' interrogazione");
        }
    }

    public static void struttureDisponibili(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/app_viaggi"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC";

            String usernome = "root";
            String pwd = "password";

            con = DriverManager.getConnection(url, usernome, pwd);
        } catch (Exception e) {
            System.out.println("connessione fallita!");
        }

        try {
            String query = "select nome, indirizzo\n" +
                    "from struttura natural join prenotazione\n" +
                    "where (dataCheckIn >= '2018-01-01' and dataCheckOut <= '2020-12-12');\n";

            Statement pquery = con.createStatement();
            ResultSet result = pquery.executeQuery(query);
            System.out.println("visualizzazione di tutte le strutture disponibili" +
                    "in un periodo di tempo specificato : ");
            while (result.next()) {
                String nome = result.getString("nome");
                String indirizzo = result.getString("indirizzo");

                System.out.println(nome + "\t" + indirizzo + "\t");
            }
        } catch (Exception e) {
            System.out.println("errore nell' interrogazione");
        }
    }

    public static void prezzoStruttureDisponibili(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/app_viaggi"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC";

            String usernome = "root";
            String pwd = "password";

            con = DriverManager.getConnection(url, usernome, pwd);
        } catch (Exception e) {
            System.out.println("connessione fallita!");
        }

        try {
            String query = "select nome, indirizzo\n" +
                    "from struttura natural join prenotazione\n" +
                    "where ((dataCheckIn >= '2018-01-01' and dataCheckOut <= '2020-12-12') and" +
                    "prezzoTotale <= '50');\n";

            Statement pquery = con.createStatement();
            ResultSet result = pquery.executeQuery(query);
            System.out.println("visualizzazione di tutte le strutture ricettive disponibili" +
                    "in un periodo di tempo specificato il cui prezzo non superi i 50 euro a notte");
            while (result.next()) {
                String nome = result.getString("nome");
                String indirizzo = result.getString("indirizzo");

                System.out.println(nome + "\t" + indirizzo + "\t");
            }
        } catch (Exception e) {
            System.out.println("errore nell' interrogazione");
        }
    }

    public static void distanzaPuntoDiInteresse(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/app_viaggi"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC";

            String usernome = "root";
            String pwd = "password";

            con = DriverManager.getConnection(url, usernome, pwd);
        } catch (Exception e) {
            System.out.println("connessione fallita!");
        }

        try {
            String query = "select * \n" +
                    "from struttura natural join puntoInteresse\n" +
                    "where posizione = '10 km';";

            Statement pquery = con.createStatement();
            ResultSet result = pquery.executeQuery(query);
            System.out.println("stampa dei dati dei clienti che hanno prenotato solo" +
                    " appartamenti e ostelli : ");
            while (result.next()) {
                String nome = result.getString("nome");
                String indirizzo = result.getString("indirizzo");

                System.out.println(nome + "\t" + indirizzo + "\t");
            }
        } catch (Exception e) {
            System.out.println("errore nell' interrogazione");
        }
    }
    public static void prenotazioni_ostelli_appartamenti(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/app_viaggi"
                    + "?useUnicode=true&useJDBCCompliantTimezoneShift=true"
                    + "&useLegacyDatetimeCode=false&serverTimezone=UTC";

            String usernome = "root";
            String pwd = "password";

            con = DriverManager.getConnection(url, usernome, pwd);
        } catch (Exception e) {
            System.out.println("connessione fallita!");
        }

        try {
            String query = "select * from cliente \n" +
                    "natural join prenotazione \n" +
                    "where tipo_struttura = ostello or appartamento;";

            Statement pquery = con.createStatement();
            ResultSet result = pquery.executeQuery(query);
            System.out.println("visualizzazione del numero di prenotazioni effettutate " +
                    "da tutti i clienti nell' ultimo mese : ");
            while (result.next()) {
                String nome = result.getString("nome");
                String cognome = result.getString("cognome");
                String codiceFiscale = result.getString("codiceFiscale");
                String email = result.getString("email");
                String dataNascita = result.getString("dataNascita");
                String telefono = result.getString("telefono");
                String prenotazioniEffettuate = result.getString("prenotazioniEffettute");

                System.out.println(nome + "\t" + cognome + "\t" + codiceFiscale + "\t" + email +
                    "\t" + dataNascita + "\t" + telefono + "\t" + prenotazioniEffettuate);
            }
        } catch (Exception e) {
            System.out.println("errore nell' interrogazione");
        }
    }
}

