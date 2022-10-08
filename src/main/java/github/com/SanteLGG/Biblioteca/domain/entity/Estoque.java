package github.com.SanteLGG.Biblioteca.domain.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "estoque", schema = "biblioteca")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    @NotNull
    private Long quantidade;

    //getter and setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Long getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
