package ru.netology.javaqa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        Player player2 = findByName(playerName2);
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }

    public Player findByName(String name) {
        return players.get(name);
    }
}
