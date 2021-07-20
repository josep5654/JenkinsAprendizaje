
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository;

import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import com.josepa.prueba.conocimientos.content.Tienda.domain.TiendaJpa;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.jpa.TiendaRepositoryJpa;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.FindTiendaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FindTiendaRepository implements FindTiendaPort {

  private TiendaRepositoryJpa tiendaRepositoryJpa;

  @Override
  public Tienda findById(Integer idTienda) throws Exception {
    TiendaJpa tiendaJpa =
        tiendaRepositoryJpa
            .findById(idTienda)
            .orElseThrow(
                () -> new Exception("Tienda no encontrada con id: " + idTienda));
    return new Tienda(tiendaJpa);
  }
}

