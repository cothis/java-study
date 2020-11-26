package day019.observer;

/*
    Observer
        : 감시, 정찰
        : 감시자 패턴
        : 특정 class 를 감시

 */

import java.util.Observable;
import java.util.Observer;

public class ObserverEx {
    public static void main(String[] args) {

        MyClass myClass = new MyClass();
        myClass.addObserver(new ObserverAA());
        myClass.addObserver(new ObserverBB());

        myClass.setId("abc123");
        myClass.setPassword("qwerty123");
        myClass.notifyObservers("id: " + myClass.getId() + ", pw: " + myClass.getPassword());

    }
}

class MyClass extends Observable {
    private String id;
    private String password;

    private String preArg = null;

    public MyClass() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public void notifyObservers(Object arg) {
        String str = (String) arg;

        // 변화가 없을 때 -> 감시자에게 통지하지 않는다.
        if(str.equals(preArg)) return;
        
        // 변화가 있는 경우
        preArg = str;
        setChanged(); // reset
        super.notifyObservers(arg);
        clearChanged();
    }
}

class ObserverAA implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String str = (String) arg;
        System.out.println("감시자 AA 통지받았음 : " + str);
    }
}

class ObserverBB implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String str = (String) arg;
        System.out.println("감시자 BB 통지받았음 : " + str);
    }
}
