drop database if exists bookdb;
create database bookdb;

use bookdb;

drop table if exists books;

CREATE TABLE books(
id INT(20) AUTO_INCREMENT primary key,
`year` VARCHAR(255),
book_name VARCHAR(255),
author VARCHAR(255),
num_pages VARCHAR(20),
theme VARCHAR (20),
price VARCHAR (20),
rating varchar (20),
picture varchar(256) DEFAULT NULL

        );
        
INSERT INTO books VALUES (1, "1997", "Harry Potter & The Philosophers Stone", "JK ROWLING", "233", "Magic", "$40", "5", "tps.JPG");
INSERT INTO books VALUES (2, "1998", "Harry Potter & The Chamber of Secrets", "JK ROWLING", "251", "Magic", "$50", "5", "tcos.JPG");
INSERT INTO books VALUES (3, "1999", "Harry Potter & The Prisoner of Azkaban", "JK ROWLING", "317", "Magic", "$30", "5", "tpoa.JPG");
INSERT INTO books VALUES (4, "2000", "Harry Potter & The Goblet of Fire", "JK ROWLING", "636", "Magic", "$40", "5", "tgof.JPG");
INSERT INTO books VALUES (null, "2003", "Harry Potter & The Order of the Phoenix", "JK ROWLING", "766", "Magic", "$20", "5", "tootp.JPG");
INSERT INTO books VALUES (null, "2005", "Harry Potter & The Half Blood Prince", "JK ROWLING", "607", "Magic", "$20", "5", "hbp.JPG");
INSERT INTO books VALUES (null, "2007", "Harry Potter & The Deathly Hallows", "JK ROWLING", "607", "Magic", "$20", "5", "tdh.JPG");
INSERT INTO books VALUES (null, "2016", "The Secret History of Twin Peaks", "Mark Frost", "300", "Mystery", "$36", "5", "twinpeaks.JPG");
INSERT INTO books VALUES (null, "1991", "American Psycho", "Bret Easton Ellis", "500", "Horror", "$20", "5", "ap.JPG");


SELECT * FROM	 books;
	