package github.com.SanteLGG.Biblioteca.domain.entity.controller;

import github.com.SanteLGG.Biblioteca.domain.entity.Autor;
import github.com.SanteLGG.Biblioteca.domain.entity.Livro;
import github.com.SanteLGG.Biblioteca.domain.entity.repository.AutorRepository;
import github.com.SanteLGG.Biblioteca.domain.entity.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping//Listar os livros cadastrados no banco de dados
    public List<Livro> listar(){
        return livroRepository.findAll();
    }

    @GetMapping("/{id}") //Listar os Livros cadastrados no banco de dados pelo ID
    public ResponseEntity<Livro> buscarPeloId(@PathVariable Long id){
        if(livroRepository != null){
            return ResponseEntity.of(livroRepository.findById(id));
        }
        return ResponseEntity.notFound().build();
    }


}
