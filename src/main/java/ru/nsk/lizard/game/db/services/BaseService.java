package ru.nsk.lizard.game.db.services;

import com.googlecode.genericdao.search.Sort;
import ru.nsk.lizard.game.db.common.Filter;

import javax.persistence.EntityManager;
import java.util.List;

public interface BaseService<T, ID> {

    List<T> search(Filter... filters);

    List<T> search(List<Filter> filters);

    List<T> search(int page, int count, List<Filter> filters, List<Sort> orders);

    List<T> search(int page, int count, List<Filter> filters);

    T searchUnique(Filter... filters);

    T searchUnique(List<Filter> filter);

    int countAll();

    int count(Filter... filters);

    int count(List<Filter> filters);

    void delete(ID id);

    T save(T entity);

    T[] save(T... entities);

    T findById(ID id);

    void flush();

    EntityManager getEm();
}
