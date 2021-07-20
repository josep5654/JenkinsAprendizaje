
package com.josepa.prueba.conocimientos.content.Libros.infrastructure.controller.dto.output;


import com.josepa.prueba.conocimientos.content.Libros.domain.Libro;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SimpleLibroOutputDTO implements Serializable {
  protected Integer idLibro;
  protected String nombre;
  protected Integer capitulos;
  private Double precio;
  private Integer idTienda;



  public SimpleLibroOutputDTO(Libro libro) {

    this.setIdLibro(libro.getIdLibro());
    this.setNombre(libro.getNombre());
    this.setCapitulos(libro.getCapitulos());
    this.setPrecio(libro.getPrecio());
    this.setIdTienda(libro.getIdTienda());
  }
}

