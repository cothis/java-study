package myarraylist;


public class MyArrayList<E> {
	private int capacity;
	private int size;
	private E[] array;
	
	public int size() {
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		capacity = 1;
		size = 0;
		array = (E[]) new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayList(int capacity) {
		this.capacity = capacity;
		size = 0;
		array = (E[]) new Object[capacity]; 
	}
	
	@SuppressWarnings("unchecked")
	private void resize() {
		E[] tmp = (E[]) new Object[capacity*2];
		System.arraycopy(array, 0, tmp, 0, capacity);
		capacity = capacity * 2;
		array = tmp;
	}
	
	public void insert(E data) {
		if(capacity == size) {
			resize();
		}
		array[size] = data;
		size++;
	}
	
	public void delete(int index) {
		if(index >= size) System.out.println("배열 크기 초과");
		for(int i=index; i<size; i++) {
			array[i] = array[i+1];
		}
		size--;
	}
	
	public E search(E data) {
		int i = 0;
		for(i=0; i<size; i++) {
			if(array[i].equals(data)) break;
		}
		if(i == size) return null;
		else return array[i];
	}
	
	public void change(int index, E data) {
		if(index >= size) System.out.println("배열 크기 초과");
		array[index] = data;
	}
	
	public void print() {
		for(int i=0; i<size; i++) {
			if(i==0) System.out.print("[");
			else	System.out.print(", ");
			System.out.print(array[i]);
		}
		System.out.println("]");
	}
}
