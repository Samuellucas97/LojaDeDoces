--Índices da tabela Cliente
CREATE INDEX index_Cliente ON Cliente USING BTREE(idCliente);

--Índices da tabela Funcionario
CREATE INDEX index_Funcionario ON Funcionario USING HASH(cpf);
