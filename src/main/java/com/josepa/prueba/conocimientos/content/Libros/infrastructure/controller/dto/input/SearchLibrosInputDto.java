package com.josepa.prueba.conocimientos.content.Libros.infrastructure.controller.dto.input;

import com.josepa.prueba.conocimientos.content.Libros.domain.noDatabase.SearchLibro;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SearchLibrosInputDto {

    private Integer idLibro;
    private String nombre;
    private Integer capitulos;
    private Double precio;


    public SearchLibro searchLibro(){
        SearchLibro searchLibro = new SearchLibro();

        searchLibro.setIdLibro(this.getIdLibro());
        searchLibro.setNombre(this.getNombre());
        searchLibro.setCapitulos(this.getCapitulos());
        searchLibro.setPrecio(this.getPrecio());


        return searchLibro;
    }
}
