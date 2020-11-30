package day021.work.membercontrol.dto;

public class Pitcher extends Member {

    int win;
    int lose;
    double defence;

    public Pitcher(String name, int age, double height, int win, int lose, double defence) {
        super(name, age, height);
        this.win = win;
        this.lose = lose;
        this.defence = defence;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public double getDefence() {
        return defence;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }
}
