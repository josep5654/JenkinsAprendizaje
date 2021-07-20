
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.output;


import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SimpleTiendaOutputDTO implements Serializable {
  protected Integer idTienda;
  protected String nombre;
  protected String direccion;




  public SimpleTiendaOutputDTO(Tienda tienda) {

    this.setIdTienda(tienda.getIdTienda());
    this.setNombre(tienda.getNombre());
    this.setDireccion(tienda.getDireccion());
  }
}

