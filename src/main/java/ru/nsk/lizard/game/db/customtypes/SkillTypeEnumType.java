package ru.nsk.lizard.game.db.customtypes;

import ru.nsk.lizard.game.db.enums.SkillType;
import ru.nsk.lizard.game.db.common.PersistentEnumType;

/**
 * Created by dkim on 11.08.2015.
 */
public class SkillTypeEnumType extends PersistentEnumType<SkillType> {

    @Override
    public Class<SkillType> returnedClass() {
        return SkillType.class;
    }
}
