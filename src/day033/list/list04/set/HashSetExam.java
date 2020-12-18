package day033.list.list04.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExam {

    public static void main(String[] args) {
        //Set 인터페이스 : Set 타입에서 구현되어야 할 메소드 정의
        //HashSet 클래스(구현체) : Set 인터페이스를 구현한 클래스

        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("홍길동");
        set.add("홍길동");
        System.out.println("set : " + set);
        
        set.remove("1");
        System.out.println("set : " + set);
        System.out.println("set.contains(\"홍길동\") : " + set.contains("홍길동"));

        System.out.println("set.size() : " + set.size());
        System.out.println("set.isEmpty() : " + set.isEmpty());

        System.out.println("-----------------------------------");
        set.add("김유신");
        set.add("을지문덕");
        set.add("홍경래");
        System.out.println("set : " + set);

        System.out.println("==== Set 전체 데이터 조회 ====");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println("it.next() = " + it.next());
        }
        System.out.println("----------------");

        for (String str : set) {
            System.out.println(str);
        }

        System.out.println("================================");
        //실습(수정) : 김유신 -> 김유신2 변경처리
        //김유신 삭제하고 김유신2 추가
        //김유신2 추가하고 김유신 삭제

        if(set.contains("김유신")) {
            // 사실 contains 필요 없음
            if (set.remove("김유신")) {
                set.add("김유신2");
            }
        }
        

        System.out.println("set : " + set);

    }
}