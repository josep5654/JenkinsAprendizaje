package com.josepa.prueba.conocimientos.content.Tienda.domain;


import com.josepa.prueba.conocimientos.content.Libros.domain.Libro;
import com.josepa.prueba.conocimientos.content.Libros.domain.LibroJpa;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MSTR_TIENDA")
public class TiendaJpa {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)

  @Column(name = "I_ID_TIENDA")
  private Integer idTienda;
  @Column(name = "S_NOMBRE")
  private String nombre;
  @Column(name= "S_DIRECCION")
  private String direccion;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "I_ID_TIENDA")
  private List<LibroJpa> libroJpa;



  public TiendaJpa(Tienda tienda) {

    if (tienda == null) return;

    this.setIdTienda(tienda.getIdTienda());
    this.setNombre(tienda.getNombre());
    this.setDireccion(tienda.getDireccion());

    List<Libro> libro = tienda.getLibroList();
    updateLibro(libro);
  }

  public void updateLibro(List<Libro> libro){
    if (libro == null){
      this.setLibroJpa(new ArrayList<>());
    return;
    }
   // List<LibroJpa>libroJpa = libro.stream().map(LibroJpa::new).collect(Collectors.toList());
    //this.setLibroJpa(libroJpa);
  }
}
