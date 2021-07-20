
package com.josepa.prueba.conocimientos.content.Libros.infrastructure.repository.jpa;


import com.josepa.prueba.conocimientos.content.Libros.domain.LibroJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositoryJpa extends JpaRepository<LibroJpa, Integer> {
}

