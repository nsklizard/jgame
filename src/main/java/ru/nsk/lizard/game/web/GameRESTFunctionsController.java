package ru.nsk.lizard.game.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsk.lizard.game.common.GameConstants;
import ru.nsk.lizard.game.db.dao.impl.CreatureDAOJPAImpl;
import ru.nsk.lizard.game.db.dao.GameMapDAO;
import ru.nsk.lizard.game.logic.ActionProcessor;
import ru.nsk.lizard.game.logic.FightJob;

/**
 * Created by dmitr_000 on 20.05.2015.
 */
@RestController
public class GameRESTFunctionsController {

    @Autowired
    CreatureDAOJPAImpl creatureDAOJPAImpl;

    @Autowired
    GameMapDAO gameMapDAO;

    @Autowired
    ActionProcessor actionProcessor;

    @RequestMapping("/settleCreature")
    public String settleCreature(@RequestParam(value = "x") int x,
                                 @RequestParam(value = "y") int y,
                                 @RequestParam(value = "creatureId") long creatureId) {
        if (x < 0 || y < 0 || creatureId <= 0 || x > GameConstants.WORLD_SIZE || y > GameConstants.WORLD_SIZE) {
            return "failed to settle creature";
        }
        actionProcessor.queue.add(new FightJob(x, y, creatureDAOJPAImpl.find(creatureId), gameMapDAO));
        return "creature with id=" + creatureId + " settled in x=" + x + ", y=" + y;
    }
}
