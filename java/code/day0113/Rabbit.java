package day0113;

public class Rabbit implements IAnimal {
    @Override
    public void makeSound() {
        System.out.println("토끼 토끼");
    }

    @Override
    public void move() {
        System.out.println("깡총 깡총");
    }

    @Override
    public void eat() {
        System.out.println("풀을 뜯어먹습니다.");
    }

    public void swim() {
        System.out.println("용궁에 갑니다.");
    }
}
