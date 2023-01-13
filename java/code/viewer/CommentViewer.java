package viewer;

import controller.CommentController;
import model.CommentDTO;
import model.UserDTO;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class CommentViewer {
    private final Scanner SCANNER;
    private CommentController commentController;
    private Board2Viewer board2Viewer;
    private UserDTO login;
    private ArrayList<UserDTO> userList;
    public CommentViewer(Scanner scanner) {
        SCANNER = scanner;
        commentController = new CommentController();
    }

    public void setBoard2Viewer(Board2Viewer board2Viewer) {
        this.board2Viewer = board2Viewer;
    }

    public void setLogin(UserDTO login) {
        this.login = login;
    }

    public void setUserList(ArrayList<UserDTO> list) {
        this.userList = list;
    }

    public void showMenu(int boardId) {
        String message = "1. 댓글 달기 2. 댓글 목록 3. 게시물로 돌아가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 3);
            if (userChoice == 1) {
                insert(boardId);
            } else if (userChoice == 2) {
                commentController.updateComment(userList);
                printList(boardId);
            } else if (userChoice == 3) {
                break;
            }
        }
    }

    private void insert(int boardId) {
        String message = "댓글을 입력해주세요.";
        CommentDTO newComment = new CommentDTO();
        newComment.setBoardId(boardId);
        newComment.setUserId(login.getId());
        newComment.setUserNickname(login.getNickname());
        newComment.setContent(ScannerUtil.nextLine(SCANNER, message));

        commentController.insert(newComment);
    }

    private void printList(int boardId) {
        ArrayList<CommentDTO> list = commentController.selectByBoardId(boardId);
        if(list.isEmpty()) {
            System.out.println("해당 게시물에는 등록된 댓글이 없습니다.");
        } else {
            for (CommentDTO c : list) {
                System.out.printf("%d. %s - %s\n", c.getId(), c.getContent(), c.getUserNickname());
            }
            String message = "1. 댓글 수정 2. 댓글 삭제 3. 뒤로 가기";
            int userChoice = ScannerUtil.nextInt(SCANNER, message, 1, 3);
            if(userChoice != 3) {
                message = "수정하거나 삭제할 댓글의 번호나 뒤로 가시려면 0을 입력하세요.";
                int select = ScannerUtil.nextInt(SCANNER, message);
                ArrayList<CommentDTO> loginUserCommentList = commentController.selectByUserId(login.getId(), boardId);
                while(select != 0 && commentController.selectById(select) == null) {
                    System.out.println("존재하지 않는 번호의 댓글입니다.");

                    select = ScannerUtil.nextInt(SCANNER, message);
                }
                if (select != 0) {
                    if(!loginUserCommentList.isEmpty()) {
                        for (CommentDTO c : loginUserCommentList) {
                            if(select == c.getId()) {
                                if (userChoice == 1) {
                                    update(c);
                                } else if (userChoice == 2) {
                                    commentController.delete(select);
                                    System.out.println("댓글을 삭제했습니다.");
                                }
                            }
                        }
                    } else {
                        if(userChoice == 1) System.out.println("수정할 수 없는 댓글입니다.");
                        else if(userChoice == 2) System.out.println("삭제할 수 없는 댓글입니다.");
                    }
                }
                printList(boardId);
            }
        }
    }

    private void update(CommentDTO commentDTO) {
        String message = "댓글을 수정해주세요.";
        CommentDTO temp = new CommentDTO(commentDTO);
        temp.setContent(ScannerUtil.nextLine(SCANNER, message));
        commentController.update(temp);
        System.out.println("댓글을 수정했습니다.");
    }
}
