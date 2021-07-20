
package com.josepa.prueba.conocimientos.content.Tienda.domain;


import com.josepa.prueba.conocimientos.content.Libros.domain.Libro;
import com.josepa.prueba.conocimientos.content.Libros.domain.LibroJpa;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.input.TiendaInputDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Tienda {

  private Integer idTienda;

  private String nombre;
  private String direccion;

  //relaciones
  private List<Libro> libroList;





  private TiendaJpa tiendaJpa;
  public Tienda(TiendaJpa tiendaJpa) {
    if (tiendaJpa == null) return;
    this.tiendaJpa = tiendaJpa;



    this.setIdTienda(tiendaJpa.getIdTienda());
    this.setNombre(tiendaJpa.getNombre());
    this.setDireccion(tiendaJpa.getDireccion());
  }

  public Tienda(TiendaInputDTO  tiendaInputDTO) {

    if(tiendaInputDTO == null) return;

    if (tiendaInputDTO.getNombre() != null) this.setNombre(tiendaInputDTO.getNombre());
    if (tiendaInputDTO.getDireccion() != null) this.setDireccion(tiendaInputDTO.getDireccion());
  }
  public void update(Tienda updateTienda) {
    if(updateTienda.getNombre()!=null)
      this.setNombre(updateTienda.getNombre());
    if(updateTienda.getDireccion()!=null)
      this.setDireccion(updateTienda.getDireccion());
  }




  public List<Libro> getLibroList() {
    if (libroList != null && !libroList.isEmpty()) return libroList;
    if (tiendaJpa == null) return new ArrayList<>();
    List<LibroJpa> getLibros = tiendaJpa.getLibroJpa();
    if (getLibros == null) return new ArrayList<>();
    List<Libro> libros =
            getLibros.stream().map(Libro::new).collect(Collectors.toList());
    this.setLibroList(libros);
    return libroList;
  }
}
