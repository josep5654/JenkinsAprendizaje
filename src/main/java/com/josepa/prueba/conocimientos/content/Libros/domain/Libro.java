
package com.josepa.prueba.conocimientos.content.Libros.domain;


import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import com.josepa.prueba.conocimientos.content.Tienda.domain.TiendaJpa;
import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

  private Integer idLibro;

  private String nombre;
  private Integer capitulos;
  private Double precio;


  //relaciones
  private Tienda tienda;
  private Integer idTienda;





  private LibroJpa libroJpa;

  public Libro(LibroJpa libroJpa) {
    if (libroJpa == null) return;
    this.libroJpa = libroJpa;

    this.setIdLibro(libroJpa.getIdLibro());
    this.setNombre(libroJpa.getNombre());
    this.setCapitulos(libroJpa.getCapitulos());
    this.setPrecio(libroJpa.getPrecio());
    this.setIdTienda(libroJpa.getTiendaJpa().getIdTienda());
  }


  public void update(Libro updateLibro) {
    if(updateLibro.getNombre()!=null)
      this.setNombre(updateLibro.getNombre());
    if(updateLibro.getCapitulos()!=null)
      this.setCapitulos(updateLibro.getCapitulos());
    if(updateLibro.getPrecio()!=null)
      this.setPrecio(updateLibro.getPrecio());
  }

  public Tienda getTienda() {
    if (this.tienda != null) return this.tienda;
    if (this.getLibroJpa() == null) return null;
    TiendaJpa tiendaJpa = getLibroJpa().getTiendaJpa();
    if (tiendaJpa == null) return null;
    Tienda tienda = new Tienda(tiendaJpa);
    this.setTienda(tienda);
    return tienda;
  }


}
