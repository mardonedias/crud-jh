-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE Filme (
id_filme INT(11) PRIMARY KEY AUTO_INCREMENT,
titulo VARCHAR(45),
locado TINYINT(1),
titulo_original VARCHAR(45),
id_genero INT(11)
);

CREATE TABLE Genero (
id_genero INT(11) PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR(45)
);

CREATE TABLE Cliente (
nome VARCHAR(60),
bairro VARCHAR(20),
telefone VARCHAR(20),
endereco VARCHAR(60),
cidade VARCHAR(30),
celular VARCHAR(20),
email VARCHAR(60),
ativo TINYINT,
id_cliente INT(11) PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE Locacao (
data_hora_locacao DATETIME,
finalizar_locacao TINYINT,
data_hora_devolucao DATETIME,
id_locacao INT(11) PRIMARY KEY AUTO_INCREMENT,
id_cliente INT(11),
id_filme INT(11),
FOREIGN KEY(id_cliente) REFERENCES Cliente (id_cliente),
FOREIGN KEY(id_filme) REFERENCES Filme (id_filme)
);

ALTER TABLE Filme ADD FOREIGN KEY(id_genero) REFERENCES Genero (id_genero)
