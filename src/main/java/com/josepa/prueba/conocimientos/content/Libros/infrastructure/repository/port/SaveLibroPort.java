
package com.josepa.prueba.conocimientos.content.Libros.infrastructure.repository.port;


import com.josepa.prueba.conocimientos.content.Libros.domain.Libro;

public interface SaveLibroPort {
    Libro save(Libro libro) throws Exception;
}

