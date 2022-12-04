BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

DROP TABLE IF EXISTS book_genre, book_author, book, tag, book_tag, author, genre, publisher,book_language, book_publisher CASCADE;
DROP SEQUENCE IF EXISTS genre_serial, author_serial, tag_serial, publisher_serial, language_serial;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE genre_serial;
CREATE TABLE genre (
    genre_id INT NOT NULL DEFAULT nextval('genre_serial'),
    genre_name varchar(50) NOT NULL,
	CONSTRAINT PK_genre PRIMARY KEY(genre_id)
);

CREATE SEQUENCE author_serial;
CREATE TABLE author (
    author_id INT NOT NULL DEFAULT nextval('author_serial'),
    author_name varchar(200) NOT NULL,
	CONSTRAINT PK_author PRIMARY KEY(author_id)
);

CREATE SEQUENCE tag_serial;
CREATE TABLE tag (
    tag_id INT NOT NULL DEFAULT nextval('tag_serial'),
    tag_word varchar(200) NOT NULL,
    CONSTRAINT PK_tag PRIMARY KEY(tag_id)
);

CREATE SEQUENCE publisher_serial;
CREATE TABLE publisher (
  publisher_id INT NOT NULL DEFAULT nextval('publisher_serial'),
  publisher_name VARCHAR(400),
  CONSTRAINT pk_publisher PRIMARY KEY (publisher_id)
);


CREATE SEQUENCE language_serial;
CREATE TABLE book_language (
    language_id INT NOT NULL DEFAULT nextval('language_serial'),
    language_name VARCHAR(50),
    CONSTRAINT pk_language PRIMARY KEY (language_id)
);



CREATE TABLE book (
    isbn13 BIGINT NOT NULL,
    title varchar(200) NOT NULL,
    pub_date date NULL,
    num_pages INT,
	language_id INT,
	overview text NULL,
    CoverLink varchar(500) NULL,
	CONSTRAINT PK_book PRIMARY KEY(isbn13)
);

CREATE TABLE book_tag (
	isbn13 BIGINT NOT NULL,
	tag_id INT,
    CONSTRAINT PK_book_tag PRIMARY KEY(isbn13)
);

CREATE TABLE book_publisher (
	isbn13 BIGINT NOT NULL,
  	publisher_id INT,
  CONSTRAINT pk_book_publisher PRIMARY KEY (isbn13)
);

CREATE TABLE book_author (
    isbn13 BIGINT NOT NULL,
    author_id INT NOT NULL,
	CONSTRAINT PK_book_author PRIMARY KEY(isbn13, author_id),
    CONSTRAINT FK_book_author_book FOREIGN KEY(isbn13) REFERENCES book(isbn13),
    CONSTRAINT FK_book_author_author FOREIGN KEY(author_id) REFERENCES author(author_id)
);

CREATE TABLE book_genre (
    isbn13 BIGINT NOT NULL,
    genre_id INT NOT NULL,
	CONSTRAINT PK_book_genre PRIMARY KEY(isbn13, genre_id),
    CONSTRAINT FK_book_genre_book FOREIGN KEY(isbn13) REFERENCES book(isbn13),
    CONSTRAINT FK_book_genre_genre FOREIGN KEY(genre_id) REFERENCES genre(genre_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO author(author_name) VALUES ('Tolkien');
INSERT INTO author(author_name) VALUES ('Marquez');

INSERT INTO book (isbn13, title, pub_date, num_pages, language_id, overview ,CoverLink)
VALUES (9780063270886, 'The Fellowship of the Ring','07/05/2022','432', 1, 'J.R.R. Tolkien’s classic fantasy has accumulated worldwide acclaim as the greatest adventure tale ever written. No other writer has created a world as distinct as Middle-earth, complete with its own geography, history, languages, and legends. And no one has created characters as endearing as Tolkien’s large-hearted, hairy-footed hobbits.',
		'https://prodimage.images-bn.com/lf?set=key%5Bresolve.pixelRatio%5D,value%5B1%5D&set=key%5Bresolve.width%5D,value%5B600%5D&set=key%5Bresolve.height%5D,value%5B10000%5D&set=key%5Bresolve.imageFit%5D,value%5Bcontainerwidth%5D&set=key%5Bresolve.allowImageUpscaling%5D,value%5B0%5D&set=key%5Bresolve.format%5D,value%5Bwebp%5D&source=url%5Bhttps://prodimage.images-bn.com/pimages/9780063270886_p0_v2_s600x595.jpg%5D&scale=options%5Blimit%5D,size%5B600x10000%5D&sink=format%5Bwebp%5D'),
		(9780063227262, 'Sira','09/13/2022','736', 3, 'Cuatro ciudades, dos misiones, una mujer. Vuelve a sumergirte en un tiempo inolvidable. Después de El tiempo entre costuras, SIRA, la nueva novela de María Dueñas.',
		 'https://prodimage.images-bn.com/pimages/9780063227262_p0_v2_s600x595.jpg'),
		(9781728281414, 'The Sun and Its Shade','02/28/2023', '544', 1, 'The novella features Zaccai, one of the Northern fae, and his complicated relationship with a mortal and another fae as the three train for the coming war with the queen. Exploring issues of identity, sexuality, power, and loyalty, Piper CJ brings strong writing and rich characters to expand her THE NIGHT AND ITS MOON world even further.',
		 'https://prodimage.images-bn.com/lf?set=key%5Bresolve.pixelRatio%5D,value%5B1%5D&set=key%5Bresolve.width%5D,value%5B300%5D&set=key%5Bresolve.height%5D,value%5B10000%5D&set=key%5Bresolve.imageFit%5D,value%5Bcontainerwidth%5D&set=key%5Bresolve.allowImageUpscaling%5D,value%5B0%5D&set=key%5Bresolve.format%5D,value%5Bwebp%5D&source=url%5Bhttps://prodimage.images-bn.com/pimages/9781728281414_p0_v1_s600x595.jpg%5D&scale=options%5Blimit%5D,size%5B300x10000%5D&sink=format%5Bwebp%5D');

COMMIT TRANSACTION;
