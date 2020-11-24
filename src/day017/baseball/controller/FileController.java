package day017.baseball.controller;

import day017.baseball.domain.Batter;
import day017.baseball.domain.Pitcher;
import day017.baseball.domain.Player;
import day017.baseball.service.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    private final Service service;
    private File file;

    public FileController(Service service) {
        this.service = service;
        try {
            createFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createFile() throws Exception{
        file = new File("D:/tmp/day014_baseball.txt");
        if(!file.exists()) {
            file.createNewFile();
        }
    }

    public void saveData(List<Player> players) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            for(Player player : players) {
                if(player instanceof Pitcher) {
                    player.setId(player.getId()+1000);
                }
                else if(player instanceof Batter) {
                    player.setId(player.getId()+5000);
                }
                pw.println(player);
            }

            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Player> loadData() {
        List<Player> players = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while((line = br.readLine()) != null) {
                players.add(createPlayer(line));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return players;
    }

    public Player createPlayer(String line) {
        Player player = null;
        String[] elements = line.split(",");
        for(int i = 0; i < elements.length; i++ ) {
            elements[i] = elements[i]
                    .substring(elements[i].indexOf("=") + 1)
                    .trim();
        }
        int number = Integer.parseInt(elements[0]);
        String name = elements[1];
        int age = Integer.parseInt(elements[2]);
        double height = Double.parseDouble(elements[3]);

        int ex1 = Integer.parseInt(elements[4]);
        int ex2 = Integer.parseInt(elements[5]);
        double ex3 = Double.parseDouble(elements[6]);;

        if(number / 1000 == 1) {
            player = new Pitcher(number-1000, name, age, height, ex1, ex2, ex3);
        }
        else if (number / 5000 == 1) {
            player = new Batter(number-5000, name, age, height, ex1, ex2, ex3);
        }

        return player;
    }
}
