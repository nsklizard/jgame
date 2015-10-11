package ru.nsk.lizard.game.db.dao.impl;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsk.lizard.game.db.entities.Creature;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by dkim on 12.05.2015.
 */
@Service
public class CreatureDAOJPAImpl extends GenericDAOImpl<Creature, Long>{
    @Autowired
    private JPASearchProcessor jpaSearchProcessor;
    @PersistenceContext
    protected EntityManager em;

    @PostConstruct
    private void init() {
        setEntityManager(em);
        setSearchProcessor(jpaSearchProcessor);
    }
}
