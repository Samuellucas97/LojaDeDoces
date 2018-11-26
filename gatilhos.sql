
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
		RAISE EXCEPTION 'ESSE NUMERO JA FOI ADICIONADO AO CLIENTE ';
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
	ELSE IF NEW.salario IS NULL THEN 
		RAISE EXCEPTION 'CONTEUDO NULO NO CAMPO SALARIO DA TABELA CARGO';
	END IF;
		
	/** Verificando se o campo salario da inserção ou atualização é negativo. Daí, se for*/	
	IF NEW.salario <= 0.0 THEN 
		RAISE EXCEPTION 'O CAMPO SALARIO DA TABELA CARGO NÃO PODE SER NEGATIVO';
	END IF;
	
	IF( EXISTS(SELECT nomeCargo FROM Cargo WHERE nomeCargo = NEW.nomeCargo ) )THEN 
		RAISE EXCEPTION 'ESSE CARGO JA FOI ADICIONADO AO CLIENTE ';
    END IF;    
 
 	RETURN NEW;
END;
$cargo_gatilho$ LANGUAGE plpgsql;

CREATE TRIGGER  cargo_gatilho BEFORE INSERT OR UPDATE on Cargo
FOR EACH ROW  EXECUTE PROCEDURE cargo_gatilho(); 