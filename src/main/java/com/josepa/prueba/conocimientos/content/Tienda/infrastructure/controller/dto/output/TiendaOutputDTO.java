
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.output;


import com.josepa.prueba.conocimientos.content.Libros.infrastructure.controller.dto.output.SimpleLibroOutputDTO;
import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class TiendaOutputDTO extends SimpleTiendaOutputDTO implements Serializable {

  private List<SimpleLibroOutputDTO> libroList;

  public TiendaOutputDTO(Tienda tienda) {

    super(tienda);
    setLibroList(tienda.getLibroList().stream().map(SimpleLibroOutputDTO::new).collect(Collectors.toList()));



  }
}

