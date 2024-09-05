CREATE SCHEMA `app_viaggi` ;
USE `app_viaggi`;

CREATE TABLE `agenzia` (
  `nome` varchar(20) NOT NULL,
  `sitoWeb` varchar(30) NOT NULL,
  PRIMARY KEY (`nome`)
);

INSERT INTO `app_viaggi`.`agenzia` (`nome`, `sitoWeb`) VALUES ('Booking', 'www.booking.com');
INSERT INTO `app_viaggi`.`agenzia` (`nome`, `sitoWeb`) VALUES ('TripAdvisor', 'www.tripadvisor.com');
INSERT INTO `app_viaggi`.`agenzia` (`nome`, `sitoWeb`) VALUES ('Trivago', 'www.trivago.com');


CREATE TABLE `cliente` (
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `codiceFiscale` char(16) NOT NULL,
  `email` varchar(30) NOT NULL,
  `dataNascita` date NOT NULL,
  `telefono` bigint NOT NULL,
  `prenotazioniEffettuate` int NOT NULL,
  PRIMARY KEY (`nome`,`cognome`,`codiceFiscale`)
);

INSERT INTO `cliente` VALUES ('giuseppe','verdi','GSPVDI01D10E414S','giuseppeverdi@gmail.com','1985-12-11',3669809765,2),
('mario','rossi','MRORSI01D10E919D','mariorossi@gmail.com','1990-12-12',3145648779,2),
('paolo','neri','PLONRI01D10E919N','paoloneri@gmail.com','1980-05-09',3297856443,1);

CREATE TABLE `prenotazione` (
  `codicePrenotazione` int NOT NULL,
  `checkIn` date NOT NULL,
  `checkOut` date NOT NULL,
  `noteCliente` text NOT NULL,
  `prezzoTotale` int NOT NULL,
  `cliente` varchar(20) NOT NULL,
  PRIMARY KEY (`codicePrenotazione`),
  KEY `cliente_idx` (`cliente`),
  CONSTRAINT `cliente` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO `prenotazione` VALUES (2357,'2020-07-07','2020-08-06','centro citta',80,'giuseppe'),
(3924,'2019-06-08','2019-07-09','vista mare',120,'mario'),
(5953,'2018-03-23','2018-04-03','wifi incluso',150,'paolo');

CREATE TABLE `puntoInteresse` (
  `nome` varchar(20) NOT NULL,
  `citta` varchar(20) NOT NULL,
  `tipoPunto` varchar(20) NOT NULL,
  `posizione` varchar(20) NOT NULL,
  PRIMARY KEY (`nome`,`citta`)
);

INSERT INTO `puntoInteresse` VALUES ('colosseo','roma','monumento storico','10 km '),
('duomo di milano','milano','monumento storico','20 km'),
('torre di pisa','pisa','monumento storico','10 km');

CREATE TABLE `struttura` (
  `nome` varchar(20) NOT NULL,
  `indirizzo` varchar(20) NOT NULL,
  `descrizioneServizi` text NOT NULL,
  `annoIscrizione` int NOT NULL,
  `telefono` bigint NOT NULL,
  `tipo` varchar(15) NOT NULL,
  `prezzo` int NOT NULL,
  `numeroOspiti` int DEFAULT NULL,
  `tipoStanza` varchar(15) DEFAULT NULL,
  `vani` int DEFAULT NULL,
  `metri_quadri` int DEFAULT NULL,
  `cliente` varchar(20) NOT NULL,
  PRIMARY KEY (`nome`,`indirizzo`),
  KEY `cliente_idx` (`cliente`)
);

INSERT INTO `struttura` VALUES ('eden','via venezia','centro citta',2002,439685743,'ostello',80,NULL,NULL,NULL,NULL,''),
('europa','via napoli','vista mare',2003,139848012,'appartamento',150,NULL,NULL,5,100,''),
('garden','via roma','wifi incluso',2000,549240277,'hotel',120,3,'tripla',NULL,NULL,'');

CREATE TABLE `tessera` (
  `codiceCliente` int NOT NULL,
  `periodoValidita` int NOT NULL,
  `dataScadenza` date NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `sconto` int DEFAULT NULL,
  `nome_cliente` varchar(20) NOT NULL,
  PRIMARY KEY (`codiceCliente`),
  KEY `cliente_idx` (`nome_cliente`),
  KEY `nomeCliente_idx` (`codiceCliente`),
  CONSTRAINT `nome_cliente` FOREIGN KEY (`nome_cliente`) REFERENCES `cliente` (`nome`) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO `tessera` VALUES (23421,15,'2019-07-09','premium',20,'mario'),
(36754,20,'2018-12-12','premium',15,'paolo');
