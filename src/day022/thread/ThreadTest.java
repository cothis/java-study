package day022.thread;

public class ThreadTest {
    public static void main(String[] args) {

        ThreadEx thread1 = new ThreadEx("퐁");
        ThreadEx thread2 = new ThreadEx("당");
        ThreadEx thread3 = new ThreadEx("!");
        thread1.start();
        thread2.start();
        thread3.start();
        
        System.out.println("프로그램 종료");
        
    }
}

class ThreadEx extends Thread {

    String msg;
    static int myCount = 0;
    static int objectCount = 0;

    public ThreadEx(String msg) {
        this.msg = msg;
        objectCount++;
    }

    @Override
    public void run() {
        super.run();

        for (int i = 0; i < 10; i++) {
            System.out.println(msg + ", " + i);
            upStatic();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void upStatic() {
        myCount++;
        if(myCount >= objectCount) {
            myCount = 0;
            System.out.println();
        }
    }
}
