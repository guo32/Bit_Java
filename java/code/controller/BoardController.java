package controller;

import model.BoardDTO;

import java.util.ArrayList;

public class BoardController {
    private ArrayList<BoardDTO> list;
    private int nextId;

    public BoardController() {
        list = new ArrayList<>();
        nextId = 1;
    }

    public void insert(BoardDTO boardDTO) {
        boardDTO.setId(nextId++);
        list.add(boardDTO);
    }

    public BoardDTO selectById(int id) {
        for (BoardDTO board : list) {
            if (board.getId() == id) {
                return new BoardDTO(board);
            }
        }
        return null;
    }

    public ArrayList<BoardDTO> selectAll() {
        return list;
    }

    public void update(BoardDTO boardDTO) {
        list.set(list.indexOf(boardDTO), boardDTO);
    }

    public void delete(int id) {
        BoardDTO b = new BoardDTO();
        b.setId(id);
        list.remove(b);
    }
}
