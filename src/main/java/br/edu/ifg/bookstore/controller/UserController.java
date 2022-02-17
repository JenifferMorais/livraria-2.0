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

import br.edu.ifg.bookstore.domain.models.User;
import br.edu.ifg.bookstore.repositories.UserRepository;

@RestController
@RequestMapping("/usuarios")
public class UserController {
	@Autowired
	private UserRepository usuarioRepository;
	
	@GetMapping
	public List<User> list(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public User show(@PathVariable Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	@PostMapping
	public User create(@RequestBody User usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
	@PutMapping("/{id}")
	public User update(@PathVariable Long id, @RequestBody User usuario) {
		User findUser = usuarioRepository.findById(id).orElse(null);
		
		if(findUser!=null) {
			BeanUtils.copyProperties(usuario, findUser, "id");
			return usuarioRepository.save(findUser);
		}
		return null;
	}
	

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		User findUser = usuarioRepository.findById(id).orElse(null);
		
		if(findUser!=null) {
			usuarioRepository.delete(findUser);
		}
	}
}
