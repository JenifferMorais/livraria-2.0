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

import br.edu.ifg.bookstore.domain.models.Sale;
import br.edu.ifg.bookstore.repositories.CheckOutRepository;

@RestController
@RequestMapping("/checkout")
public class CheckOut {
	@Autowired
	private CheckOutRepository checkOutRepository;
	
	
	@GetMapping
	public List<Sale> list(Sale venda){
		return checkOutRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Sale show (@PathVariable Long id) {
		return checkOutRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
	public Sale update(@PathVariable Long id, @RequestBody Sale venda ) {
		Sale findVenda = checkOutRepository.findById(id).orElse(null);
		
		if(findVenda!=null) {
			BeanUtils.copyProperties(venda, findVenda, "id");
			return checkOutRepository.save(findVenda);
		}
		return null;
	}
	
	@PostMapping
	public Sale create(@RequestBody Sale venda) {
		return checkOutRepository.save(venda);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Sale findVenda = checkOutRepository.findById(id).orElse(null);
		
		if(findVenda != null) {
			checkOutRepository.delete(findVenda);
		}
	}

}
