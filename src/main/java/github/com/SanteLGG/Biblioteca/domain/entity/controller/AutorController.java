package github.com.SanteLGG.Biblioteca.domain.entity.controller;

import github.com.SanteLGG.Biblioteca.domain.entity.Autor;
import github.com.SanteLGG.Biblioteca.domain.entity.Livro;
import github.com.SanteLGG.Biblioteca.domain.entity.repository.AutorRepository;
import github.com.SanteLGG.Biblioteca.domain.entity.repository.LivroRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping//Listar os autores cadastrados no banco de dados
    public List<Autor> listar(){
        return autorRepository.findAll();
    }

    @GetMapping("/{id}") //Listar os autores cadastrados no banco de dados pelo ID
    public ResponseEntity<Autor> buscarPeloId(@PathVariable Long id){
        if(autorRepository != null){

            return ResponseEntity.of(autorRepository.findById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping//cadastrar autor
    public ResponseEntity<Autor> salvarAutor(@RequestBody Autor autor){
        Autor autorSalvo = autorRepository.save(autor);

        return ResponseEntity.ok(autorSalvo);
    }

    @DeleteMapping("/deletar/{id}")//deletar autor
    public ResponseEntity<Autor> deletarAutor(@PathVariable Long id){
        if(autorRepository.existsById(id)){
            autorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
