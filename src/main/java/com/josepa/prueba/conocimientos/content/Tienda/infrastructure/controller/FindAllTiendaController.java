
package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller;


import com.josepa.prueba.conocimientos.configs.PagedListDTO;
import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.output.SimpleTiendaOutputDTO;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.FindAllTiendaPort;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
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
public class FindAllTiendaController {

  private FindAllTiendaPort findAllTiendaPort;

  @GetMapping()
  @Transactional(rollbackFor = Exception.class, readOnly = true)
  public PagedListDTO<SimpleTiendaOutputDTO> findAll(@RequestParam(name = "page", defaultValue = "0") int page,
                                                     @RequestParam(name = "size", defaultValue = "10") int size) throws Exception {

    List<Tienda> tiendaList = findAllTiendaPort.findAll();
    List<SimpleTiendaOutputDTO> tiendaListOutput = tiendaList.stream().map(SimpleTiendaOutputDTO::new).collect(Collectors.toList());

    return new PagedListDTO(tiendaListOutput,size,page);
  }
}

