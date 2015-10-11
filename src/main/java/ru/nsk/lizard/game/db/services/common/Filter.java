package ru.nsk.lizard.game.db.services.common;

import java.util.Collection;

public class Filter {

    private final boolean disjunction;
    private final com.googlecode.genericdao.search.Filter filter;

    public static final int OP_EQUAL = com.googlecode.genericdao.search.Filter.OP_EQUAL;
    public static final int OP_NOT_EQUAL = com.googlecode.genericdao.search.Filter.OP_NOT_EQUAL;
    public static final int OP_LESS_THAN = com.googlecode.genericdao.search.Filter.OP_LESS_THAN;
    public static final int OP_GREATER_THAN = com.googlecode.genericdao.search.Filter.OP_GREATER_THAN;
    public static final int OP_LESS_OR_EQUAL = com.googlecode.genericdao.search.Filter.OP_LESS_OR_EQUAL;
    public static final int OP_GREATER_OR_EQUAL = com.googlecode.genericdao.search.Filter.OP_GREATER_OR_EQUAL;
    public static final int OP_LIKE = com.googlecode.genericdao.search.Filter.OP_LIKE;
    public static final int OP_ILIKE = com.googlecode.genericdao.search.Filter.OP_ILIKE;
    public static final int OP_IN = com.googlecode.genericdao.search.Filter.OP_IN;
    public static final int OP_NOT_IN = com.googlecode.genericdao.search.Filter.OP_NOT_IN;
    public static final int OP_NULL = com.googlecode.genericdao.search.Filter.OP_NULL;
    public static final int OP_NOT_NULL = com.googlecode.genericdao.search.Filter.OP_NOT_NULL;
    public static final int OP_EMPTY = com.googlecode.genericdao.search.Filter.OP_EMPTY;
    public static final int OP_NOT_EMPTY = com.googlecode.genericdao.search.Filter.OP_NOT_EMPTY;
    public static final int OP_AND = com.googlecode.genericdao.search.Filter.OP_AND;
    public static final int OP_OR = com.googlecode.genericdao.search.Filter.OP_OR;
    public static final int OP_NOT = com.googlecode.genericdao.search.Filter.OP_NOT;
    public static final int OP_SOME = com.googlecode.genericdao.search.Filter.OP_SOME;
    public static final int OP_ALL = com.googlecode.genericdao.search.Filter.OP_ALL;
    public static final int OP_NONE = com.googlecode.genericdao.search.Filter.OP_NONE;
    public static final int OP_CUSTOM = com.googlecode.genericdao.search.Filter.OP_CUSTOM;

    public Filter() {
        this(false);
    }

    public Filter(com.googlecode.genericdao.search.Filter filter) {
        this(filter, false);
    }

    public Filter(com.googlecode.genericdao.search.Filter filter, boolean disjunction) {
        this.filter = filter;
        this.disjunction = disjunction;
    }

    public Filter(boolean disjunction) {
        this.filter = new com.googlecode.genericdao.search.Filter();
        this.disjunction = disjunction;
    }

    public Filter(String property, Object value) {
        this(property, value, false);
    }

    public Filter(String property, Object value, boolean disjunction) {
        this.filter = new com.googlecode.genericdao.search.Filter(property, value);
        this.disjunction = disjunction;
    }

    public Filter(String property, Object value, int operator) {
        this(property, value, operator, false);
    }

    public Filter(String property, Object value, int operator, boolean disjunction) {
        this.filter = new com.googlecode.genericdao.search.Filter(property, value, operator);
        this.disjunction = disjunction;
    }

    public boolean isDisjunction() {
        return disjunction;
    }

    public com.googlecode.genericdao.search.Filter getFilter() {
        return filter;
    }

    //------------------------------------------------------------------------------------------------------------------

    public static Filter lessThan(String property, Object value) {
        return new Filter(com.googlecode.genericdao.search.Filter.lessThan(property, value));
    }

    public static Filter greaterThan(String property, Object value) {
        return new Filter(com.googlecode.genericdao.search.Filter.greaterThan(property, value));
    }

    public static Filter lessOrEqual(String property, Object value) {
        return new Filter(com.googlecode.genericdao.search.Filter.lessOrEqual(property, value));
    }

    public static Filter greaterOrEqual(String property, Object value) {
        return new Filter(com.googlecode.genericdao.search.Filter.greaterOrEqual(property, value));
    }

    public static Filter in(String property, Collection<?> value) {
        return new Filter(com.googlecode.genericdao.search.Filter.in(property, value));
    }

    public static Filter in(String property, Object... value) {
        return new Filter(com.googlecode.genericdao.search.Filter.in(property, value));
    }

    public static Filter notIn(String property, Collection<?> value) {
        return new Filter(com.googlecode.genericdao.search.Filter.notIn(property, value));
    }

    public static Filter notIn(String property, Object... value) {
        return new Filter(com.googlecode.genericdao.search.Filter.notIn(property, value));
    }

    public static Filter like(String property, String value) {
        return new Filter(com.googlecode.genericdao.search.Filter.like(property, value));
    }

    public static Filter ilike(String property, String value) {
        return new Filter(com.googlecode.genericdao.search.Filter.ilike(property, value));
    }

    public static Filter notEqual(String property, Object value) {
        return new Filter(com.googlecode.genericdao.search.Filter.notEqual(property, value));
    }

    public static Filter isNull(String property) {
        return new Filter(com.googlecode.genericdao.search.Filter.isNull(property));
    }

    public static Filter isNotNull(String property) {
        return new Filter(com.googlecode.genericdao.search.Filter.isNotNull(property));
    }

    public static Filter isEmpty(String property) {
        return new Filter(com.googlecode.genericdao.search.Filter.isEmpty(property));
    }

    public static Filter isNotEmpty(String property) {
        return new Filter(com.googlecode.genericdao.search.Filter.isNotEmpty(property));
    }

    public static Filter and(com.googlecode.genericdao.search.Filter... filters) {
        return new Filter(com.googlecode.genericdao.search.Filter.and(filters));
    }

    public static Filter or(com.googlecode.genericdao.search.Filter... filters) {
        return new Filter(com.googlecode.genericdao.search.Filter.or(filters));
    }

    public static Filter not(com.googlecode.genericdao.search.Filter filter) {
        return new Filter(com.googlecode.genericdao.search.Filter.not(filter));
    }

    public static Filter some(String property, com.googlecode.genericdao.search.Filter filter) {
        return new Filter(com.googlecode.genericdao.search.Filter.some(property, filter));
    }

    public static Filter all(String property, com.googlecode.genericdao.search.Filter filter) {
        return new Filter(com.googlecode.genericdao.search.Filter.all(property, filter));
    }

    public static Filter none(String property, com.googlecode.genericdao.search.Filter filter) {
        return new Filter(com.googlecode.genericdao.search.Filter.none(property, filter));
    }

    public static Filter custom(String expression) {
        return new Filter(com.googlecode.genericdao.search.Filter.custom(expression));
    }

    public static Filter custom(String expression, Object... values) {
        return new Filter(com.googlecode.genericdao.search.Filter.custom(expression, values));
    }

    public static Filter custom(String expression, Collection<?> values) {
        return new Filter(com.googlecode.genericdao.search.Filter.custom(expression, values));
    }
}
