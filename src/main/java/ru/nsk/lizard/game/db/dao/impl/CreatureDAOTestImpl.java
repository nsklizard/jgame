package ru.nsk.lizard.game.db.dao.impl;

import ru.nsk.lizard.game.db.dao.CreatureDAO;
import ru.nsk.lizard.game.db.dao.SkillDAO;
import ru.nsk.lizard.game.db.entities.Creature;
import ru.nsk.lizard.game.db.entities.Skill;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dkim on 07.10.2015.
 */
public class CreatureDAOTestImpl implements CreatureDAO {
    private Map<Integer, Creature> storage = new HashMap<Integer, Creature>();
    private static int id = 0;

    private SkillDAO skillDAO = SkillDAOTestImpl.getInstance();

    private static CreatureDAOTestImpl instance;
    private CreatureDAOTestImpl() {
        instance = new CreatureDAOTestImpl();
    }
    public static CreatureDAO getInstance(){
        return instance;
    }

    @Override
    public Creature getCreature(int creatureId) {
        return storage.get(creatureId);
    }

    @Override
    public Creature createCreature(String name, Map<Integer, Integer> skills) {

        Map<Skill, Integer> skillsMap = new HashMap<Skill, Integer>();
        for (Integer skillId : skills.keySet()) {
            skillsMap.put(skillDAO.getSkillById(skillId), skills.get(skillId));
        }


        Creature creature = new Creature();
        creature.setName(name);

        creature.setSkillLinks();

        storage.put(id, creature);

        return creature;
    }
}
