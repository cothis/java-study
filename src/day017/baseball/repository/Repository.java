package day017.baseball.repository;

import day017.baseball.domain.Player;

import java.util.*;

public class Repository {
    private static final Map<Integer, Player> hashMap = new HashMap<>();
    private static int sequence = 0;

    public Player add(Player player) {
        player.setId(++sequence);
        hashMap.put(sequence, player);
        return player;
    }

    public void load(List<Player> players) {
        for (Player player : players) {
            if(player != null) {
                System.out.println(player);
                hashMap.put(player.getId(), player);
                sequence = player.getId();
            }
        }
    }

    public Optional<Player> removeById(int id) {
        return Optional.ofNullable(hashMap.remove(id));
    }

    public Optional<Player> findById(int id) {
        return Optional.ofNullable(hashMap.get(id));
    }

    public Optional<Player> findByName(String name) {
        return hashMap.values().stream()
                .filter(player -> player.getName().equals(name))
                .findAny();
    }

    public List<Player> findAll() {
        return new ArrayList<>(hashMap.values());
    }

    public void clearAll() {
        hashMap.clear();
    }
}
