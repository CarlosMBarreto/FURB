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