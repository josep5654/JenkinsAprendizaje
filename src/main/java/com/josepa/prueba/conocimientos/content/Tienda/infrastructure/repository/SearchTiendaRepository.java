package com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository;

import com.josepa.prueba.conocimientos.configs.SearchUtil;
import com.josepa.prueba.conocimientos.configs.StringUtil;
import com.josepa.prueba.conocimientos.content.Tienda.domain.Tienda;
import com.josepa.prueba.conocimientos.content.Tienda.domain.TiendaJpa;
import com.josepa.prueba.conocimientos.content.Tienda.domain.noDatabase.SearchTienda;
import com.josepa.prueba.conocimientos.content.Tienda.infrastructure.repository.port.SearchTiendaPort;
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
public class SearchTiendaRepository implements SearchTiendaPort {

    private EntityManager entityManager;

    @Override
    public Page<Tienda> search(SearchTienda searchTienda, int page, int size) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<TiendaJpa> criteriaQuery =
                criteriaBuilder.createQuery(TiendaJpa.class);
        CriteriaQuery<Long> criteriaQueryCount = criteriaBuilder.createQuery(Long.class);

        // select
        List<Predicate> prs = new ArrayList<>();
        Root<TiendaJpa> root = tmp(criteriaBuilder, criteriaQuery, prs, searchTienda);

        String orderByField = "idTienda"; // default orderField

        criteriaQuery.select(root).where(prs.toArray(new Predicate[] {}));
        List<TiendaJpa> tiendaJpas =
                entityManager
                        .createQuery(criteriaQuery)
                        .setFirstResult(page * size)
                        .setMaxResults(size)
                        .getResultList();

        // count
        Root<TiendaJpa> rootCount =
                tmp(criteriaBuilder, criteriaQueryCount, prs, searchTienda);
        criteriaQueryCount
                .select(criteriaBuilder.count(rootCount))
                .where(prs.toArray(new Predicate[] {}));
        long maxResults = entityManager.createQuery(criteriaQueryCount).getSingleResult();

        // return
       List<Tienda> tags =
              tiendaJpas.stream().map(Tienda::new).collect(Collectors.toList());
      return new PageImpl<>(tags, PageRequest.of(page, size), maxResults);

//        List<Tienda> tags =
//                tiendaJpas.stream().map(Tienda::new).skip(page*size).limit(size).collect(Collectors.toList());
//        return new PageImpl<>(tags, PageRequest.of(page, size), maxResults);
    }

    private Boolean doesContainsField(String orderBy) {
        if (orderBy == null || orderBy.isEmpty()) return false;
        Field[] fields = TiendaJpa.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals(orderBy)) return true;
        }
        return false;
    }

    private Root<TiendaJpa> tmp(
            CriteriaBuilder cb,
            CriteriaQuery<?> cq,
            List<Predicate> prs,
            SearchTienda searchTienda) {

        // root
        Root<TiendaJpa> root = cq.from(TiendaJpa.class);


        // wheres

            SearchUtil.addPrsInteger(
                    cb, prs, root.get("idTienda"), searchTienda.getIdTienda());

        if(!StringUtil.isNullOrEmpty(searchTienda.getNombre()))
            SearchUtil.addPrsStringLike(
                    cb, prs, root.get("nombre"), searchTienda.getNombre());

        if(!StringUtil.isNullOrEmpty(searchTienda.getDireccion()))
            SearchUtil.addPrsStringLike(
                    cb, prs, root.get("direccion"), searchTienda.getDireccion());



        return root;
    }
}

