package models;

import java.util.ArrayList;
import java.util.List;


public class Squad {
    private String squadName;
    private String cause;
    private static boolean isRegisteredHero = false;
    private List<String> heroMembers = new ArrayList<>();
    private static List<Squad> squadList = new ArrayList<>();
    private int squadId;

    public Squad(String name, String cause, Hero hero) {
        this.squadName = name.trim();
        this.cause = cause.trim();
        crossCheckHero(hero.getHeroID());

        if (isRegisteredHero) {
            hero.setSquadAlliance(squadName);
            heroMembers.add(hero.getName());
            squadList.add(this);
            this.squadId = squadList.size();
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

    public void addMembers(Hero hero) {
        if (heroMembers.size() < 7) {
            heroMembers.add(hero.getName());
        } else {
            System.out.println("LIMIT REACHED!!!");
        }

    }

    public List<String> getMembers() {
        return heroMembers;
    }

    public String getCause() {
        return cause;
    }

    public static void changeHeroSquad(Hero hero, Squad newSquad) {
        Squad currentSquad = null;
        for (Squad squad : squadList) {
            if (hero.getSquadAlliance().equalsIgnoreCase(squad.squadName)) {
                currentSquad = squad;
                break;
            }
        }

        for (Squad squad : squadList) {
            if (newSquad.squadName.equalsIgnoreCase(squad.squadName)) {
                if (!hero.getSquadAlliance().equalsIgnoreCase("None")) {
                    //IF HERO EXISTED IN PREVIOUS SQUAD
                    //noinspection ConstantConditions
                    currentSquad.heroMembers.remove(hero.getName());
                    newSquad.heroMembers.add(hero.getName());
                    hero.setSquadAlliance(newSquad.squadName);
                    break;
                } else {
                    //IF HERO HAD NO ALLIANCE
                    newSquad.heroMembers.add(hero.getName());
                    hero.setSquadAlliance(newSquad.squadName);
                }
            } else {
                System.out.println("Squad Doesn't exist");
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

    private static void crossCheckHero(int idToCheck) {
        for (Hero hero : Hero.getHeroRegistry()) {
            if (hero.getHeroID() == idToCheck) {
                isRegisteredHero = true;
                break;
            }
        }
    }

}
