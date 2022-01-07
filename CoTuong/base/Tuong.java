package com.dongchess.base;

import static java.lang.Math.abs;

public class Tuong extends QuanCo {
    public Tuong(int x, int y, int color) {
        this.constructor(x, y,5, color, 100);
    }

    @Override
    boolean canMoveTo(int xMove, int yMove, QuanCo[][] qc) {
        int thisX = this.getParam("x");
        int thisY = this.getParam("y");
        int thisColor = this.getParam("color");

        // trùng màu quân mình:
        if (qc[xMove][yMove].getParam("color") == thisColor) return false;

        // cot 1
        if (thisY == 1) {
            if (thisColor == 1) return yMove == 3 && (xMove == 1 ? qc[2][2].getParam("color") == 0 : (xMove == 5 && qc[4][2].getParam("color") == 0));
            return yMove == 3 && (xMove == 6 ? qc[7][2].getParam("color") == 0 : (xMove == 10 && qc[9][2].getParam("color") == 0));
        }

        // cot 3
        if (thisY == 3) {
            // quân trắng:
            if (thisX == 1) return xMove == 3 && (yMove == 1 ? qc[2][2].getParam("color") == 0 : (yMove == 5 && qc[2][4].getParam("color") == 0));
            if (thisX == 5) return xMove == 3 && (yMove == 1 ? qc[4][2].getParam("color") == 0 : (yMove == 5 && qc[4][4].getParam("color") == 0));

            // quân đen:
            if (thisX == 6) return xMove == 8 && (yMove == 1 ? qc[7][2].getParam("color") == 0 : (yMove == 5 && qc[7][4].getParam("color") == 0));
            return thisX == 10 && xMove == 8 && (yMove == 1 ? qc[9][2].getParam("color") == 0 : (yMove == 5 && qc[9][4].getParam("color") == 0));
        }

        // cot 5
        if (thisY == 5) {
            // quân trắng:
            if (thisX == 3) {
                if (yMove == 3) return xMove == 1 ? qc[2][4].getParam("color") == 0 : (xMove == 5 && qc[4][4].getParam("color") == 0);
                return yMove == 7 && xMove == 1 ? qc[2][6].getParam("color") == 0 : (xMove == 5 && qc[4][6].getParam("color") == 0);
            }

            // quân đen: thisX = 8
            if (yMove == 3) return xMove == 10 ? qc[9][4].getParam("color") == 0 : (xMove == 6 && qc[7][4].getParam("color") == 0);
            return yMove == 7 && xMove == 10 ? qc[9][6].getParam("color") == 0 : (xMove == 6 && qc[7][6].getParam("color") == 0);

        }

        // cot 7
        if (thisY == 7) {
            // quân trắng:
            if (thisX == 1) return xMove == 3 && (yMove == 9 ? qc[2][8].getParam("color") == 0 : (yMove == 5 && qc[2][6].getParam("color") == 0));
            if (thisX == 5) return xMove == 3 && (yMove == 9 ? qc[4][8].getParam("color") == 0 : (yMove == 5 && qc[4][6].getParam("color") == 0));

            // quân đen:
            if (thisX == 6) return xMove == 8 && (yMove == 9 ? qc[7][8].getParam("color") == 0 : (yMove == 5 && qc[7][6].getParam("color") == 0));
            return thisX == 10 && xMove == 8 && (yMove == 9 ? qc[9][8].getParam("color") == 0 : (yMove == 5 && qc[9][6].getParam("color") == 0));
        }


        // cot 9
        if (thisY == 9) {
            if (thisColor == 1) return yMove == 7 && (xMove == 1 ? qc[2][8].getParam("color") == 0 : (xMove == 5 && qc[4][8].getParam("color") == 0));
            return yMove == 7 && (xMove == 1 ? qc[7][8].getParam("color") == 0 : (xMove == 5 && qc[9][8].getParam("color") == 0));
        }

        return false;
    }

    @Override
    public String moveTo(int xMove, int yMove) {
        int thisX = this.getParam("x");
        int thisY = this.getParam("y");
        int thisColor = this.getParam("color");

        System.out.println("Tịnh: (" + thisX + "," + thisY + ") --> (" + xMove + "," + yMove + ")");
        if (thisColor == 1) {
            return "Tịnh " + thisY + (thisX > xMove ? " thoái " : " tấn ") + abs(thisY - yMove) + " - ";
        }

        return "Tịnh " + thisY + (thisX > xMove ? " tấn " : " thoái ") + abs(thisY - yMove) + " - ";
    }
}
