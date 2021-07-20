package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository;


import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import com.josepa.prueba.conocimientos.content.Tienda.domain.TiendaJpa;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.jpa.TiendaRepositoryJpa;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.FindAllTiendaPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class FindAllTiendasRepository implements FindAllTiendaPort{

    TiendaRepositoryJpa tiendaRepositoryJpa;

    @Override
    public List<Tienda> findAll() throws Exception {

        List<TiendaJpa> tiendas = new ArrayList<>();
        tiendas = tiendaRepositoryJpa.findAll();
        List<Tienda> tiendaList = new ArrayList<>();
        tiendaList = tiendas.stream().map(Tienda::new).collect(Collectors.toList());

        return tiendaList;
    }
}




