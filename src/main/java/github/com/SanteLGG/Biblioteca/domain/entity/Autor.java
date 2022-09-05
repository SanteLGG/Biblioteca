package github.com.SanteLGG.Biblioteca.domain.entity;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "autor", schema = "biblioteca")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private Long livro_id;

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

    public Long getLivro_id() {
        return livro_id;
    }
    public void setLivro_id(Long livro_id) {
        this.livro_id = livro_id;
    }

}
