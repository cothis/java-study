package day034.collection.hashmap;

import java.util.*;

public class HashMapExam {

    public static void main(String[] args) {
        // Map 인터페이스 : 키(key)-값(value) 쌍으로 데이터 저장 관리
        // - 순서가 없다.
        // - 키(key) : 중복 안됨(중복값 없이 유일한 데이터)
        // - 값(value) : 중복 가능
        //--------------------------------------------------------

        Map<String, Integer> map = new HashMap<>();
        map.put("홍길동", 100); //100은 오토박싱
        map.put("김유신", new Integer(95));
        map.put("강감찬", 88);
        map.put("계백", 88);
        map.put("홍길동", 93); //동일한 key 값이 있으면 바꿔치기
        System.out.println(map);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("일지매", 92);
        map2.put("전우치", 82);
        System.out.println(map2);
        map2.remove("일지매");
        System.out.println(map2);

        System.out.println("map.isEmpty() = " + map.isEmpty());
        System.out.println("map.get(\"홍길동\") = " + map.get("홍길동"));
        System.out.println("map.containsKey(\"을지문덕\") = " + map.containsKey("을지문덕"));
        System.out.println("map.containsValue(88) = " + map.containsValue(88));
        
        //데이터 수정
        System.out.println("=========== 데이터 수정 ===========");
        System.out.println("map = " + map);
        System.out.println("map.replace(\"홍길동\",99) = " + map.replace("홍길동", 99));
        System.out.println("map.replace(\"을지문덕\", 100) = " + map.replace("을지문덕", 100));
        System.out.println("map = " + map);

        //==========================================================
        System.out.println("=========== 전체 데이터 조회 ===========");
        //Map 에서는 키(key)를 이용해서 데이터(value) 조회
        //키 추출
        System.out.println("===== 키(key) 추출 : keySet() =====");
        System.out.println("map.keySet() = " + map.keySet());
        System.out.println();

        System.out.println("===== foreach 사용 조회 =====");
        for (String key : map.keySet()) {
            System.out.println("map.get(" + key + ") = " + map.get(key));
        }
        System.out.println();

        System.out.println("===== Iterator 사용 조회 =====");
        Iterator<String> ite = map.keySet().iterator();
        while (ite.hasNext()) {
            String key = ite.next();
            System.out.println("map.get(" + key + ") = " + map.get(key));
        }
        System.out.println();

        // 값만 추출
        System.out.println("===== 값(value) 추출 : values() =====");
        System.out.println("map.values() = " + map.values());

        System.out.println("===== Iterator 사용 조회 및 합계 계산 =====");
        Iterator<Integer> iteVal = map.values().iterator();
        int sum = 0;
        while (iteVal.hasNext()) {
            Integer value = iteVal.next();
            sum += value;
            System.out.println("value = " + value);
        }
        System.out.println("합계점수 = " + sum);

        System.out.println("===== Map 데이터 전체 조회 방법 =====");
        System.out.println("===== 방법1 : keySet(), iterator() 사용 =====");

        System.out.println("===== 방법2 : entrySet() 사용 =====");
        // Entry : Map 내부에 선언된 인터페이스 - Map.Entry
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
        }


    }
}

