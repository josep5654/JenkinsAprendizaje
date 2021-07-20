
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller;

import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.DeleteTiendaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Api(tags = "Tienda", description = "Tienda endpoints")
@RequestMapping("tiendas")
public class DeleteTiendaController {

  private DeleteTiendaPort deleteTagsPort;

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("{idTienda}")
  public void delete(@PathVariable("idTienda") Integer idTienda) {
    deleteTagsPort.deleteById(idTienda);
  }
}

