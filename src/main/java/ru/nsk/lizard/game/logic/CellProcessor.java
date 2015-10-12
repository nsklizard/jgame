package ru.nsk.lizard.game.logic;


import org.apache.log4j.Logger;
import ru.nsk.lizard.game.db.entities.Creature;
import ru.nsk.lizard.game.db.entities.GameMap;
import ru.nsk.lizard.game.db.services.GameMapService;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by dkim on 06.10.2015.
 */
public class CellProcessor extends Thread {
    Logger log = Logger.getLogger(CellProcessor.class.getName());
    private Object lock = new Object();

    //    private List<Creature> queue = new LinkedList<Creature>();
    private BlockingQueue<Creature> queue = new LinkedBlockingQueue<>();
    private Creature owner = null;
    private GameCore gameCore;
    private GameMapService gameMapService;
    private int x;
    private int y;

    public CellProcessor(int x, int y, GameCore gameCore, GameMapService gameMapService) {
        this.x = x;
        this.y = y;
        this.gameCore = gameCore;
        this.gameMapService = gameMapService;
    }

    public Creature getOwner() {
        return owner;
    }

    public void addCreature(Creature creature) {
        if (creature == null) return;

        queue.add(creature);
        log.debug("creature added to processing queue");
    }

    @Override
    public void run() {
        loadFromDB();
        while (true) {
            Creature attacker = null;
            try {
                log.debug("Waiting for creature");
                attacker = queue.take();
                log.debug("Creature available id=" + attacker.getId() + ", name=" + attacker.getName());
            } catch (InterruptedException e) {
                log.error(e);
                throw new RuntimeException(e);
            }

            if (owner == null) {
                owner = attacker;
                saveToDB();
            } else if (attacker.equals(owner)) {

            } else {
                Creature winner = BattleCalculator.fight(attacker, owner);
                log.debug("winner id=" + winner.getId() + ", name=" + winner.getName());
                if (!winner.equals(owner)){
                    saveToDB();
                }
                owner = winner;
                spread();
            }
        }
    }

    /**
     * Поднять из БД состояние
     */
    private void loadFromDB() {
        owner = gameMapService.get(x, y) == null ? null : gameMapService.get(x, y).getCreature();
    }


    /**
     * Сохранить в БД текущее положение вещей
     */
    private void saveToDB() {
        GameMap cell = gameMapService.get(x, y);
        if (cell == null) {
            cell = new GameMap();
            cell.setX(x);
            cell.setY(y);
        }
        cell.setCreature(owner);
        gameMapService.save(cell);
        log.debug("saved to DB id="+owner.getId()+", name="+owner.getName());
    }

    /**
     * Расселить в соседние клетки
     * 1 1 1
     * 1 0 1
     * 1 1 1
     * <p/>
     * 8-связность
     */
    private void spread() {
        for (int xCoord = x - 1; xCoord <= x + 1; xCoord++) {
            for (int yCoord = y - 1; yCoord <= y + 1; yCoord++) {
                if (x == xCoord && y == yCoord) continue;
                gameCore.settleCreature(xCoord, yCoord, owner);
                log.trace("Spreaded to x=" + xCoord + ", y=" + yCoord);
            }
        }
    }
}
