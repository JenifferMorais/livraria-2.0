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

import br.edu.ifg.livraria.repositories.UsuarioRepository;
import br.edu.ifg.livraria.domain.models.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> list(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario show(@PathVariable Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	@PostMapping
	public Usuario create(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
	@PutMapping("/{id}")
	public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
		Usuario findUser = usuarioRepository.findById(id).orElse(null);
		
		if(findUser!=null) {
			BeanUtils.copyProperties(usuario, findUser, "id");
			return usuarioRepository.save(findUser);
		}
		return null;
	}
	

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		Usuario findUser = usuarioRepository.findById(id).orElse(null);
		
		if(findUser!=null) {
			usuarioRepository.delete(findUser);
		}
	}
}
