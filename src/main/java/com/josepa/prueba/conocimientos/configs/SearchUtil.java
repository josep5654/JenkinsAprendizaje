package com.josepa.prueba.conocimientos.configs;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

/** @author diegotobalina created on 21/11/2020 */
public class SearchUtil {

    public static void addPrsInitialDate(
            CriteriaBuilder cb, List<Predicate> predicates, Path<Date> path, Date date) {
        if (date == null) return;
        predicates.add(cb.greaterThanOrEqualTo(path, date));
    }

    public static void addPrsFinalDate(
            CriteriaBuilder cb, List<Predicate> predicates, Path<Date> path, Date date) {
        if (date == null) return;
        predicates.add(cb.lessThanOrEqualTo(path, date));
    }

    public static void addPrsBoolean(
            CriteriaBuilder cb, List<Predicate> predicates, Path<Boolean> path, Boolean booleanValue) {
        if (booleanValue == null) return;
        predicates.add(cb.equal(path, booleanValue));
    }

    public static void addPrsEnum(
            CriteriaBuilder cb, List<Predicate> predicates, Path<Enum> path, Enum enumeration) {
        if (enumeration == null) return;
        predicates.add(cb.equal(path, enumeration));
    }

    public static void addPrsStringEquals(
            CriteriaBuilder cb, List<Predicate> predicates, Path<String> path, String string) {
        addPrsString(cb, predicates, path, string, "equals");
    }

    public static void addPrsStringLike(
            CriteriaBuilder cb, List<Predicate> predicates, Path<String> path, String string) {
        addPrsString(cb, predicates, path, string, "like");
    }

    private static void addPrsString(
            CriteriaBuilder cb,
            List<Predicate> predicates,
            Path<String> path,
            String string,
            String equals) {
        if (StringUtil.isNullOrEmpty(string)) return;

        String cleanedString = cleanString(string);
        Expression<String> cleanedStringDatabase = cleanPath(cb, path);

        Predicate predicate =
                getConditionForString(cleanedString, equals, cb, path, cleanedStringDatabase);
        predicates.add(predicate);
    }

    private static Predicate getConditionForString(
            String cleanedString,
            String condition,
            CriteriaBuilder cb,
            Path<String> path,
            Expression<String> cleanedStringDatabase) {
        if ("NULL".equals(cleanedString)) return cb.isNull(path);
        switch (condition) {
            case "equals":
                return cb.equal(cleanedStringDatabase, prStringEquals(cleanedString));
            default:
                return cb.like(cleanedStringDatabase, prStringLike(cleanedString));
        }
    }

    private static Expression<String> cleanPath(CriteriaBuilder cb, Path<String> path) {
        return cb.upper(cb.function("norm_text_latin", String.class, path));
    }

    private static String cleanString(String string) {
        return StringUtils.stripAccents(string).toUpperCase();
    }

    public static void addPrsInteger(
            CriteriaBuilder cb, List<Predicate> predicates, Path<Integer> path, Integer integer) {
        if (integer == null) return;
        predicates.add(cb.equal(path, prInteger(integer)));
    }

    public static void addPrsDouble(
            CriteriaBuilder cb, List<Predicate> predicates, Path<Integer> path, Double vDouble) {
        if (vDouble == null) return;
        predicates.add(cb.equal(path, (int) Math.round(prDouble(vDouble))));
    }

    public static Integer prInteger(Integer key) {
        return (key == null || key < 0) ? 0 : key;
    }

    public static Double prDouble(Double key) {
        return (key == null || key < 0) ? 0 : key;
    }

    public static String prStringEquals(String key) {
        return (StringUtil.isNullOrEmpty(key)) ? "" : key;
    }

    public static String prStringLike(String key) {
        return (StringUtil.isNullOrEmpty(key)) ? "%" : "%" + key + "%";
    }

    public static long getMaxResults(
            EntityManager entityManager, List<Predicate> prs, Class<?> rootClass) {
        CriteriaBuilder countCb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countCq = countCb.createQuery(Long.class);
        countCq.select(countCb.count(countCq.from(rootClass)));
        return entityManager.createQuery(countCq).getSingleResult();
    }

    /**
     * Devuelve equals o not equals dependiendo del paramtetro shouldEquals
     *
     * @param shouldEquals must no be null
     */
    public static Predicate getEqualsOrNotEquals(
            Boolean shouldEquals, CriteriaBuilder cb, Path<Object> path1, Path<Object> path2) {
        if (shouldEquals) return cb.equal(path1, path2);
        return cb.notEqual(path1, path2);
    }
}

