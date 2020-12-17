package day033.list.list03.linkedlist;

import java.util.*;
import java.util.stream.Collectors;

public class LinkedListExam {

    public static void main(String[] args) {
        // LinkedList 클래스 : List 인터페이스를 구현한 거에 대해서만 우선 생각
        LinkedList<String> list = new LinkedList<>();
        list.add("홍길동");
//        list.add("홍길동");
//        list.add("김유신");
        System.out.println("list : " + list);
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("----------------------------");
        list.clear();

        String str = "강강,김유신,강감찬,홍경래,을지문덕";
        String[] strs = str.split(",");
        System.out.println("strs : " + Arrays.toString(strs));

        //배열에 있는 데이터를 리스트에 추가
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
        }
        System.out.println("list : " + list);

        //개선된 for문 형태로도 작성(실습)
        LinkedList<String> list2 = new LinkedList<>();
        for (String name : strs) {
            list2.add(name);
        }
        System.out.println("list2 : " + list2);


        System.out.println("=======================");
        Collections.reverse(list);
        System.out.println("list reverse 후 : " + list);

        //삭제 : 김유신
        list.remove("김유신");
        System.out.println("김유신 삭제 후 : " + list);

        //------------------------------------------
        //(실습) 을지문덕 -> 을지문덕2 변경처리(수정) 위치 모른다는 전제
        //1. "을지문덕" 이 어디에 있는지 찾고 (indexOf)
        //2. 찾은 위치에서 "을지문덕2"로 수정 (set)

        // indexOf
        int index = list.indexOf("을지문덕");
        if (index >= 0) list.set(index, "을지문덕2");
        System.out.println("list : " + list);

        // for
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if("을지문덕2".equals(name)) {
                list.set(i, "을지문덕3");
                break;
            }
        }
        System.out.println("list : " + list);

        // Iterator
        Iterator<String> it = list.iterator();
        for (int i = 0 ;it.hasNext(); i++) {
            if("을지문덕3".equals(it.next())) {
                list.set(i, "을지문덕4");
            }
        }
        System.out.println("list : " + list);

        // Stream
        List<String> result = list.stream().map(name -> {
            if ("을지문덕4".equals(name)) {
                name = "을지문덕5";
            }
            return name;
        }).collect(Collectors.toList());
        System.out.println("list : " + list);

        System.out.println("result : " + result);
    }
}
