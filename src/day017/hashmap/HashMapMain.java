package day017.hashmap;

import java.util.*;

public class HashMapMain {
    public static void main(String[] args) {
        /*
            HashMap : 사전(dictionary)
                주로 String : Object
                      "사과":"apple"
                       key : value -> 1 pair ==> json(web)
                       tree 구조
                       key 중복안됨.

            TreeMap = HashMap + Sorting

         */

        HashMap<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> map = new HashMap<>();

        TreeMap<Integer, String> treeMap = new TreeMap<>(hashMap);
        TreeMap<Integer, String> treeMapEmpty = new TreeMap<>();

        // 추가
        hashMap.put(111, "백십일");
        hashMap.put(222, "이백이십이"); // hashMap.put(new Integer(222), new String("이백이십이"));
        hashMap.put(333, "삼백삼십삼");
        hashMap.values()
                .forEach(m -> {
                    System.out.println("m = " + m);
                });
        
        // value 얻기
        String value = hashMap.get(111);
        System.out.println("value = " + value);

        // 검색
        boolean hasKey = hashMap.containsKey(222);
        System.out.println("hasKey = " + hasKey);
        
        // value 얻기 2
        if(hashMap.containsKey(333)) {
            value = hashMap.get(333);
            System.out.println("value = " + value);
        }
        
        // 모든 key값을 취득 -> value
        Iterator<Integer> it = hashMap.keySet().iterator();
        while(it.hasNext()) {
            int key = it.next();
            System.out.println("key = " + key);

            String val = hashMap.get(key);
            System.out.println("val = " + val);
        }
        System.out.println();

        // 수정 (value만 가능)

        //hashMap.replace(111, "100 + 10 + 1");
        hashMap.put(111, "110 + 1"); // 같은 키값이면 덮어쓰기 된다.

        for(int key : hashMap.keySet()) {
            System.out.println("hashMap.get(" + key + ") = " + hashMap.get(key));
        }
        System.out.println();

        // 삭제
        hashMap.remove(222);

        for(int key : hashMap.keySet()) {
            System.out.println("hashMap.get(" + key + ") = " + hashMap.get(key));
        }
        System.out.println();


        hashMap.put(222, "haha");
        hashMap.put(444, "hehe");
        hashMap.put(0, "nunu");
        hashMap.put(1, "one");
        for(int key : hashMap.keySet()) {
            System.out.println("hashMap.get(" + key + ") = " + hashMap.get(key));
        }
        System.out.println();

        treeMap = new TreeMap<>(hashMap);
        for(int key : treeMap.keySet()) { // 오름차순 정렬된 키값.
            System.out.println("treeMap.get(" + key + ") = " + treeMap.get(key));
        }
        System.out.println();
        
        for(int key : treeMap.descendingKeySet()) { // 내침차순 정렬된 키값.
            System.out.println("treeMap.get(" + key + ") = " + treeMap.get(key));
        }
        System.out.println();


        HashMap<String, String> fruitMap = new HashMap<>();
        fruitMap.put("apple", "사과");
        fruitMap.put("pear", "배");
        fruitMap.put("grape", "포도");
        fruitMap.put("banana", "바나나");

        // 취득
        value = fruitMap.get("apple");
        System.out.println("value = " + value);
        System.out.println();

        // sorting
        // TreeMap으로 바꿔주는게 좋다.
        TreeMap<String, String> fruitTreeMap = new TreeMap<>(fruitMap);

        // Ascending(오름차순)
        for(String key : fruitTreeMap.keySet()) {
            System.out.println("fruitTreeMap.get(" + key + ") = " + fruitTreeMap.get(key));
        }
        System.out.println();

        // Descending(내림차순)
        for(String key : fruitTreeMap.descendingKeySet()) {
            System.out.println("fruitTreeMap.get(" + key + ") = " + fruitTreeMap.get(key));
        }
        System.out.println();

    }
}
