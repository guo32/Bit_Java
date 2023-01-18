package day0118;

import viewer.FilmViewer;
import viewer.MemberViewer;

import java.util.Scanner;

public class MovieProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 각 뷰어 초기화
        MemberViewer memberViewer = new MemberViewer(scanner);
        FilmViewer filmViewer = new FilmViewer(scanner);

        // 의존성 주입
        memberViewer.setFilmViewer(filmViewer);

        memberViewer.showIndex();
    }
}
