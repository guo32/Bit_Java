package day0113;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex04Date {
    public static void main(String[] args) {
        Date d = new Date();
        d.setHours(16);
        d.setMonth(1); // 0~11: 0부터 시작함 0 --> 1월

        System.out.println(d);
        System.out.println(d.getTime());

        DateFormat df = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        // yyMMdd hh:mm:ss
        System.out.println(df.format(d));

        df = new SimpleDateFormat("yyMMdd");
        df.setLenient(false); // 옳지 않은 값을 입력했을 때 내부에서 알아서 처리하는 것을 막음
        String temp = "233460";
        try {
            d = df.parse(temp);
        } catch (Exception e) { // 지정한 문자열 값이 날짜로 변환 불가능한 경우
            System.out.println("해당 스트링은 date로 변환할 수 없어서 현재 날짜로 date를 설정하겠습니다.");
            d = new Date();
        }
        System.out.println(d);
    }
}
