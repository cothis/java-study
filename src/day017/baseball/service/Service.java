package day017.baseball.service;

import day017.baseball.domain.Player;
import day017.baseball.repository.Repository;

import java.util.List;
import java.util.Optional;

public class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public int join(Player player) {
        repository.add(player);
        return player.getId();
    }

    public void joinLoadData(List<Player> players) {
        repository.load(players);
    }

    public Optional<Player> removeById(int id) {
        return repository.removeById(id);
    }

    public Optional<Player> findByName(String name) {
        return repository.findByName(name);
    }

    public Optional<Player> findOne(int id) {
        return repository.findById(id);
    }

    public List<Player> findPlayers() {
        return repository.findAll();
    }
}
