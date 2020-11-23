package day016.member.domain;

public class Member {
    private int number;
    private String name;
    private int age;

    public Member() {
    }

    public Member(int number, String name, int age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" + "number=" + number + ", name='" + name + "', age=" + age + '}';
    }
}
