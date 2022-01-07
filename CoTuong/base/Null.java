package com.dongchess.base;

import static java.lang.Math.abs;

public class Null extends QuanCo {
    public Null(int x, int y) {
        this.constructor(x, y,0, 0, 10);
    }

    @Override
    boolean canMoveTo(int x, int y, QuanCo[][] qc) {
        return false;
    }

    @Override
    public String moveTo(int xMove, int yMove) {
        return "dongntd";
    }
}
