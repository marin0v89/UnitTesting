package rpg_lab;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.nio.file.Watchable;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class HeroTest {
    @Test
    public void testHeroGainsExperienceWhenTargetIsKilled() {

        Weapon weapon = mock(Weapon.class);
        Target target = mock(Target.class);

        Hero hero = new Hero("Java-Wizard", weapon);
        when(target.isDead()).thenReturn(true);
        when(target.giveExperience()).thenReturn(13);
        hero.attack(target);
        assertEquals(13, hero.getExperience());
    }
}