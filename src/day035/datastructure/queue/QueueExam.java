package day035.datastructure.queue;

//큐(Queue) : 선입선출(FIFO)

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class QueueExam {

    public static void main(String[] args) {
        System.out.println("---- 큐(Queue) : 선입선출(FIFO) ----");

        Queue<String> que = new LinkedList<>();
        que.offer("1.첫째"); //입력
        que.add("2.둘째"); //입력
        que.offer("3.셋째");
        System.out.println(">> que = " + que + ", que.size() = " + que.size());

        System.out.println("\n---- peek() : 확인만 ----");
        System.out.println("que.peek() = " + que.peek());
        System.out.println("que.peek() = " + que.peek());

        System.out.println("\n---- pool() : 데이터 꺼내기 ----");
        System.out.println("que.poll() = " + que.poll());
        System.out.println("que.poll() = " + que.poll());
        System.out.println("que.poll() = " + que.poll());
        System.out.println(">> que = " + que + ", que.size() = " + que.size());
        System.out.println("que.poll() = " + que.poll()); // No Exception, return null
        System.out.println("que.isEmpty() = " + que.isEmpty());
        System.out.println("que.peek() = " + que.peek()); // No Exception, return null

        System.out.println("\n======= Queue 전체 데이터 추출 =======");
        que.offer("21.첫째");
        que.add("22.둘째");
        que.offer("23.셋째");
        System.out.println(">> que = " + que + ", que.size() = " + que.size());
        System.out.println("que.isEmpty() = " + que.isEmpty());

        while (!que.isEmpty()) { //비어 있지 않으면
            System.out.println("que.poll() = " + que.poll());
        }
        System.out.println("que.isEmpty() = " + true);

        System.out.println("\n---- size() 사용 전체데이터 추출 ----");
        que.offer("31.첫째");
        que.add("32.둘째");
        que.offer("33.셋째");
        System.out.println("que.size() = " + que.size());
        while (que.size() > 0) {
            System.out.println("que.poll() = " + que.poll());
        }
        System.out.println("que.size() = " + 0);

        System.out.println("\n---- remove() ---------");
        que.offer("41.첫째");
        que.add("42.둘째");
        que.offer("43.셋째");
        System.out.println("que.size() = " + que.size());
        while (que.size() > 0) {
            System.out.println("que.remove() = " + que.remove());
        }
        System.out.println("que.size() = " + 0);
        //remove() : 데이터가 없으면, 예외 발생
        try {
            System.out.println("que.remove() = " + que.remove()); // Occur NoSuchElementException
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
}
