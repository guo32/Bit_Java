package day0111;

import util.ScannerUtil;

import java.util.Scanner;

/*
게시판
(제목, 작성자, 글번호, 내용)
배열로 관리, 가장 오래된 것 지우기

1. 게시물 클래스 만들기
2. 이후 작성
 */
public class Ex02Board01 {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final int BOARD_SIZE = 5;

    public static Board[] boardList = new Board[BOARD_SIZE];
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
        int index = findLastNumber();
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
            duplicate = checkDuplicate(newBoard);
            if(duplicate) System.out.println("중복된 게시물 번호입니다. 다시 입력해주세요.");
            else {
                if(index == BOARD_SIZE) {
                    moveElement();
                    index = BOARD_SIZE - 1;
                }
                boardList[index] = newBoard;
            }
        }
    }

    public static boolean checkDuplicate(Board board) {
        int lastNumber = findLastNumber();
        if(lastNumber == -1) lastNumber = BOARD_SIZE;
        for(int i = 0; i < lastNumber; i++) {
            if(boardList[i].equals(board)) return true;
        }
        return false;
    }

    public static int findLastNumber() {
        for(int i = 0; i < BOARD_SIZE; i++) {
            if(boardList[i] == null) return i;
        }
        return boardList.length;
    }

    public static void moveElement() {
        for(int i = 0; i < BOARD_SIZE - 1; i++) {
            boardList[i] = boardList[i + 1];
        }
    }

    public static void printList() {
        if(findLastNumber() == 0) {
            System.out.println("아직 작성된 게시물이 없습니다.");
        } else {
            for(int i = 0; i < findLastNumber(); i++) {
                System.out.println(boardList[i].getId() + ". " + boardList[i].getTitle());
            }
            String message = "상세보기할 게시물의 번호나 뒤로 가시려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(SCANNER, message);

            while((userChoice != 0 && findIndexById(userChoice) == -1)) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(SCANNER, message);
            }

            if(userChoice != 0) {
                printOne(userChoice);
            }
        }
    }

    public static void printOne(int id) {
        if(findIndexById(id) == -1) {
            System.out.println("해당 id를 가진 게시물은 존재하지 않습니다.");
        } else {
            boardList[findIndexById(id)].print();
            String message = "1. 수정 2. 뒤로가기";
            int userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 2);
            if(userChoice == 1) {
                update(id);
            } else {
                printList();
            }
        }
    }

    public static void update(int id) {
        int index = findIndexById(id);
        boardList[index].setTitle(ScannerUtil.nextLine(SCANNER, "새로운 제목을 입력해주세요."));

        boardList[index].setContent(ScannerUtil.nextLine(SCANNER, "새로운 내용을 입력해주세요."));

        printOne(id);
    }

    public static int findIndexById(int id) {
        for(int i = 0; i < boardList.length; i++) {
            if(boardList[i] != null && id == boardList[i].getId()) {
                return i;
            }
        }

        return -1;
    }
}
