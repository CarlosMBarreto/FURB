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


-- criando a tabela teste1
DROP TABLE IF EXISTS teste1;
CREATE TABLE teste1
(id_teste1 INT PRIMARY KEY, -- definindo a PK no nivel da coluna
ds_teste1 VARCHAR(50));
DROP TABLE IF EXISTS teste2;
CREATE TABLE teste2
-- criando a tabela teste2
(id_teste2 INT,
ds_teste2 VARCHAR(50),
PRIMARY KEY (id_teste1)); -- definindo a PK no nivel da tabela;
-- criando a tabela teste3
DROP TABLE IF EXISTS teste3;
CREATE TABLE teste3
(id_teste3 INT,
ds_teste3 VARCHAR(50),
constraint teste3_id_teste3_pk PRIMARY KEY (id_teste1)); -- definindo a PK no nivel da tabela 
-- e nomeando a restrição (regra): "Teste3_id_teste3_pk"
-- alterando a definição da coluna para NOT NULL
ALTER TABLE teste3
	MODIFY COLUMN ds_teste3 VARCHAR(50) NOT NULL;
DESC teste3;

-- adicionando uma coluna que sera uma FK
ALTER TABLE teste2
ADD COLUMN id_teste1 INT;
ALTER TABLE teste2
ADD CONSTRAINT teste2_id_teste1_fk foreign KEY (id_teste1) -- referencia
REFERENCES teste1(id_teste1); -- tabela referenciada e a coluna PK da tabela

ALTER TABLE teste3
ADD COLUMN id_teste1 INT REFERENCES teste1(id_teste1); -- adicionamos a coluna e já
-- indicamos a referência à tabela e coluna PK