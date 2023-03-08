package ecommerce.service.categoria;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import ecommerce.dto.CategoriaDto;
import ecommerce.exceptionHandler.Exceptions.CategoriaNotFoundException;
import ecommerce.model.Categoria;
import ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService{
	
	private final CategoriaRepository repository;
	
	public CategoriaService(CategoriaRepository repository) {
		this.repository = repository;
	}

	@Override
	public CategoriaDto save(String descricao) {
		var novaCategoria = new Categoria();
		novaCategoria.setDescricao(descricao);
		novaCategoria = repository.save(novaCategoria);
		return new CategoriaDto(novaCategoria);
		
	}

	@Override
	public CategoriaDto getById(Integer id) {
		var categoria = repository.findById(id).orElseThrow(() -> new CategoriaNotFoundException());
		return new CategoriaDto(categoria);
	}

	@Override
	public Set<CategoriaDto> findAll() {
		List<Categoria> categorias = repository.findAll();
		Set<CategoriaDto> categoriasDto = new HashSet<CategoriaDto>();
		categorias.forEach((categoria) -> categoriasDto.add(new CategoriaDto(categoria)));
		return categoriasDto;
	}

	@Override
	public CategoriaDto update(CategoriaDto categoriaDto) {
		if(repository.existsById(categoriaDto.getId())) {
			return new CategoriaDto(repository.save(new Categoria(categoriaDto)));
		}
		throw new CategoriaNotFoundException();
	}

	@Override
	public boolean delete(Integer id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		throw new CategoriaNotFoundException();
	}

}
