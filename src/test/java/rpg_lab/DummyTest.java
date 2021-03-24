package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DummyTest {
    public static final int HEALTH = 10;
    public static final int EXPERIENCE = 13;

    private Dummy aliveDummy;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        aliveDummy = createDummy(HEALTH, EXPERIENCE);
        deadDummy = createDummy(0, EXPERIENCE);
    }

    @Test
    public void testDummyLosesHealthWhenAttacked() {
        aliveDummy.takeAttack(3);
        assertEquals(7, aliveDummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDummyFailsWhenAttacked() {
        deadDummy.takeAttack(0);
    }

    @Test
    public void testDeadDummyGivesExperience() {
        int actualExperience = deadDummy.giveExperience();
        assertEquals(EXPERIENCE, actualExperience);
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyDoesntGiveExperience() {
        aliveDummy.giveExperience();
    }

    private Dummy createDummy(int health, int experience) {
        return new Dummy(health, experience);
    }

}