package com.example.sgxiangqi.Pieces;

public abstract class Piece {
    private boolean side;
    private String label;

    public Piece(){}

    public Piece(boolean side) {
        this.side = side;
    }

    public boolean getSide() {
        return side;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
