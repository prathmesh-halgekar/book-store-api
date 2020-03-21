DROP TABLE IF EXISTS BOOK;
CREATE TABLE BOOK (
  ID VARCHAR(10) NOT NULL PRIMARY KEY,
  NAME VARCHAR(250) NOT NULL,
  DETAILS VARCHAR(250),
  PRICE DECIMAL(20,3) DEFAULT NULL,
  IMAGE VARCHAR(250)
);

DROP TABLE IF EXISTS USER;
CREATE TABLE USER (
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  NAME VARCHAR(250) NOT NULL,
  USERNAME VARCHAR(250) NOT NULL,
  PASSWORD VARCHAR(250) NOT NULL,
  IS_ACTIVE BOOLEAN NOT NULL,
  IMAGE VARCHAR(250)
);

DROP TABLE IF EXISTS BOOK_VIEW;
CREATE TABLE BOOK_VIEW (
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  BOOK_ID VARCHAR(10) NOT NULL,
  USERNAME VARCHAR(250) NOT NULL,
  CONSTRAINT FK_BOOK_VIEW_BOOK FOREIGN KEY (BOOK_ID) references BOOK(ID),
  CONSTRAINT FK_BOOK_VIEW_USER FOREIGN KEY (USERNAME) references USER(USERNAME)
);

INSERT INTO BOOK (ID, NAME, DETAILS, PRICE, IMAGE) VALUES
  ('b1', 'Textbook A:  Unit testing basic principles', 'lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum', 75.234, 'https://bilder.buecher.de/produkte/42/42530/42530510z.jpg'),
  ('b2', 'Textbook B:  Machine learning fundamentals', 'lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum', 23.34, 'https://bilder.buecher.de/produkte/48/48193/48193654z.jpg'),
  ('b3', 'Textbook C:  Domain driven design', 'lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum', 120, 'https://bilder.buecher.de/produkte/49/49065/49065197z.jpg');
  
INSERT INTO USER (NAME, USERNAME, PASSWORD, IS_ACTIVE) VALUES
	('test1','test1@check24.de','123',TRUE),
	('test2','test2@check24.de','123',TRUE),
	('test3','test3@check24.de','123',TRUE); 
	
INSERT INTO BOOK_VIEW (BOOK_ID, USERNAME) VALUES
	('b1','test1@check24.de'),
	('b2','test1@check24.de'),
	('b1','test2@check24.de'),
	('b2','test2@check24.de'),
	('b3','test2@check24.de'),
	('b3','test3@check24.de'); 
  