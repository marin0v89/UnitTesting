package rpg_lab;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class AxeTest {
    public static final int ATTACK = 10;
    public static final int DURABILITY = 10;


    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        axe = createAxe(ATTACK, DURABILITY);
        dummy = createDummy();
    }

    @Test
    public void testAxeConstructorShouldSetCorrectAttackAndDurability() {
        assertEquals(ATTACK, axe.getAttackPoints());
        assertEquals(DURABILITY, axe.getDurabilityPoints());

    }

    @Test(expected = IllegalStateException.class)
    public void testAxeAttackShouldFailIfAxeHasZeroDurability() {
        Axe axe = createAxe(ATTACK, 0);
        axe.attack(dummy);
    }

    @Test
    public void testAxeLosesSingleDurabilityPointWhenAttacking() {
        axe.attack(dummy);
        assertEquals(DURABILITY - 1, axe.getDurabilityPoints());
    }

    private Dummy createDummy() {
        return new Dummy(100, 100);
    }

    private Axe createAxe(int attack, int durability) {
        return new Axe(attack, durability);
    }
}
