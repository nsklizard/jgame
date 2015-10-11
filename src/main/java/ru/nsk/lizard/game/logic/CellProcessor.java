package ru.nsk.lizard.game.logic;


import org.apache.log4j.Logger;
import ru.nsk.lizard.game.db.entities.Creature;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dkim on 06.10.2015.
 */
public class CellProcessor extends Thread {
    Logger log = Logger.getLogger(CellProcessor.class.getName());

    private List<Creature> queue = new LinkedList<Creature>();
    private Creature owner = null;

    private Object lock = new Object();


    public Creature getOwner(){
        return owner;
    }

    public void addCreature(Creature creature) {
        if (creature==null) return;

        synchronized (lock) {
            queue.add(creature);
            log.debug("creature added to processing queue");
            lock.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (queue.isEmpty()) {
                    try {
                        log.debug("CellProcessor locked");
                        lock.wait();
                        log.debug("CellProcessor notified");
                    } catch (InterruptedException e) {
                        log.error(e);
                    }
                }
                Creature attacker = queue.remove(0);
                if (owner == null) {
                    owner = attacker;
                } else if (attacker.equals(owner)){

                } else{
                    owner = BattleCalculator.fight(attacker, owner);
                    log.debug("CellProcessor new settler"+owner.getId()+" "+owner.getName());
                }
            }
        }
    }
}
