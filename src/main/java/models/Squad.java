package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private Hero newHero;
    private String squadName;
    private String cause;
    private String[] members = new String[6];
    private static List<Squad> squadList = new ArrayList<>();
    private int squadId;

    public Squad(String name, String cause) {
        this.squadName = name;
        this.cause = cause;
    }

    public Hero getHero() {
        return newHero;
    }

    public String getName() {
        return squadName;
    }


    public int getSquadId() {
        return squadId;
    }
}
