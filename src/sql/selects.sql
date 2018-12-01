/**
 * @brief   Contém os selects importantes
 * @author  Samuel Lucas de Moura Ferino
 * @version 0.0.1
 */

/**    --:>  VISÕES RELACIONADOS AO CLIENTE    */

-- Tabela com nome de cliente com os seus telefones
CREATE VIEW vw_Cliente_Telefones AS
SELECT nomeCliente, numeroTelefone FROM Cliente INNER JOIN Telefone ON Cliente.idCliente = Telefone.idCliente 
GROUP BY nomeCliente;

/** Não completados 
 *
-- Tabela com nome de cliente, quantidade de produtos comprados, nome do produto e preço
SELECT nomeCliente, nomeProduto, quantidade, preco  FROM Cliente INNER JOIN Solicitacao ON Cliente.idCliente = Solicitacao.idCliente 
                                  INNER JOIN Produto ON Solicitacao.idProduto = Produto.idProduto
GROUP BY nomeCliente;


-- Tabela com nome do cliente e marcas que mais compra
SELECT nomeCliente, nomeFabricante, quantidade  FROM Cliente INNER JOIN Solicitacao ON Cliente.idCliente = Solicitacao.idCliente 
                                  INNER JOIN Produto ON Solicitacao.idProduto = Produto.idProduto
                                  INNER JOIN Fabricante ON Produto.idFabricante = Fabricante.idFabricante
GROUP BY nomeCliente
ORDER BY quantidade DESC;
*/

/**    --:>   VISÕES RELACIONADOS AO FUNCIONÁRIO    */

-- Tabela com nome de cargos e quantidade de funcionários relacionados a esse cargo
CREATE VIEW vw_Cargo_Funcionario AS
SELECT nomeCargo, COUNT(idFuncionario) FROM Cargo INNER JOIN Funcionario ON Cargo.idCargo = Funcionario.idCargo
GROUP BY nomeCargo
ORDER BY COUNT(idFuncionario) DESC; 


