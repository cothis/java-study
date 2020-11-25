package day018.singleton;

public class SingletonMain {
    public static void main(String[] args) {

        for(int i = 0; i < 5; i++){
            MyClass myCls = new MyClass();
            YouClass youCls = new YouClass();
            HeClass heClass = new HeClass();
            System.out.println(myCls);
            System.out.println(youCls);
            System.out.println(heClass);
            System.out.println();
        }
    }
}

class SingletonClass {
    public int number = 0;
    public int yNumber = 0;

    private SingletonClass() {}

    private static class LazyLoader {
        private static final SingletonClass si = new SingletonClass();
    }

    public static SingletonClass getInstance() {
        return LazyLoader.si;
    }
}

class MyClass {
    private int number;

    public MyClass() {
        SingletonClass si = SingletonClass.getInstance(); // 싱글톤 객체 생성
        this.number = ++si.number;
    }

    @Override
    public String toString() {
        return "MyClass{" + "number=" + number + '}';
    }
}

class YouClass {
    private int count;
    private int youNumber;

    public YouClass() {
        SingletonClass si = SingletonClass.getInstance();
        this.count = si.number;
        youNumber = (int)(Math.random()*10);
        si.yNumber = youNumber;
    }

    @Override
    public String toString() {
        return "YouClass{" + "count=" + count + ", youNumber=" + youNumber + '}';
    }
}

class HeClass {
    private int num;
    public HeClass() {
        SingletonClass si = SingletonClass.getInstance();
        this.num = si.yNumber;
    }

    public void method() {

    }

    @Override
    public String toString() {
        return "HeClass{" + "num=" + num + '}';
    }
}