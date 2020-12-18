package day034.collection.hashset;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class HashSetEqualsExam {

    public static void main(String[] args) {
        Set<Person> persons = new TreeSet<>();
        persons.add(new Person("홍길동", 27, 4));
        persons.add(new Person("홍길동", 27, 3));
        persons.add(new Person("홍길동", 27, 2));
        persons.add(new Person("홍길동2", 30, 3));
        persons.add(new Person("홍길동", 27, 1));
        System.out.println(persons);
    }
}

class Person implements Comparable {
    String name;
    int age;
    int jumin;

    public Person(String name, int age, int jumin) {
        this.name = name;
        this.age = age;
        this.jumin = jumin;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", jumin='" + jumin + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(jumin, person.jumin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jumin);
    }

    @Override
    public int compareTo(Object o) {
        if (this.hashCode() > o.hashCode()) {
            return 1;
        } else if (this.equals(o)) {
            return 0;
        } else {
            return -1;
        }
    }
}
