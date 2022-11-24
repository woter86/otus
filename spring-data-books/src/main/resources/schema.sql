DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS(ID BIGINT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(255));

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES(ID BIGINT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(255));

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS(ID BIGINT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(255), AUTHOR_ID BIGINT, GENRE_ID BIGINT);

DROP TABLE IF EXISTS COMMENTS;
CREATE TABLE COMMENTS(ID BIGINT PRIMARY KEY AUTO_INCREMENT, COMMENT VARCHAR(255), BOOK_ID BIGINT);



