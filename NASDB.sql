CREATE DATABASE IF NOT EXISTS NASDB;
USE NASDB;

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS ARTICLE;

-- Select statements to view the data
SELECT * FROM USERS;