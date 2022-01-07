package com.dongchess.base;

import static java.lang.Math.abs;

public class Xe extends QuanCo {
    public Xe(int x, int y, int color) {
        this.constructor(x, y,2, color, 400);
    }

    @Override
    boolean canMoveTo(int xMove, int yMove, QuanCo[][] qc) {
        int thisX = this.getParam("x");
        int thisY = this.getParam("y");
        int thisColor = this.getParam("color");

        // trùng màu quân mình:
        if (qc[xMove][yMove].getParam("color") == thisColor) return false;

        // đi ngang:
        if (thisX == xMove) {
            int maxY = Math.max(thisY, yMove);
            int minY = Math.min(thisY, yMove);

            for (int i = minY + 1; i < maxY; i++) {
                if (qc[thisX][i].getParam("color") != 0) return false;
            }
            return true;
        }

        // đi dọc:
        if (thisY == yMove) {
            int maxX = Math.max(thisX, xMove);
            int minX = Math.min(thisX, xMove);

            for (int i = minX + 1; i < maxX; i++) {
                if (qc[i][thisY].getParam("color") != 0) return false;
            }
            return true;
        }

        return false;
    }

    @Override
    public String moveTo(int xMove, int yMove) {
        int thisX = this.getParam("x");
        int thisY = this.getParam("y");
        int thisColor = this.getParam("color");

        System.out.println("Xe: (" + thisX + "," + thisY + ") --> (" + xMove + "," + yMove + ")");

        if (thisX == xMove) return "Xe " + thisY + " bình " + yMove + " - ";
        if (thisColor == 1) return "Xe " + thisY + (thisX > xMove ? " thoái " : " tấn " ) + abs(thisX - xMove) + " - ";
        return "Xe " + thisY + (thisX > xMove ? " tấn " : " thoái " ) + abs(thisX - xMove) + " - ";
    }
}
