package github.com.SanteLGG.Biblioteca.domain.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table (name = "livro", schema = "biblioteca")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String genero;

    @NotNull
    private Long paginas;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;


    @ManyToOne
    @JoinColumn(name = "id_editora")
    private Editora editora;


    //getter and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Long getPaginas() {
        return paginas;
    }
    public void setPaginas(Long paginas) {
        this.paginas = paginas;
    }

    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }
    public void setEditora(Editora editora) {
        this.editora = editora;
    }

}
