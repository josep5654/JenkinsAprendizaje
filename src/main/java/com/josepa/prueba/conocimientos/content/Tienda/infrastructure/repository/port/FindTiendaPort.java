
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port;


import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;

public interface FindTiendaPort {
    Tienda findById(Integer idTienda) throws Exception;
}
