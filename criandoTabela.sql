
/**  - Removendo tabelas - */
/** DROP TABLE Cliente, Telefone, Cargo, Estoque, Funcionario, Fabricante, Produto, Solicitacao;
  */

/** Criando tabela Cliente */
CREATE TABLE Cliente(
	idCliente SERIAL NOT NULL UNIQUE,
	nome VARCHAR,
	PRIMARY KEY(idCliente)
);

/** Criando tabela Telefone */
CREATE TABLE Telefone(
	idTelefone SERIAL NOT NULL UNIQUE,
    numero VARCHAR,
    idCliente INTEGER REFERENCES Cliente,
    PRIMARY KEY(idTelefone)
);

/** Criando tabela Cargo */
CREATE TABLE Cargo(
	idCargo SERIAL NOT NULL UNIQUE,
	nomeCargo VARCHAR,
	salario FLOAT,
	PRIMARY KEY (idCargo)
);

/** Criando tabela Funcionario */
CREATE TABLE Funcionario(
	idFuncionario SERIAL NOT NULL UNIQUE,
	nomeFuncionario VARCHAR,
	cpf VARCHAR,
	dataDeNascimento DATE,
	idCargo INTEGER REFERENCES Cargo,
	PRIMARY KEY(idFuncionario)
);

/** Criando tabela Fabricante */
CREATE TABLE Fabricante(
	idFabricante SERIAL NOT NULL UNIQUE,
	nomeFabricante VARCHAR,
	PRIMARY KEY(idFabricante)
);

/** Criando tabela Produto */
CREATE TABLE Produto(
	idProduto SERIAL NOT NULL UNIQUE,
	nomeProduto VARCHAR,
	preco FLOAT,
	dataDeValidade DATE,
	idFabricante INTEGER REFERENCES Fabricante,
    PRIMARY KEY(idProduto)
);

/** Criando tabela Solicitacao */
CREATE TABLE Solicitacao(
	idSolicitacao SERIAL NOT NULL UNIQUE,
	descricao VARCHAR,
    quantidade INTEGER,
	idFuncionario INTEGER REFERENCES Funcionario,
	idCliente INTEGER REFERENCES Cliente,
	idProduto INTEGER REFERENCES Produto,	
	PRIMARY KEY(idSolicitacao)
);  

/** Criando tabela Estoque */
CREATE TABLE Estoque(
	idEstoque SERIAL NOT NULL UNIQUE,
	quantidade INTEGER,
	idProduto INTEGER REFERENCES Produto,
	PRIMARY KEY(idEstoque)
);

