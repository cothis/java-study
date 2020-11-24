package day017.dto;

import java.util.HashMap;

public class DtoMain {
    public static int sequence = 0;
    static HashMap<Integer, Vo> hashMap = new HashMap<>();

    public static void print() {
        for(Vo vo : hashMap.values()) {
            System.out.println(vo);
        }
        System.out.println();
    }

    public static void create(String name) {
        Vo vo = new Vo(++sequence, name);
        hashMap.put(sequence, vo);
    }

    public static void create(Integer key, String name) {
        Vo vo = new Vo(key, name);
        hashMap.put(key, vo);
    }

    public static Vo remove(Integer key) {
        return hashMap.remove(key);
    }

    public static Vo read(Integer key) {
        return hashMap.get(key);
    }

    public static void update(Integer key, String name) {
        if(hashMap.containsKey(key)) {
            hashMap.replace(key, new Vo(key, name));
        }
    }

    public static void main(String[] args) {
        // 추가
        System.out.println("데이터 생성");
        create("apple");
        create("grape");
        create("banana");
        print();

        // 삭제
        System.out.println("데이터 삭제");
        remove(1);
        remove(2);
        print();
        
        // 검색
        System.out.println("데이터 재생성");
        create(1, "apple");
        create(2, "grape");
        print();

        System.out.println("검색");
        System.out.println("hashMap.get(1) = " + read(1));
        System.out.println();

        // 수정
        System.out.println("데이터 수정");
        update(1, "pear");
        System.out.println("(apple -> banana) = " + read(1));
        System.out.println();

        // 출력
        System.out.println("전체 데이터 출력");
        print();
    }
}
