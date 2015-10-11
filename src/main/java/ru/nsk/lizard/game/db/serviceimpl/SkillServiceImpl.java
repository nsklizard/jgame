package ru.nsk.lizard.game.db.serviceimpl;

import org.springframework.stereotype.Service;
import ru.nsk.lizard.game.db.entities.Skill;
import ru.nsk.lizard.game.db.services.SkillService;

/**
 * Created by lizard on 11.10.2015.
 */
@Service
public class SkillServiceImpl extends BaseServiceImpl<Skill, Long> implements SkillService {
    public SkillServiceImpl() {
        super(Skill.class);
    }
}
