package br.edu.ifg.bookstore.domain.models;



import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaleItem {
	private long livro_id;
	private long venda_id;
	private int quantidade;
	private double valor_unitario;
}
