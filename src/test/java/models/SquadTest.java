package models;

import org.junit.After;
import org.junit.Before;

@SuppressWarnings("ALL")
public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    private Hero setupNewHero() {
        return new Hero("Batman", 45, "Money", "Loneliness");
    }

    private Hero setupHero2() {
        return new Hero("Superman", 180, "Almost everything", "Kryptonite");
    }

    private Squad setupNewSquad() {
        return new Squad("Avengers", "Defeat Thanos");
    }


    @After
    public void tearDown() throws Exception {
        Hero.clearHeroRegistry();
    }
}