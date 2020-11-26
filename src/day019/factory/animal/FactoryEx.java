package day019.factory.animal;

import java.util.ArrayList;
import java.util.List;

public class FactoryEx {
    public static void main(String[] args) {
        /*
            Singleton Pattern
                : 중심이 되는 데이터 관리 template(list, map)을 중심으로
                : 어느 클래스에서나 쉽게 접근하기 위한 패턴
                : instance(object)가 1개만 있는 패턴
            
            Factory(공장) Pattern
                : 원하는 형태의 object 를 생성하기 위한 패턴
            
            Factory 예)
                interface   동물
                class       고양이, 멍멍이, 황소

                Animal animal1 = new Cat();
                Animal animal2 = new Dog();
                Animal animal3 = new Cow();
         */

        /*
        Animal ani1 = AnimalFactory.create("강아지");
        Animal ani2 = AnimalFactory.create("고양이");
        Animal ani3 = AnimalFactory.create("황소");

        ani1.printDescript();
        ani2.printDescript();
        ani3.printDescript();

        ((Cat)ani2).catMethod();

         */

        List<Animal> list = new ArrayList<>();
        String arrStr[] = {"황소", "고양이", "황소", "강아지", "강아지", "강아지"};
        for (String str : arrStr){
            Animal animal = AnimalFactory.create(str);
            list.add(animal);
        }

        for (int i = 0; i < list.size(); i++) {
            Animal animal = list.get(i);
            animal.printDescript();

            if(animal instanceof Cat) {
                Cat c = (Cat) animal;
                c.catMethod();
            }
            else if(animal instanceof Dog) {
                Dog c = (Dog) animal;
                c.dogMethod();
            }
            else if(animal instanceof Cow) {
                Cow c = (Cow) animal;
                c.cowMethod();
            }
        }

        list.forEach(Animal::printDescript);

        System.out.println();
        AnimalType[] typeArr = {AnimalType.CAT, AnimalType.DOG, AnimalType.COW };
        List<Animal> list2 = new ArrayList<>();
        for (AnimalType type :
                typeArr) {
            Animal test = AnimalEnumFactory.create(type);
            list2.add(test);
        }
        list2.forEach(Animal::printDescript);

    }
}
enum AnimalType {
    CAT("고양이", new Cat()),
    DOG("강아지", new Dog()),
    COW("황소", new Cow());

    private String name;
    private Animal animal;

    AnimalType(String type, Animal animal) {
        this.name = type;
        this.animal = animal;
    }

    public Animal getAnimal() {
        return this.animal;
    }
}

class AnimalEnumFactory extends AnimalFactory {
    public static Animal create(AnimalType type) {
        return type.getAnimal();
    }
}


class AnimalFactory {
    public static Animal create(String animalName) {
        if(animalName.equals("고양이")) {
            return new Cat();
        }
        else if(animalName.equals("강아지")) {
            return new Dog();
        }
        else if(animalName.equals("황소")) {
            return new Cow();
        }
        else {
            System.out.println("생성할 클래스가 없습니다.");
            return null;
        }
    }
}


interface Animal {
    public void printDescript();
}

class Cat implements Animal {
    @Override
    public void printDescript() {
        System.out.println("고양이입니다.");
    }
    public void catMethod() {
        System.out.println("야옹!");
    }
}

class Dog implements Animal {
    @Override
    public void printDescript() {
        System.out.println("강아지입니다.");
    }
    public void dogMethod() {
        System.out.println("멍멍.");
    }
}

class Cow implements Animal {
    @Override
    public void printDescript() {
        System.out.println("황소입니다.");
    }
    public void cowMethod() {
        System.out.println("음머~");
    }
}
