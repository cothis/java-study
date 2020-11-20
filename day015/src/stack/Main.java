package stack;

import java.util.Scanner;

public class Main {
	
	static void menu() {
		Scanner sc = new Scanner(System.in);
		
		// 몇개짜리 스택만들건지?
		System.out.print("크기: ");
		int capacity = sc.nextInt();
		StackClass stackClass = new StackClass(capacity);
		
		// 메인 프로세스
		while(true) {
			System.out.print("(1)추가 (2)삭제 (3)마지막값 (4)종료 : ");
			int select = sc.nextInt();
			
			if(select == 1) {
				// 추가
				System.out.println("넣을 값을 입력해주세요");
				String input = sc.next();
				stackClass.push(input);
				
			}
			else if (select == 2) {
				// 삭제
				stackClass.pop();
			} 
			else if (select == 3) {
				// 마지막값(peek)
				String result = (String) stackClass.peek();
				System.out.println(result);
			}
			else if(select == 4) break;
		}
		
		
		
		
		sc.close();
	}
	
	public static void main(String[] args) {
	/*
		Stack: First In Last Out
	*/	
		menu();
		
		/*
		StackClass stack = new StackClass(5);
		
		String str = "one";
		stack.push(str);
		
		String peekStr = (String) stack.peek();
		System.out.println("push(\"one\")");
		System.out.println("peekStr: " + peekStr);
		
		str = "two";
		stack.push(str);
		
		System.out.println();
		System.out.println("push(\"two\")");
		peekStr = (String) stack.peek();
		System.out.println("peekStr: " + peekStr);
		
		String popStr = (String) stack.pop();
		peekStr = (String) stack.peek();
		System.out.println();
		System.out.println("pop()");
		System.out.println("popStr: " + popStr);
		System.out.println("peekStr: " + peekStr);
		
		Integer i = 111;
		stack.push(i);
		
		int t = (Integer) stack.peek();
		System.out.println();
		System.out.println("push(111)");
		System.out.println("peekStr: " + t);
		*/
	}
}

class StackClass {
	
	private int top;				//통 최상위 인덱스
	private int maxSize;
	private Object[] stackArray;	//통
	
	StackClass(int maxSize) {
		this.maxSize = maxSize;
		this.top = -1;
		
		this.stackArray = new Object[this.maxSize];
	}
	
	// 통이 비어있는지?
	boolean isEmpty() {
		return (top == -1);
	}
	
	// 통이 가득 차 있는지?
	boolean isFull() {
		return (top == maxSize-1);
	}
	
	void push(Object obj) {
		if(isFull()) {
			System.out.println("통이 가득 차 있습니다.");
			return;
		}
		
		top++;
		stackArray[top] = obj;
		System.out.println(obj + " 값이 추가되었습니다.");
	}
	
	// 통에 공을 뺀다.
	Object pop() {
		Object obj = peek();
		
		if (top > -1) {
			top--;
			System.out.println(obj + " 값이 삭제되었습니다.");
		}
		
		return obj;
	}
	
	// Top에 있는 것을 확인
	Object peek() {
		if(isEmpty()) {
			System.out.println("통이 비어있습니다.");
			return null;
		}
		
		return stackArray[top];		
	}
}











