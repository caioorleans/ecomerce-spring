package ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ecommerce.dto.CategoriaDto;
import ecommerce.exceptionHandler.Exceptions.CategoriaNotFoundException;
import ecommerce.model.Categoria;
import ecommerce.repository.CategoriaRepository;
import ecommerce.service.categoria.CategoriaService;
import jakarta.validation.ConstraintViolationException;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTests {
	
	@Mock
	CategoriaRepository repository;
	
	@InjectMocks
	CategoriaService categoriaService;
	
	@Test
	public void saveShouldReturnCorrectCategoriaDto() {
		var categoria = new Categoria();
		categoria.setId(1);
		categoria.setDescricao("Terror");
		
		when(repository.save(any(Categoria.class))).thenReturn(categoria);
		
		assertEquals(categoriaService.save("Terror").getId(), categoria.getId());
		assertEquals(categoriaService.save("Terror").getDescricao(), categoria.getDescricao());
	}
	
	@Test
	public void existingIdShouldReturnCategoriaDto() {
		var categoria = new Categoria();
		categoria.setId(1);
		categoria.setDescricao("Terror");
		
		Optional<Categoria> c = Optional.of(categoria);
		
		when(repository.findById(any(Integer.class))).thenReturn(c);
		
		assertEquals(categoriaService.getById(1).getId(), categoria.getId());
		assertEquals(categoriaService.getById(1).getDescricao(), categoria.getDescricao());
	}
	
	@Test
	public void inexistingIdShouldThrowException() {
		Optional<Categoria> c = Optional.empty();
		when(repository.findById(any(Integer.class))).thenReturn(c);
		assertThrows(CategoriaNotFoundException.class, () -> categoriaService.getById(1));
	}
	
	@Test
	public void updatingInexistingCategoriaShouldThrowException() {
		var categoriaDto = new CategoriaDto();
		categoriaDto.setId(1);
		categoriaDto.setDescricao("Terror");
		when(repository.existsById(any(Integer.class))).thenReturn(false);
		assertThrows(CategoriaNotFoundException.class, () -> categoriaService.update(categoriaDto));
	}
	
	@Test
	public void deleteInexistingCategoriaShouldThrowException() {
		when(repository.existsById(any(Integer.class))).thenReturn(false);
		assertThrows(CategoriaNotFoundException.class, () -> categoriaService.delete(1));
	}
	
	@Test
	public void deleteExistingCategoriaShouldReturnTrue() {
		when(repository.existsById(any(Integer.class))).thenReturn(true);
		assertEquals(categoriaService.delete(1),true);
	}

}
