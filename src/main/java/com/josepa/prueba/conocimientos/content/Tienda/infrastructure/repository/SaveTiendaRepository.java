
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository;

import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import com.josepa.prueba.conocimientos.content.Tienda.domain.TiendaJpa;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.jpa.TiendaRepositoryJpa;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.SaveTiendaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SaveTiendaRepository implements SaveTiendaPort {

  private TiendaRepositoryJpa tiendaRepositoryJpa;

  @Override
  public Tienda save(Tienda tienda) throws Exception {
    TiendaJpa tiendaJpa = new TiendaJpa(tienda);
    tiendaRepositoryJpa.save(tiendaJpa);
    return new Tienda(tiendaJpa);
  }
}

