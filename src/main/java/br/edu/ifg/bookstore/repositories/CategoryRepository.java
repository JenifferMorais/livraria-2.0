package br.edu.ifg.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifg.bookstore.domain.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
