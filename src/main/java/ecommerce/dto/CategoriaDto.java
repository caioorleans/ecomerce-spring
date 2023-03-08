package ecommerce.dto;

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
public class CategoriaDto {
	
	@NotNull
	private Integer id;
	
	@NotBlank(message="Descrição é obrigatória")
	private String descricao;
	
	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.descricao = categoria.getDescricao();
	}
}
