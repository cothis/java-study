package day033.list.list01.arraylist;

import java.util.ArrayList;

public class ArrayListExam {

    public static void main(String[] args) {

        ArrayList list1 = new ArrayList();

        list1.add(new Integer(5));
        list1.add(1); // int -> Integer 자동형변환되어서 저장
        list1.add(5);
        list1.add(3);
        list1.add("홍길동");

        System.out.println(list1);

        Integer obj = (Integer) list1.get(0);
        System.out.println(obj.intValue());
        int intValue = obj.intValue();
        
        //4번 인덱스 값 처리 : 문자열 데이터가 있음
        //실행시 java.lang.ClassCastException 발생
        // int <- Integer <- Object(실체 String) : 형변환 안됨
        if (list1.get(4) instanceof Integer) {
            Integer obj2 = (Integer) list1.get(4);  // 문법은 오류없으나 실행하면 오류
            intValue = obj2.intValue(); // 강제 형변환
        } else if (list1.get(4) instanceof String) {
            String s = (String) list1.get(4);
            System.out.println("list1.get(4) : " + s);
        }

        //--------------------------------------------------------
        System.out.println("--------------------------------------------");
        ArrayList list2 = new ArrayList(list1.subList(1, 4));
        System.out.println("list2 = " + list2);

        //데이터 추가
        list2.add(4);
        System.out.println("list2 = " + list2);
        
        //데이터 참조(검색, 확인)
        System.out.println("list2.get(0) : " + list2.get(0)); //첫번째 데이터 조회(확인)
        
        //데이터 수정
        list2.set(0, 999);
        System.out.println("list2.set(0, 999) 실행 후 = " + list2);

        //데이터 삭제
        list2.remove(0);
        System.out.println("list2.remove(0) 실행 후 = " + list2);

        list2.add(77);
        list2.add(88);
        list2.add(77);
        System.out.println("list2 = " + list2);

        //java.lang.IndexOutOfBoundsException
//        list2.remove(77); //인덱스 번호 77에 있는 데이터 삭제
        list2.remove(new Integer(77));
        System.out.println("list2.remove(new Integer(77)) 실행 후 = " + list2);
        
        //전체데이터 삭제
        System.out.println("=======================================");
        System.out.println("list2 = " + list2);
        System.out.println("list2.size() : " + list2.size());
        ArrayList list3 = new ArrayList(list2);

//        list2.remove(0);
//        System.out.println("list2.remove(0) = " + list2);
//        System.out.println("list2.size() : " + list2.size());

        for ( ; list2.size() != 0 ; list2.remove(0)); // 앞에서부터 삭제
        for ( ; list2.size() != 0 ; list2.remove(list2.size()-1)); // 뒤에서부터 삭제
        list2.clear(); // List에 이미 구현된 삭제

        //List 특성은 데이터가 삭제되면 뒤쪽에 데이터가 앞쪽으로 이동
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            System.out.println("i: " + i + ", size: " + list2.size());
            System.out.println("list2 = " + list2);
            list2.remove(0);
        }
        System.out.println("최종 list2 : " + list2);

        System.out.println("===================================");
        System.out.println("list3 = " + list3);

        for (int i = list3.size() - 1 ; i >= 0 ; i--) {
            System.out.println("i: " + i + ", size: " + list3.size());
            System.out.println("list3 = " + list3);
            list3.remove(i);
        }
        System.out.println("최종 list3 : " + list3);
        


    }
}
