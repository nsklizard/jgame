package ru.nsk.lizard.game.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsk.lizard.game.db.entities.Skill;
import ru.nsk.lizard.game.logic.GameCore;

import java.util.List;

/**
 * Created by dkim on 20.05.2015.
 */
@RestController
public class GameRESTFunctionsController {

    @Autowired
    GameCore gameCore;

    @RequestMapping("/settleCreature")
    public String settleCreature(@RequestParam(value = "x") int x,
                                 @RequestParam(value = "y") int y,
                                 @RequestParam(value = "creatureId") long creatureId) {
        gameCore.settleCreature(x, y, creatureId);
        return "creature with id=" + creatureId + " settled in x=" + x + ", y=" + y;
    }

    @RequestMapping("/getSkills")
    public List<Skill> getSkills() {
        return gameCore.getSkills();
    }
}
