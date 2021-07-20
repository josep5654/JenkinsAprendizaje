
package com.josepa.prueba.conocimientos.content.Libros.infrastructure.repository;

import com.josepa.prueba.conocimientos.content.Libros.domain.Libro;
import com.josepa.prueba.conocimientos.content.Libros.domain.LibroJpa;
import com.josepa.prueba.conocimientos.content.Libros.infrastructure.repository.jpa.LibroRepositoryJpa;
import com.josepa.prueba.conocimientos.content.Libros.infrastructure.repository.port.SaveLibroPort;
import com.josepa.prueba.conocimientos.content.Tienda.domain.TiendaJpa;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.FindTiendaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SaveLibroRepository implements SaveLibroPort {

  private LibroRepositoryJpa libroRepositoryJpa;
  private FindTiendaPort tiendaPort;

  @Override
  public Libro save(Libro libro) throws Exception {
    TiendaJpa tiendaJpa = new TiendaJpa(tiendaPort.findById(libro.getIdTienda()));

    LibroJpa libroJpa = new LibroJpa(libro);
    libroJpa.setTiendaJpa(tiendaJpa);
    libroRepositoryJpa.save(libroJpa);

    return new Libro(libroJpa);
  }
}

