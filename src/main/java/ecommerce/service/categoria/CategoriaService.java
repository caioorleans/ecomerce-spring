package ecommerce.service.categoria;

import java.util.Set;

import org.springframework.stereotype.Service;

import ecommerce.dto.CategoriaDto;
import ecommerce.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService{
	
	private final CategoriaRepository repository;
	
	public CategoriaService(CategoriaRepository repository) {
		this.repository = repository;
	}

	@Override
	public CategoriaDto save(CategoriaDto categoriaDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaDto getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<CategoriaDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaDto update(CategoriaDto categoriaDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
