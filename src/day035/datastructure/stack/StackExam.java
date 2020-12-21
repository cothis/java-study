package day035.datastructure.stack;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.stream.Collectors;

public class StackExam {

    public static void main(String[] args) {
        System.out.println("=== 스택(Stack : LIFO) ===");
        Stack<String> st = new Stack<>();
        st.push("1.첫째");
        st.push("2.둘째");
        st.add("3.셋째"); //add() 사용해도 push와 동일
        System.out.println("st = " + st + ", st.size() = " + st.size() + ", st.empty() = " + st.empty());

        System.out.println("\n--- peek() : 데이터 확인  ---");
        System.out.println("st.peek() = " + st.peek());
        System.out.println("st.peek() = " + st.peek());

        System.out.println("\n--- pop() : 데이터 꺼내기 ---");
        System.out.println("st.pop() = " + st.pop());
        System.out.println("st.pop() = " + st.pop());
        System.out.println("st.pop() = " + st.pop());
        System.out.println("st = " + st + ", st.size() = " + st.size() + ", st.empty() = " + st.empty());
        try {
            System.out.println("st.pop() = " + st.pop()); // 데이터가 없으면 occur EmptyStackException
        } catch (EmptyStackException e) {
            System.out.println("\u001B[31m" + e.getClass().getName());
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i = stackTrace.length - 1 ; i >= 0 ; i--) {
                System.out.println("\u001B[35m" + " - " + stackTrace[i]);
            }
            System.out.print("\u001B[0m");
        }

        System.out.println("\n=== 스택(Stack) 전체 데이터 사용 ===");
        st.push("21.첫째");
        st.push("22.둘째");
        st.add("23.셋째"); //add() 사용해도 push와 동일
        System.out.println("st = " + st + ", st.size() = " + st.size() + ", st.empty() = " + st.empty());
        while(!st.empty()) {
            System.out.println("st.pop() = " + st.pop());
        }
        System.out.println("st = " + st + ", st.size() = " + st.size() + ", st.empty() = " + st.empty());

    }
}
