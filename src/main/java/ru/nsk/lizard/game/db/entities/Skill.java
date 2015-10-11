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
    private int fire;

    @Column(name = "water")
    private int water;

    @Column(name = "air")
    private int air;

    @Column(name = "earth")
    private int earth;

    @Column(name = "ether")
    private int ether;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @Type(type = "ru.nsk.lizard.game.db.customtypes.SkillTypeEnumType")
    private SkillType type;

    public Skill(){}

    public Skill(String name, int fire, int water, int air, int earth, int ether, SkillType type) {
        this.name = name;
        this.fire = fire;
        this.water = water;
        this.air = air;
        this.earth = earth;
        this.ether = ether;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFire() {
        return fire;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getAir() {
        return air;
    }

    public void setAir(int air) {
        this.air = air;
    }

    public int getEarth() {
        return earth;
    }

    public void setEarth(int earth) {
        this.earth = earth;
    }

    public int getEther() {
        return ether;
    }

    public void setEther(int ether) {
        this.ether = ether;
    }

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

}
