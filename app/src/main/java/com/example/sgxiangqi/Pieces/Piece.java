package com.example.sgxiangqi.Pieces;

import com.example.sgxiangqi.Position;

public class Piece {

    private Position position;
    private boolean side;

    public Piece(){}

    public Piece(boolean side) {
        this.side = side;
        position = new Position();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isSide() {
        return side;
    }

    public void setSide(boolean side) {
        this.side = side;
    }
}
