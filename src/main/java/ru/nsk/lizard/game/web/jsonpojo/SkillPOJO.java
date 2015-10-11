package ru.nsk.lizard.game.web.jsonpojo;

import org.hibernate.annotations.Type;
import ru.nsk.lizard.game.db.entities.Skill;
import ru.nsk.lizard.game.db.enums.SkillType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by lizard on 11.10.2015.
 */
public class SkillPOJO {
    private String name;
    private long fire;
    private long water;
    private long air;
    private long earth;
    private long ether;
    private String type;

    public SkillPOJO() {
    }

    public SkillPOJO(Skill skill) {
        this.name = skill.getName();
        this.fire = skill.getFire();
        this.water = skill.getWater();
        this.air = skill.getAir();
        this.earth = skill.getEarth();
        this.ether = skill.getEther();
        this.type = skill.getType().name();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getEther() {
        return ether;
    }

    public void setEther(long ether) {
        this.ether = ether;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
