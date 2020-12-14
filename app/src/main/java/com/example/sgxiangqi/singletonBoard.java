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
        board[0][0] = new Che(true);
        board[8][0] = new Che(true);

        board[1][0] = new Ma(true);
        board[7][0] = new Ma(true);

        board[2][0] = new Xiang(true);
        board[6][0] = new Xiang(true);

        board[3][0] = new Shi(true);
        board[5][0] = new Shi(true);

        board[4][0] = new JiangShuai(true);

        board[1][2] = new Pao(true);
        board[7][2] = new Pao(true);

        board[0][3] = new BingZu(true);
        board[2][3] = new BingZu(true);
        board[4][3] = new BingZu(true);
        board[6][3] = new BingZu(true);
        board[8][3] = new BingZu(true);

        //RED PIECES

        board[0][9] = new Che(false);
        board[8][9] = new Che(false);

        board[1][9] = new Ma(false);
        board[7][9] = new Ma(false);

        board[2][9] = new Xiang(false);
        board[6][9] = new Xiang(false);

        board[3][9] = new Shi(false);
        board[5][9] = new Shi(false);

        board[4][9] = new JiangShuai(false);

        board[1][7] = new Pao(false);
        board[7][7] = new Pao(false);

        board[0][6] = new BingZu(false);
        board[2][6] = new BingZu(false);
        board[4][6] = new BingZu(false);
        board[6][6] = new BingZu(false);
        board[8][6] = new BingZu(false);

    }

    public Piece[][] getBoard() {
        return this.board;
    }

}
