Descrizione del progetto - Gestione di prenotazioni di strutture ricettive online
Progetto: Applicazione per la gestione delle prenotazioni di strutture ricettive
Tecnologie utilizzate: Java, JDBC, SQL, Database relazionale, Schema ER

Il progetto riguarda lo sviluppo di un'applicazione web per la gestione delle prenotazioni di strutture ricettive.
L'applicazione permette la gestione di prenotazioni, clienti, strutture e agenzie di viaggio,
con funzionalità per l'analisi e la gestione dei dati.

Caratteristiche principali:

Prenotazioni: Gestione delle prenotazioni con calcolo automatico dei costi basati su durata del soggiorno, tipo di struttura e tessera fedeltà (standard o premium).
Gestione delle strutture ricettive: Supporto per oltre 5000 strutture, con visualizzazione delle strutture in base alla distanza da punti di interesse (entro 100 km).
Fidelizzazione clienti: Sistema di tessere fedeltà che permette ai clienti premium di ottenere sconti sulle prenotazioni.
Integrazione con agenzie di viaggio: Le prenotazioni possono essere effettuate tramite 10 diverse agenzie registrate sulla piattaforma.
Report: Generazione di report giornalieri e mensili, tra cui il numero di prenotazioni mensili, i migliori clienti premium e le strutture meno prenotate.


Aspetti tecnici:

Schema ER e mapping relazionale:
Il progetto è basato su uno schema entità-relazioni che include le entità Cliente, Prenotazione, Struttura, Agenzia, Tessera e Punti di Interesse, con relazioni come "Gestione", "Esecuzione" e "Categorizzazione".
Lo schema ER è stato ristrutturato per eliminare gerarchie e attributi multivalore
Integrazione con database SQL e script in Java:
sviluppo di script SQL per la creazione e il popolamento delle tabelle e integrazione con JDBC per interrogare il database tramite query.
