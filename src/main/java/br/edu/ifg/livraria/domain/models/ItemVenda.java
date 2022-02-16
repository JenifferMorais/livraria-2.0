package br.edu.ifg.livraria.domain.models;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ItemVenda {
	private long livro_id;
	private long venda_id;
	private int quantidade;
	private double valor_unitario;
}
