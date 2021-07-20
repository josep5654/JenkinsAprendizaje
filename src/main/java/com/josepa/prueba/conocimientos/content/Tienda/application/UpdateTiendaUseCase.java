package com.josepa.prueba.conocimientos.content.Tienda.application;

import com.josepa.prueba.conocimientos.content.Tienda.application.port.UpdateTiendaPort;
import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.FindTiendaPort;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.SaveTiendaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateTiendaUseCase implements UpdateTiendaPort {

  private SaveTiendaPort saveTiendaPort;
  private FindTiendaPort findTiendaPort;

  @Override
  public Tienda update(Integer idTienda, Tienda tienda) throws Exception {
    Tienda newTienda = findTiendaPort.findById(idTienda);

    newTienda.update(tienda);

    return saveTiendaPort.save(newTienda);
  }
}
