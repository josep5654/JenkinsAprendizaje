
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller;


import com.josepa.prueba.conocimientos.content.Tienda.application.port.CreateTiendaPort;
import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.input.TiendaInputDTO;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.output.SimpleTiendaOutputDTO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Api(tags = "Tienda", description = "Tienda endpoints")
@RequestMapping("tiendas")
public class CreateTiendaController {

  private CreateTiendaPort createTiendaPort;

  @PostMapping
  public SimpleTiendaOutputDTO create( @RequestBody TiendaInputDTO tiendaInputDTO)  throws Exception {
    Tienda createTienda = createTiendaPort.create(tiendaInputDTO.tienda(new Tienda()));
    return new SimpleTiendaOutputDTO(createTienda);

  }
}

