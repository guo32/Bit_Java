package viewer;

import controller.Board2Controller;
import model.Board2DTO;
import model.UserDTO;
import util.ScannerUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Board2Viewer {
    private Board2Controller board2Controller;
    private final Scanner SCANNER;
    private final String DATE_FORMAT = "yy/MM/dd HH:mm:ss";
    private UserViewer userViewer;
    private CommentViewer commentViewer;
    private UserDTO login;
    private ArrayList<UserDTO> userList;
    private ReplyViewer replyViewer;

    public Board2Viewer(Scanner scanner) { // 의존성 주입
        board2Controller = new Board2Controller();
        SCANNER = scanner;
    }

    public void setUserViewer(UserViewer userViewer, CommentViewer commentViewer) {
        this.userViewer = userViewer;
        this.commentViewer = commentViewer;
    }

    public void setReplyViewer(ReplyViewer replyViewer) {
        this.replyViewer = replyViewer;
    }

    public void setLogin(UserDTO login) {
        this.login = login;
    }
    public void setUserList(ArrayList<UserDTO> list) {
        userList = new ArrayList<>();
        for (UserDTO u : list) {
            userList.add(new UserDTO(u));
        }
    }

    public void showMenu() {
        String message = "1. 새 글 작성하기 2. 글 목록 보기 3. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(SCANNER, message);
            if (userChoice == 1) {
                writeBoard();
            } else if (userChoice == 2) {
                board2Controller.updateBoard(userList);
                printList();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    private void writeBoard() {
        Board2DTO board2DTO = new Board2DTO();

        board2DTO.setWriterId(login.getId());
        board2DTO.setWriterNickname(login.getNickname());

        String message = "글의 제목을 입력해주세요.";
        board2DTO.setTitle(ScannerUtil.nextLine(SCANNER, message));

        message = "글의 내용을 입력해주세요.";
        board2DTO.setContent((ScannerUtil.nextLine(SCANNER, message)));

        board2Controller.add(board2DTO);
    }

    private void printList() {
        ArrayList<Board2DTO> list = board2Controller.selectAll();
        if (list.isEmpty()) {
            System.out.println("아직 등록된 글이 없습니다.");
        } else {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            for (Board2DTO b : list) {
                System.out.printf("%d. %s - %s\n", b.getId(), b.getTitle(), df.format(b.getEntryDate()));
            }

            String message = "상세보기할 글의 번호나 뒤로 가시려면 0을 입력해주세요.";
            int userChoice = ScannerUtil.nextInt(SCANNER, message);

            while (userChoice != 0 && !list.contains(new Board2DTO(userChoice))) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(SCANNER, message);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
        }
    }

    private void printOne(int id) {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        Board2DTO board2DTO = board2Controller.selectOne(id);
        System.out.println("=================================");
        System.out.println(board2DTO.getTitle());
        System.out.println("---------------------------------");
        System.out.println("글 번호: " + board2DTO.getId());
        System.out.println("글 작성자: " + board2DTO.getWriterNickname());
        System.out.println("작성일: " + df.format(board2DTO.getEntryDate()));
        System.out.println("수정일: " + df.format(board2DTO.getModifyDate()));
        System.out.println("---------------------------------");
        System.out.println(board2DTO.getContent());
        System.out.println("---------------------------------");
        System.out.println("댓글");
        System.out.println("---------------------------------");
        replyViewer.printAll(id);
        System.out.println("=================================");

        String message;
        int userChoice;

        if (board2DTO.getWriterId() == login.getId()) {
            message = "1. 수정 2. 삭제 3. 댓글 4. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 4);
        } else {
            message = "3. 댓글 4. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(SCANNER, message, 3, 4);
        }

        if (userChoice == 1) {
            update(id);
        } else if (userChoice == 2) {
            delete(id);
        } else if (userChoice == 3) {
            replyViewer.showMenu(id);
            //commentViewer.setLogin(login);
            //commentViewer.setUserList(userList);
            //commentViewer.showMenu(id); // 댓글 메뉴
            printOne(id);
        } else if (userChoice == 4) {
            printList();
        }
    }

    private void update(int id) {
        Board2DTO b = board2Controller.selectOne(id);

        String message = "새로운 제목을 입력해주세요.";
        b.setTitle(ScannerUtil.nextLine(SCANNER, message));

        message = "새로운 내용을 입력해주세요.";
        b.setContent(ScannerUtil.nextLine(SCANNER, message));

        board2Controller.update(b);
    }

    private void delete(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(SCANNER, message);
        if (yesNo.equalsIgnoreCase("Y")) {
            board2Controller.delete(id);
            printList();
        } else {
            printOne(id);
        }
    }
}
