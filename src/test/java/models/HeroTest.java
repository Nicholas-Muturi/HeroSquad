package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

@SuppressWarnings("ALL")
public class HeroTest {

    @Before
    public void setUp() throws Exception {
    }

    private Hero setupNewHero(){
        return new Hero ("Batman",40,"Money","Loneliness");
    }

    @Test
    public void heroInstantiatesCorrectly() {
        Hero newHero = setupNewHero();
        assertTrue(newHero instanceof Hero);
    }

    @Test
    public void getHeroName_true() {
        Hero newHero = setupNewHero();
        assertTrue(newHero.getName() instanceof String);
    }

    @After
    public void tearDown() throws Exception {
    }
}