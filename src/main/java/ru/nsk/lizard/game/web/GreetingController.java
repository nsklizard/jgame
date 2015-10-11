package ru.nsk.lizard.game.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsk.lizard.game.db.dao.UserDAO;

import javax.transaction.Transactional;

@RestController
public class GreetingController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/greeting")
    @Transactional
    public String greeting(@RequestParam(value="name"/*, defaultValue="World"*/) String name) {


//        Set<Creature> creatureSet = userDAO.find(1L).getCreatures();
//        for (Creature creature : creatureSet){
//            List<Creatureconfig> creatureConfigs = creature.getCreatureConfigs();
//        }

        return name;
    }


}