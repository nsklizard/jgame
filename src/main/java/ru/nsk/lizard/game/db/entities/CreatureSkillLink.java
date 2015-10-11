package ru.nsk.lizard.game.db.entities;

import javax.persistence.*;

/**
 * Created by dkim on 09.10.2015.
 */
@Entity
@Table(name = "creature_skill_links")
public class CreatureSkillLink {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "creature_skill_links_id", unique = true, nullable = false)
    private long creatureSkillLinkId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creature_id", nullable = false)
    private Creature creature;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    @Column(name="power")
    private long power;


    public long getCreatureSkillLinkId() {
        return creatureSkillLinkId;
    }

    public void setCreatureSkillLinkId(long creatureSkillLinkId) {
        this.creatureSkillLinkId = creatureSkillLinkId;
    }

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreatureSkillLink that = (CreatureSkillLink) o;

        if (creatureSkillLinkId != that.creatureSkillLinkId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (creatureSkillLinkId ^ (creatureSkillLinkId >>> 32));
    }
}
