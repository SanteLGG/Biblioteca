package github.com.SanteLGG.Biblioteca.domain.entity;

import com.sun.istack.NotNull;
import org.springframework.data.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "autor", schema = "biblioteca")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    //getter and setters
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
