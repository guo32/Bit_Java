package controller;

import model.CommentDTO;

import java.util.ArrayList;

public class CommentController {
    private ArrayList<CommentDTO> list;
    private int nextId;

    public CommentController() {
        list = new ArrayList<>(); // 여기서 새 리스트로 초기화하면 안 될 것 같은 기분이 든다.
        nextId = 1;
    }

    // 댓글 삽입
    public void insert(CommentDTO commentDTO) {
        commentDTO.setId(nextId++);
        list.add(commentDTO);
    }

    // 댓글 수정
    public void update(CommentDTO commentDTO) {
        list.set(list.indexOf(commentDTO), commentDTO);
    }

    // 댓글 삭제
    public void delete(int id) {
        list.remove(new CommentDTO(id));
    }

    // 댓글 고유 아이디로 댓글 찾기
    public CommentDTO selectById(int id) {
        CommentDTO temp = new CommentDTO(id);
        if (list.contains(temp)) {
            return new CommentDTO(list.get(list.indexOf(temp)));
        }
        return null;
    }

    // 게시물 고유 아이디로 댓글 리스트 반환하기
    public ArrayList<CommentDTO> selectByBoardId(int id) {
        ArrayList<CommentDTO> result = new ArrayList<>();
        for (CommentDTO c : list) {
            if (c.getBoardId() == id) {
                result.add(new CommentDTO(c));
            }
        }
        return result;
    }

    public ArrayList<CommentDTO> selectByUserId(int userId, int boardId) {
        ArrayList<CommentDTO> commentOfBoardList = selectByBoardId(boardId);
        ArrayList<CommentDTO> result = new ArrayList<>();
        for (CommentDTO c : commentOfBoardList) {
            if (c.getUserId() == userId) {
                result.add(new CommentDTO(c));
            }
        }
        return result;
    }

    // 전체 댓글 리스트 반환하기
    public ArrayList<CommentDTO> selectAll() {
        ArrayList<CommentDTO> result = new ArrayList<>();
        for (CommentDTO c : list) {
            result.add(new CommentDTO(c));
        }
        return result;
    }
}
