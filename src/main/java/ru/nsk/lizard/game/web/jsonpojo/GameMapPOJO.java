package ru.nsk.lizard.game.web.jsonpojo;

import ru.nsk.lizard.game.db.entities.GameMap;

/**
 * Created by lizard on 13.10.2015.
 */
public class GameMapPOJO {
    private long x;
    private long y;
    private long cId;

    public GameMapPOJO(GameMap gameMap) {
        this.x = gameMap.getX();
        this.y = gameMap.getY();
        this.cId = gameMap.getCreature()==null?0:gameMap.getCreature().getId();
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public long getcId() {
        return cId;
    }

    public void setcId(long cId) {
        this.cId = cId;
    }
}
