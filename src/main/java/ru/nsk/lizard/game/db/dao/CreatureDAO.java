package ru.nsk.lizard.game.db.dao;


import ru.nsk.lizard.game.db.entities.Creature;

import java.util.Map;

/**
 * Created by dkim on 07.10.2015.
 */
public interface CreatureDAO {
    public Creature getCreature(int creatureId);
    public Creature createCreature(String name, Map<Integer, Integer> skills);
}
