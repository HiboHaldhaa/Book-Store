BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

DROP TABLE IF EXISTS book_genre, book_author, book, tag, book_tag, author, genre, publisher,book_language, book_publisher CASCADE;
DROP SEQUENCE IF EXISTS genre_serial, author_serial, tag_serial, publisher_serial, language_serial ;

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

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- 

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

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
