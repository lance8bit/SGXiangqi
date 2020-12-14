package com.example.sgxiangqi.Pieces;

import com.example.sgxiangqi.Position;

public class Piece {
    private boolean side;
    private String label;

    public Piece(){}

    public Piece(boolean side) {
        this.side = side;
    }

    public boolean getSide() {
        return side;
    }

    public void setSide(boolean side) {
        this.side = side;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
