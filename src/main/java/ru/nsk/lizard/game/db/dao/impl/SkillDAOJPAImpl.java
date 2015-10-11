package ru.nsk.lizard.game.db.dao.impl;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nsk.lizard.game.db.dao.SkillDAO;
import ru.nsk.lizard.game.db.entities.Skill;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by dkim on 09.10.2015.
 */
@Service
public class SkillDAOJPAImpl extends GenericDAOImpl<Skill, Long> implements SkillDAO {
    @Autowired
    private JPASearchProcessor jpaSearchProcessor;
    @PersistenceContext
    protected EntityManager em;

    @PostConstruct
    private void init() {
        setEntityManager(em);
        setSearchProcessor(jpaSearchProcessor);
    }

    @Override
    public List<Skill> getSkills() {
        return findAll();
    }

    @Override
    public Skill getSkillByName(String name) {
        return search();
    }

    @Override
    public Skill getSkillById(int id) {
        return null;
    }
}

