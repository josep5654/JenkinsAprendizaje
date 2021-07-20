
package com.josepa.prueba.conocimientos.content.Libros.infrastructure.controller;

import com.josepa.prueba.conocimientos.configs.PagedListDTO;
import com.josepa.prueba.conocimientos.content.Libros.domain.Libro;
import com.josepa.prueba.conocimientos.content.Libros.domain.noDatabase.SearchLibro;
import com.josepa.prueba.conocimientos.content.Libros.infrastructure.controller.dto.input.SearchLibrosInputDto;
import com.josepa.prueba.conocimientos.content.Libros.infrastructure.controller.dto.output.LibroOutputDTO;
import com.josepa.prueba.conocimientos.content.Libros.infrastructure.controller.dto.output.SimpleLibroOutputDTO;
import com.josepa.prueba.conocimientos.content.Libros.infrastructure.repository.port.SearchLibroPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@Api(tags = "Libro", description = "Libro endpoints")
@RequestMapping("tiendas")
public class SearchLibroController {

  private SearchLibroPort searchLibroPort;

  @GetMapping("{idTienda}/libros")
  @Transactional(rollbackFor = Exception.class)

  public PagedListDTO<SimpleLibroOutputDTO> search(
      SearchLibrosInputDto searchLibrosInputDto,
      @PathVariable Integer idTienda,
      @RequestParam(name = "page", defaultValue = "0") int page,
      @RequestParam(name = "size", defaultValue = "10") int size) {
    SearchLibro searchLibro =
        searchLibrosInputDto.searchLibro();
    searchLibro.setIdTienda(idTienda);
    Page<Libro> libros =
        searchLibroPort.search(searchLibro, page, size);
    List<SimpleLibroOutputDTO> tagsOutputDTOS =
        libros.getContent().stream()
            .map(l -> new LibroOutputDTO(l))
            .collect(Collectors.toList());
    return new PagedListDTO(
        tagsOutputDTOS,
        libros.getTotalElements(),
        libros.getTotalPages());
  }
}

