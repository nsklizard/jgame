package ru.nsk.lizard.game.logic.v2;


import ru.nsk.lizard.game.db.entities.Creature;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dkim on 06.10.2015.
 */


public class CellProcessor extends Thread {
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
            System.out.println("added");
            lock.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (queue.isEmpty()) {
                    try {
                        System.out.println("locked");
                        lock.wait();
                        System.out.println("lock waited");
                    } catch (InterruptedException e) {
                        System.out.println("InterruptedException");
                    }
                }
                Creature attacker = queue.remove(0);
                if (owner == null) {
                    owner = attacker;
                } else if (attacker.equals(owner)){} else{
                    owner = BattleCalculator.fight(attacker, owner);
                }
            }
        }
    }
}
