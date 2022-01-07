package com.dongchess.base;

import static java.lang.Math.abs;

public class Ma extends QuanCo {
    public Ma(int x, int y, int color) {
        this.constructor(x, y,4, color, 200);
    }

    @Override
    boolean canMoveTo(int xMove, int yMove, QuanCo[][] qc) {
        int thisX = this.getParam("x");
        int thisY = this.getParam("y");
        int thisColor = this.getParam("color");

        // trùng màu quân mình:
        if (qc[xMove][yMove].getParam("color") == thisColor) return false;

        if (thisX - xMove == 2)  return abs(thisY - yMove) == 1 && qc[thisX - 1][thisY].getParam("color") == 0;

        if (xMove - thisX == 2)  return abs(thisY - yMove) == 1 && qc[thisX + 1][thisY].getParam("color") == 0;

        if (thisY - yMove == 2)  return abs(thisX - xMove) == 1 && qc[thisX][thisY - 1].getParam("color") == 0;

        if (yMove - thisY == 2)  return abs(thisX - xMove) == 1 && qc[thisX][thisY + 1].getParam("color") == 0;

        return false;
    }

    @Override
    public String moveTo(int xMove, int yMove) {
        int thisX = this.getParam("x");
        int thisY = this.getParam("y");
        int thisColor = this.getParam("color");
        System.out.println("Mã: (" + thisX + "," + thisY + ") --> (" + xMove + "," + yMove + ")");
        if (thisColor == 1) return "Mã " + thisY + (thisX < xMove ? " tấn " : " thoái ") + yMove + " - ";
        return "Mã " + thisY + (thisX < xMove ? " thoái " : " tấn ") + yMove + " - ";
    }
}