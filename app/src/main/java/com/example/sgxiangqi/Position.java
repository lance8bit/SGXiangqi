package com.example.sgxiangqi;

import com.example.sgxiangqi.Pieces.Piece;

public class Position {

    private int x_pos;
    private int y_pos;
    private Piece piece;

    public Position(){
        piece = new Piece();
    }

    public void setPosicion(int x, int y){
        this.x_pos = x;
        this.y_pos = y;
    }

    public int getX_pos() {
        return x_pos;
    }

    public void setX_pos(int x_pos) {
        this.x_pos = x_pos;
    }

    public int getY_pos() {
        return y_pos;
    }

    public void setY_pos(int y_pos) {
        this.y_pos = y_pos;
    }
}
