package br.edu.ifg.bookstore.domain.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="categories")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String descricao;
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	@JsonIgnoreProperties("category")
	private Set<Book> books; //Set não permite repetição
	
	
}
