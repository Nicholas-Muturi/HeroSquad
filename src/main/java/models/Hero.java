package models;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private int age;
    private String specialPower;
    private String weakness;
    private List<Hero> allHeroes = new ArrayList<>();
    private int heroID;

    public Hero(String name, int age, String specialPower, String weakness) {
        this.name = name;
        this.age = age;
        this.specialPower = specialPower;
        this.weakness = weakness;
        this.allHeroes.add(this);
        this.heroID = allHeroes.size();
    }

    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
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

    public String getSpecialPower() {
        return specialPower;
    }

    public String getWeakness() {
        return weakness;
    }

    public List<Hero> getAllHeroes() {
        return allHeroes;
    }

    public int getHeroID() {
        return heroID;
    }
}
