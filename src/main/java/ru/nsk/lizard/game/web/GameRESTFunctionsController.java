package ru.nsk.lizard.game.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsk.lizard.game.db.common.Filter;
import ru.nsk.lizard.game.db.entities.Creature;
import ru.nsk.lizard.game.db.entities.GameMap;
import ru.nsk.lizard.game.db.entities.Skill;
import ru.nsk.lizard.game.db.services.CreatureService;
import ru.nsk.lizard.game.db.services.GameMapService;
import ru.nsk.lizard.game.db.services.SkillService;
import ru.nsk.lizard.game.logic.GameCore;
import ru.nsk.lizard.game.web.jsonpojo.CreaturePOJO;
import ru.nsk.lizard.game.web.jsonpojo.GameMapPOJO;
import ru.nsk.lizard.game.web.jsonpojo.SkillPOJO;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dkim on 20.05.2015.
 */
@RestController
public class GameRESTFunctionsController {

    @Autowired
    GameCore gameCore;

    @Autowired
    CreatureService creatureService;

    @Autowired
    GameMapService gameMapService;

    @Autowired
    SkillService skillService;

    @RequestMapping("/settleCreature")
    public ResponseEntity<String> settleCreature(@RequestParam(value = "x") int x,
                                 @RequestParam(value = "y") int y,
                                 @RequestParam(value = "creatureId") long creatureId) {
        //TODO: проверка входных значений
        gameCore.settleCreature(x, y, creatureService.findById(creatureId));
        return new ResponseEntity<String>("creature with id=" + creatureId + " settled in x=" + x + ", y=" + y, HttpStatus.OK);
    }

    @RequestMapping("/getMap")
    public ResponseEntity<List<GameMapPOJO>> getMap() {
        List<GameMap> map = gameMapService.search(new Filter());

        List<GameMapPOJO> ret = new LinkedList<>();
        for (GameMap gm : map) {
            ret.add(new GameMapPOJO(gm));
        }

        return new ResponseEntity<List<GameMapPOJO>>(ret, HttpStatus.OK);
    }

    @RequestMapping("/getSkills")
    public ResponseEntity<List<SkillPOJO>> getSkills(@RequestParam(value = "quantity") int quantity) {
//        List<Skill> skills = gameCore.getSkills();
        List<Skill> skills = skillService.getRandomSkills(quantity);

        List<SkillPOJO> ret = new LinkedList<>();
        for (Skill skill : skills) {
            ret.add(new SkillPOJO(skill));
        }

        return new ResponseEntity<List<SkillPOJO>>(ret, HttpStatus.OK);
    }

    @RequestMapping(value = "/createCreature", method = RequestMethod.POST)
    public ResponseEntity<Long> createCreature(@RequestBody CreaturePOJO creaturePOJO) {
        //todo: validate creature

        Long id = gameCore.createCreature(creaturePOJO.getName(), creaturePOJO.getSkills());
        if (id != null) {
            return new ResponseEntity<Long>(id, HttpStatus.OK);
        } else {
            return new ResponseEntity<Long>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/getCreature")
    public ResponseEntity<CreaturePOJO> getCreature(@RequestParam(value = "id") long id) {
        Creature creature = creatureService.findById(id);

        if (creature != null) {
            return new ResponseEntity<CreaturePOJO>(new CreaturePOJO(creature), HttpStatus.OK);
        } else {
            return new ResponseEntity<CreaturePOJO>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/getCreatureLandsCount")
    public ResponseEntity<String> getCreatureLandsCount(@RequestParam(value = "id") long id) {
        return new ResponseEntity<String>(String.valueOf(gameMapService.getCreatureLandsCount(id)), HttpStatus.OK);
    }

}
