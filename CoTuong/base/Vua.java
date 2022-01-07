package com.dongchess.base;

import static java.lang.Math.abs;

public class Vua extends QuanCo {
    public Vua(int x, int y, int color) {
        this.constructor(x, y,1, color, 10000);
    }

    @Override
    boolean canMoveTo(int xMove, int yMove, QuanCo[][] qc) {
        int thisX = this.getParam("x");
        int thisY = this.getParam("y");
        int thisColor = this.getParam("color");

        // trùng màu quân mình:
        if (qc[xMove][yMove].getParam("color") == thisColor) return false;

        // di doc:
        if (thisY == yMove) return (thisColor == 1 ? xMove <= 3 : xMove >= 8) && abs(thisX - xMove) == 1;

        // di cheo:
        if (thisY == 4 || thisY == 6) return yMove == 5 && xMove == (thisColor == 1 ? 2 : 9);
        if (thisY == 5) return (yMove == 4 || yMove == 6) && (thisColor == 1 ? (xMove == 1 || xMove == 3) : (xMove == 8 || xMove == 10));

        return false;
    }

    @Override
    public String moveTo(int xMove, int yMove) {
        int thisX = this.getParam("x");
        int thisY = this.getParam("y");
        int thisColor = this.getParam("color");

        System.out.println("Tướng: (" + thisX + "," + thisY + ") --> (" + xMove + "," + yMove + ")");

        if (thisX == xMove) return  "Tướng " + thisX + " bình " + abs(thisY - yMove) + " - ";
        if (thisColor == 1) return "Tướng " + thisY + (thisX > xMove ? " thoái " : " tấn ") + abs(thisY - yMove) + " - ";
        return "Tướng " + thisY + (thisX > xMove ? " tấn " : " thoái ") + abs(thisY - yMove) + " - ";
    }
}
