package br.edu.ifg.livraria.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody -- Responsavel pelas respostas web
//@Component -- Para dizer que o spring é responsável por essa classe

@RestController //2 anotações em 1 kkk

@RequestMapping("/home") //caminho
public class Home {
	
	@GetMapping //Mapeando o metodo, informando que é do tipo get
	public String hello() {
		return "Hello World!";
	}
	
	@GetMapping("/{name}")
	public String hello(@PathVariable String name) {
		return "Olá "+ name + "!";
	}
	
	
	

}
