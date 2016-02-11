package ru.nsk.lizard.game.db.services;

import ru.nsk.lizard.game.db.entities.Skill;

import java.util.List;

/**
 * Created by lizard on 11.10.2015.
 */
public interface SkillService extends BaseService<Skill,Long>{
    public List<Skill> getRandomSkills(int quantity);
}
