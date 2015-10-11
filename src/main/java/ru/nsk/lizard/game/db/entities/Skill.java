package ru.nsk.lizard.game.db.entities;

import org.hibernate.annotations.Type;
import ru.nsk.lizard.game.db.enums.SkillType;

import javax.persistence.*;

/**
 * Created by dkim on 12.05.2015.
 */
@Entity
@Table(name = "skills")
@SequenceGenerator(name = "default_gen", sequenceName = "skills_id_seq", allocationSize = 1)
public class Skill extends BaseEntity{
    @Column(name = "name")
    private String name;

    @Column(name = "fire")
    private long fire;

    @Column(name = "water")
    private long water;

    @Column(name = "air")
    private long air;

    @Column(name = "earth")
    private long earth;

    @Column(name = "poison")
    private long poison;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @Type(type = "ru.nsk.lizard.game.db.customtypes.SkillTypeEnumType")
    private SkillType type;

    public Skill(){}

    public Skill(String name, long fire, long water, long air, long earth, long poison, SkillType type) {
        this.name = name;
        this.fire = fire;
        this.water = water;
        this.air = air;
        this.earth = earth;
        this.poison = poison;
        this.type = type;
    }

    public long getFire() {
        return fire;
    }

    public void setFire(long fire) {
        this.fire = fire;
    }

    public long getWater() {
        return water;
    }

    public void setWater(long water) {
        this.water = water;
    }

    public long getAir() {
        return air;
    }

    public void setAir(long air) {
        this.air = air;
    }

    public long getEarth() {
        return earth;
    }

    public void setEarth(long earth) {
        this.earth = earth;
    }

    public long getPoison() {
        return poison;
    }

    public void setPoison(long poison) {
        this.poison = poison;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

}
