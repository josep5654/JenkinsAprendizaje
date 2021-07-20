
package com.josepa.prueba.conocimientos.content.Libros.application.port;


import com.josepa.prueba.conocimientos.content.Libros.domain.Libro;

public interface CreateLibroPort {
    Libro create(Libro Libro) throws Exception;
}
