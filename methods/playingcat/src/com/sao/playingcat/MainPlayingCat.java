package com.sao.playingcat;

import static com.sao.playingcat.PlayingCat.isCatPlaying;

public class MainPlayingCat {
    public static void main(String[] args) {
        System.out.println(isCatPlaying(true, 10));
        System.out.println(isCatPlaying(false, 36));
        System.out.println(isCatPlaying(false, 35));
    }
}
