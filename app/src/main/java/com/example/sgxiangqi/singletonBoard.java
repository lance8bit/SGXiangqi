package com.example.sgxiangqi;

import com.example.sgxiangqi.Pieces.BingZu;
import com.example.sgxiangqi.Pieces.Piece;

import java.util.ArrayList;

public class singletonBoard {

    private static singletonBoard newInstance;
    private Piece[][] board = null;

    public static singletonBoard getNewInstance(){
        if(newInstance == null){
            newInstance = new singletonBoard();
        }
        return newInstance;
    }

    private singletonBoard(){
        board = new Piece[9][10];

        board[0][3] = new BingZu(true, new Position(3,0));
        board[2][3] = new BingZu(true, new Position(3,2));
        board[4][3] = new BingZu(true, new Position(3,4));
        board[6][3] = new BingZu(true, new Position(3,6));
        board[8][3] = new BingZu(true, new Position(3,8));

        board[0][6] = new BingZu(true, new Position(6,0));
        board[2][6] = new BingZu(true, new Position(6,2));
        board[4][6] = new BingZu(true, new Position(6,4));
        board[6][6] = new BingZu(true, new Position(6,6));
        board[8][6] = new BingZu(true, new Position(6,8));

    }

    public Piece[][] getBoard() {
        return this.board;
    }

    public void movePosition(int x_or, int y_or, int x_new, int y_new){
        board[x_new][y_new] = board[x_or][y_or];
        board[x_or][y_or] = null;
    }

}
