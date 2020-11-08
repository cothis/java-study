package LinkedList;

class LinkedList<T> {
	private LinkedList<T> next;
	private T obj;
	private static int len = 0;
	
	LinkedList(){
		this.next = null;
		this.obj = null;
	}
	
	public int length() {
		return len;
	}
	
	private LinkedList(T obj){
		len++;
		this.obj = obj;
	}
	
	public T get(int index) {
		LinkedList<T> pos = this;
		int searchIndex = 0;
		while(pos.next != null && searchIndex < index) {
			pos = pos.next;
			searchIndex++;
		}
		return pos.obj;
	}
	
	public void pushAt(T obj, int index) {
		if (len == 0) {
			this.obj = obj;
			len++;
			return;
		}
		LinkedList<T> pos = this;
		int searchIndex = 0;
		while(pos.next != null && searchIndex + 1 < index) {
			pos = pos.next;
			searchIndex++;
		}
		LinkedList<T> item = new LinkedList<>(obj);
		LinkedList<T> tmp = pos.next;
		item.next = tmp;
		pos.next = item;
		
		
	}
		
	public void push(T obj) {
		pushAt(obj, len);
	}
	
	public String printAll() {
		LinkedList<T> pos = this;
		if(pos.next == null && pos.obj == null) {
			return "";
		}
		String value = "";
		boolean first = true;
		while(pos != null) {
			if(first) {
				first = false;
				value = "[" + value + pos.obj.toString();
			} else {
				value = value + "," + pos.obj.toString();
			}
			if (pos.next == null)
				break;
			pos = pos.next;
		}
		value = value + "]";
		return value;
	}
}

public class Main {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		for(int i = 0; i < 10 ; i++) {
			list.push("I'm " + i);
			System.out.println(list.printAll());
			System.out.println(list.length());
		}
		
		System.out.println(list.get(4));
		list.pushAt("haha", 2);
		System.out.println(list.printAll());
	}
}
