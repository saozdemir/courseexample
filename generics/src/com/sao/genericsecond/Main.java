package com.sao.genericsecond;

public class Main {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaideCrows = new Team("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
        //adelaideCrows.addPlayer(pat);
        //adelaideCrows.addPlayer(beckham);

        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);
        System.out.println(baseballTeam.numPlayers());

        //Team<String> brokenTeam = new Team<>("This wont work"); //Derleme hatası yok //Runtime da hata alırız.
        //brokenTeam.addPlayer("No one");

        Team<SoccerPlayer> brokenTeam = new Team<>("this won't work");
        brokenTeam.addPlayer(beckham);

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2, 1);
        //adelaideCrows.matchResult(baseballTeam, 1, 1);//matchResult(Team<T> opponent, int ourScore, int theirScore) generic yapıldı


        League<Team<FootballPlayer>> footballLeague = new League<Team<FootballPlayer>>("SuperLeague");
        footballLeague.add(melbourne);
        footballLeague.add(hawthorn);
        footballLeague.add(fremantle);
        footballLeague.add(adelaideCrows);

        footballLeague.showLeagueTable();
    }
}
