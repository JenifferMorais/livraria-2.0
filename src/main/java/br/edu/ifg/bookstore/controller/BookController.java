package br.edu.ifg.bookstore.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifg.bookstore.domain.models.Book;
import br.edu.ifg.bookstore.repositories.BookRepository;


@RestController
@RequestMapping("/livros")
public class BookController {
	@Autowired
	private BookRepository livroRepository;
	
	@GetMapping
	public List<Book> list() {
		return livroRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Book show(@PathVariable Long id) {
		return livroRepository.findById(id).orElse(null);
	}
	
	@PostMapping
	public Book create(@RequestBody Book livro) {
		return livroRepository.save(livro);
	}
	
	@PutMapping("/{id}")
	public Book update(@PathVariable Long id, @RequestBody Book livro) {
		Book findBook = livroRepository.findById(id).orElse(null);
		
		if(findBook != null) {
			BeanUtils.copyProperties(livro, findBook, "id");
			return livroRepository.save(findBook);
		}
		return null;	
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Book findBook = livroRepository.findById(id).orElse(null);
		
		if(findBook != null) {
			livroRepository.delete(findBook);
		}
		
	}
	
}
