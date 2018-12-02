--Índices da tabela Cliente
CREATE INDEX index_Cliente ON Cliente USING BTREE(idCliente);

--Índices da tabela Funcionario
CREATE INDEX index_Funcionario ON Funcionario USING HASH(cpf);

--Índices da tabela Cargo
CREATE INDEX index_Cargo ON Cargo USING HASH (nomeCargo);
