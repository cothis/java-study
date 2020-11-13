package baseball;

public class Main {
	public static void main(String[] args) {
		/*
		Baseball bb = new Baseball();
		bb.init();
		*/
		System.out.println("ha");
		BaseballByTeacher ball = new BaseballByTeacher();
		ball.init();
		ball.loop();
		ball.result();
		
	}
}
