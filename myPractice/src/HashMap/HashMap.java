package HashMap;


import HashMap.Entry;

public class HashMap<T, S> {
	private Entry<T, S>[] entry;
	private int count;
	@SuppressWarnings("unchecked")
	public HashMap() {
		entry = new Entry[10];
		count = 0;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap(int capacity) {
		entry = new Entry[capacity];
		count = 0;
	}
	
	public void put(T key, S value) {
		int existNumber = -1;
		// check exist
		for (int i = 0; i < count; i++) {
			if (entry[i].getKey().equals(key)) {
				existNumber = i;
			}
		}
		
		if (existNumber > -1) {
			entry[existNumber].setValue(value);
			return;
		}
		
		// check capacity
		if ( count >= entry.length) {
			@SuppressWarnings("unchecked")
			Entry<T, S>[] temp = new Entry[entry.length * 2];
			for (int i = 0 ; i < entry.length ; i++) {
				temp[i] = entry[i];
			}
			entry = temp;
		}
		
		entry[count] = new Entry<T, S>(key, value);
		count++;		
	}
	
	public Entry<T, S>[] entrySet(){
		@SuppressWarnings("unchecked")
		Entry<T, S>[] temp = new Entry[count];
		for (int i = 0; i < count; i++) {
			temp[i] = entry[i];
		}
		return temp;
	}
	
	public void printEntrySet() {
		for(Entry<T, S> e : entrySet()) {
			System.out.println(e);
		}
		System.out.println();
	}
	
	@SuppressWarnings("unchecked")
	public T get(T key) {
		T value = null;
		for (int i = 0; i < count; i++) {
			if (entry[i].getKey().equals(key)) {
				value = (T) entry[i].getValue();
			}
		}
		return value;
	}
	
	public void remove(T key) {
		for (int i = 0; i < count; i++) {
			if (entry[i].getKey().equals(key)) {
				for(int j = i; j < count - 1; j++) {
					entry[j] = entry[j + 1];
				}
				entry[count] = null;
				count--;
			}
		}
	}
}
