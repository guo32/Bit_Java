package day0113;
/*
정규 표현식(Regular Expression)
문자열의 패턴을 표현하는 방식
 */
public class Ex03RegExp {
    public static void main(String[] args) {
        // 1. 숫자 체크
        System.out.println("1. 숫자 체크");
        String pattern = "\\d"; // 문자열이 하나의 숫자로 이루어져 있는지 체크
        System.out.println("\"1\": " + "1".matches(pattern));
        System.out.println("\"a\": " + "a".matches(pattern));
        System.out.println("--------------------------------------");
        // 2. 글자 체크
        System.out.println("2. 글자 체크");
        pattern = "\\w"; // word
        System.out.println("\"1\": " + "1".matches(pattern));
        System.out.println("\"a\": " + "a".matches(pattern));
        System.out.println("--------------------------------------");
        // 3. 알파벳 체크
        System.out.println("3. 알파벳 체크");
        pattern = "[A-Za-z]";
        System.out.println("\"1\": " + "1".matches(pattern));
        System.out.println("\"a\": " + "a".matches(pattern));
        System.out.println("--------------------------------------");
        // 4. 여러 개의 숫자로만 이루어져있는지 체크
        System.out.println("4. 여러 개의 숫자 체크");
        pattern = "\\d+"; // + : 한 개 이상 * : 0개 이상
        System.out.println("\"1\": " + "1".matches(pattern));
        System.out.println("\"123\": " + "123".matches(pattern));
        System.out.println("--------------------------------------");
        // 5. 복합적 사용
        System.out.println("5. 복합적 사용");
        pattern = "010-\\d{4}-\\d{4}";
        System.out.println("\"010-1234-1664\": " + "010-1234-1234".matches(pattern));
        System.out.println("\"02-111-2222\": " + "02-111-2222".matches(pattern));
        System.out.println("\"korea\": " + "korea".matches(pattern));
        System.out.println("--------------------------------------");

        System.out.println("6. 복합적 사용(2)");
        pattern = "\\d{3,6}"; // 3~6개의 정수
        System.out.println("\"123\": " + "123".matches(pattern));
        System.out.println("\"12345\": " + "12345".matches(pattern));
        System.out.println("\"12\": " + "12".matches(pattern));
        System.out.println("--------------------------------------");
    }
}
