package day0112;

import util.ScannerUtil;
import viewer.Board2Viewer;
import viewer.CommentViewer;
import viewer.ReplyViewer;
import viewer.UserViewer;

import java.util.Scanner;

public class Ex03Board02_S {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Board2Viewer board2Viewer = new Board2Viewer(scanner);
        UserViewer userViewer = new UserViewer(scanner);
        CommentViewer commentViewer = new CommentViewer(scanner);
        ReplyViewer replyViewer = new ReplyViewer(scanner);

        userViewer.setBoard2Viewer(board2Viewer);
        userViewer.setReplyViewer(replyViewer);

        board2Viewer.setUserViewer(userViewer, commentViewer);
        board2Viewer.setReplyViewer(replyViewer);
        commentViewer.setBoard2Viewer(board2Viewer);

        userViewer.showIndex();
    }
}
