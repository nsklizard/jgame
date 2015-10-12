package ru.nsk.lizard.game.db.serviceimpl;

import com.googlecode.genericdao.search.Search;
import org.springframework.stereotype.Service;
import ru.nsk.lizard.game.db.common.Filter;
import ru.nsk.lizard.game.db.entities.GameMap;
import ru.nsk.lizard.game.db.services.GameMapService;

import javax.persistence.NoResultException;

/**
 * Created by lizard on 13.10.2015.
 */
@Service
public class GameMapServiceImpl extends BaseServiceImpl<GameMap, Long> implements GameMapService {
    public GameMapServiceImpl() {
        super(GameMap.class);
    }

    public GameMap get(long x, long y){
        try {
            return (GameMap) em.createQuery("from GameMap where x = " + x + " and y = " + y)
                    .getSingleResult();
        }catch (NoResultException nre){
            return null;
        }
    }
}
