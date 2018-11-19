
/**  - Removendo tabelas -
	DROP TABLE Cliente, Telefone, Cargo, Estoque, Funcionario, Fabricante, Produto, Solicitacao;
 */   
/**
CREATE TABLE Cliente(
	idCliente SERIAL NOT NULL UNIQUE,
	nome VARCHAR NOT NULL,
	PRIMARY KEY(idCliente)
);

CREATE TABLE Telefone(
	idTelefone SERIAL NOT NULL UNIQUE,
    numero VARCHAR NOT NULL,
    idCliente INTEGER NOT NULL REFERENCES Cliente,
    PRIMARY KEY(idTelefone)
);

CREATE TABLE Cargo(
	idCargo SERIAL NOT NULL UNIQUE,
	nomeCargo VARCHAR NOT NULL,
	salario FLOAT NOT NULL,
	PRIMARY KEY (idCargo)
);

CREATE TABLE Estoque(
	idEstoque SERIAL NOT NULL UNIQUE,
	quantidade INTEGER NOT NULL,
	PRIMARY KEY(idEstoque)
);

CREATE TABLE Funcionario(
	idFuncionario SERIAL NOT NULL UNIQUE,
	nomeFuncionario VARCHAR NOT NULL,
	cpf VARCHAR NOT NULL UNIQUE,
	dataDeNascimento DATE NOT NULL,
	idCargo INTEGER NOT NULL REFERENCES Cargo,
	PRIMARY KEY(idFuncionario)
);

CREATE TABLE Fabricante(
	idFabricante SERIAL NOT NULL UNIQUE,
	nomeFabricante VARCHAR NOT NULL,
	PRIMARY KEY(idFabricante)
);

CREATE TABLE Produto(
	idProduto SERIAL NOT NULL UNIQUE,
	nomeProduto VARCHAR NOT NULL,
	preco FLOAT NOT NULL,
	dataDeValidade DATE NOT NULL,
	idEstoque INTEGER NOT NULL REFERENCES Estoque,
	idFabricante INTEGER NOT NULL REFERENCES Estoque,
    PRIMARY KEY(idProduto)
);

CREATE TABLE Solicitacao(
	idSolicitacao SERIAL NOT NULL UNIQUE,
	descricao VARCHAR NOT NULL,
    quantidade INTEGER NOT NULL,
	idFuncionario INTEGER NOT NULL REFERENCES Funcionario,
	idCliente INTEGER NOT NULL REFERENCES Cliente,
	idEstoque INTEGER NOT NULL REFERENCES Estoque,	
	PRIMARY KEY(idSolicitacao)
);   
*/