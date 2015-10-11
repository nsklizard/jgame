package ru.nsk.lizard.game.db.services.common;

import java.io.Serializable;

public interface PersistentEnum extends Serializable {
    String getLocalizedName();

    String toString();
}
