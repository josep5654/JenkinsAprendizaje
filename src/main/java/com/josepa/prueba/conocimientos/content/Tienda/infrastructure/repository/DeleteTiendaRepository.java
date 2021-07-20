
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.jpa.TiendaRepositoryJpa;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.DeleteTiendaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DeleteTiendaRepository implements DeleteTiendaPort {
  private TiendaRepositoryJpa tiendaRepositoryJpa;

  @Override
  public void deleteById(Integer idTienda) {

    tiendaRepositoryJpa.deleteById(idTienda);
  }
}
