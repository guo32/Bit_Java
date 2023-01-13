package viewer;

import controller.BoardController;
import model.BoardDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardViewer {
    private final Scanner SCANNER;
    private BoardController boardController;

    public BoardViewer() {
        SCANNER = new Scanner(System.in);
        boardController = new BoardController();
    }

    public void showMenu() {
        while (true) {
            String message = "1. 새 게시물 입력\n2. 게시물 목록\n3. 종료";
            int userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 3);

            if (userChoice == 1) {
                insert();
            } else if (userChoice == 2) {
                printList();
            } else if (userChoice == 3) {
                System.out.println("시스템을 종료합니다.");
                break;
            }
        }
    }

    private void insert() {
        String message = "게시물 제목을 입력하세요.";
        String title = ScannerUtil.nextLine(SCANNER, message);

        message = "게시물 작성자를 입력하세요.";
        String writer = ScannerUtil.nextLine(SCANNER, message);

        message = "게시물 내용을 입력하세요.";
        String content = ScannerUtil.nextLine(SCANNER, message);

        BoardDTO newBoard = new BoardDTO();
        newBoard.setTitle(title);
        newBoard.setWriter(writer);
        newBoard.setContent(content);

        boardController.insert(newBoard);
    }

    private void printList() {
        ArrayList<BoardDTO> list = boardController.selectAll();
        if (list.isEmpty()) {
            System.out.println("등록된 게시물이 없습니다.");
        } else {
            for (BoardDTO board : list) {
                System.out.printf("%d. %s\n", board.getId(), board.getTitle());
            }

            while (true) {
                String message = "상세보기할 게시물의 아이디나 뒤로 가시려면 0을 입력하세요.";
                int userChoice = ScannerUtil.nextInt(SCANNER, message);
                if (userChoice != 0 && boardController.selectById(userChoice) == null) {
                    System.out.println("잘못 입력하셨습니다.");
                    continue;
                }
                if (userChoice != 0) {
                    BoardDTO b = new BoardDTO(boardController.selectById(userChoice));
                    printOne(b);
                } else break;
            }
        }
    }

    private void printOne(BoardDTO boardDTO) {
        System.out.println("----------------------------");
        System.out.println(boardDTO.getTitle());
        System.out.println("No. " + boardDTO.getId() + " | 작성자: " + boardDTO.getWriter());
        System.out.println("----------------------------");
        System.out.println(boardDTO.getContent());

        while (true) {
            String message = "1. 게시물 수정\n2. 게시물 삭제\n3. 뒤로가기";
            int userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 3);
            if(userChoice == 1) {
                update(boardDTO);
            } else if (userChoice == 2) {
                delete(boardDTO);
            } else if (userChoice == 3) {
                printList();
                break;
            }
        }
    }

    private void update(BoardDTO boardDTO) {
        String message = "게시물 제목을 수정해주세요.";
        String newTitle = ScannerUtil.nextLine(SCANNER, message);

        message = "게시물 내용을 수정해주세요.";
        String newContent = ScannerUtil.nextLine(SCANNER, message);

        boardDTO.setTitle(newTitle);
        boardDTO.setContent(newContent);

        boardController.update(boardDTO);

        System.out.println("게시물이 수정되었습니다.");
        printOne(boardDTO);
    }

    private void delete(BoardDTO boardDTO) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(SCANNER, message);
        if (yesNo.equalsIgnoreCase("Y")) {
            boardController.delete(boardDTO.getId());
        } else {
            printList();
        }
    }
}
