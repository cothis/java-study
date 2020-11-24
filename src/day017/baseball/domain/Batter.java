package day017.baseball.domain;

public class Batter extends Player{
    int moundCount;
    int hits;
    double hitRate;

    public Batter() {
    }

    public Batter(int id, String name, int age, double height, int moundCount, int hits, double hitRate) {
        super(id, name, age, height);
        this.moundCount = moundCount;
        this.hits = hits;
        this.hitRate = hitRate;
    }

    public int getMoundCount() {
        return moundCount;
    }

    public void setMoundCount(int moundCount) {
        this.moundCount = moundCount;
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
    public String toString() {
        return super.toString() +
                ", moundCount=" + moundCount +
                ", hits=" + hits +
                ", hitRate=" + hitRate;
    }
}
