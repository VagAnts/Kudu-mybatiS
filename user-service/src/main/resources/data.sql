-- Table Schemas
DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS address;

CREATE TABLE address(
    id INT AUTO_INCREMENT  PRIMARY KEY,
    city VARCHAR(15) NOT NULL,
    street VARCHAR(15),
    building_no INT,
    door_no INT
);

CREATE TABLE users(
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(20),
    lastname VARCHAR(20),
    username VARCHAR(20) NOT NULL,
    email VARCHAR(20) UNIQUE,
    password varchar(100) NOT NULL,
    role varchar(15) NOT NULL