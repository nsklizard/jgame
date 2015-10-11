package ru.nsk.lizard.game.db.serviceimpl;

import org.springframework.stereotype.Service;
import ru.nsk.lizard.game.db.entities.Creature;
import ru.nsk.lizard.game.db.services.CreatureService;

/**
 * Created by lizard on 11.10.2015.
 */
@Service
public class CreatureServiceImpl extends BaseServiceImpl<Creature, Long> implements CreatureService {
    public CreatureServiceImpl() {
        super(Creature.class);
    }
}

