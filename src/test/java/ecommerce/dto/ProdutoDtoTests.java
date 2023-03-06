package ecommerce.dto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ecommerce.dto.produto.ProdutoDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ProdutoDtoTests {
	private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
    public void nullAttributesShouldFailValidation() {
    	var produto = new ProdutoDto();
    	Set<ConstraintViolation<ProdutoDto>> violations = validator.validate(produto);
    	assertFalse(violations.isEmpty());
    }
    
    @Test
    public void categoriaNotValidOfCategoriasShouldFailValidation() {
    	var produto = new ProdutoDto();
    	produto.setDescricao("PC Gamer");
    	produto.setPreco(2000.99);
    	produto.setEstoque(100);
    	
    	var categoria = new CategoriaDto();
    	Set<CategoriaDto> categorias = new HashSet<CategoriaDto>();
    	categorias.add(categoria);
    	produto.setCategorias(categorias);
    	
    	Set<ConstraintViolation<ProdutoDto>> violations = validator.validate(produto);
    	assertFalse(violations.isEmpty());
    }
    
    @Test
    public void allValidAttributesShouldaAssertValidation() {
    	var produto = new ProdutoDto();
    	produto.setDescricao("PC Gamer");
    	produto.setPreco(2000.99);
    	produto.setEstoque(100);
    	
    	var categoria = new CategoriaDto();
    	categoria.setDescricao("Gamer");
    	Set<CategoriaDto> categorias = new HashSet<CategoriaDto>();
    	categorias.add(categoria);
    	produto.setCategorias(categorias);
    	
    	Set<ConstraintViolation<ProdutoDto>> violations = validator.validate(produto);
    	assertTrue(violations.isEmpty());
    }
    
}
