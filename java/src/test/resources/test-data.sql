BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, author, book_author, book_tag, book_genres, books, author, tags, genres;
DROP SEQUENCE IF EXISTS seq_user_id, author_serial, tag_serial, genre_serial;

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

CREATE SEQUENCE author_serial;
CREATE TABLE author (

	author_id int NOT NULL DEFAULT nextval('author_serial'),
	author_name varchar(200) NOT NULL,

	CONSTRAINT pk_author PRIMARY KEY(author_id)

);

CREATE TABLE books (

	isbn int NOT NULL UNIQUE,
	author_id int NOT NULL,
	title varchar(200) NOT NULL,
	publication_date date NULL,

	CONSTRAINT PK_book PRIMARY KEY(isbn),
	CONSTRAINT FK_book_author FOREIGN KEY(author_id) REFERENCES author(author_id)

);

CREATE TABLE book_author (

	isbn int NOT NULL,
	author_id int NOT NULL,

	CONSTRAINT PK_book_author PRIMARY KEY(isbn, author_id),
	CONSTRAINT FK_book_author_book FOREIGN KEY(isbn) REFERENCES books(isbn),
	CONSTRAINT FK_book_author_author FOREIGN KEY(author_id) REFERENCES author(author_id)

);

CREATE SEQUENCE tag_serial;
CREATE TABLE tags (

	tag_id int NOT NULL DEFAULT nextval('tag_serial'),
	tag_word varchar(50) NOT NULL,

	CONSTRAINT PK_tags PRIMARY KEY(tag_id)

);

CREATE TABLE book_tag (

	isbn int NOT NULL,
	tag_id int NOT NULL,

	CONSTRAINT PK_book_tag PRIMARY KEY(isbn, tag_id),
	CONSTRAINT FK_book_tag_book FOREIGN KEY(isbn) REFERENCES books(isbn),
	CONSTRAINT FK_book_tag_tag FOREIGN KEY(tag_id) REFERENCES tags(tag_id)
);

CREATE SEQUENCE genre_serial;
CREATE TABLE genres (

	genre_id int NOT NULL DEFAULT nextval('genre_serial'),
	genre_name varchar(50) NOT NULL,

	CONSTRAINT PK_genre_serial PRIMARY KEY(genre_id)

);

CREATE TABLE book_genres (

	isbn int NOT NULL,
	genre_id int NOT NULL,

	CONSTRAINT PK_book_genres PRIMARY KEY(isbn, genre_id),
	CONSTRAINT FK_book_genres_book FOREIGN KEY (isbn) REFERENCES books(isbn),
	CONSTRAINT FK_book_genres_genres FOREIGN KEY(genre_id) REFERENCES genres(genre_id)

);

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO author(author_name) VALUES ('Tolkien');
INSERT INTO author(author_name) VALUES ('Marquez');

COMMIT TRANSACTION;
