
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller;


import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.output.SimpleTiendaOutputDTO;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.output.TiendaOutputDTO;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.FindTiendaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Api(tags = "Tienda", description = "Tienda endpoints")
@RequestMapping("tiendas")
public class FindTiendaController {

  private FindTiendaPort findTiendaPort;

  @GetMapping("{idTienda}")
  @Transactional(rollbackFor = Exception.class, readOnly = true)
  public SimpleTiendaOutputDTO findById(@PathVariable("idTienda") Integer idTienda)
      throws Exception {
    Tienda tiendaOutPut = findTiendaPort.findById(idTienda);
    return new TiendaOutputDTO(tiendaOutPut);
  }
}

