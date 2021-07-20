
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller;

import com.josepa.prueba.conocimientos.configs.PagedListDTO;
import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import com.josepa.prueba.conocimientos.content.Tienda.domain.noDatabase.SearchTienda;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.input.SearchTiendaInputDto;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.output.SimpleTiendaOutputDTO;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.output.TiendaOutputDTO;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.SearchTiendaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@Api(tags = "Tienda", description = "Tienda endpoints")
@RequestMapping("tiendas")
public class SearchTiendaController {

  private SearchTiendaPort searchTiendaPort;

  @GetMapping("search")
  @Transactional(rollbackFor = Exception.class)

  public PagedListDTO<SimpleTiendaOutputDTO> search(
      SearchTiendaInputDto searchTiendaInputDto,
      @RequestParam(name = "page", defaultValue = "0") int page,
      @RequestParam(name = "size", defaultValue = "10") int size) {
    SearchTienda searchTienda =
        searchTiendaInputDto.searchTienda();
    Page<Tienda> tienda =
        searchTiendaPort.search(searchTienda, page, size);
    List<SimpleTiendaOutputDTO> tagsOutputDTOS =
        tienda.getContent().stream()
            .map(tiendas -> new TiendaOutputDTO(tiendas))
            .collect(Collectors.toList());
    return new PagedListDTO(
        tagsOutputDTOS,
        tienda.getTotalElements(),
        tienda.getTotalPages());
  }
}

