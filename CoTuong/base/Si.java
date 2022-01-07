package com.dongchess.base;

import static java.lang.Math.abs;

public class Si extends QuanCo {
    public Si(int x, int y, int color) {
        this.constructor(x, y,6, color, 100);
    }

    @Override
    boolean canMoveTo(int xMove, int yMove, QuanCo[][] qc) {
        int thisX = this.getParam("x");
        int thisY = this.getParam("y");
        int thisColor = this.getParam("color");

        // trùng màu quân mình:
        if (qc[xMove][yMove].getParam("color") == thisColor) return false;

        // di vao trung tam
        if (thisY == 4 || thisY == 6) return yMove == 5 && xMove == (thisColor == 1 ? 2 : 9);

        // di ra ngoai cung
        if (thisY == 5 && (yMove == 4 || yMove == 6)) return abs(thisX - xMove) == 1;

        return false;
    }

    @Override
    public String moveTo(int xMove, int yMove) {
        int thisX = this.getParam("x");
        int thisY = this.getParam("y");
        int thisColor = this.getParam("color");

        System.out.println("Sĩ: (" + thisX + "," + thisY + ") --> (" + xMove + "," + yMove + ")");

        if (thisX == xMove) return  "Sĩ " + thisX + " bình " + abs(thisY - yMove) + " - ";
        if (thisColor == 1) return "Sĩ " + thisY + (thisX > xMove ? " thoái " : " tấn ") + abs(thisY - yMove) + " - ";
        return "Sĩ " + thisY + (thisX > xMove ? " tấn " : " thoái ") + abs(thisY - yMove) + " - ";
    }
}
