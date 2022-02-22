package br.edu.ifg.bookstore.domain.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="books")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//Pojo - minha classe com meus atributos e métodos acessores
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Especifica um valor que é gerado. Strategy: estrategia de como o valor será criado
	@EqualsAndHashCode.Include
	private long id;
	private String nome;
	private String autor;
	private BigDecimal valor;
	private String ISBN;
	private String descricao;
	private String imagem;
	private transient int quantidade;
	@ManyToOne
	@JsonIgnoreProperties("books")
	private Category category;
	
}
