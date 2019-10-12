package models;

import java.util.ArrayList;
import java.util.List;


public class Squad {
    private String squadName;
    private String cause;
    private static boolean isRegisteredHero = false;
    private List<Object> heroMembers = new ArrayList<>();
    private static List<Squad> squadList = new ArrayList<>();
    private int squadId;

    public Squad(String name, String cause, Hero hero) {
        this.squadName = name.trim();
        this.cause = cause.trim();
        crossCheckHero(hero.getHeroID());

        if (isRegisteredHero) {
            hero.setSquadAlliance(squadName);
            heroMembers.add(hero);
            squadList.add(this);
            this.squadId = squadList.size();

            System.out.println(hero.getName() + "......." + hero.getSquadAlliance());
        } else {
            System.out.println("HERO ISN'T REGISTERED");
        }
    }

    public String getName() {
        return squadName;
    }

    public int getSquadId() {
        return squadId;
    }

    public String getCause() {
        return cause;
    }

    public static void crossCheckHero(int idToCheck) {
        for (Hero hero : Hero.getHeroRegistry()) {
            if (hero.getHeroID() == idToCheck) {
                isRegisteredHero = true;
                break;
            }
        }
    }


    public void clearMemberLists() {
        heroMembers.clear();
    }

    public static List<Squad> getAllSquads() {
        return squadList;
    }

    public static void clearSquadList() {
        squadList.clear();
    }

}
