package github.com.SanteLGG.Biblioteca.domain.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "autor", schema = "biblioteca")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    //getter and setters
    public Long getCodigo() {
        return id;
    }
    public void setCodigo(Long codigo) {
        this.id = codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
