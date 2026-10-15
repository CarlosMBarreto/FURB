-- excluindo a tabela depto
DROP TABLE IF EXISTS depto;
-- criando a tabela depto
CREATE TABLE depto (
   cd_depto INT(10) NOT NULL,
	nm_depto VARCHAR(50));
-- descrevendo a estrutura da tabela
DESC depto;
-- adicionando uma coluna à tabela depto
ALTER TABLE depto
ADD COLUMN ds_local VARCHAR(30);
-- alterando o tipo de dado de uma coluna
ALTER TABLE depto
MODIFY COLUMN nm_depto VARCHAR(50);
-- alterando a tabela removendo uma coluna
ALTER TABLE depto
DROP COLUMN ds_local;
-- adicionando algumas Linhas à tabela
INSERT INTO depto VALUES (1, 'depto 1');
INSERT INTO depto VALUES (2, 'depto 2');
INSERT INTO depto VALUES (3, 'depto 3');
-- selecionando os dados da tabela
SELECT * FROM depto;
-- criando uma tabela a partir da seleção de dados de outra tabela
DROP TABLE IF EXISTS depto2;
CREATE TABLE depto2 AS
SELECT nm_depto FROM depto;


DROP TABLE IF EXISTS marca;
CREATE TABLE marca
(cd_marca INTEGER,
ds_marca VARCHAR(30));

DROP TABLE IF EXISTS combustivel;
CREATE TABLE combustivel
(cd_combustivel INTEGER,
ds_combustivel VARCHAR(30));

DROP TABLE IF EXISTS modelo;
CREATE TABLE modelo
(cd_modelo INTEGER,
 cd_marca  INTEGER, -- aqui "será" uma FK para modelo!
ds_modelo VARCHAR(50));

DROP TABLE IF EXISTS localidade;
CREATE TABLE localidade
(cd_localidade INTEGER,
nm_localidade VARCHAR(50),
sg_uf				CHAR(2));

DROP TABLE IF EXISTS veiculo;
CREATE TABLE veiculo
(nr_placa CHAR(7),
cd_proprietario INTEGER, -- será uma FK para proprietario
cd_modelo INTEGER,
nr_ano_fab INTEGER,
nr_ano_mod INTEGER,
qt_km_rodado INTEGER,
nr_portas INTEGER,
ds_observacao VARCHAR(100));

DROP TABLE IF EXISTS proprietario;
CREATE TABLE proprietario
(cd_proprietario INTEGER,
cd_localidade INTEGER, -- será uma FK para Localidade
nm_proprietario VARCHAR(50),
ds_logradouro VARCHAR(50),
ds_complemento VARCHAR(50),
ds_bairro VARCHAR(50),
nr_telefone VARCHAR(15), 
ds_email VARCHAR(50));

DROP TABLE IF EXISTS veiculo_combustivel;
CREATE TABLE veiculo_combustivel
(cd_combustivel INTEGER, -- será uma FK para combustivel
nr_placa CHAR(7)); -- será uma FK para veiculo