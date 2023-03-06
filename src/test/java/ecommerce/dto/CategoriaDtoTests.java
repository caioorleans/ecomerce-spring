package ecommerce.dto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@SpringBootTest
public class CategoriaDtoTests {
	private static Validator validator;

    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
	@Test
	public void nullCategoriaShouldFailValidation() {
		var categoriaDto = new CategoriaDto();
		Set<ConstraintViolation<CategoriaDto>> violations = validator.validate(categoriaDto);
        assertFalse(violations.isEmpty());
	}
	
	@Test
	public void blankCategoriaShouldFailValidation() {
		var categoriaDto = new CategoriaDto();
		categoriaDto.setDescricao("");
		Set<ConstraintViolation<CategoriaDto>> violations = validator.validate(categoriaDto);
        assertFalse(violations.isEmpty());
	}
	
	@Test
	public void validCategoriaShouldAssertValidation() {
		var categoriaDto = new CategoriaDto();
		categoriaDto.setDescricao("Terror");
		Set<ConstraintViolation<CategoriaDto>> violations = validator.validate(categoriaDto);
        assertTrue(violations.isEmpty());
	}
	
}
