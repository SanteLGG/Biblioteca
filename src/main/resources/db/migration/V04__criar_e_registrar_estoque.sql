CREATE TABLE estoque (
    id SERIAL PRIMARY KEY,
    id_livro SERIAL NOT NULL,
    FOREIGN KEY (id_livro) REFERENCES livro(id),
    quantidade INT NOT NULL
);

INSERT INTO estoque (id_livro, quantidade) VALUES (1, 2);
INSERT INTO estoque (id_livro, quantidade) VALUES (2, 1);