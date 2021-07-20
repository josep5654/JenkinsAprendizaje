package com.josepa.prueba.conocimientos.content.Libros.infrastructure.controller.dto.input;

import com.josepa.prueba.conocimientos.content.Libros.domain.Libro;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class LibrosInputDTO {

  private String nombre;
  private Integer capitulos;
  private Double precio;

  public Libro tienda(Libro saveLibro) {
    if (saveLibro == null) return null;

    if (this.getNombre() != null)
      saveLibro.setNombre(this.getNombre());
    if (this.getCapitulos() != null)
      saveLibro.setCapitulos(this.getCapitulos());
    if (this.getPrecio() != null)
      saveLibro.setPrecio(this.getPrecio());



    return saveLibro;
  }
}
