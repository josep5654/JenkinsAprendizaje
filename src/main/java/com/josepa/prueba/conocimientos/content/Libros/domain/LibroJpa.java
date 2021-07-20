package com.josepa.prueba.conocimientos.content.Libros.domain;


import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import com.josepa.prueba.conocimientos.content.Tienda.domain.TiendaJpa;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MSTR_LIBRO")
public class LibroJpa {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)

  @Column(name = "I_ID_LIBRO")
  private Integer idLibro;
  @Column(name = "S_NOMBRE")
  private String nombre;
  @Column(name= "I_CAPITULOS")
  private Integer capitulos;
  @Column (name="D_PRECIO")
  private Double precio;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "I_ID_TIENDA",updatable = false,insertable = false)
  private TiendaJpa tiendaJpa;

  @Column(name = "I_ID_TIENDA")
  private Integer idTienda;



  public LibroJpa(Libro libro) {

    if (libro == null) return;

    this.setIdLibro(libro.getIdLibro());
    this.setNombre(libro.getNombre());
    this.setCapitulos(libro.getCapitulos());
    this.setPrecio(libro.getPrecio());
    this.setIdTienda(libro.getIdTienda());
    Tienda tienda = libro.getTienda();
    updateTienda(tienda);

  }

  public void updateTienda(Tienda tienda){
    if (tienda == null) {
      this.setTiendaJpa(null);
      return;
    }
    TiendaJpa tiendaJpa = new TiendaJpa(tienda);
    this.setTiendaJpa(tiendaJpa);
  }


}
