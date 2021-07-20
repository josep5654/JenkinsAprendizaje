
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.jpa;


import com.josepa.prueba.conocimientos.content.Tienda.domain.TiendaJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaRepositoryJpa extends JpaRepository<TiendaJpa, Integer> {
}

