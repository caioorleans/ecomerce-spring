package ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
