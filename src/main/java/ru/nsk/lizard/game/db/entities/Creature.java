package ru.nsk.lizard.game.db.entities;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by dkim on 12.05.2015.
 */
@Entity
@Table(name="creatures")
@SequenceGenerator(name = "default_gen", sequenceName = "creatures_id_seq", allocationSize = 1)
public class Creature extends BaseEntity{
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "creature", fetch = FetchType.EAGER)
    private List<CreatureSkillLink> skillLinks;

    /**
     *
     * @return
     */
    public Map<Skill, Long> getSkills() {
        Map<Skill, Long> ret = new HashMap<Skill, Long>();
        for (CreatureSkillLink link : skillLinks) {
            ret.put(link.getSkill(), link.getPower());
        }
        return ret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CreatureSkillLink> getSkillLinks() {
        return skillLinks;
    }

    public void setSkillLinks(List<CreatureSkillLink> skillLinks) {
        this.skillLinks = skillLinks;
    }
}
