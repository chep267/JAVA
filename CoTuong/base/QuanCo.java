package com.dongchess.base;

abstract class QuanCo {
    private int x,y; //toa do
    private int type; // ki hieu: 1-vua, 2-xe, 3-phao, 4-ma, 5-tuong, 6-si, 7-tot
    private int color; // mau sac: 1-trang, 2-den
    private int point; // diem;

    protected QuanCo() {}

    abstract boolean canMoveTo(int xMove, int yMove, QuanCo[][] qc);
    abstract String moveTo(int x, int y);

    public void constructor(int x, int y, int type, int color, int point) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.color = color;
        this.point = point;
    }

    //get:
    public int getParam(String param) {
        switch (param) {
            case "x":
                return this.x;
            case "y":
                return this.y;
            case "color":
                return this.color;
            case "type":
                return this.type;
            case "point":
                return this.point;
            default:
                return 0;
        }
    }

    //set:
    public void setParam(String param, int value) {
        switch (param) {
            case "x":
                this.x = value;
                break;
            case "y":
                this.y = value;
                break;
            case "color":
                this.color = value;
                break;
            case "type":
                this.type = value;
                break;
            case "point":
                this.point = value;
                break;
            default:
                break;
        }
    }
}