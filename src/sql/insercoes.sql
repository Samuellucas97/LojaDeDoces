
/** Inserindo clientes */
INSERT INTO Cliente (nome) values
('ANA'),
('MARIA'),
('PAULO'),
('JOAO'),
('FERNANDO'),
('RAQUEL'),
('DANIEL'),
('JULIA'),
('LUCAS'),
('BRUNA'),
('BRUNO');

/** Inserindo telefones */
INSERT INTO Telefone (numero, idCliente) values
('8499998881', 1),
('8499998882', 2),
('8499998883', 3),
('8499998884', 4);

/** Inserindo cargos */
INSERT INTO Cargo (nomeCargo, salario) values
('ATENDENTE DE CAIXA', 1000.00 ),
('GERENTE', 2700.00 ),
('VENDEDOR', 1300.00 );

/** Inserindo funcionários **/
INSERT INTO Funcionario(nomeFuncionario, cpf, dataDeNascimento, idCargo) values
('LUAN', '700.100.987-45', '1990-12-20', 3),
('PEDRO', '700.200.987-45', '1990-12-20',3),
('CECILIA', '700.300.987-45', '1990-12-20',3),
('RAFAEL', '700.400.987-45', '1990-12-20',1),
('FELIPE', '700.500.987-45', '1990-12-20',2);

/** Inserindo fabricantes */
INSERT INTO Fabricante( nomeFabricante ) values
('NESTLE'),
('BAUDUCCO'),
('CACAU SHOW'),
('KOPENHAGEN'),
('FERRERO ROCHER');

/** Inserindo produtos */
INSERT INTO Produto(nomeProduto, preco, dataDeValidade, idFabricante) values
('PANETTONE', 89.9, '2019-03-26', 4 ),
('CHOCOTTONE', 21.7, '2019-03-26', 2),
('BARRA DE CHOCOLATE', 4.9, '2019-06-26', 1),
('COOKIES', 12.0, '2019-10-26' ,3),
('COOKIES', 6.0, '2019-10-26' ,1),
('COOKIES', 5.0, '2019-10-26' ,2);

/** Inserindo estoque **/
INSERT INTO Estoque(quantidade, idProduto) values
(3, 1),
(1, 3),
(2, 2);

/** Inserindo solicitação (Venda) */
--INSERT INTO Solicitacao( descricao, quantidade, idFuncionario, idCliente, idProduto ) values
--('COMPRANDO UM CHOCOTTONE', );
