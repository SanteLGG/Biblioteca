CREATE TABLE autor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    livro_id SERIAL NOT NULL
);

INSERT INTO autor (nome, livro_id) VALUES ('Stephen Hawking', 2);
INSERT INTO autor (nome, livro_id) VALUES ('Michael Faraday', 1);

