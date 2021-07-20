
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port;


import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import com.josepa.prueba.conocimientos.content.Tienda.domain.noDatabase.SearchTienda;
import org.springframework.data.domain.Page;

public interface SearchTiendaPort {

    Page<Tienda> search(SearchTienda searchTags, int page, int size);

}

