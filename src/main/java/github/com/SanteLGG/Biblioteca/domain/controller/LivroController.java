package github.com.SanteLGG.Biblioteca.domain.controller;

import github.com.SanteLGG.Biblioteca.domain.entity.Livro;
import github.com.SanteLGG.Biblioteca.domain.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/cadastro")//cadastrar livro
    public ResponseEntity<Livro> salvarLivro (@RequestBody Livro livro){
        Livro livroSalvo = livroRepository.save(livro);

        return ResponseEntity.ok(livroSalvo);
    }

    @DeleteMapping("/deletar/{id}")//deletar Livros
    public ResponseEntity<Livro> deletarLivro(@PathVariable Long id){
        if(livroRepository.existsById(id)){
            livroRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/atualizar/{id}") //atualizar dados no bancos e dados
    public ResponseEntity atualizarLivro(@PathVariable Long id, @RequestBody Livro livro){
        return livroRepository.findById(id).map(livroExistente -> {
            livro.setId(livroExistente.getId());
            livroRepository.save(livro);
            return ResponseEntity.ok().build();
        }).orElseGet( () -> ResponseEntity.notFound().build());
    }

    @GetMapping("/filtros") //buscar editoras por propriedades
    public ResponseEntity find(Livro filtro){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);

        List<Livro> lista = livroRepository.findAll(example);
        return ResponseEntity.ok(lista);
    }
}
