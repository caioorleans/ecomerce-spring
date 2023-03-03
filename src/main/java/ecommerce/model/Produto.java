package ecommerce.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Double preco;
	
	@Column(nullable = false)
	private Integer estoque;
	
	@ManyToMany(mappedBy="produtos")
	private Set<Categoria> categorias;
}
