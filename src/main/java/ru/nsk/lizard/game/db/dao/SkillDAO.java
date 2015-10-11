package ru.nsk.lizard.game.db.dao;


import ru.nsk.lizard.game.db.entities.Skill;

import java.util.List;

/**
 * Created by dkim on 07.10.2015.
 */
public interface SkillDAO {
    public List<Skill> getSkills();
    public Skill getSkillByName(String name);
    public Skill getSkillById(int id);
}
