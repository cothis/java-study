package day016.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    /*
        Collection : Object 수집
        List
            : 목록 + Array
            : 데이터의 관리를 유동적으로 할 수 있는 배열
        
        ArrayList(== Vector)
            : 배열처럼 사용할 수 있는 리스트
            : 선형 구조 0-0-0-0-0-
            : 검색 속도가 빠르다.
            : index로 접근하고 관리된다. 0 ~ n - 1
        
        Linked List
            : 삽입과 삭제가 빈번하게 발생할 때 적합
     */

    public static void printAll(List<Integer> list) {
        System.out.println("Main.printAll");
        for(int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            System.out.println("list.get(" + i + ") = " + n);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        /* Create */
        list.add(1001);
        list.add(1002);
        list.add(1003);
        list.add(2);

        // size
        int len= list.size();
        System.out.println("len = " + len);

        // data 출력
        printAll(list);

        for (int i : list) {
            System.out.println("i = " + i);
        }

        // 원하는 위치에 추가
        int addNum = 5002;
        list.add(1, addNum);

        printAll(list);

        /* Delete */
        list.remove(2);
        printAll(list);

        /* Read */
        int index = list.indexOf(1003);
        System.out.println("list.indexOf(1003) = " + index);
        System.out.println("list.get(index) = " + list.get(index));
        System.out.println();

        index = -1;
        for(int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            if(value == 5002) {
                index = i;
                break;
            }
        }
        System.out.println("search index using for loop");
        System.out.println("list.indexOf(5002) = " + index);
        System.out.println("list.get(index) = " + list.get(index));
        System.out.println();
        printAll(list);

        /* Update */
        int newData = 1002;
        list.set(1, newData);
        System.out.println("set newData at list index 1");
        printAll(list);


        list.clear();
        List<String> list2 = new ArrayList<>();
        list2.add("Spring");
        list2.add("Summer");
        list2.add("Fall");
        list2.add("Winther"); //오타
        System.out.println("list2 = " + Arrays.deepToString(list2.toArray()));


        list2.remove("Fall");
        list2.remove(0);

        System.out.println("list2 = " + Arrays.deepToString(list2.toArray()));

        index = list2.indexOf("Winther");
        list2.set(index, "Winter");
        System.out.println("list2 = " + Arrays.deepToString(list2.toArray()));

    }
}
