package github.com.SanteLGG.Biblioteca.service;

import github.com.SanteLGG.Biblioteca.model.Autor;
import github.com.SanteLGG.Biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    private AutorRepository repository;

    public AutorService(AutorRepository repository){
        this.repository = repository;
    }

    public void salvarAutor(Autor autor){
        validarAutor(autor);
        this.repository.persistir(autor);
    }

    public void validarAutor(Autor autor){
        //aplica validações
    }


}
