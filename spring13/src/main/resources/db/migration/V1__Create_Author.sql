DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS
(
    ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    FIRST_NAME VARCHAR(255),
    LAST_NAME VARCHAR(255),
    AGE INTEGER,
    YEAR_BIRTHDATE INTEGER
);