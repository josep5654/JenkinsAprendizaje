
package com.josepa.prueba.conocimientos.content.Tienda.application.port;


import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;

public interface CreateTiendaPort {
    Tienda create(Tienda Tienda) throws Exception;
}
