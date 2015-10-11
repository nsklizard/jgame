package ru.nsk.lizard.game.logic.v2;

import ru.nsk.lizard.game.db.dao.impl.CreatureDAOJPAImpl;
import ru.nsk.lizard.game.db.entities.Creature;

import java.util.Map;

/**
 * Created by dkim on 07.10.2015.
 */
public class GameCore {

    CreatureDAOJPAImpl creatureDAOJPAImpl = CreatureDAOTestImpl.getInstance();
    SkillDAO skillDAO = SkillDAOTestImpl.getInstance();

    CellProcessor[][] cp = null;

    public void initMap(int width, int length){
        cp = new CellProcessor[width][length];
        for (int x = 0;x<width;x++){
            for (int y= 0; y<length; y++){
                cp[x][y] = new CellProcessor();
                cp[x][y].start();
            }
        }
    }

    public void settleCreature(int x, int y, int creatureId){
        Creature creature = creatureDAOJPAImpl.getCreature(creatureId);
        cp[x][y].addCreature(creature);
    }

    public List<Skill> getSkills(){
        return skillDAO.getSkills();
    }

    public void createCreature(String name, Map<Integer, Integer> skills){
        creatureDAOJPAImpl.createCreature(name, skills);
    }

}
