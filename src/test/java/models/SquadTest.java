package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ALL")
public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    private Hero setupNewHero() {
        return new Hero("Batman", 45, "Money", "Loneliness");
    }

    private Hero setupHero2() {
        return new Hero("Iron Man", 30, "Money", "Ego");
    }

    private Squad setupNewSquad(Hero hero) {
        return new Squad("Justice League", "Just Exist", hero);
    }

    private Squad setupNewSquad2(Hero hero) {
        return new Squad("Avengers", "Just Exist again", hero);
    }

    @Test
    public void squadInstanciatedCorrectly() {
        Squad squad = setupNewSquad(setupNewHero());
        assertTrue(squad instanceof Squad);
    }

    @Test
    public void getSquadName() {
        Squad squad = setupNewSquad(setupNewHero());
        assertTrue(squad.getName() instanceof String);
    }

    @Test
    public void getSquadCause() {
        Squad squad = setupNewSquad(setupNewHero());
        assertTrue(squad.getCause() instanceof String);
    }

    @Test
    public void addingHeroToExistingSquad() {
        Squad squad = setupNewSquad(setupNewHero());
        squad.addMembers(setupHero2());
        assertEquals(2, squad.getMembers().size());
    }

    @Test
    public void addHero_NotExeedLimitOf1_int() {
        /* Change back limit to 1 before testing again */
        Squad squad = setupNewSquad(setupNewHero());
        squad.addMembers(setupHero2());
        assertEquals(1, squad.getMembers().size());
    }

    @Test
    public void moveHeroToAnotherSquad() {
        Hero.clearHeroRegistry();
        Hero hero1 = setupNewHero();
        Hero hero2 = setupHero2();
        Squad squad = setupNewSquad(hero1);
        Squad squad2 = setupNewSquad(hero2);
        System.out.println("------------ Before -----------");
        System.out.println(squad.getMembers());
        System.out.println(squad2.getMembers());

        assertEquals(1, squad.getMembers().size());
        Squad.changeHeroSquad(hero1, squad2);

        System.out.println("------------ After-----------");
        System.out.println(squad.getMembers());
        System.out.println(squad2.getMembers());
        assertEquals(0, squad.getMembers().size());
        assertEquals(2, squad2.getMembers().size());
    }

    @After
    public void tearDown() throws Exception {
        Hero.clearHeroRegistry();
    }
}