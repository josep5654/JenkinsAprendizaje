
package com.josepa.prueba.conocimientos.content.Libros.infrastructure.repository.port;


import com.josepa.prueba.conocimientos.content.Libros.domain.Libro;
import com.josepa.prueba.conocimientos.content.Libros.domain.noDatabase.SearchLibro;
import org.springframework.data.domain.Page;

public interface SearchLibroPort {

    Page<Libro> search(SearchLibro searchLibro, int page, int size);

}

