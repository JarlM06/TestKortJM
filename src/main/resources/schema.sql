CREATE DATABASE IF NOT EXISTS databasenavn;
USE databasenavn;

CREATE TABLE IF NOT EXISTS Kortstokk (
                                         id INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS Kort (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    kortstokk_id INT,
                                    type VARCHAR(255),
                                    nummer INT,
                                    FOREIGN KEY (kortstokk_id) REFERENCES Kortstokk(id)
);
