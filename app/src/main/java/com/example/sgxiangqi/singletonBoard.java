package com.example.sgxiangqi;

import com.example.sgxiangqi.Pieces.BingZu;
import com.example.sgxiangqi.Pieces.Piece;

import java.util.ArrayList;

public class singletonBoard {

    private static singletonBoard newInstance;
    private ArrayList board;

    public static singletonBoard getNewInstance(){
        if(newInstance == null){
            newInstance = new singletonBoard();
        }
        return newInstance;
    }

    private singletonBoard(){
        board = new ArrayList<Piece>();
        board.add(new BingZu(true, new Position(3, 0)));
        board.add(new BingZu(true, new Position(3, 2)));
        board.add(new BingZu(true, new Position(3, 4)));
        board.add(new BingZu(true, new Position(3, 6)));
        board.add(new BingZu(true, new Position(3, 8)));
        board.add(new BingZu(true, new Position(6, 0)));
        board.add(new BingZu(true, new Position(6, 2)));
        board.add(new BingZu(true, new Position(6, 4)));
        board.add(new BingZu(true, new Position(6, 6)));
        board.add(new BingZu(true, new Position(6, 8)));
    }

    public ArrayList<Piece> getBoard() {
        return board;
    }
}
