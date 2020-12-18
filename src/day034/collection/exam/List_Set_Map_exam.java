package day034.collection.exam;

import java.util.*;

public class List_Set_Map_exam {

    public static void main(String[] args) {
        String[] names = {"홍길동", "강감찬", "박나래", "이순신"};
        System.out.println("========= List ==========");
		/* (실습) List 사용실습
		1. 이름등록 : 홍길동, 강감찬, 박나래, 이순신
		2. 전체 데이터 출력
			출력 예) index : 이름(데이터)
		3. 데이터 수정 : 홍길동 -> 홍길동2
		4. 바뀐 데이터(홍길동2) 화면 출력
		***********************************/
        {
            List<String> list = new ArrayList<>(Arrays.asList(names.clone()));
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + " : " + list.get(i));
            }
            System.out.println();
            int index = list.indexOf("홍길동");

            list.set(index, "홍길동2");

            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + " : " + list.get(i));
            }
            System.out.println();
        }

        System.out.println("========= Set ==========");
		/* (실습) Set 사용
		1. 이름등록 : 홍길동, 강감찬, 박나래, 이순신
		2. 출력 : 이름 (오름차순, 가나다순)
		3. 데이터 수정 : 홍길동 -> 홍길동2
		*******************************/
        {
            Set<String> set = new TreeSet<>(Arrays.asList(names.clone()));
            for (String name : set) {
                System.out.println(name);
            }
            System.out.println();

            if (set.remove("홍길동")) {
                set.add("홍길동2");
            }

            for (String name : set) {
                System.out.println(name);
            }
            System.out.println();
        }

        System.out.println("========= Map ==========");
		/* Map 사용
		1. 데이터 입력 : 101-홍길동, 102-강감찬, 103-박나래, 104-이순신
		2. 출력 : 101-홍길동 (key 오름차순)
		3. 수정 : 홍길동 -> 홍길동2 (key 값 사용 : 101)
		4. 수정 : 강감찬 -> 강감찬2 (이름을 비교해서 찾아서 수정)
		*********************************/
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(i + 101, names[i]);
        }

        for (Integer key : map.keySet()) {
            System.out.println(key + "-" + map.get(key));
        }
        System.out.println();

        map.put(101, "홍길동2");
        for (Integer key : map.keySet()) {
            if ("강감찬".equals(map.get(key))) {
                map.put(key, "강감찬2");
            }
        }

        for (Integer key : map.keySet()) {
            System.out.println(key + "-" + map.get(key));
        }
        System.out.println();



    }

}









