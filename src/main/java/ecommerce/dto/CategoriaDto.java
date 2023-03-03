package ecommerce.dto;

import ecommerce.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor
@Getter @Setter
public class CategoriaDto {
	
	private Integer id;
	private String descricao;
	
	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.descricao = categoria.getDescricao();
	}
}
