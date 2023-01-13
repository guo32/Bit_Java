package day0113;
/*
상속(Inheritance)
상속의 목적: 코드의 재사용성과 다형성을 위해서

상속의 종류:
1. 클래스 상속
    코드의 재사용성이 주목적
    부모클래스의 메소드를 자식 클래스가 그대로 사용할 수 있다.
    extends 라는 키워드를 통해서 이루어진다.
2. 인터페이스 상속
    다형성이 주목적
    부모 인터페이스의 메소드를 자식 클래스가 반드시 재정의(=오버라이드) 해야 한다.
    implements 라는 키워드를 통해서 이루어진다.
 */
public class Ex01Inheritance {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.move();
        animal.eat();

        Dog dog = new Dog();
        dog.move();
        dog.eat();
        dog.makeSound();

        // 부모의 클래스를 자식의 생성자로 초기화 할 수 있음
        // 하지만 자식 내부에 새롭게 만들어진 메소드는 알 수 없음
        Animal a = new Dog();
        a.move();
        a.eat();

        // 어떤 클래스를 호출하냐에 따라 작동 방식이 달라짐
        IAnimal iAnimal = new Cat();
        showSample(iAnimal);
    }

    // 다형성 부여하기
    public static void showSample(IAnimal animal) {
        animal.makeSound();
        animal.move();
        animal.eat();
    }

}
