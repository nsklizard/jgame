package ru.nsk.lizard.game.logic.v2;


import ru.nsk.lizard.game.db.entities.Creature;
import ru.nsk.lizard.game.db.entities.Skill;
import ru.nsk.lizard.game.db.enums.SkillType;

import java.util.Map;

/**
 * Created by dkim on 07.10.2015.
 */
public class BattleCalculator {
    public static Creature fight(Creature attacker, Creature defender) {
        //TODO: refactor

        int c1AttackFire = 0;
        int c1AttackWater = 0;
        int c1AttackAir = 0;
        int c1AttackEarth = 0;
        int c1AttackEther = 0;

        int c1DefenceFire = 0;
        int c1DefenceWater = 0;
        int c1DefenceAir = 0;
        int c1DefenceEarth = 0;
        int c1DefenceEther = 0;

        int c2AttackFire = 0;
        int c2AttackWater = 0;
        int c2AttackAir = 0;
        int c2AttackEarth = 0;
        int c2AttackEther = 0;

        int c2DefenceFire = 0;
        int c2DefenceWater = 0;
        int c2DefenceAir = 0;
        int c2DefenceEarth = 0;
        int c2DefenceEther = 0;

        Map<Skill, Long> c1Skills = attacker.getSkills();
        for (Skill s : c1Skills.keySet()) {
            if (s.getType().equals(SkillType.OFFENSE)) {
                c1AttackFire += s.getFire() * c1Skills.get(s);
                c1AttackWater += s.getWater() * c1Skills.get(s);
                c1AttackAir += s.getAir() * c1Skills.get(s);
                c1AttackEarth += s.getEarth() * c1Skills.get(s);
                c1AttackEther += s.getEther() * c1Skills.get(s);
            } else if (s.getType().equals(SkillType.DEFENCE)) {
                c1DefenceFire += s.getFire() * c1Skills.get(s);
                c1DefenceWater += s.getWater() * c1Skills.get(s);
                c1DefenceAir += s.getAir() * c1Skills.get(s);
                c1DefenceEarth += s.getEarth() * c1Skills.get(s);
                c1DefenceEther += s.getEther() * c1Skills.get(s);
            }
        }


        Map<Skill, Long> c2Skills = defender.getSkills();
        for (Skill s : c2Skills.keySet()) {
            if (s.getType().equals(SkillType.OFFENSE)) {
                c2AttackFire += s.getFire() * c1Skills.get(s);
                c2AttackWater += s.getWater() * c1Skills.get(s);
                c2AttackAir += s.getAir() * c1Skills.get(s);
                c2AttackEarth += s.getEarth() * c1Skills.get(s);
                c2AttackEther += s.getEther() * c1Skills.get(s);
            } else if (s.getType().equals(SkillType.DEFENCE)) {
                c2DefenceFire += s.getFire() * c1Skills.get(s);
                c2DefenceWater += s.getWater() * c1Skills.get(s);
                c2DefenceAir += s.getAir() * c1Skills.get(s);
                c2DefenceEarth += s.getEarth() * c1Skills.get(s);
                c2DefenceEther += s.getEther() * c1Skills.get(s);
            }
        }

        long totalC1DPS = (c1AttackFire - c2DefenceFire < 0 ? 0 : (c1AttackFire - c2DefenceFire))
                + (c1AttackWater - c2DefenceWater < 0 ? 0 : (c1AttackWater - c2DefenceWater))
                + (c1AttackAir - c2DefenceAir < 0 ? 0 : (c1AttackAir - c2DefenceAir))
                + (c1AttackEarth - c2DefenceEarth < 0 ? 0 : (c1AttackEarth - c2DefenceEarth))
                + (c1AttackEther - c2DefenceEther < 0 ? 0 : (c1AttackEther - c2DefenceEther));

        long totalC2DPS = (c2AttackFire - c1DefenceFire < 0 ? 0 : (c2AttackFire - c1DefenceFire))
                + (c2AttackWater - c1DefenceWater < 0 ? 0 : (c2AttackWater - c1DefenceWater))
                + (c2AttackAir - c1DefenceAir < 0 ? 0 : (c2AttackAir - c1DefenceAir))
                + (c2AttackEarth - c1DefenceEarth < 0 ? 0 : (c2AttackEarth - c1DefenceEarth))
                + (c2AttackEther - c1DefenceEther < 0 ? 0 : (c2AttackEther - c1DefenceEther));

        if (totalC1DPS>totalC2DPS){
            return attacker;
        }

        return defender;
    }
}
