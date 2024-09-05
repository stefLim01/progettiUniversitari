CREATE SCHEMA applicazione_viaggi;
USE applicazione_viaggi;

CREATE TABLE `agenzia` (
  `nome` varchar(20) NOT NULL,
  PRIMARY KEY (`nome`)
);

CREATE TABLE `categorizzazione` (
  `puntoInteresse` varchar(20) NOT NULL,
  `struttura` varchar(30) NOT NULL,
  PRIMARY KEY (`puntoInteresse`,`struttura`),
  KEY `puntoInteresse_idx` (`puntoInteresse`),
  KEY `struttura_idx` (`struttura`),
  CONSTRAINT `punto` FOREIGN KEY (`puntoInteresse`) REFERENCES `puntoInteresse` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `strutturaNome` FOREIGN KEY (`struttura`) REFERENCES `struttura` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `cliente` (
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `codiceFiscale` varchar(20) NOT NULL,
  `dataNascita` date NOT NULL,
  `email` varchar(30) NOT NULL,
  `telefono` int NOT NULL,
  `prenotazioniEffettuate` int NOT NULL,
  PRIMARY KEY (`nome`,`cognome`,`codiceFiscale`)
);

CREATE TABLE `prenotazione` (
  `codicePrenotazione` int NOT NULL,
  `dataCheckIn` date NOT NULL,
  `dataCheckOut` date NOT NULL,
  `noteClinete` text NOT NULL,
  `prezzoTotale` int NOT NULL,
  `cliente` varchar(20) NOT NULL,
  PRIMARY KEY (`codicePrenotazione`),
  KEY `cliente_idx` (`cliente`),
  CONSTRAINT `cliente` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `puntoInteresse` (
  `nome` varchar(20) NOT NULL,
  `citta'` varchar(20) NOT NULL,
  `tipoPunto` varchar(30) NOT NULL,
  `posizione` int NOT NULL,
  PRIMARY KEY (`nome`,`citta'`)
);

CREATE TABLE `riferimentoHotel` (
  `ospiti` int NOT NULL,
  `prenotazione` int NOT NULL,
  `struttura` varchar(30) NOT NULL,
  PRIMARY KEY (`ospiti`),
  KEY `prenotazione_idx` (`prenotazione`),
  KEY `struttura_idx` (`struttura`),
  CONSTRAINT `prenotazione` FOREIGN KEY (`prenotazione`) REFERENCES `prenotazione` (`codicePrenotazione`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `sitoWeb` (
  `nome` varchar(20) NOT NULL,
  `agenzia` varchar(20) NOT NULL,
  PRIMARY KEY (`nome`),
  KEY `agenzia_idx` (`agenzia`),
  CONSTRAINT `agenzia` FOREIGN KEY (`agenzia`) REFERENCES `agenzia` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `stanza` (
  `tipoStanza` varchar(20) NOT NULL,
  `strutturaHotel` varchar(30) NOT NULL,
  PRIMARY KEY (`strutturaHotel`,`tipoStanza`),
  CONSTRAINT `strutturaHotel` FOREIGN KEY (`strutturaHotel`) REFERENCES `struttura` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `struttura` (
  `nome` varchar(30) NOT NULL,
  `indirizzo` varchar(30) NOT NULL,
  `annoIscrizione` year NOT NULL,
  `descrizioneServizi` mediumtext NOT NULL,
  `tipoStruttura` varchar(15) NOT NULL,
  `prezzo` int NOT NULL,
  `dimensioni` int DEFAULT NULL,
  PRIMARY KEY (`nome`,`indirizzo`)
);

CREATE TABLE `telefono` (
  `numero` int NOT NULL,
  `struttura` varchar(30) NOT NULL,
  PRIMARY KEY (`numero`),
  KEY `struttura_idx` (`struttura`),
  CONSTRAINT `struttura` FOREIGN KEY (`struttura`) REFERENCES `struttura` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE `tessera` (
  `codiceCliente` int NOT NULL,
  `periodoValidita'` int NOT NULL,
  `dataScadenza` date NOT NULL,
  `tipoTessera` varchar(10) NOT NULL,
  `sconto` int DEFAULT NULL,
  `nomeCliente` varchar(20) NOT NULL,
  PRIMARY KEY (`codiceCliente`),
  KEY `Nomecliente_idx` (`codiceCliente`),
  KEY `cliente_idx` (`nomeCliente`),
  CONSTRAINT `nomeCliente` FOREIGN KEY (`nomeCliente`) REFERENCES `cliente` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE
);

USE applicazione_viaggi;

INSERT INTO `cliente` VALUES ('luca ','verdi','LUCVRD70M1IE482T','1980-05-11','lucaverdi@gmail.com',35674522,7),
('mario','rossi','MRORSI01D10E928S','1990-12-12','mariorossi@gmail.com',333546432,3),
('paolo','neri','POLNRI42E87T969E','1980-03-06','paoloneri@gmail.com',344552211,2);

INSERT INTO `prenotazione` VALUES (24554,'2019-05-08','2019-09-10','wifi incluso',200,'paolo'),
(32114,'2015-06-08','2015-09-08','camera singola',150,'mario'),
(14236,'2016-03-23','2017-04-12','vista mare',100,'luca');

INSERT INTO `agenzia` VALUES ('booking'),
('tripadvisor'),
('trivago');

INSERT INTO `puntoInteresse` VALUES ('colosseo','roma','monumento storico',10),
('duomo','milano','monumento storico',5),
('Torre di pisa','pisa','monumento storico',20);

INSERT INTO `sitoWeb` VALUES ('www.booking.com','booking'),
('www.tripadvisor.com','tripadvisor'),
('www.triavago.com','trivago');

INSERT INTO `struttura` VALUES ('Eden','via salaria',2000,'vista mare','appartamento',150,NULL),
('Europa','via roma',1990,'extralusso','hotel',200,NULL),
('Garden','via appia ',1995,'wifi incluso','ostello',70,NULL);

INSERT INTO `telefono` VALUES (542391231,'eden'),
(134265378,'europa'),
(1650875622,'garden');

INSERT INTO `tessera` VALUES (23441,10,'2019-07-08','premium',20,'mario'),
(87798,15,'2018-07-02','stadard',NULL,'paolo');

INSERT INTO `stanza` VALUES ('doppia','europa'),
('singola','europa'),
('tripla','europa');

INSERT INTO `riferimentoHotel` VALUES (2,24554,'garden'),
(3,32114,'europa');

INSERT INTO `categorizzazione` VALUES ('colosseo','europa'),
('duomo','eden'),
('torre di pisa','garden');


