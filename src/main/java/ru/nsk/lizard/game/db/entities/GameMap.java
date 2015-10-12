package ru.nsk.lizard.game.db.entities;

import javax.persistence.*;

/**
 * Created by lizard on 13.10.2015.
 */
@Entity
@Table(name="game_map")
@SequenceGenerator(name = "default_gen", sequenceName = "game_map_id_seq", allocationSize = 1)
public class GameMap extends BaseEntity{
    @Column(name = "x")
    private long x;

    @Column(name = "y")
    private long y;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creatureId", nullable = false)
    private Creature creature;

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

    public Creature getCreature() {
        return creature;
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }
}
