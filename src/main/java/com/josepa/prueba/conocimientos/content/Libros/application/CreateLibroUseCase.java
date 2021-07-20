package com.josepa.prueba.conocimientos.content.Libros.application;



import com.josepa.prueba.conocimientos.content.Libros.application.port.CreateLibroPort;
import com.josepa.prueba.conocimientos.content.Libros.domain.Libro;
import com.josepa.prueba.conocimientos.content.Libros.infrastructure.repository.port.SaveLibroPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateLibroUseCase implements CreateLibroPort {

  private SaveLibroPort saveLibroPort;

  @Override
  public Libro create(Libro libro) throws Exception {
    return saveLibroPort.save(libro);
  }
}
