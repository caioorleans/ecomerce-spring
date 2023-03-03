package ecommerce.dto;

import java.util.Set;

import ecommerce.model.Categoria;
import ecommerce.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor
@Getter @Setter
public class ProdutoDto {
	
	private Integer id;
	private String descricao;
	private Double preco;
	private Integer estoque;
	private Set<Categoria> categorias;
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.estoque = produto.getEstoque();
		produto.getCategorias().forEach(categoria -> this.categorias.add(categoria));
	}
	
}
