package com.example.sgxiangqi;

public class Board {

    private Position[][] board;

    public Board(){
        board = new Position[9][8];
    }

    public Position[][] getBoard() {
        return board;
    }

    public void setBoard(Position[][] board) {
        this.board = board;
    }

}
