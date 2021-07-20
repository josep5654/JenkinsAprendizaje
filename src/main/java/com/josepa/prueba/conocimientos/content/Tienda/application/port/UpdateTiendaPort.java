
package com.josepa.prueba.conocimientos.content.Tienda.application.port;


import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;

public interface UpdateTiendaPort {
    Tienda update(Integer idPerson, Tienda tienda) throws Exception;
}
