package ecommerce.model;

import java.util.Set;

import ecommerce.dto.CategoriaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Categoria {
	
	public Categoria(CategoriaDto categoriaDto) {
		this.id = categoriaDto.getId();
		this.descricao = categoriaDto.getDescricao();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable=false, unique=true)
	private String descricao;
	
	@ManyToMany
	@JoinTable(name = "caterogia_produto", joinColumns = @JoinColumn(name = "categoria_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private Set<Produto> produtos;
}
