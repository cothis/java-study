package day015.queue;

public class Main {
	public static void main(String[] args) {
	
	/*
		Queue
		First In First Out
	*/
		
		QueueClass queue = new QueueClass(5);
		
		String str = "one";
		queue.push(str);
		String peek = (String) queue.peek();
		System.out.println("queue.push(str)");
		System.out.println("queue.peek() : " + peek);
		System.out.println();
		
		str = "two";
		queue.push(str);
		peek = (String) queue.peek();
		System.out.println("queue.push(str)");
		System.out.println("queue.peek() : " + peek);
		System.out.println();
		
		str = "three";
		queue.push(str);
		peek = (String) queue.peek();
		System.out.println("queue.push(str)");
		System.out.println("queue.peek() : " + peek);
		System.out.println();
		
		queue.pop();
		peek = (String) queue.peek();
		System.out.println("queue.pop()");
		System.out.println("queue.peek() : " + peek);
		System.out.println();
		
		queue.pop();
		peek = (String) queue.peek();
		System.out.println("queue.pop()");
		System.out.println("queue.peek() : " + peek);
		System.out.println();
		
	}
}

class QueueClass {
	private int front;
	private int rear;
	
	private int maxSize;
	private Object[] queueArray;
	public QueueClass(int maxSize) {
		super();
		this.front = 0;
		this.rear = -1;
		this.maxSize = maxSize;
		this.queueArray = new Object[maxSize];
	}
	
	public boolean isEmpty() {
		boolean res = front == rear + 1;
		if(res) {
			System.out.println("큐가 비어있습니다.");
		}
		return res;
	}
	
	public boolean isFull() {
		boolean res = rear == maxSize - 1;
		if(res) {
			System.out.println("큐가 가득찼습니다.");
		}
		return res;
	}
	
	public void push(Object obj) {
		if(isFull()) return;
		
		rear ++;
		queueArray[rear] = obj;
	}
	
	public Object pop() {
		Object obj = peek();
		
		if(front > maxSize -1) return null;
		front++;
		return obj;
	}
	
	public Object peek() {
		if(isEmpty()) return null;
		
		return queueArray[front];
	}
	
	
}







