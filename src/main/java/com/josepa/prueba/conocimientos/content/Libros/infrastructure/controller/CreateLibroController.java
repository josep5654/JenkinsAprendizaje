
package com.josepa.prueba.conocimientos.content.Libros.infrastructure.controller;


import com.josepa.prueba.conocimientos.content.Libros.application.port.CreateLibroPort;
import com.josepa.prueba.conocimientos.content.Libros.domain.Libro;
import com.josepa.prueba.conocimientos.content.Libros.infrastructure.controller.dto.input.LibrosInputDTO;
import com.josepa.prueba.conocimientos.content.Libros.infrastructure.controller.dto.output.LibroOutputDTO;
import com.josepa.prueba.conocimientos.content.Libros.infrastructure.controller.dto.output.SimpleLibroOutputDTO;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@Api(tags = "Libro", description = "Libro endpoints")
@RequestMapping("tiendas")
public class CreateLibroController {

  private CreateLibroPort createLibroPort;


  @PostMapping("{idTienda}/libros")
  public SimpleLibroOutputDTO create(@PathVariable Integer idTienda, @RequestBody LibrosInputDTO librosInputDTO)  throws Exception {
    Libro libro = librosInputDTO.tienda(new Libro());
    libro.setIdTienda(idTienda);
    Libro createLibro = createLibroPort.create(libro);

    return new LibroOutputDTO(createLibro);

  }
}

