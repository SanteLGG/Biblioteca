package github.com.SanteLGG.Biblioteca.domain.entity.controller;

import github.com.SanteLGG.Biblioteca.domain.entity.Autor;
import github.com.SanteLGG.Biblioteca.domain.entity.Editora;
import github.com.SanteLGG.Biblioteca.domain.entity.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
