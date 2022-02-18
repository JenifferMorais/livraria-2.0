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

import br.edu.ifg.bookstore.domain.models.Category;
import br.edu.ifg.bookstore.repositories.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryContoller {

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping
	public List<Category> list() {
		return categoryRepository.findAll();
	}

	@GetMapping("/{id}")
	public Category show(@PathVariable Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@PostMapping
	public Category create(@RequestBody Category category) {
		return categoryRepository.save(category);
	}

	@PutMapping("/{id}")
	public Category update(@PathVariable Long id, @RequestBody Category category) {

		Category findCategory = categoryRepository.findById(id).orElse(null);

		if (findCategory != null) {
			BeanUtils.copyProperties(category, findCategory, "id");
			return categoryRepository.save(findCategory);
		}
		return null;

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Category findCategory = categoryRepository.findById(id).orElse(null);
		
		if(findCategory != null) {
			categoryRepository.delete(findCategory);
		}
	}

}
