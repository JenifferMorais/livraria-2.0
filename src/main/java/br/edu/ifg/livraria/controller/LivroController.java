package br.edu.ifg.livraria.controller;

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

import br.edu.ifg.livraria.domain.models.Livro;
import br.edu.ifg.livraria.repositories.LivroRepository;


@RestController
@RequestMapping("/livros")
public class LivroController {
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping
	public List<Livro> list() {
		return livroRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Livro show(@PathVariable Long id) {
		return livroRepository.findById(id).orElse(null);
	}
	
	@PostMapping
	public Livro create(@RequestBody Livro livro) {
		
		return livroRepository.save(livro);
	}
	
	@PutMapping("/{id}")
	public Livro update(@PathVariable Long id, @RequestBody Livro livro) {
		Livro findBook = livroRepository.findById(id).orElse(null);
		
		if(findBook != null) {
			BeanUtils.copyProperties(livro, findBook, "id");
			return livroRepository.save(findBook);
		}
		return null;	
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Livro findBook = livroRepository.findById(id).orElse(null);
		
		if(findBook != null) {
			livroRepository.delete(findBook);
		}
		
	}
	
}
