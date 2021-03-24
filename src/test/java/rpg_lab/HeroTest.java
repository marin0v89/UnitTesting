package rpg_lab;

import org.junit.Test;

import java.nio.file.Watchable;

import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void testHeroGainsExperienceWhenTargetIsKilled() {
        Weapon weapon = new Weapon() {

            @Override
            public int getAttackPoints() {
                return 0;
            }

            @Override
            public int getDurabilityPoints() {
                return 0;
            }

            @Override
            public void attack(Target target) {

            }
        };

        Target target = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return 13;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };
        Hero hero = new Hero("Java-Wizard", weapon);
        hero.attack(target);
        assertEquals(13, hero.getExperience());
    }
}