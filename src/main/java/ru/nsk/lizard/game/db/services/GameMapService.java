package ru.nsk.lizard.game.db.services;

import ru.nsk.lizard.game.db.entities.GameMap;

/**
 * Created by lizard on 13.10.2015.
 */
public interface GameMapService extends BaseService<GameMap, Long> {
    public GameMap get(long x, long y);
}
