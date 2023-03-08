package ecommerce.service.categoria;

import java.util.Set;

import ecommerce.dto.CategoriaDto;

public interface ICategoriaService {

	public CategoriaDto save(String descricao);
	
	public CategoriaDto getById(Integer id);
	
	public Set<CategoriaDto> findAll();
	
	public CategoriaDto update(CategoriaDto categoriaDto);
	
	public boolean delete(Integer id);
}
