package day0111;

public class Student {
    private int id;
    private String name;
    private int korean;
    private int english;
    private int math;

    // 생성자
    public Student() {
        id = -1;
        name = "아직 없음";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void print() {
        System.out.printf("번호: %d번 이름: %s\n", id, name);
        System.out.printf("국어: %d점 영어: %d점 수학: %d점\n", korean, english, math);
        System.out.printf("총점: %d점 평균: %.2f점\n", calculateSum(), calculateAverage());
    }

    /*
    calculateSum(), calculateAverage()의 경우
    내부에서만 사용하므로 private으로 지정
     */
    private int calculateSum() {
        return korean + english + math;
    }

    private double calculateAverage() {
        return (double) calculateSum() / 3;
    }

    public boolean equals(Object object) {
        //object가 Student의 인스턴스가 맞는지 확인
        if(object instanceof Student) {
            Student s = (Student) object; // 명시적 형변환
            return id == s.id;
        }
        return false;
    }
}
