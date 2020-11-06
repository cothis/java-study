package HashMap;

public class Entry<T, S> {
	private T key;
	private S value;
	
	public Entry() {
		
	}
	
	public Entry(T key, S value) {
		this.key = key;
		this.value = value;
	}
	
	public T getKey() {
		return key;
	}
	public S getValue() {
		return value;
	}
	
	public void setKey(T key) {
		this.key = key;
	}
	
	public void setValue(S value) {
		this.value = value;
	}
	
	public String toString() {
		return "{ key: \"" + key + "\", value: \"" + value + "\" }";
	}
	
}
