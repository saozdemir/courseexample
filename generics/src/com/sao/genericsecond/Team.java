package com.sao.genericsecond;

import java.util.ArrayList;
import java.util.Collections;

//public class Team<T> { //Base class exteds yok
public class Team<T extends Player> implements Comparable<Team<T>> { //Tür argümanı olarak kullanımı kısıtladık kısıtladık //String tanımlanan satır çalışmaz!!
    // Ayrıca casting yapmamıza gerek kalmadı çünkü Player türü için kısıtlama getirdik.
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<T> members = new ArrayList<>(); //Abstract Player classı için oluşturuldu

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) { //Player is an asbtract no concreate!
        if (members.contains(player)) {
            //System.out.println(((Player) player).getName() + " is already on the this team"); //Base type olarak tanımlama yapılırsa casting gerekiyor
            System.out.println(player.getName() + " is already on the this team");
            return false;
        } else {
            members.add(player);
            //System.out.println(((Player) player).getName() + " picked for team " + this.name);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) { //Aynı takımlar arası maç yapılabilmesi için generic yaptık.
        // Böylece futbol ve basebol takımım maç yaptı demeyecek.
        String message;
        if (ourScore > theirScore) {
            won++;
            message = " Beat ";
        } else if (ourScore == theirScore) {
            tied++;
            message = " Drew with ";
        } else {
            lost++;
            message = " Lost to ";
        }
        played++;
        if (opponent != null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore); //Rakinin puanini güncelledik. Rakip argümanı null yaptık sadece skor güncelleyeceğiz.
        }
    }

    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1;
        } else if (this.ranking() < team.ranking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
