
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller;


import com.josepa.prueba.conocimientos.content.Tienda.application.port.UpdateTiendaPort;
import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.input.TiendaInputDTO;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.output.SimpleTiendaOutputDTO;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.FindTiendaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Api(tags = "Tienda", description = "Tienda endpoints")
@RequestMapping("tiendas")
public class UpdateTiendaController {

  private UpdateTiendaPort updateTiendaPort;
  private FindTiendaPort findTiendaPort;

  @PutMapping("{idTienda}")

  public SimpleTiendaOutputDTO update(
      @PathVariable("idTienda") Integer idTienda,
      @RequestBody TiendaInputDTO tiendaInputDTO)
      throws Exception {

    Tienda tiendaUpdate = new Tienda(tiendaInputDTO);

    Tienda actualTienda = findTiendaPort.findById(idTienda);
    Tienda updateTienda = updateTiendaPort.update(actualTienda.getIdTienda(), tiendaUpdate);
    return new SimpleTiendaOutputDTO(updateTienda);
  }
}

