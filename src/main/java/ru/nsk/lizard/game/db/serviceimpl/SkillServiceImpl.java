package ru.nsk.lizard.game.db.serviceimpl;

import org.springframework.stereotype.Service;
import ru.nsk.lizard.game.db.entities.Skill;
import ru.nsk.lizard.game.db.services.SkillService;

import java.util.List;

/**
 * Created by lizard on 11.10.2015.
 */
@Service
public class SkillServiceImpl extends BaseServiceImpl<Skill, Long> implements SkillService {
    public SkillServiceImpl() {
        super(Skill.class);
    }

    @Override
    public List<Skill> getRandomSkills(int quantity) {
        //http://blog.rhodiumtoad.org.uk/2009/03/08/selecting-random-rows-from-a-table/
        return em.createNativeQuery("select * from skills where id in\n" +
                "        (select floor(random() * (max_id - min_id + 1)) + min_id\n" +
                "           from generate_series(1,"+quantity*2+"),\n" +
                "                (select max(id) as max_id,\n" +
                "                        min(id) as min_id\n" +
                "                   from skills) s1\n" +
                "         limit "+quantity*2+")\n" +
                " order by random() limit " + quantity, Skill.class).getResultList();
    }
}
