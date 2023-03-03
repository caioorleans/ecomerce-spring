package ecommerce.dto.produto;

import java.util.Set;

import ecommerce.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor
@Getter @Setter
public class NovoProdutoDto {
	
	@NotBlank(message="Descrição é obrigatória")
	private String descricao;
	
	@NotNull(message="Preço é obrigatório")
	private Double preco;
	
	@NotNull(message="Quantidade em estoque é obrigatória")
	private Integer estoque;
	
	private Set<Integer> idCategorias;
}
