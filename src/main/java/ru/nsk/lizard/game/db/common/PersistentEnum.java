package ru.nsk.lizard.game.db.common;

import java.io.Serializable;

public interface PersistentEnum extends Serializable {
    String getLocalizedName();

    String toString();
}
