package models;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private static List<Hero> heroRegistry = new ArrayList<>();
    private int heroID;

    public Hero(String name, int age, String power, String weakness) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        heroRegistry.add(this);
        this.heroID = heroRegistry.size();
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPower() {
        return power;
    }

    public String getWeakness() {
        return weakness;
    }

    public static List<Hero> getHeroRegistry() {
        return heroRegistry;
    }

    public static Hero findHero(int searchID) {
        return heroRegistry.get(searchID - 1);
    }

    public static Hero deleteHero(int searchID) {
        return heroRegistry.remove(searchID - 1);
    }

    public static void clearHeroRegistry(){
        heroRegistry.clear();
    }

    public int getHeroID() {
        return heroID;
    }
}
