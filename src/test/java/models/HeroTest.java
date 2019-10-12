package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void getHeroAge_int() {
        Hero newHero = setupNewHero();
        assertEquals(40,newHero.getAge());
    }

    @Test
    public void getHeroPower_true() {
        Hero newHero = setupNewHero();
        assertTrue(newHero.getPower() instanceof String);
    }

    @Test
    public void getHeroWeakness_true() {
        Hero newHero = setupNewHero();
        assertTrue(newHero.getWeakness() instanceof String);
    }



    @After
    public void tearDown() throws Exception {

    }
}