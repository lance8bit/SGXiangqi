package com.example.sgxiangqi;

import com.example.sgxiangqi.Pieces.BingZu;
import com.example.sgxiangqi.Pieces.Che;
import com.example.sgxiangqi.Pieces.JiangShuai;
import com.example.sgxiangqi.Pieces.Ma;
import com.example.sgxiangqi.Pieces.Pao;
import com.example.sgxiangqi.Pieces.Piece;
import com.example.sgxiangqi.Pieces.Shi;
import com.example.sgxiangqi.Pieces.Xiang;

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

        //BLACK PIECES
        board[0][0] = new Che(true, new Position(0, 0));
        board[8][0] = new Che(true, new Position(0, 0));

        board[1][0] = new Ma(true, new Position(0, 0));
        board[7][0] = new Ma(true, new Position(0, 0));

        board[2][0] = new Xiang(true, new Position(0, 0));
        board[6][0] = new Xiang(true, new Position(0, 0));

        board[3][0] = new Shi(true, new Position(0, 0));
        board[5][0] = new Shi(true, new Position(0, 0));

        board[4][0] = new JiangShuai(true, new Position(0, 0));

        board[1][2] = new Pao(true, new Position(0, 0));
        board[7][2] = new Pao(true, new Position(0, 0));

        board[0][3] = new BingZu(true, new Position(3,0));
        board[2][3] = new BingZu(true, new Position(3,2));
        board[4][3] = new BingZu(true, new Position(3,4));
        board[6][3] = new BingZu(true, new Position(3,6));
        board[8][3] = new BingZu(true, new Position(3,8));

        //RED PIECES

        board[0][9] = new Che(false, new Position(0, 0));
        board[8][9] = new Che(false, new Position(0, 0));

        board[1][9] = new Ma(false, new Position(0, 0));
        board[7][9] = new Ma(false, new Position(0, 0));

        board[2][9] = new Xiang(false, new Position(0, 0));
        board[6][9] = new Xiang(false, new Position(0, 0));

        board[3][9] = new Shi(false, new Position(0, 0));
        board[5][9] = new Shi(false, new Position(0, 0));

        board[4][9] = new JiangShuai(false, new Position(0, 0));

        board[1][7] = new Pao(false, new Position(0, 0));
        board[7][7] = new Pao(false, new Position(0, 0));

        board[0][6] = new BingZu(false, new Position(6,0));
        board[2][6] = new BingZu(false, new Position(6,2));
        board[4][6] = new BingZu(false, new Position(6,4));
        board[6][6] = new BingZu(false, new Position(6,6));
        board[8][6] = new BingZu(false, new Position(6,8));

    }

    public Piece[][] getBoard() {
        return this.board;
    }

    public void movePosition(int x_or, int y_or, int x_new, int y_new){
        board[x_new][y_new] = board[x_or][y_or];
        board[x_or][y_or] = null;
    }

}
