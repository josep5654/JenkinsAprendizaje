
package com.josepa.prueba.conocimientos.content.Libros.infrastructure.repository;
import com.josepa.prueba.conocimientos.content.Libros.infrastructure.repository.jpa.LibroRepositoryJpa;
import com.josepa.prueba.conocimientos.content.Libros.infrastructure.repository.port.DeleteLibroPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DeleteLibroRepository implements DeleteLibroPort {
  private LibroRepositoryJpa libroRepositoryJpa;

  @Override
  public void deleteById(Integer idLibro) {

    libroRepositoryJpa.deleteById(idLibro);
  }
}
