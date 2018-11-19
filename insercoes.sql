/** Inserindo 10 clientes */
INSERT INTO Cliente (nome) values
('ANA'),
('MARIA'),
('PAULO'),
('JOAO'),
('FERNANDO'),
('RAQUEL'),
('DANIEL'),
('JULIA'),
('BRUNA'),
('BRUNO');



/** Inserindo telefones */
INSERT INTO Telefone (numeroTelefone, idCliente) values
('8499998881', 1),
('8499998882', 1),
('8499998883', 2),
('8499998884', 2),
('8499191884', 3),
('8499998884', 4);


/** Inserindo cargos */
INSERT INTO Cargo (nomeCargo, salario) values
('atendente de caixa', 1000.00 ),
('gerente', 2700.00 ),
('vendedor', 1300.00 );

/** **/
INSERT INTO Estoque(quantidade) values
(3),
(2);