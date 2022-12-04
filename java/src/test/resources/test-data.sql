BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, author;
DROP SEQUENCE IF EXISTS seq_user_id, seq_author_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

 CREATE SEQUENCE seq_author_id
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


CREATE TABLE author (

    author_id int DEFAULT nextval('seq_author_id'::regclass) NOT NULL,
    author_name varchar(200) NOT NULL,
    CONSTRAINT PK_author PRIMARY KEY (author_id)

);

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO author(author_name) VALUES ('Tolkien');
INSERT INTO author(author_name) VALUES ('Marquez');



COMMIT TRANSACTION;
