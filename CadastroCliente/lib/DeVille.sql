CREATE DATABASE DeVille;

USE DeVille;

CREATE TABLE Cliente (
	COD_Cliente INT NOT NULL,
	CPF_Cliente VARCHAR(11) NOT NULL,
	Nasc_Cliente DATETIME NOT NULL,
	Nome_Cliente VARCHAR(100) NOT NULL,
	Tel_Cliente VARCHAR(11) NOT NULL);

ALTER TABLE Cliente 
ADD CONSTRAINT PK_CLIENTE PRIMARY KEY(COD_Cliente);

GRANT execute,select,insert,update,delete TO public;