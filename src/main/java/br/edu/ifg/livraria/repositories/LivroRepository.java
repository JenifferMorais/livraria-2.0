package br.edu.ifg.livraria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifg.livraria.domain.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
