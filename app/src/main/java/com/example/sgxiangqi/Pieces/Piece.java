package com.example.sgxiangqi.Pieces;

import com.example.sgxiangqi.Position;

public class Piece {
    private Position position;
    private boolean side;

    public Piece(){}

    public Piece(boolean side, Position position) {
        this.side = side;
        this.position =  position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean getSide() {
        return side;
    }

    public void setSide(boolean side) {
        this.side = side;
    }

}
