package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.input;

import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TiendaInputDTO {

  private String nombre;
  private String direccion;

  public Tienda tienda(Tienda saveTienda) {
    if (saveTienda == null) return null;

    if (this.getNombre() != null)
      saveTienda.setNombre(this.getNombre());
    if (this.getDireccion() != null)
      saveTienda.setDireccion(this.getDireccion());


    return saveTienda;
  }
}
