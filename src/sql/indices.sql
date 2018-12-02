-- Índices da tabela Cliente
CREATE INDEX index_btree_Cliente ON Cliente USING BTREE(idCliente);

-- Índices da tabela Telefone
CREATE INDEX index_hash_Telefone ON Telefone USING HASH(numeroTelefone);

-- Índices da tabela Funcionario
CREATE INDEX index_hash_Funcionario ON Funcionario USING HASH(cpf); -- MAIS IMPORTANTE

-- Índices da tabela Cargo
CREATE INDEX index_hash_Cargo ON Cargo USING HASH(nomeCargo);

-- Índices da tabela Fabricante
CREATE INDEX index_hash_Fabricante ON Fabricante USING HASH(nomeFabricante);   -- MAIS IMPORTANTE

-- Índice da tabela Solicitação 
CREATE INDEX index_btree_Solicitacao ON Solicitacao USING BTREE(idSolicitacao);
