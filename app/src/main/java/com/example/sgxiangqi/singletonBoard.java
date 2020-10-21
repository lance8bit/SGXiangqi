package com.example.sgxiangqi;

import com.example.sgxiangqi.Pieces.BingZu;
import com.example.sgxiangqi.Pieces.Piece;

import java.util.ArrayList;

public class singletonBoard {

    private static singletonBoard newInstance;
    private Piece[][] board;

    public static singletonBoard getNewInstance(){
        if(newInstance == null){
            newInstance = new singletonBoard();
        }
        return newInstance;
    }

    private singletonBoard(){
        board = new Piece[9][8]();
        board[4][0] = new BingZu(true, new Position(4,0));
    }

    public Piece[][] getBoard(){
        return this.board;
    }

    //public void addToListEquipos(Equipos nEquipo){
        listEquipos.add(nEquipo);
    }

}
