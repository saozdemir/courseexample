package com.sao.genericsecond;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String name;
    private ArrayList<T> teams = new ArrayList<T>();

    public League(String name) {
        this.name = name;
    }

    public boolean add(T team) {
        if (teams.contains(team)) {
            System.out.println(team.getName() + " already exist in the league of " + this.name);
            return false;
        } else {
            teams.add(team);
            return true;
        }
    }

    public void showLeagueTable() {
        Collections.sort(teams);
        for (T team : teams) {
            System.out.println(team.getName() + " : " + team.ranking());
        }
    }
}
