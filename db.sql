DROP DATABASE IF EXISTS countries;
CREATE DATABASE countries;
USE countries;
CREATE TABLE potrebiteli(
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255),
pass VARCHAR(255), 
mail VARCHAR(255)
);
INSERT INTO potrebiteli VALUES
 (1, "admin", "admin", "admin@local.bg"),
 (2, "usr", "u", "usr@local.bg");