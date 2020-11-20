package myabstract;

public class MyAbstract {
	public static void main(String[] args) {
		/*
			abstract : 추상
						완전체는 아닌 선언만 되어있는 메소드를 포.함하는 클래스
						
						추상메소드 + 일반메소드  + 변수= 추상클래스
						
						자체 객체 생성은 거의 불가능하며, 상속 후 추상메소드를 작성한 후에 생성 가능
						자체 객체 생성하려면 객체 생성 시 인라인으로 override 메소드를 정의하여 사용 할수 있다.
						
			abstract class{
				method(){ // 일반 메소드
				}
				
				abstract method(); // 추상 메소드
			}
		 
		*/
		
		// 안되는 경우 : AbstractClass ac = new AbstractClass();
		/* 코드안에서 추상메소드 구현
		AbstractClass ac = new AbstractClass() {
			
			@Override
			public void absMethod() {
				// TODO Auto-generated method stub
				System.out.println("absMethod");				
			}
		};
		*/
		
		NormalClass nc = new NormalClass(); // 잘 된다.
		nc.method();
		nc.absMethod();
		System.out.println();
		
		AbstractClass ac = new NormalClass();
		ac.method();
		ac.absMethod();
		
	}
}

abstract class AbstractClass {
	public void method() {
		System.out.println("Abstract Normal method()");
	}
	public abstract void absMethod();
}

class NormalClass extends AbstractClass {

	@Override
	public void absMethod() {
		System.out.println("NormalClass override abs method()");
	}
	
}
