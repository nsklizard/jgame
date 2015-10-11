package ru.nsk.lizard.game.db.dao.impl;

import ru.nsk.lizard.game.db.dao.SkillDAO;
import ru.nsk.lizard.game.db.entities.Skill;
import ru.nsk.lizard.game.db.enums.SkillType;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dkim on 07.10.2015.
 */
public class SkillDAOTestImpl implements SkillDAO {

    private static SkillDAOTestImpl instance;
    private SkillDAOTestImpl(){
        instance = new SkillDAOTestImpl();
    }
    public static SkillDAO getInstance(){
        return instance;
    }

    private static List<Skill> skills = new LinkedList<Skill>();

    //@@formatter:off
    static {
        skills.add(new Skill( "Огненная тряпка",          2,  0,  0,  0,  0, SkillType.OFFENSE));
        skills.add(new Skill( "Я водяной, я водяной",     1,  1,  0,  0,  0, SkillType.DEFENCE));
        skills.add(new Skill( "За Аиур",                  0,  0,  0,  0,  3, SkillType.OFFENSE));
    }
    //@formatter:on

    @Override
    public List<Skill> getSkills() {
        return skills;
    }

    @Override
    public Skill getSkillByName(String name) {
        for (Skill skill : skills) {
            if (skill.getName().equals(name)){
                return skill;
            }
        }
        return null;
    }

    @Override
    public Skill getSkillById(int id) {
        for (Skill skill : skills) {
            if (skill.getSkillId() == id){
                return skill;
            }
        }
        return null;
    }
}
