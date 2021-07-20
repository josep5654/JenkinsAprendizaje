
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port;



import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;

public interface SaveTiendaPort {
    Tienda save(Tienda tienda) throws Exception;
}

