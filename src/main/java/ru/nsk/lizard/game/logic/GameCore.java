package ru.nsk.lizard.game.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.nsk.lizard.game.db.common.Filter;
import ru.nsk.lizard.game.db.entities.Creature;
import ru.nsk.lizard.game.db.entities.CreatureSkillLink;
import ru.nsk.lizard.game.db.entities.Skill;
import ru.nsk.lizard.game.db.services.CreatureService;
import ru.nsk.lizard.game.db.services.GameMapService;
import ru.nsk.lizard.game.db.services.SkillService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * Created by dkim on 07.10.2015.
 */
@Component
@Scope
public class GameCore {

    @Autowired
    CreatureService creatureService;

    @Autowired
    SkillService skillService;

    @Autowired
    GameMapService gameMapService;

    CellProcessor[][] cp = null;

    @PostConstruct
    public void init() {
        initMap(3, 3);
    }

    public void initMap(int width, int length) {
        cp = new CellProcessor[width][length];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < length; y++) {
                cp[x][y] = new CellProcessor(x,y,this, gameMapService);
                cp[x][y].start();
            }
        }
    }

    public void settleCreature(int x, int y, Creature creature) {
        //TODO: сделать проверку на координаты
//        Creature creature = creatureService.findById(creatureId);
        cp[x][y].addCreature(creature);
    }

    public List<Skill> getSkills() {
        return skillService.search(new Filter());
    }

    /**
     * @param name
     * @param skills - <tt>Map</tt> <Skill Id, SkillPower>
     */
    public Long createCreature(String name, Map<Long, Long> skills) {
        Creature creature = new Creature();
        creature.setName(name);

        for (Long skillId : skills.keySet()) {
            CreatureSkillLink link = new CreatureSkillLink();
            link.setSkill(skillService.findById(skillId));
            link.setCreature(creature);
            link.setPower(skills.get(skillId));
            creature.getSkillLinks().add(link);
        }

        creature = creatureService.save(creature);
        return creature == null ? null : creature.getId();
    }

}
