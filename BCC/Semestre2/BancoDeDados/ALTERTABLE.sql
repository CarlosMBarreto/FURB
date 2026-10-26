-- adicionando as PK às tabelas (cor já tem PK desde o CREATE)
ALTER TABLE marca ADD PRIMARY KEY (cd_marca);
ALTER TABLE combustivel ADD PRIMARY KEY (cd_combustivel);
ALTER TABLE modelo ADD PRIMARY KEY (cd_modelo);
ALTER TABLE localidade ADD PRIMARY KEY (cd_localidade);
ALTER TABLE proprietario ADD PRIMARY KEY (cd_proprietario);
ALTER TABLE veiculo ADD PRIMARY KEY (nr_placa);
ALTER TABLE veiculo_combustivel ADD PRIMARY KEY (cd_combustivel, nr_placa);

-- adicionando as FK às tabelas
ALTER TABLE modelo -- cd_marca -> marca(cd_marca)
ADD CONSTRAINT modelo_cd_marca_fk FOREIGN KEY (cd_marca) REFERENCES marca(cd_marca);
ALTER TABLE veiculo -- cd_proprietario -> proprietario(cd_proprietario)
ADD CONSTRAINT veiculo_cd_proprietario_fk FOREIGN KEY (cd_proprietario)
REFERENCES proprietario(cd_proprietario);
ALTER TABLE veiculo -- cd_modelo -> modelo(cd_modelo)
ADD FOREIGN KEY (cd_modelo) REFERENCES modelo(cd_modelo); -- aqui sem "batismo" da regra
ALTER TABLE proprietario -- cd_localidade -> localidade(cd_localidade)
ADD FOREIGN KEY (cd_localidade) REFERENCES localidade(cd_localidade); -- idem
ALTER TABLE veiculo_combustivel -- ambas as FKs na mesma instrução
ADD FOREIGN KEY (nr_placa) REFERENCES veiculo(nr_placa),
ADD FOREIGN KEY (cd_combustivel) REFERENCES combustivel(cd_combustivel);

-- adicionando as FKs na tabela veiculo_acessorio em instrução única
ALTER TABLE veiculo_acessorio
	ADD FOREIGN KEY (nr_placa) REFERENCES veiculo(nr_placa),
	ADD FOREIGN KEY (cd_acessorio) REFERENCES acessorio(cd_acessorio);
-- adicionando a coluna cd_cor na tabela veiculo e indicando que ela é FK
ALTER TABLE veiculo
	ADD COLUMN cd_cor INT,
	ADD FOREIGN KEY (cd_cor) REFERENCES cor(cd_cor);
-- alternativa para criacão da tabela veiculo acessorio2 em instrução única

CREATE TABLE veiculo_acessorio2
(nr_placa CHAR(7) REFERENCES veiculo(nr_placa),
cd_acessorio INT REFERENCES acessorio(cd_acessorio),
PRIMARY KEY (nr_placa,cd_acessorio));