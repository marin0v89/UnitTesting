package rpg_lab;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    private static class TestWeapon implements Weapon {

        @Override
        public int getAttackPoints() {
            return 0;
        }

        @Override
        public int getDurabilityPoints() {
            return 0;
        }

        @Override
        public void attack(Dummy target) {

        }
    }

    private static class TestTarget implements Target {

    }

    @Test
    public void testHeroGainsExperienceWhenTargetIsKilled() {
        //Hero hero = new Hero("Java_Wizzard", new TestWeapon());
        //hero.attack(TestTarget());
       // assertEquals(13, hero.getExperience());
    }

}