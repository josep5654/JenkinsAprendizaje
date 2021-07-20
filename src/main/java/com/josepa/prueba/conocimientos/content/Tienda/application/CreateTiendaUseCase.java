package com.josepa.prueba.conocimientos.content.Tienda.application;



import com.josepa.prueba.conocimientos.content.Tienda.application.port.CreateTiendaPort;
import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.SaveTiendaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateTiendaUseCase implements CreateTiendaPort {

  private SaveTiendaPort saveTiendaPort;

  @Override
  public Tienda create(Tienda tienda) throws Exception {
    return saveTiendaPort.save(tienda);
  }
}
