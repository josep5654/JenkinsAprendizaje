package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port;

import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;

import java.util.List;

public interface FindAllTiendaPort {
    List<Tienda> findAll() throws Exception;
}
