package ru.nsk.lizard.game.web.jsonpojo;

import ru.nsk.lizard.game.db.entities.Skill;

/**
 * Created by lizard on 11.10.2015.
 */
public class SkillPOJO {
    private String name;
    private long fire;
    private long water;
    private long air;
    private long earth;
    private long poison;
    private String type;

    public SkillPOJO() {
    }

    public SkillPOJO(Skill skill) {
        this.name = skill.getName();
        this.fire = skill.getFire();
        this.water = skill.getWater();
        this.air = skill.getAir();
        this.earth = skill.getEarth();
        this.poison = skill.getPoison();
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

    public long getPoison() {
        return poison;
    }

    public void setPoison(long poison) {
        this.poison = poison;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
