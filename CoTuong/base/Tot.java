package com.dongchess.base;

import static java.lang.Math.abs;

public class Tot extends QuanCo {
    public Tot(int x, int y, int color) {
        this.constructor(x, y,7, color, 50);
    }

    @Override
    boolean canMoveTo(int xMove, int yMove, QuanCo[][] qc) {
        int thisX = this.getParam("x");
        int thisY = this.getParam("y");
        int thisColor = this.getParam("color");

        // trùng màu quân mình:
        if (qc[xMove][yMove].getParam("color") == thisColor) return false;

        // di doc:
        if (thisY == yMove) return xMove == thisX + (thisColor == 1 ? 1 : -1);

        // sang song di ngang:
        if (thisX == xMove && (thisColor == 1 ? thisX > 5 : thisX < 6)) {
            if (thisY == 1) return yMove == 2;
            if (thisY == 9) return yMove == 8;
            return abs(thisY - yMove) == 1;
        }

        return false;
    }

    @Override
    public String moveTo(int xMove, int yMove) {
        int thisX = this.getParam("x");
        int thisY = this.getParam("y");

        System.out.println("Tốt: (" + thisX + "," + thisY + ") --> (" + xMove + "," + yMove + ")");

        return "Tốt " + thisX + (thisX == xMove ? " bình " + abs(thisY - yMove) : " tấn " + abs(thisX - xMove)) + " - ";
    }
}
