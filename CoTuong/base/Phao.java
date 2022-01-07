package com.dongchess.base;

import static java.lang.Math.abs;

public class Phao extends QuanCo {
    public Phao(int x, int y, int color) {
        this.constructor(x, y,3, color, 200);
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
            int count = 0;
            for (int i = minY + 1; i < maxY; i++) {
                if (qc[thisX][i].getParam("color") != 0) count++;
                if (count > 1) return false;
            }
            return (count == 1 && qc[xMove][yMove].getParam("color") != thisColor) || (count == 0 && qc[xMove][yMove].getParam("color") == 0);
        }

        // đi dọc:
        if (thisY == yMove) {
            int maxX = Math.max(thisX, xMove);
            int minX = Math.min(thisX, xMove);
            int count = 0;
            for (int i = minX + 1; i < maxX; i++) {
                if (qc[i][thisY].getParam("color") != 0) count++;
                if (count > 1) return false;
            }
            return (count == 1 && qc[xMove][yMove].getParam("color") != thisColor) || (count == 0 && qc[xMove][yMove].getParam("color") == 0);
        }

        return false;
    }

    @Override
    public String moveTo(int xMove, int yMove) {
        int thisX = this.getParam("x");
        int thisY = this.getParam("y");
        int thisColor = this.getParam("color");

        System.out.println("Pháo: (" + thisX + "," + thisY + ") --> (" + xMove + "," + yMove + ")");

        if (thisX == xMove) return "Pháo " + thisY + " bình " + yMove + " - ";
        if (thisColor == 1) return "Pháo " + thisY + (thisX > xMove ? " thoái " : " tấn " ) + abs(thisX - xMove) + " - ";
        return "Pháo " + thisY + (thisX > xMove ? " tấn " : " thoái " ) + abs(thisX - xMove) + " - ";
    }
}
