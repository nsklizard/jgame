package ru.nsk.lizard.game.common;

import org.springframework.stereotype.Component;

/**
 * Created by dkim on 12.05.2015.
 */
@Component
public class GameProperties {
    public static final String MAP_ATTR = "MAP_ATTR";
    public static int WORLD_WIDTH;
    public static int WORLD_LENGTH;

    static{
        WORLD_WIDTH = getIntProperty("world.width", 3);
        WORLD_LENGTH = getIntProperty("world.length", 3);
    }

    private static int getIntProperty(String propertyName, int defaultInt){
        try {
            return Integer.parseInt(PropertyUtils.get(propertyName));
        }catch (NumberFormatException e){
            return defaultInt;
        }
    }
}
