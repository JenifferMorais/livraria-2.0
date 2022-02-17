package br.edu.ifg.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifg.bookstore.domain.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
