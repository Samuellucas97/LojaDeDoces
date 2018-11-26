
/** Gatilho da tabela Cliente */ 
CREATE OR REPLACE FUNCTION cliente_gatilho() RETURNS trigger AS $cliente_gatilho$
BEGIN
	/** Verificando se o campo nome da inserção ou atualização é nulo. Daí, se for, impede-se a ação. */
    IF NEW.nome IS NULL THEN
       RAISE EXCEPTION 'CONTEUDO NULO NO CAMPO NOME DA TABELA CLIENTE';
    END IF;   
	RETURN NEW;
END;
$cliente_gatilho$ LANGUAGE plpgsql;

CREATE TRIGGER  cliente_gatilho BEFORE INSERT OR UPDATE on Cliente
FOR EACH ROW  EXECUTE PROCEDURE cliente_gatilho();

/** Testando a funcionalidade do gatilho  
 *
 * INSERT INTO Cliente (nome) values (null);
 */

/** Gatilho da tabela Telefone */
CREATE OR REPLACE FUNCTION telefone_gatilho() RETURNS trigger AS $telefone_gatilho$
BEGIN
	/** Verificando se o campo numero da inserção ou atualização é nulo. Daí, se for, impede-se a ação. */
	IF NEW.numero IS NULL THEN
       RAISE EXCEPTION 'CONTEUDO NULO NO CAMPO NUMERO DA TABELA TELEFONE';
    END IF;
	
	IF( EXISTS(SELECT numero FROM Telefone WHERE numero = NEW.numero ) )THEN 
		RAISE EXCEPTION 'UM REGISTRO COM ESSE NUMERO JA FOI ADICIONADO A TABELA TELEFONE';
    END IF;    
    
	RETURN NEW;
END;
$telefone_gatilho$ LANGUAGE plpgsql;

CREATE TRIGGER  telefone_gatilho BEFORE INSERT OR UPDATE on Telefone
FOR EACH ROW  EXECUTE PROCEDURE telefone_gatilho();

/** Testando a funcionalidade do gatilho  
 *	
 * Tentando adicionar com null
 * INSERT INTO Telefone (numero, idCliente) values (null, 1);
 *
 * Tentando adicionar tupla que já existe na tabela Telefone
 * INSERT INTO Telefone (numero, idCliente) values ('8499998881', 1);
 */
 
/** Gatilho da tabela Cargo */
CREATE OR REPLACE FUNCTION cargo_gatilho() RETURNS trigger AS $cargo_gatilho$
BEGIN
	/** Verificando se o campo nomeCargo da inserção ou atualização é nulo. Daí, se for, impede-se a ação. */
	IF NEW.nomeCargo IS NULL THEN
       RAISE EXCEPTION 'CONTEUDO NULO NO CAMPO NOMECARGO DA TABELA CARGO';
    /** Verificando se o campo salario da inserção ou atualização é nulo. Daí, se for, impede-se a ação. */
	END IF;
	IF NEW.salario IS NULL THEN 
		RAISE EXCEPTION 'CONTEUDO NULO NO CAMPO SALARIO DA TABELA CARGO';
	END IF;
		
	/** Verificando se o campo salario da inserção ou atualização é negativo. Daí, se for, impede-se a ação. */	
	IF NEW.salario <= 0.0 THEN 
		RAISE EXCEPTION 'O CAMPO SALARIO DA TABELA CARGO NÃO PODE SER NEGATIVO';
	END IF;
	
	IF( EXISTS(SELECT nomeCargo FROM Cargo WHERE nomeCargo = NEW.nomeCargo ) )THEN 
		RAISE EXCEPTION 'UM REGISTRO COM ESSE CARGO JA FOI ADICIONADO A TABELA CARGO';
    END IF;    
 
 	RETURN NEW;
END;
$cargo_gatilho$ LANGUAGE plpgsql;

CREATE TRIGGER  cargo_gatilho BEFORE INSERT OR UPDATE on Cargo
FOR EACH ROW  EXECUTE PROCEDURE cargo_gatilho(); 

/** Testando a funcionalidade do gatilho  
 *	
 * Tentando adicionar com null
 * INSERT INTO Cargo (nomeCargo, salario) values (null, 1000.00 );
 * INSERT INTO Cargo (nomeCargo, salario) values ('ESTAGIARIO', null); 
 *
 * Tentando adicionar tupla que já existe na tabela Cargo
 * INSERT INTO Cargo (nomeCargo, salario) values ('ATENDENTE DE CAIXA', 1000.00 );
 * 
 * Tentando adicionar tupla com salário negativo
 * INSERT INTO Cargo (nomeCargo, salario) values ('ESTAGIARIO', -500.00 );
 */

 /** Gatilho da tabela Funcionario */
CREATE OR REPLACE FUNCTION funcionario_gatilho() RETURNS trigger AS $funcionario_gatilho$
BEGIN
	/** Verificando se o campo nomeFuncionario da inserção ou atualização é nulo. Daí, se for, impede-se a ação. */
	IF NEW.nomeFuncionario IS NULL THEN
       RAISE EXCEPTION 'CONTEUDO NULO NO CAMPO NOMEFUNCIONARIO DA TABELA FUNCIONARIO';
    END IF;
	
	/** Verificando se o campo CPF da inserção ou atualização é nulo. Daí, se for, impede-se a ação. */
	IF NEW.cpf IS NULL THEN 
		RAISE EXCEPTION 'CONTEUDO NULO NO CAMPO CPF DA TABELA FUNCIONARIO';
	END IF;
	
	/** Verificando se o campo dataNascimento da inserção ou atualização é nulo. Daí, se for, impede-se a ação. */
	IF NEW.dataDeNascimento IS NULL THEN 
		RAISE EXCEPTION 'CONTEUDO NULO NO CAMPO DATADENASCIMENTO DA TABELA FUNCIONARIO';
	END IF;
		
	/** Verificando se já há esse cpf na tabela. Daí, se tiver, impede a ação. */
	IF( EXISTS(SELECT cpf FROM Funcionario WHERE cpf = NEW.cpf ) )THEN 
		RAISE EXCEPTION 'UM REGISTRO COM ESSE CPF JA FOI ADICIONADO A TABELA FUNCIONARIO';
    END IF;    
 
 	RETURN NEW;
END;
$funcionario_gatilho$ LANGUAGE plpgsql;

CREATE TRIGGER  funcionario_gatilho BEFORE INSERT OR UPDATE on Funcionario
FOR EACH ROW  EXECUTE PROCEDURE funcionario_gatilho(); 

/** Testando a funcionalidade do gatilho  
 *	
 * Tentando adicionar com null
 * INSERT INTO Funcionario(nomeFuncionario, cpf, dataDeNascimento, idCargo) values (null, '702.100.987-45', '1990-12-20', 3); 
 * INSERT INTO Funcionario(nomeFuncionario, cpf, dataDeNascimento, idCargo) values ('BRIAN', null, '1990-12-20', 3); 
 * INSERT INTO Funcionario(nomeFuncionario, cpf, dataDeNascimento, idCargo) values ('BRIAN', '702.100.987-45', null, 3); 
 *
 * Tentando adicionar tupla que já existe na tabela Funcionario
 * INSERT INTO Funcionario(nomeFuncionario, cpf, dataDeNascimento, idCargo) values ('LUAN', '700.100.987-45', '1990-12-20', 3);
 */

/** Gatilho da tabela Fabricante */
CREATE OR REPLACE FUNCTION fabricante_gatilho() RETURNS trigger AS $fabricante_gatilho$
BEGIN
	/** Verificando se o campo nomeFabricante da inserção ou atualização é nulo. Daí, se for, impede-se a ação. */
	IF NEW.nomeFabricante IS NULL THEN
       RAISE EXCEPTION 'CONTEUDO NULO NO CAMPO NOMEFABRICANTE DA TABELA FABRICANTE';
    END IF;
	
	/** Verificando se já há esse nome de fabricante na tabela. Daí, se tiver, impede a ação. */
	IF( EXISTS(SELECT nomeFabricante FROM Fabricante WHERE nomeFabricante = NEW.nomeFabricante ) )THEN 
		RAISE EXCEPTION 'UM REGISTRO COM ESSE NOME DE FABRICANTE JA FOI ADICIONADO A TABELA FABRICANTE';
    END IF;    
 
 	RETURN NEW;
END;
$fabricante_gatilho$ LANGUAGE plpgsql;

CREATE TRIGGER  fabricante_gatilho BEFORE INSERT OR UPDATE on Fabricante
FOR EACH ROW  EXECUTE PROCEDURE fabricante_gatilho(); 

/** Testando a funcionalidade do gatilho  
 *	
 * Tentando adicionar com null
 * INSERT INTO Fabricante( nomeFabricante ) values (null);
 *
 * Tentando adicionar tupla que já existe na tabela Fabricante
 * INSERT INTO Fabricante( nomeFabricante ) values ('NESTLE');
 */

/** Gatilho da tabela Produto */
CREATE OR REPLACE FUNCTION produto_gatilho() RETURNS trigger AS $produto_gatilho$
BEGIN
	/** Verificando se o campo nomeProduto da inserção ou atualização é nulo. Daí, se for, impede-se a ação. */
	IF NEW.nomeProduto IS NULL THEN
       RAISE EXCEPTION 'CONTEUDO NULO NO CAMPO NOMEPRODUTO DA TABELA PRODUTO';
    END IF;
	
	/** Verificando se o campo preco da inserção ou atualização é nulo. Daí, se for, impede-se a ação. */
	IF NEW.preco IS NULL THEN 
		RAISE EXCEPTION 'CONTEUDO NULO NO CAMPO PRECO DA TABELA PRODUTO';
	END IF;
	
	/** Verificando se o campo dataDeValidade da inserção ou atualização é nulo. Daí, se for, impede-se a ação. */
	IF NEW.dataDeValidade IS NULL THEN 
		RAISE EXCEPTION 'CONTEUDO NULO NO CAMPO DATADEVALIDADE DA TABELA PRODUTO';
	END IF;	
	 
    /** Verificando se o campo preco da inserção ou atualização é negativo. Daí, se for, impede-se a ação. */	
	IF NEW.preco <= 0.0 THEN 
    	RAISE EXCEPTION 'O CAMPO PRECO DA TABELA PRODUTO NÃO PODE SER NEGATIVO';
  	END IF;
    
 	RETURN NEW;
END;
$produto_gatilho$ LANGUAGE plpgsql;

CREATE TRIGGER  produto_gatilho BEFORE INSERT OR UPDATE on Produto
FOR EACH ROW  EXECUTE PROCEDURE produto_gatilho(); 

/** Testando a funcionalidade do gatilho  
 *	
 * Tentando adicionar com null
 * INSERT INTO Produto(nomeProduto, preco, dataDeValidade, idFabricante) values (null, 89.9, '2019-03-26', 4 );
 * INSERT INTO Produto(nomeProduto, preco, dataDeValidade, idFabricante) values ('COOKIES', null, '2019-03-26', 4 );
 * INSERT INTO Produto(nomeProduto, preco, dataDeValidade, idFabricante) values ('COOKIES', 9.9, null, 4 );
 *
 * Tentando adicionar tupla com preço negativo na tabela Funcionario
 * INSERT INTO Produto(nomeProduto, preco, dataDeValidade, idFabricante) values ('COOKIES', -5.5, '2019-03-26', 4 );
 */