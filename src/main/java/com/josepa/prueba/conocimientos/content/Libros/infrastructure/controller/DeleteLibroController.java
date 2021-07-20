
package com.josepa.prueba.conocimientos.content.Libros.infrastructure.controller;

import com.josepa.prueba.conocimientos.content.Libros.infrastructure.repository.port.DeleteLibroPort;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.FindTiendaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Api(tags = "Libro", description = "Libro endpoints")
@RequestMapping("tiendas")
public class DeleteLibroController {

  private DeleteLibroPort deleteLibroPort;
  private FindTiendaPort findTiendaPort;


  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("{idTienda}/libros/{idLibro}")
  public void delete(@PathVariable("idTienda") Integer idTienda, @PathVariable Integer idLibro) throws Exception {

    findTiendaPort.findById(idTienda);
    deleteLibroPort.deleteById(idLibro);
  }
}

