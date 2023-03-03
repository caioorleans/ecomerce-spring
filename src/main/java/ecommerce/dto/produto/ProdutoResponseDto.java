package ecommerce.dto.produto;

import java.util.Set;

import ecommerce.model.Categoria;
import ecommerce.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor
@Getter @Setter
public class ProdutoResponseDto {
	
	private Integer id;
	
	@NotBlank(message="Descrição é obrigatória")
	private String descricao;
	
	@NotNull(message="Preço é obrigatório")
	private Double preco;
	
	@NotNull(message="Quantidade em estoque é obrigatória")
	private Integer estoque;
	
	private Set<Categoria> categorias;
	
	public ProdutoResponseDto(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.estoque = produto.getEstoque();
		produto.getCategorias().forEach(categoria -> this.categorias.add(categoria));
	}
	
}
