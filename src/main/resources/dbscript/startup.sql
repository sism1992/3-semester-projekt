drop database if exists mormor_db;
create database mormor_db;
use mormor_db;

DROP USER IF EXISTS 'groot'@'localhost';
CREATE USER 'groot'@'localhost' IDENTIFIED BY 'iamgroot';
GRANT ALL ON * TO 'groot'@'localhost';