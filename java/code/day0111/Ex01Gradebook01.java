package day0111;

public class Ex01Gradebook01 {
    public static void main(String[] args) {
        Student s = new Student();
        s.setId(1);
        s.setName("홍길동");
        s.setKorean(80);
        s.setEnglish(80);
        s.setMath(81);

        s.print();

        Student s2 = new Student();
        s2.setId(2);
        s2.setName("김길동");
        s2.setKorean(90);
        s2.setEnglish(90);
        s2.setMath(91);

        s2.print();

        Student s3 = new Student();
        s3.setId(2);
        s3.setName("김길동");
        s3.setKorean(90);
        s3.setEnglish(90);
        s3.setMath(91);

        s2.print();
        s3.print();

        /*String a = "Abc";
        String b = new String("Abc");

        System.out.println(a.equals(b));*/
        System.out.println(s3.equals(s3));
        System.out.println(s3.equals("abc"));
    }
}
// 1. 학생 관리
// 2. 게시판(제목, 작성자, 글번호, 내용) --> 배열로 관리, 가장 오래된 것 지우기