package github.com.SanteLGG.Biblioteca.domain.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "editora", schema = "biblioteca")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    //getters and setters
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
}
