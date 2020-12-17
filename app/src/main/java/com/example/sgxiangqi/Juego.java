package com.example.sgxiangqi;

import android.util.Log;

import com.example.sgxiangqi.Pieces.Piece;

public class Juego {

    private boolean turno, primero;
    private Piece[][] pieces;
    private int FX, FY, SX, SY;

    public Juego(){
        pieces = singletonBoard.getNewInstance().getBoard();
        turno = false;
        primero = false;
        FX = 0;
        FY = 0;
        SX = 0;
        SY = 0;
    }

    public boolean getTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public void jugada(int XMOVE, int YMOVE){

        if (primero == false) {
            if(pieces[XMOVE][YMOVE] != null){
                this.FX = XMOVE;
                this.FY = YMOVE;
                this.primero = true;
            }
        } else {
            this.SX = XMOVE;
            this.SY = YMOVE;

            if(checkJugada(FX, FY, SX, SY)) {
                movePieza(FX, FY, SX, SY);

                if(getTurno()){
                    setTurno(false);
                }else{
                    setTurno(true);
                }
            }
            cleanJugada();
        }
    }

    public boolean checkJugada(int X1, int Y1, int X2, int Y2){
        boolean possibility = false;

        switch (pieces[X1][Y1].getLabel()){
            case "BingZu":
                if(jugadaBingZu(X1, Y1, X2, Y2)){
                    possibility = true;
                }
                break;
            case "Che":
                if(jugadaChe(X1, Y1, X2, Y2)){
                    possibility = true;
                }
                break;
            case "JiangShuai":
                if(jugadaJianShuai(X1, Y1, X2, Y2)){
                    possibility = true;
                }
                break;
            case "Ma":
                if(jugadaMa(X1, Y1, X2, Y2)){
                    possibility = true;
                }
                break;
            case "Pao":
                if(jugadaPao(X1, Y1, X2, Y2)){
                    possibility = true;
                }
                break;
            case "Shi":
                if(jugadaShi(X1, Y1, X2, Y2)){
                    possibility = true;
                }
                break;
            case "Xiang":
                if(jugadaXiang(X1, Y1, X2, Y2)){
                    possibility = true;
                }
                break;
        }

        return possibility;
    }

    public boolean jugadaBingZu(int X1, int Y1, int X2, int Y2){
        boolean correcta = false;

        if(pieces[X1][Y1].getSide() == true){
            if(pieces[X2][Y2] == null){
                if(Y2 < 5 && Y2 == Y1 + 1){
                    correcta = true;
                } else if(Y2 > 4 && Y2 == Y1 + 1 || Y2 > 4 && Y2 == Y1 && X2 == X1 + 1 || Y2 > 4 && Y2 == Y1 && X2 == X1 - 1){
                    correcta = true;
                }
            } else {
                if(pieces[X2][Y2].getSide() == false){
                    if(Y2 > 4 && Y2 == Y1 + 1 || Y2 > 4 && Y2 == Y1 && X2 == X1 + 1 || Y2 > 4 && Y2 == Y1 && X2 == X1 - 1){
                        correcta = true;
                    }
                }
            }
        } else {
            if(pieces[X2][Y2] == null){
                if(Y2 > 4 && Y2 == Y1 - 1){
                    correcta = true;
                } else if(Y2 < 5 && Y2 == Y1 - 1 || Y2 < 5 && Y2 == Y1 && X2 == X1 + 1 || Y2 < 5 && Y2 == Y1 && X2 == X1 - 1){
                    correcta = true;
                }
            } else {
                if(pieces[X2][Y2].getSide() == true){
                    if(Y2 < 5 && Y2 == Y1 - 1 || Y2 < 5 && Y2 == Y1 && X2 == X1 + 1 || Y2 < 5 && Y2 == Y1 && X2 == X1 - 1){
                        correcta = true;
                    }
                }
            }
        }

        return correcta;
    }

    public boolean jugadaChe(int X1, int Y1, int X2, int Y2){
        boolean correcta = false;

        if(pieces[X2][Y2] != null){
            if(pieces[X2][Y2].getSide() != pieces[X1][Y1].getSide()  ){
                if(X2 == X1){
                    if(Y2 == Y1 - 1){
                        correcta = true;
                    } else if(Y2 < Y1){
                        correcta = true;
                        for (int i = Y1 - 1; i > Y2; i--) {
                            if(pieces[X1][i] != null){
                                i = Y2;
                                correcta = false;
                            }
                        }
                    } else if(Y2 > Y1){
                        correcta = true;
                        for (int i = Y1 + 1; i < Y2 ; i++) {
                            if(pieces[X1][i] != null){
                                i = Y2;
                                correcta = false;
                            }
                        }
                    }
                } else if(Y2 == Y1){
                    if(X2 == X1 - 1){
                        correcta = true;
                    } else if(X2 < X1){
                        correcta = true;
                        for (int i = X1 - 1; i > X2; i--) {
                            if(pieces[i][Y1] != null){
                                i = X1;
                                correcta = false;
                            }
                        }
                    } else if(X2 > X1){
                        correcta = true;
                        for (int i = X1 + 1; i < X2 ; i++) {
                            if(pieces[X1][Y1] != null){
                                i = X2;
                                correcta = false;
                            }
                        }
                    }
                }
            }
        }else{
            //MOVEMOS EN EJE Y
            if(X2 == X1){
                correcta = true;
                //COMPROVAMOS SI MUEVE UNA O MAS POSICIONES Y
                if(Y2 > Y1 + 1 || Y2 < Y1 - 1){
                    if(Y2 > Y1){
                        for(int i = Y1 + 1; i < Y2; i++){
                            correcta = true;
                            if(pieces[X1][i] != null){
                                //SE ENCUENTRA UNA PIEZA, MOVE INVALID
                                correcta = false;
                                break;
                            }
                        }
                    }else{
                        for (int i = Y2; i < Y1; i++) {
                            correcta = true;
                            if(pieces[X1][i] != null){
                                //SE ENCUENTRA UNA PIEZA, MOVE INVALID
                                correcta = false;
                                break;
                            }
                        }
                    }
                }
            //MOVEMOS EN EJE X
            }else if(Y2 == Y1){
                correcta = true;
                //COMPROVAMOS SI MUEVE UNA O MAS POSICIONES Y
                if(X2 > X1 + 1 || X2 < X1 - 1){
                    if(X2 > X1){
                        for(int i = X1 + 1; i < X2; i++){
                            correcta = true;
                            if(pieces[i][Y1] != null){
                                //SE ENCUENTRA UNA PIEZA, MOVE INVALID
                                correcta = false;
                                break;
                            }
                        }
                    }else{
                        for (int i = X2; i < X1; i++) {
                            correcta = true;
                            if(pieces[i][Y1] != null){
                                //SE ENCUENTRA UNA PIEZA, MOVE INVALID
                                correcta = false;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return correcta;
    }

    public boolean jugadaJianShuai(int X1, int Y1, int X2, int Y2){
        boolean correcta = false;

        //CHECK LADO ROJO
        if(X2 > 2 && X2 < 6){
            if(Y2 > 6){
                if(checkJuanShuai(X1, Y1, X2, Y2)){
                    correcta = true;
                }
            } else if(Y2 < 3){
                if(checkJuanShuai(X1, Y1, X2, Y2)){
                    correcta = true;
                }
            }
        }

        return correcta;
    }

    public boolean checkJuanShuai(int X1, int Y1, int X2, int Y2){
        boolean correcta = false;

        if(pieces[X2][Y2] != null){
            if(pieces[X1][Y1].getSide() != pieces[X2][Y2].getSide()){
                if(X2 == X1){
                    if(Y2 == Y1 + 1 || Y2 == Y1 - 1){
                        correcta = true;
                    }
                }else if(Y2 == Y1){
                    if(X2 == X1 + 1 || X2 == X1 - 1){
                        correcta = true;
                    }
                }else{
                    if(X2 == X1 + 1 && Y2 == Y1 + 1 || X2 == X1 + 1 && Y2 == Y1 - 1 || X2 == X1 - 1 && Y2 == Y1 + 1 || X2 == X1 - 1 && Y2 == Y1 - 1){
                        correcta = true;
                    }
                }
            }
        }else{
            if(X2 == X1){
                if(Y2 == Y1 + 1 || Y2 == Y1 - 1){
                    correcta = true;
                }
            }else if(Y2 == Y1){
                if(X2 == X1 + 1 || X2 == X1 - 1){
                    correcta = true;
                }
            }else{
                if(X2 == X1 + 1 && Y2 == Y1 + 1 || X2 == X1 + 1 && Y2 == Y1 - 1 || X2 == X1 - 1 && Y2 == Y1 + 1 || X2 == X1 - 1 && Y2 == Y1 - 1){
                    correcta = true;
                }
            }
        }

        return correcta;
    }

    public boolean jugadaMa(int X1, int Y1, int X2, int Y2){
        boolean correcta = false;

        if(pieces[X2][Y2] != null){
            if(pieces[X1][Y1].getSide() != pieces[X2][Y2].getSide()){
                if(checkMa(X1, Y1, X2, Y2)){
                    correcta = true;
                }
            }
        }else{
            if(checkMa(X1, Y1, X2, Y2)){
                correcta = true;
            }
        }

        return correcta;
    }

    public boolean checkMa(int X1, int Y1, int X2, int Y2){
        boolean correcta = false;

        if(Y2 == Y1 + 2 && X2 == X1 + 1){
            if(pieces[X1][Y1+1] == null){
                correcta = true;
            }
        }else if(Y2 == Y1 + 2 && X2 == X1 - 1){
            if(pieces[X1][Y1+1] == null){
                correcta = true;
            }
        }else if(Y2 == Y1 - 2 && X2 == X1 + 1){
            if(pieces[X1][Y1-1] == null){
                correcta = true;
            }
        }else if(Y2 == Y1 - 2 && X2 == X1 - 1){
            if(pieces[X1][Y1-1] == null){
                correcta = true;
            }
        }

        return correcta;
    }

    public boolean jugadaPao(int X1, int Y1, int X2, int Y2){
        boolean correcta = false;

        if(pieces[X2][Y2] != null){
            if(beetweenPieces(X1,Y1,X2,Y2)){
                correcta = true;
            }
        }else{
            correcta = true;
            if(Y2 > Y1 && X2 == X1){
                for (int i = Y1 + 1; i < Y2 ; i++) {
                    if(pieces[X1][i] != null){
                        correcta = false;
                        break;
                    }
                }
            } else if(X2 > X1 && Y2 == Y1){
                for (int i = X1 + 1; i < X2 ; i++) {
                    if(pieces[i][Y1] != null){
                        correcta = false;
                        break;
                    }
                }
            } else if(Y2 < Y1 && X2 == X1){
                for (int i = Y1 - 1; i > Y2 ; i--) {
                    if(pieces[X1][i] != null){
                        correcta = false;
                        break;
                    }
                }
            } else if(X2 < X1 && Y2 == Y1){
                for (int i = X1 - 1; i > X2 ; i--) {
                    if(pieces[i][Y1] != null){
                        correcta = false;
                        break;
                    }
                }
            }
        }

        return correcta;
    }

    public boolean beetweenPieces(int X1, int Y1, int X2, int Y2){
        boolean isIn = false;

        if (Y2 > Y1 && X2 == X1) {
            int counter = 0;

            for (int i = Y1; i < Y2; i++) {
                if(pieces[X2][i] != null && pieces[X2][i].getSide() != pieces[X1][Y1].getSide()){
                    counter++;
                }
            }

            if(counter > 1){
                isIn = true;
            }
        }else if(X2 > X1 && Y2 == Y1){
            int counter = 0;

            for (int i = X1; i < X2; i++) {
                if(pieces[X2][i] != null && pieces[X2][i].getSide() != pieces[X1][Y1].getSide()){
                    counter++;
                }
            }

            if(counter > 1){
                isIn = true;
            }
        }else if(Y2 < Y1 && X2 == X1){
            int counter = 0;

            for (int i = Y1; i > Y2; i--) {
                if(pieces[X2][i] != null && pieces[X2][i].getSide() != pieces[X1][Y1].getSide()){
                    counter++;
                }
            }

            if(counter > 0){
                isIn = true;
            }
        }else if(X2 < X1 && Y2 == Y1){
            int counter = 0;

            for (int i = X1; i > X2; i--) {
                if(pieces[i][Y2] != null && pieces[X2][i].getSide() != pieces[X1][Y1].getSide()){
                    counter++;
                }
            }

            if(counter > 0){
                isIn = true;
            }
        }

        return isIn;
    }

    public boolean jugadaShi(int X1, int Y1, int X2, int Y2){
        boolean correcta = false;

        if(X2 > 2 && X2 < 6 && X2 == X1 + 1 && Y2 == Y1 + 1 ||X2 > 2 && X2 < 6 && X2 == X1 - 1 && Y2 == Y1 + 1 ||X2 > 2 && X2 < 6 && X2 == X1 + 1 && Y2 == Y1 - 1 ||X2 > 2 && X2 < 6 && X2 == X1 - 1 && Y2 == Y1 - 1) {
            if(pieces[X2][Y2] == null){
                if(Y2 > 6){
                    correcta = true;
                } else if(Y2 < 3){
                    correcta = true;
                }

            }else{
                if(pieces[X2][Y2].getSide() != pieces[X1][Y1].getSide()){
                    correcta = true;
                }
            }
        }

        return correcta;
    }

    public boolean jugadaXiang(int X1, int Y1, int X2, int Y2){
        boolean correcta = false;

        if(Y2 == Y1 + 2 && X2 == X1 + 2 || Y2 == Y1 - 2 && X2 == X1 - 2 ||Y2 == Y1 + 2 && X2 == X1 - 2 ||Y2 == Y1 - 2 && X2 == X1 + 2){
            if(X2 < X1 && Y2 < Y1){
                if(pieces[X1 - 1][Y1 - 1] == null){
                    if(Y2 > 4 && pieces[X1][Y1].getSide() == false){
                        if(pieces[X2][Y2] == null){
                            correcta = true;
                        }else{
                            if(pieces[X1][Y1].getSide() != pieces[X2][Y2].getSide()){
                                correcta = true;
                            }
                        }
                    } else if(Y2 < 5 && pieces[X1][Y1].getSide() == true){
                        if(pieces[X2][Y2] == null){
                            correcta = true;
                        }else{
                            if(pieces[X1][Y1].getSide() != pieces[X2][Y2].getSide()){
                                correcta = true;
                            }
                        }
                    }
                }
            } else if(X2 < X1 && Y2 > Y1){
                if(pieces[X1 - 1][Y1 + 1] == null){
                    if(Y2 > 4 && pieces[X1][Y1].getSide() == false){
                        if(pieces[X2][Y2] == null){
                            correcta = true;
                        }else{
                            if(pieces[X1][Y1].getSide() != pieces[X2][Y2].getSide()){
                                correcta = true;
                            }
                        }
                    } else if(Y2 < 5 && pieces[X1][Y1].getSide() == true){
                        if(pieces[X2][Y2] == null){
                            correcta = true;
                        }else{
                            if(pieces[X1][Y1].getSide() != pieces[X2][Y2].getSide()){
                                correcta = true;
                            }
                        }
                    }
                }
            } else if(X2 > X1 && Y2 > Y1){
                if(pieces[X1 + 1][Y1 + 1] == null){
                    if(Y2 > 4 && pieces[X1][Y1].getSide() == false){
                        if(pieces[X2][Y2] == null){
                            correcta = true;
                        }else{
                            if(pieces[X1][Y1].getSide() != pieces[X2][Y2].getSide()){
                                correcta = true;
                            }
                        }
                    } else if(Y2 < 5 && pieces[X1][Y1].getSide() == true){
                        if(pieces[X2][Y2] == null){
                            correcta = true;
                        }else{
                            if(pieces[X1][Y1].getSide() != pieces[X2][Y2].getSide()){
                                correcta = true;
                            }
                        }
                    }
                }
            } else if(X2 > X1 && Y2 < Y1){
                if(pieces[X1 + 1][Y1 - 1] == null){
                    if(Y2 > 4 && pieces[X1][Y1].getSide() == false){
                        if(pieces[X2][Y2] == null){
                            correcta = true;
                        }else{
                            if(pieces[X1][Y1].getSide() != pieces[X2][Y2].getSide()){
                                correcta = true;
                            }
                        }
                    } else if(Y2 < 5 && pieces[X1][Y1].getSide() == true){
                        if(pieces[X2][Y2] == null){
                            correcta = true;
                        }else{
                            if(pieces[X1][Y1].getSide() != pieces[X2][Y2].getSide()){
                                correcta = true;
                            }
                        }
                    }
                }
            }
        }

        return correcta;
    }

    public void movePieza(int X1, int Y1, int X2, int Y2){
        pieces[X2][Y2] = pieces[X1][Y1];
        pieces[X1][Y1] = null;
    }

    public void cleanJugada(){
        this.primero = false;
        this.FX = 0;
        this.FY = 0;
        this.SX = 0;
        this.SY = 0;
    }
}
