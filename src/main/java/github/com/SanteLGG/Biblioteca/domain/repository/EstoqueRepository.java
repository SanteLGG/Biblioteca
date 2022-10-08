package github.com.SanteLGG.Biblioteca.domain.repository;

import github.com.SanteLGG.Biblioteca.domain.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
