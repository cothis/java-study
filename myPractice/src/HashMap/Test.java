package HashMap;

import HashMap.HashMap;

public class Test {
	public static void main(String[] args) {
		HashMap<String, String> myHash = new HashMap<>();
		String test = "java";
		String key = new String("cde");
		myHash.put("abc", "hello");
		myHash.put("bcd", "world");
		myHash.put(key, test);
		
		myHash.printEntrySet();
		
		HashMap<Integer, String> myHash2 = new HashMap<>();
		myHash2.put(1, "hello");
		myHash2.put(2, "world");
		myHash2.put(3, "java");
		myHash2.put(4, "make");
		
		myHash2.printEntrySet();

		myHash2.remove(2);
		
		myHash2.printEntrySet();
		
		myHash2.put(2, "new");
		
		myHash2.printEntrySet();		
	}
}
