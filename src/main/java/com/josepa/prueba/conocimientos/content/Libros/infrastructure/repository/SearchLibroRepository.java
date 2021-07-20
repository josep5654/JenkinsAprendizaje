package com.josepa.prueba.conocimientos.content.Libros.infrastructure.repository;

import com.josepa.prueba.conocimientos.configs.SearchUtil;
import com.josepa.prueba.conocimientos.content.Libros.domain.Libro;
import com.josepa.prueba.conocimientos.content.Libros.domain.LibroJpa;
import com.josepa.prueba.conocimientos.content.Libros.domain.noDatabase.SearchLibro;
import com.josepa.prueba.conocimientos.content.Libros.infrastructure.repository.port.SearchLibroPort;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class SearchLibroRepository implements SearchLibroPort {

    private EntityManager entityManager;

    @Override
    public Page<Libro> search(SearchLibro searchLibro, int page, int size) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<LibroJpa> criteriaQuery =
                criteriaBuilder.createQuery(LibroJpa.class);
        CriteriaQuery<Long> criteriaQueryCount = criteriaBuilder.createQuery(Long.class);

        // select
        List<Predicate> prs = new ArrayList<>();
        Root<LibroJpa> root = tmp(criteriaBuilder, criteriaQuery, prs, searchLibro);
        criteriaQuery.select(root).where(prs.toArray(new Predicate[] {}));
        List<LibroJpa> libroJpas =
                entityManager
                        .createQuery(criteriaQuery)
                        .setFirstResult(page * size)
                        .setMaxResults(size)
                        .getResultList();

        // count
        Root<LibroJpa> rootCount =
                tmp(criteriaBuilder, criteriaQueryCount, prs, searchLibro);
        criteriaQueryCount
                .select(criteriaBuilder.count(rootCount))
                .where(prs.toArray(new Predicate[] {}));
        long maxResults = entityManager.createQuery(criteriaQueryCount).getSingleResult();

        // return
        List<Libro> tags =
                libroJpas.stream().map(Libro::new).collect(Collectors.toList());
        return new PageImpl<>(tags, PageRequest.of(page, size), maxResults);
    }

    private Boolean doesContainsField(String orderBy) {
        if (orderBy == null || orderBy.isEmpty()) return false;
        Field[] fields = LibroJpa.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(orderBy)) return true;
        }
        return false;
    }

    private Root<LibroJpa> tmp(
            CriteriaBuilder cb,
            CriteriaQuery<?> cq,
            List<Predicate> prs,
            SearchLibro searchLibro) {

        // root
        Root<LibroJpa> root = cq.from(LibroJpa.class);


        // wheres


            SearchUtil.addPrsInteger(
                    cb, prs, root.get("idTienda"), searchLibro.getIdTienda());

            SearchUtil.addPrsInteger(
                    cb, prs, root.get("idLibro"), searchLibro.getIdLibro());

            SearchUtil.addPrsDouble(
                    cb, prs, root.get("precio"), searchLibro.getPrecio());

            SearchUtil.addPrsInteger(
                    cb, prs, root.get("capitulos"), searchLibro.getCapitulos());

            SearchUtil.addPrsStringLike(
                    cb, prs, root.get("nombre"), searchLibro.getNombre());

        return root;
    }
}

