package ru.nsk.lizard.game.db.serviceimpl;

import com.google.common.collect.Lists;
import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.Sort;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.nsk.lizard.game.db.entities.BaseEntity;
import ru.nsk.lizard.game.db.services.BaseService;
import ru.nsk.lizard.game.db.common.Filter;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public abstract class BaseServiceImpl<T extends BaseEntity, ID extends Serializable> extends GenericDAOImpl<T, ID> implements BaseService<T, ID> {

    protected final Class<T> clazz;

    @Autowired
    private JPASearchProcessor jpaSearchProcessor;
    @PersistenceContext
    protected EntityManager em;

    public BaseServiceImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @PostConstruct
    private void init() {
        setEntityManager(em);
        setSearchProcessor(jpaSearchProcessor);
    }

    @Override
    protected void _flush() {
        super._flush();
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> search(Filter... filters) {

        Search search = new Search();
        search.setDisjunction(true);
        processFilters(search, filters);

        return search(search);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> search(List<Filter> filters) {
        return search(filters.stream().toArray(Filter[]::new));
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> search(int page, int count, List<Filter> filters, List<Sort> orders) {

        Search search = new Search();
        search.setDisjunction(true);
        processFilters(search, filters);
        search.setSorts(orders);
        search.setPage(page);
        search.setMaxResults(count);

        return search(search);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> search(int page, int count, List<Filter> filters) {
        return search(page, count, filters, new ArrayList<>(0));
    }

    @Override
    public T searchUnique(Filter... filters) {
        Search search = new Search();
        search.setDisjunction(true);
        processFilters(search, filters);

        return searchUnique(search);
    }

    @Override
    public T searchUnique(List<Filter> filter) {
        return searchUnique(filter.stream().toArray(Filter[]::new));
    }

    @Override
    @Transactional(readOnly = true)
    public int countAll() {
        Search search = new Search();
        search.setDistinct(true);

        return count(search);
    }

    @Override
    @Transactional(readOnly = true)
    public int count(Filter... filters) {
        Search search = new Search();
        search.setDistinct(true);
        search.setDisjunction(true);
        processFilters(search, filters);

        return count(search);
    }

    @Override
    @Transactional(readOnly = true)
    public int count(List<Filter> filters) {
        return count(filters.stream().toArray(Filter[]::new));
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(ID id) {
        removeById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public T save(T entity) {
        return super.merge(entity);
    }

    @Override
    @Transactional(readOnly = false)
    public T[] save(T... entities) {
        return super.save(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public T findById(ID id) {
        return find(id);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void flush() {
        super.flush();
    }

    private static void processFilters(Search search, Filter... filters) {
        processFilters(search, Lists.newArrayList(filters));
    }

    private static void processFilters(Search search, List<Filter> filters) {
        for (Filter filter : filters) {
            if (filter.isDisjunction()) {
                search.setDisjunction(true);     //группировать [ or {...} and {...} or {...} ] не получается
                search.addFilterOr(filter.getFilter());
            } else {
                search.setDisjunction(false);    //группировать [ or {...} and {...} or {...} ]  не получается
                search.addFilterAnd(filter.getFilter());
            }
        }
    }

    public EntityManager getEm() {
        return em;
    }
}
