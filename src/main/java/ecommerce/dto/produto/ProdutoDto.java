package ecommerce.dto.produto;

import java.util.Set;

import ecommerce.dto.CategoriaDto;
import ecommerce.model.Produto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor
@Getter @Setter
public class ProdutoDto {
	
	private Integer id;
	
	@NotBlank(message="Descrição é obrigatória")
	private String descricao;
	
	@NotNull(message="Preço é obrigatório")
	private Double preco;
	
	@NotNull(message="Quantidade em estoque é obrigatória")
	private Integer estoque;
	
	@NotEmpty
	private Set<@Valid CategoriaDto> categorias;
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.estoque = produto.getEstoque();
		produto.getCategorias().forEach(categoria -> this.categorias.add(new CategoriaDto(categoria)));
	}
	
}
