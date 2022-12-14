package github.com.SanteLGG.Biblioteca.domain.controller;

import github.com.SanteLGG.Biblioteca.domain.entity.Editora;
import github.com.SanteLGG.Biblioteca.domain.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @GetMapping//Listar as editoras cadastradas no banco de dados
    private List<Editora> listar(){
        return editoraRepository.findAll();
    }

    @GetMapping("/{id}") //Listar as editoras cadastradas no banco de dados pelo ID
    public ResponseEntity<Editora> buscarPeloID(@PathVariable Long id){
        if(editoraRepository != null){
            return ResponseEntity.of(editoraRepository.findById(id));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping//cadastrar editora
    public ResponseEntity<Editora> salvarEditora (@RequestBody Editora editora){
        Editora editoraSalva = editoraRepository.save(editora);

        return ResponseEntity.ok(editoraSalva);
    }

    @DeleteMapping("/deletar/{id}")//deletar Editora
    public ResponseEntity<Editora> deletarEditora(@PathVariable Long id){
        if(editoraRepository.existsById(id)){
            editoraRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/atualizar/{id}") //atualizar dados no bancos e dados
    public ResponseEntity atualizarAutor(@PathVariable Long id, @RequestBody Editora editora){
        return editoraRepository.findById(id).map(autorExistente -> {
            editora.setId(autorExistente.getId());
            editoraRepository.save(editora);
            return ResponseEntity.ok().build();
        }).orElseGet( () -> ResponseEntity.notFound().build());
    }
}
