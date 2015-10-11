package ru.nsk.lizard.game.web.jsonpojo;

import ru.nsk.lizard.game.db.entities.Creature;
import ru.nsk.lizard.game.db.entities.CreatureSkillLink;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizard on 11.10.2015.
 */
public class CreaturePOJO {
    String name;
    Map<Long, Long> skills;

    public CreaturePOJO() {
    }
    public CreaturePOJO(Creature creature) {
        this.name = creature.getName();
        this.skills = new HashMap<>();

        for (CreatureSkillLink link : creature.getSkillLinks()) {
            this.skills.put(link.getSkill().getId(), link.getPower());
        }
    }

    public CreaturePOJO(String name, Map<Long, Long> skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, Long> getSkills() {
        return skills;
    }

    public void setSkills(Map<Long, Long> skills) {
        this.skills = skills;
    }
}
