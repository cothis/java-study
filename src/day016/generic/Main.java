package day016.generic;

public class Main {
    /*
        Generic == template(형태)
                : 자료형의 변수
                : 같은 클래스에서 다양한 자료형을 사용하고 싶을 때
     */
    public static void main(String[] args) {

        Box<Integer> box = new Box<>(111);
        System.out.println(box.getTemp() + 1);
        
        Box<String> str = new Box<>("my world");
        System.out.println(str.getTemp());

        BoxMap<Integer, String> map = new BoxMap<>(1001, "Hello");
        System.out.println("map.getKey() = " + map.getKey());
        System.out.println("map.getValue() = " + map.getValue());
        System.out.println();
        
        BoxMap<String, Object> map2 = new BoxMap<>("1001", "Hello");
        System.out.println("map2.getKey() = " + map2.getKey());
        System.out.println("map2.getValue() = " + map2.getValue());


    }
}

class Box<T> {
    T temp;

    public Box(T temp) {
        this.temp = temp;
    }

    public T getTemp() {
        return temp;
    }

    public void setTemp(T temp) {
        this.temp = temp;
    }
}

class BoxMap<Key, Value> {
    Key key;
    Value value;

    public BoxMap(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

}