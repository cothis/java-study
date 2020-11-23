package day016.stack;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StackQueueInterface<Integer> queue = new Queue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println("queue.peek() = " + queue.peek());
        int popQueue = queue.pop();
        System.out.println("popQueue = " + popQueue);
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println();

        StackQueueInterface<String> queueString = new Queue<>();
        queueString.push("hello");
        queueString.push("world");
        System.out.println("queueString.peek() = " + queueString.peek());
        String popQueueString = queueString.pop();
        System.out.println("popQueueString = " + popQueueString);
        System.out.println("queueString.peek() = " + queueString.peek());


        StackQueueInterface<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack.peek() = " + stack.peek());
        int popStack = stack.pop();
        System.out.println("popStack = " + popStack);
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println();

        StackQueueInterface<String> stackString = new Stack<>();
        stackString.push("hello");
        stackString.push("world");
        System.out.println("stackString.peek() = " + stackString.peek());
        String popStackString = stackString.pop();
        System.out.println("popStackString = " + popStackString);
        System.out.println("stackString.peek() = " + stackString.peek());


    }

}

interface StackQueueInterface<T> {
    boolean isEmpty();
    boolean isFull();
    void push(T t);
    T pop();
    T peek();
}

class Queue<T> extends Stack<T> {

    @Override
    public T peek() {
        if(isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}

class Stack<T> implements StackQueueInterface<T> {
    List<T> list = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void push(T t) {
        list.add(t);
    }

    @Override
    public T pop() {
        if(isEmpty()){
            return null;
        }
        T removed = peek();
        list.remove(removed);
        return removed;
    }

    @Override
    public T peek() {
        if(isEmpty()) {
            return null;
        }
        return list.get(list.size()-1);
    }
}
