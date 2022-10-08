CREATE TABLE livro (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    paginas INT NOT NULL,
    id_autor SERIAL NOT NULL,
    FOREIGN KEY (id_autor) REFERENCES autor(id),
    id_editora SERIAL NOT NULL,
    FOREIGN KEY (id_editora) REFERENCES editora(id)
);

INSERT INTO livro (nome, genero, paginas, id_autor, id_editora) VALUES ('A história química de uma vela. As forças da matéria', 'História da química', 223, 2, 2);
INSERT INTO livro (nome, genero, paginas, id_autor, id_editora) VALUES ('Buracaos Negros', 'Astronomia', 62, 1, 1);