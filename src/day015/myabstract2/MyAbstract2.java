package day015.myabstract2;

public class MyAbstract2 {
	public static void main(String[] args) {
		/*
			ballpen, pencil
		*/
		
		Writer w = new BallPen();
		
		MyClass mc = new MyClass(w);
		
		mc.method();
	}
}

class MyClass {
	
	Writer w;
	
	MyClass(Writer w) {
		this.w = w;
	}
	
	void method() {
		w.write();
		w.erase();
	}
}

abstract class Writer {
	
	abstract void write();
	
	void erase() {
		System.out.println("기록을 지웁니다.");		
	}
}

class BallPen extends Writer {

	@Override
	void write() {
		System.out.println("볼펜으로 기록합니다.");
	}
}

class Pencil extends Writer {

	@Override
	void write() {
		System.out.println("펜슬로 기록합니다.");
		
	}
	
}
