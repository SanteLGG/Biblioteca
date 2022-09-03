CREATE TABLE autor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    id_livro INT
);

INSERT INTO autor (nome) VALUES ('Stephen Hawking');
INSERT INTO autor (nome) VALUES ('Michael Faraday');

