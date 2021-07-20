
package com.josepa.prueba.conocimientos.content.Libros.infrastructure.controller.dto.output;


import com.josepa.prueba.conocimientos.content.Libros.domain.Libro;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.output.SimpleTiendaOutputDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LibroOutputDTO extends SimpleLibroOutputDTO implements Serializable {

  private SimpleTiendaOutputDTO tienda;




  public LibroOutputDTO(Libro libro) {

    super(libro);
    this.setTienda(new SimpleTiendaOutputDTO(libro.getTienda()));



  }
}

