package github.com.SanteLGG.Biblioteca.domain.repository;

import github.com.SanteLGG.Biblioteca.domain.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
