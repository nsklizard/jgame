package ru.nsk.lizard.game.db.enums;

import ru.nsk.lizard.game.db.services.common.PersistentEnum;

/**
 * Created by dkim on 07.10.2015.
 */
public enum SkillType implements PersistentEnum {

    OFFENSE(1, "Атака"),
    DEFENCE(-1, "Защита");

    private int m = 1;
    private String localizedName;

    private SkillType(int m, String localizedName) {
        this.m = m;
        this.localizedName = localizedName;
    }

    public int getMultiplier() {
        return m;
    }

    public String getLocalizedName() {
        return localizedName;
    }
}