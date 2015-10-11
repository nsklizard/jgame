package ru.nsk.lizard.game.db.entities;

import javax.persistence.*;

/**
 * Created by dkim on 09.10.2015.
 */
@Entity
@Table(name="creature_skill_links")
@SequenceGenerator(name = "default_gen", sequenceName = "creature_skill_links_id_seq", allocationSize = 1)
public class CreatureSkillLink extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creatureId", nullable = false)
    private Creature creature;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skillId", nullable = false)
    private Skill skill;

    @Column(name="power")
    private long power;

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
}
