package github.com.SanteLGG.Biblioteca.domain.entity.controller;

import github.com.SanteLGG.Biblioteca.domain.entity.Autor;
import github.com.SanteLGG.Biblioteca.domain.entity.repository.AutorRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Autor> buscarPeloCodigo(@PathVariable Long id){
        if(autorRepository != null){
            return ResponseEntity.of(autorRepository.findById(id));
        }
        return ResponseEntity.notFound().build();
    }


}
