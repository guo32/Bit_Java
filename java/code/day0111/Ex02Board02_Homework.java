package day0111;

import util.ArrayUtil;
import util.ScannerUtil;

import java.util.Scanner;

/*
게시판
(제목, 작성자, 글번호, 내용)
배열로 관리, 가장 오래된 것 지우기

1. 게시물 클래스 만들기
2. 이후 작성
 */
public class Ex02Board02_Homework {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static Board[] boardList = new Board[0];
    public static int nextId = 1;
    public static void main(String[] args) {
        showMenu();

        SCANNER.close();
    }

    public static void showMenu() {
        while (true) {
            int userChoice = ScannerUtil.nextInt(SCANNER, "1. 입력 2. 출력 3. 종료", 1, 3);
            if(userChoice == 1) {
                insertBoard(); // writeBoard
            } else if(userChoice == 2) {
                printList();
            } else if(userChoice == 3) {
                System.out.println("시스템을 종료합니다.");
                break;
            }
        }
    }

    public static void insertBoard() {
        boolean duplicate = true;

        while(duplicate) {
            int id = nextId++;

            String message = "게시물 제목을 입력해주세요.";
            String title = ScannerUtil.nextLine(SCANNER, message);

            message = "게시물 작성자를 입력해주세요.";
            String writer = ScannerUtil.nextLine(SCANNER, message);

            message = "게시물 내용을 입력해주세요.";
            String content = ScannerUtil.nextLine(SCANNER, message);

            Board newBoard = new Board(id, title, writer, content);
            duplicate = ArrayUtil.contains(boardList, newBoard);
            if(duplicate) System.out.println("중복된 게시물 번호입니다. 다시 입력해주세요.");
            else {
                boardList = ArrayUtil.add(boardList, newBoard);
            }
        }
    }

    public static void delete(int id) {
        int index = ArrayUtil.indexOf(boardList, id);
        boardList = ArrayUtil.removeByIndex(boardList, index);

        System.out.println("삭제되었습니다.");
        printList();
    }

    public static void printList() {
        if(ArrayUtil.isEmpty(boardList)) {
            System.out.println("아직 작성된 게시물이 없습니다.");
        } else {
            for(int i = 0; i < ArrayUtil.size(boardList); i++) {
                System.out.println(boardList[i].getId() + ". " + boardList[i].getTitle());
            }
            String message = "상세보기할 게시물의 번호나 뒤로 가시려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(SCANNER, message);

            while((userChoice != 0 && ArrayUtil.indexOf(boardList, userChoice) == -1)) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(SCANNER, message);
            }

            if(userChoice != 0) {
                printOne(userChoice);
            }
        }
    }

    public static void printOne(int id) {
        if(ArrayUtil.indexOf(boardList, id) == -1) {
            System.out.println("해당 id를 가진 게시물은 존재하지 않습니다.");
        } else {
            boardList[ArrayUtil.indexOf(boardList, id)].print();
            String message = "1. 수정 2. 삭제 3. 뒤로가기";
            int userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 3);
            if(userChoice == 1) {
                update(id);
            } else if(userChoice == 2) {
                delete(id);
            } else {
                printList();
            }
        }
    }

    public static void update(int id) {
        int index = ArrayUtil.indexOf(boardList, id);
        boardList[index].setTitle(ScannerUtil.nextLine(SCANNER, "새로운 제목을 입력해주세요."));

        boardList[index].setContent(ScannerUtil.nextLine(SCANNER, "새로운 내용을 입력해주세요."));

        printOne(id);
    }
}
