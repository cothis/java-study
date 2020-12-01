package day021.work.membercontrol.dto;

public class Batter extends Member {
    int hitCount;
    int hits;
    double hitRate;

    public Batter(String name, int age, double height, int hitCount, int hits, double hitRate) {
        super(name, age, height);
        this.hitCount = hitCount;
        this.hits = hits;
        this.hitRate = hitRate;
    }

    public int getHitCount() {
        return hitCount;
    }

    public void setHitCount(int hitCount) {
        this.hitCount = hitCount;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public double getHitRate() {
        return hitRate;
    }

    public void setHitRate(double hitRate) {
        this.hitRate = hitRate;
    }

    @Override
    public String saveData() {
        return "Batter:" + super.saveData() + String.format("-%d-%d-%.3f", hitCount, hits, hitRate);
    }
}
