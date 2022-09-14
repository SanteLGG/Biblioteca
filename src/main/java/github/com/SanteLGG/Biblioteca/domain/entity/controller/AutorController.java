package github.com.SanteLGG.Biblioteca.domain.entity.controller;

import github.com.SanteLGG.Biblioteca.domain.entity.Autor;
import github.com.SanteLGG.Biblioteca.domain.entity.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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

    @PutMapping("/atualizar/{id}") //atualizar dados no bancos e dados
    @ResponseBody
    public ResponseEntity atualizarAutor(@PathVariable Long id, @RequestBody Autor autor){
        return autorRepository.findById(id).map(autorExistente -> {
            autor.setId(autorExistente.getId());
            autorRepository.save(autor);
            return ResponseEntity.ok().build();
           }).orElseGet( () -> ResponseEntity.notFound().build());
    }

    @GetMapping("/filtros") //buscar autores por propriedades
    public ResponseEntity find(Autor filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);

        List<Autor> lista = autorRepository.findAll(example);
        return ResponseEntity.ok(lista);
    }

}
