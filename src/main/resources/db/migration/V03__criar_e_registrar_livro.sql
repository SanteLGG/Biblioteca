CREATE TABLE livro (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    paginas DECIMAL not null,
    id_autor SERIAL NOT NULL,
    FOREIGN KEY (id_autor) REFERENCES autor(id),
    id_editora SERIAL NOT NULL,
    FOREIGN KEY (id_editora) REFERENCES editora(id)
);
