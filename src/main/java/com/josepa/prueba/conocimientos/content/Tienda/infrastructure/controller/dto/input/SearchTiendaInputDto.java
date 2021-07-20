package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.controller.dto.input;

import com.josepa.prueba.conocimientos.content.Tienda.domain.noDatabase.SearchTienda;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SearchTiendaInputDto {

    private Integer idTienda;
    private String nombre;
    private String direccion;


    public SearchTienda searchTienda(){
        SearchTienda tienda = new SearchTienda();

        tienda.setIdTienda(this.getIdTienda());
        tienda.setNombre(this.getNombre());
        tienda.setDireccion(this.getDireccion());

        return tienda;
    }
}
