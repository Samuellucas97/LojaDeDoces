-- Índices da tabela Cliente
CREATE INDEX index_btree_Cliente ON Cliente USING BTREE(idCliente);

-- Índices da tabela Telefone
CREATE INDEX index_hash_Telefone ON Telefone USING HASH(numeroTelefone);

-- Índices da tabela Funcionario
CREATE INDEX index_hash_Funcionario ON Funcionario USING HASH(cpf);

-- Índices da tabela Cargo
CREATE INDEX index_Cargo ON Cargo USING HASH(nomeCargo);

-- Índices da tabela Fabricante
CREATE INDEX index_btree_Fabricante ON Fabricante USING BTREE(idFabricante);
