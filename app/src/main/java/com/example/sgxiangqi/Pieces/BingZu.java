package com.example.sgxiangqi.Pieces;

import com.example.sgxiangqi.Position;

public class BingZu extends Piece {

    public BingZu(boolean side, Position position) {
        super(side, position);
        super.setLabel("BingZu");
    }

    public boolean enemySide(){

        boolean enemySide = false;

        if(this.getPosition().getY_pos() <= 4 && this.getSide() == true){
            enemySide = false;
        } else if (this.getPosition().getY_pos() >= 5 && this.getSide() == true){
            enemySide = true;
        }

        if(this.getPosition().getY_pos() >= 5 && this.getSide() == false){
            enemySide = false;
        } else if(this.getPosition().getY_pos() <= 4 && this.getSide() == false){
            enemySide = true;
        }

        return enemySide;
    }

    public boolean possibleMove(Position current_position, Position possible_position){

        boolean possibleMove = false;

        if(enemySide() == false){
            if(possible_position.getY_pos() == current_position.getY_pos()+1){
                possibleMove = true;
            } else{
                possibleMove = false;
            }
        } else {
            if(possible_position.getY_pos() == current_position.getY_pos()+1 || possible_position.getX_pos() == current_position.getX_pos()+1 || possible_position.getX_pos() == current_position.getX_pos()-1){
                possibleMove = true;
            } else{
                possibleMove = false;
            }
        }

        return possibleMove;
    }

}
