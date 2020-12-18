package day034.collection.treemap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExam {

    public static void main(String[] args) {
        // TreeMap : 키(key) 값 기준 오름차순 정렬
        Map<String, Integer> map = new TreeMap<>();
        map.put("홍길동", 100);
        map.put("김유신", 100);
        map.put("강감찬", 88);
        map.put("100", 93);
        map.put("20", 93);
        map.put("10", 93);
        map.put("a", 93);
        map.put("A", 93);
        map.put("%", 93);
        map.put("*", 93);
        System.out.println("map = " + map);

        System.out.println("map.put(\"hi\", 123) = " + map.put("hi", 123));
        System.out.println(map.values());
        System.out.println("hi" + "이거 개쩔죠" + map.keySet());// 이클립스 안되는거 아녀요??
        // 이클립스는 안되요 찐따라..후...찐따개발툴
    }
}
