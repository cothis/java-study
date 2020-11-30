package day021.work.membercontrol.dto;

public class Member {
    Integer id;
    String name;
    int age;
    double height;

    public Member(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
