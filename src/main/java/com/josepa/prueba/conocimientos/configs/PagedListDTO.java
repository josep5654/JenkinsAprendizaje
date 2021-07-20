package com.josepa.prueba.conocimientos.configs;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/** @author diegotobalina created on 03/08/2020 */

@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class PagedListDTO<T> implements Serializable {

    @ApiModelProperty(example = "['john','oscar','mary']")
    private List<T> content;

    @ApiModelProperty(example = "500")
    private long totalElements;

    @ApiModelProperty(example = "20")
    private int numberOfElements;

    @ApiModelProperty(example = "10")
    private int totalPages;

    public PagedListDTO(List<T> content, long totalElements, int totalPages) {
        this.content = content;
        this.totalElements = totalElements;
        this.numberOfElements = content.size();
        this.totalPages = totalPages;
    }

    public PagedListDTO(Page<T> content) {
        this.content = content.getContent();
        this.totalElements = content.getTotalElements();
        this.numberOfElements = this.content.size();
        this.totalPages = content.getTotalPages();
    }
}
