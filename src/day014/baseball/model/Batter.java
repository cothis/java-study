package day014.baseball.model;

public class Batter extends Human{
	private int hitCount;
	private int hits;
	private double battingAve;
	
	public Batter() {
		
	}
	
	public Batter(int number, String name, int age, double height, int hitCount, int hits, double battingAve) {
		super(number, name, age, height);
		this.hitCount = hitCount;
		this.hits = hits;
		this.battingAve = battingAve;
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
	public double getBattingAve() {
		return battingAve;
	}
	public void setBattingAve(double battingAve) {
		this.battingAve = battingAve;
	}
	@Override
	public String toString() {
		return super.toString() + ", hit Count : " + hitCount + ", hits: " + hits + ", batting Average: " + battingAve;
	}
	
	
	
}
