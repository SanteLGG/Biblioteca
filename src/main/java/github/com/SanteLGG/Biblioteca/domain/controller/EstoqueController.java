package github.com.SanteLGG.Biblioteca.domain.controller;

import github.com.SanteLGG.Biblioteca.domain.entity.Autor;
import github.com.SanteLGG.Biblioteca.domain.entity.Estoque;
import github.com.SanteLGG.Biblioteca.domain.entity.Livro;
import github.com.SanteLGG.Biblioteca.domain.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping//Listar as quantidades cadastradas no sistema
    public List<Estoque> listar(){
        return estoqueRepository.findAll();
    }

    @GetMapping("/{id}") //Listar as quantidades cadastrados no banco de dados pelo ID
    public ResponseEntity<Estoque> buscarPeloId(@PathVariable Long id){
        if(estoqueRepository != null){

            return ResponseEntity.of(estoqueRepository.findById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping//cadastrar no estoque
    public ResponseEntity<Estoque> salvarEstoque(@RequestBody Estoque estoque){
        Estoque estoqueSalvo = estoqueRepository.save(estoque);

        return ResponseEntity.status(HttpStatus.CREATED).body(estoqueSalvo);
    }

    @DeleteMapping("/deletar/{id}")//deletar estoque
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarEstoque(@PathVariable Long id){
        estoqueRepository.deleteById(id);
    }

    @PutMapping("/atualizar/{id}") //atualizar dados no bancos e dados
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarEstoque(@PathVariable Long id, @RequestBody Estoque estoque){
        estoqueRepository.findById(id).map(estoqueExistente -> {
            estoque.setId(estoqueExistente.getId());
            estoqueRepository.save(estoque);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/filtros") //buscar editoras por propriedades
    public ResponseEntity find(Estoque filtro) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);

        List<Estoque> lista = estoqueRepository.findAll(example);
        return ResponseEntity.ok(lista);
    }
}
