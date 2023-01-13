package controller;

import model.Board2DTO;
import model.UserDTO;

import java.util.ArrayList;
import java.util.Date;

public class Board2Controller {
    private ArrayList<Board2DTO> list;
    private int nextId;

    public Board2Controller() {
        list = new ArrayList<>();
        nextId = 1;

        for(int i = 1; i <= 4; i++) {
            Board2DTO b = new Board2DTO();
            b.setTitle("제목 " + i);
            b.setWriterId(1);
            b.setWriterNickname("일반회원 1");
            b.setContent(i + "번째 게시글의 내용입니다.");

            add(b);
        }
    }

    public void add(Board2DTO board2DTO) {
        board2DTO.setId(nextId++);
        board2DTO.setEntryDate(new Date());
        board2DTO.setModifyDate(new Date());
        list.add(board2DTO);
    }

    public Board2DTO selectOne(int id) {
        Board2DTO temp = new Board2DTO(id);
        if (list.contains(temp)) {
            return new Board2DTO(list.get(list.indexOf(temp)));
        }
        return null;
    }

    public ArrayList<Board2DTO> selectAll() {
        ArrayList<Board2DTO> temp = new ArrayList<>();
        for (Board2DTO b : list) {
            temp.add(new Board2DTO(b));
        }
        return temp;
    }

    public void update(Board2DTO board2DTO) {
        board2DTO.setModifyDate(new Date());
        list.set(list.indexOf(board2DTO), board2DTO);
    }

    public void delete(int id) {
        list.remove(new Board2DTO(id));
    }

    public void updateBoard(ArrayList<UserDTO> userList) {
        for (Board2DTO b : list) {
            if (userList.indexOf(new UserDTO(b.getWriterId())) == -1) {
                Board2DTO board = new Board2DTO(b);
                board.setWriterNickname("탈퇴한 사용자");
                update(board);
            } else {
                UserDTO testUser = userList.get(userList.indexOf(new UserDTO(b.getWriterId())));

                if (!testUser.getNickname().equals(b.getWriterNickname())) {
                    Board2DTO board = new Board2DTO(b);
                    board.setWriterNickname(testUser.getNickname());
                    update(board);
                }
            }
        }
    }
}
