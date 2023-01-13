package day0113;

public class Dog extends Animal {
    public Dog() {
        System.out.println("Dog() 호출");
    }

    public void makeSound() {
        System.out.println("멍멍");
    }

    // 부모 클래스의 메소드 재정의(오버라이드)
    public void eat() {
        System.out.println("강아지는 잡식동물입니다.");
    }

}
