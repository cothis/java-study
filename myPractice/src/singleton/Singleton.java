package singleton;

public class Singleton {
	public static void main(String[] args) {
		Test t = Test.getTest();
		System.out.println(t.number);
		t.number = 20;
		Test t2 = Test.getTest();
		System.out.println(t2.number);
	}
}

class Test {
	private static Test o;
	int number;
	
	private Test() {
		number = 5;
	}
	
	public static Test getTest() {
		if(o == null) {
			o = new Test();
		} 
		return o;
	}
}
