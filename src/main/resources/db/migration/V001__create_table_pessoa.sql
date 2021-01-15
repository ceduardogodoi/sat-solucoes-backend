CREATE TABLE pessoa (
  id SERIAL PRIMARY KEY,
  nome VARCHAR NOT NULL,
  data_cadastro TIMESTAMP NOT NULL DEFAULT 'now()',
  cpf VARCHAR NOT NULL,
  renda NUMERIC(15,2)
);

INSERT INTO pessoa (nome, cpf, renda)
VALUES ('Carlos', '08439617917', 1000);

INSERT INTO pessoa (nome, cpf, renda)
VALUES ('Eduardo', '08439617917', 1000);

INSERT INTO pessoa (nome, cpf, renda)
VALUES ('Jhonata', '08439617917', 1000);

INSERT INTO pessoa (nome, cpf, renda)
VALUES ('André', '08439617917', 1000);

INSERT INTO pessoa (nome, cpf, renda)
VALUES ('Xicu', '08439617917', 1000);

INSERT INTO pessoa (nome, cpf, renda)
VALUES ('Xica', '08439617917', 1000);

INSERT INTO pessoa (nome, cpf, renda)
VALUES ('Jão', '08439617917', 1000);
