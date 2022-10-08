package github.com.SanteLGG.Biblioteca.domain.controller;

import github.com.SanteLGG.Biblioteca.domain.entity.Autor;
import github.com.SanteLGG.Biblioteca.domain.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

        return ResponseEntity.status(HttpStatus.CREATED).body(autorSalvo);
    }

    @DeleteMapping("/deletar/{id}")//deletar autor
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAutor(@PathVariable Long id){
        autorRepository.deleteById(id);
    }

    @PutMapping("/atualizar/{id}") //atualizar dados no bancos e dados
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAutor(@PathVariable Long id, @RequestBody Autor autor){
        autorRepository.findById(id).map(autorExistente -> {
            autor.setId(autorExistente.getId());
            autorRepository.save(autor);
            return ResponseEntity.ok().build();
           }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
