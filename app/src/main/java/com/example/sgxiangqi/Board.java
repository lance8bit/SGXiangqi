package com.example.sgxiangqi;

import com.example.sgxiangqi.Pieces.BingZu;
import com.example.sgxiangqi.Pieces.Piece;

import java.util.ArrayList;

public class Board {

    /*
        Position{
            Black : true (side) ;
            Red : false (side) ;
        }

        Board{
            board[y][x]
        }
     */

    private Piece[][] board;

    public Board(){
        board = new Piece[9][8];
        board[4][0] = new BingZu(true, new Position(0,4));
    }

    public Piece[][] getBoard() {
        return board;
    }

}
