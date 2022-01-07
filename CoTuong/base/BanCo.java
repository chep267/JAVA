package com.dongchess.base;

import java.util.Random;
import java.util.Scanner;

public class BanCo {

    private final QuanCo[][] banco = new QuanCo[12][11];
    public int king = 2;

    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String NULL_COLOR = "\033[1;90m";
    public static final String WHITE_COLOR = "\033[1;30m";
    public static final String BLACK_COLOR = "\033[1;31m";
    public static final String CYAN_COLOR = "\u001B[36m";

    private QuanCo taoQuanCo(int x, int y, int type, int color) {
        switch (type) {
            case 1:
                return new Vua(x, y, color);
            case 2:
                return new Xe(x, y, color);
            case 3:
                return new Phao(x, y, color);
            case 4:
                return new Ma(x, y, color);
            case 5:
                return new Tuong(x, y, color);
            case 6:
                return new Si(x, y, color);
            case 7:
                return new Tot(x, y, color);
            default:
                return new Null(x, y);
        }
    }

    private String inQuanCo(int type, int color) {
        String QuanCo_Color = color == 0 ? NULL_COLOR : color == 1 ? WHITE_COLOR : BLACK_COLOR;
        return QuanCo_Color + type + ANSI_RESET;
    }

    //check Vua có đủ 2 hay không:
    public boolean checkKing() {
        return this.king == 2;
    }

    public void anQuanCo(int type, int color) {
        switch (type) {
            case 1:
                System.out.println("Ăn Vua! Kết thúc game...");
                System.out.println("Quân " + (color == 1 ? "trắng" : "đen") + " thắng!!!");
                this.king = 1;
                break;
            case 2:
                System.out.println("Ăn Xe!");
                break;
            case 3:
                System.out.println("Ăn Pháo!");
                break;
            case 4:
                System.out.println("Ăn Mã!");
                break;
            case 5:
                System.out.println("Ăn Tượng!");
                break;
            case 6:
                System.out.println("Ăn Sĩ!");
                break;
            case 7:
                System.out.println("Ăn Tốt!");
                break;
            default:
                System.out.println(" hết!");
                break;
        }
    }

    public void taoBanCo() {
        int[][] bc = new int[][]{
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 2, 4, 5, 6, 1, 6, 5, 4, 2, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0 },
                { 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                // ---------------------------------
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 7, 0, 7, 0, 7, 0, 7, 0 },
                { 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 2, 4, 5, 6, 1, 6, 5, 4, 2, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        };

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 11; j++) {
                this.banco[i][j] = this.taoQuanCo(i, j, bc[i][j], i < 6 ? 1 : 2);
            }
        }
    }

    public void inBanCo() {
        System.out.println(CYAN_COLOR + "--------------------------Cờ tướng---------------------------\n" + ANSI_RESET);
        System.out.println(CYAN_COLOR + "      1     2     3     4     5     6     7     8     9" + ANSI_RESET);
        System.out.println(CYAN_COLOR + "-------------------------------------------------------------" + ANSI_RESET);

        for (int i = 1; i < 11; i++) {
            if (i == 6) System.out.println(CYAN_COLOR + "======   =====   =====    =====   =====   =====   =====   =====" + ANSI_RESET);
            for (int j = 1; j < 10; j++) {
                if (j == 1) System.out.print(CYAN_COLOR + (i < 10 ? i + "  |  " : i + " |  ") + ANSI_RESET);
                System.out.print(this.inQuanCo(this.banco[i][j].getParam("type"), this.banco[i][j].getParam("color")) + CYAN_COLOR + "  |  " + ANSI_RESET);
                if (j == 9) System.out.print(CYAN_COLOR + i + ANSI_RESET);
            }
            System.out.print("\n");
        }

        System.out.println(CYAN_COLOR + "-------------------------------------------------------------" + ANSI_RESET);
        System.out.println(CYAN_COLOR + "      1     2     3     4     5     6     7     8     9" + ANSI_RESET);
    }

    public void moveQuanCo(int x, int y, int xMove, int yMove) {
        int type = this.banco[xMove][yMove].getParam("type");
        int color = this.banco[x][y].getParam("color");
        System.out.print(this.banco[x][y].moveTo(xMove, yMove));
        this.banco[xMove][yMove] = this.banco[x][y];
        this.banco[x][y] = new Null(x, y);
        this.anQuanCo(type, color);
        this.inBanCo();
    }

    public void Player_Play(int color, Scanner sc) {
        int x, y, xMove, yMove;
        boolean hasQuanCo;
        boolean canMove;
        boolean failXY;
        boolean failXYMove;

        do {
            hasQuanCo = canMove = false;
            System.out.print("Nhập tọa độ x, y: ");
            x = sc.nextInt();
            y = sc.nextInt();
            failXY = x < 1 || x > 10 || y < 1 || y > 9;

            if (failXY) System.out.println("Tọa độ bạn nhập chưa đúng!");
            else {
                hasQuanCo = this.banco[x][y].getParam("color") == color;
                if (!hasQuanCo) System.out.println("Không có quân cờ của bạn. Hãy chọn lại!");
                else {
                    do {
                        System.out.print("Nhập tọa độ xMove, yMove: ");
                        xMove = sc.nextInt();
                        yMove = sc.nextInt();

                        failXYMove = xMove < 1 || xMove > 10 || yMove < 1 || yMove > 9;
                        if (failXYMove) System.out.println("Tọa độ bạn nhập chưa đúng!");
                        else {
                            canMove = this.banco[x][y].canMoveTo(xMove, yMove, this.banco);
                            if (!canMove) System.out.println("Nước này không đi được. Hãy chọn lại!");
                            else this.moveQuanCo(x, y, xMove, yMove);
                        }
                    }  while (failXYMove);
                }
            }
        } while (failXY || !hasQuanCo || !canMove);
    }

    public void Auto_Play(int color, Random a) {
        int x, y, xMove, yMove, step;
        boolean hasQuanCo;
        boolean canMove;

        do {
            step = 0;
            x = a.nextInt(10) + 1;
            y = a.nextInt(9) + 1;

            hasQuanCo = this.banco[x][y].getParam("color") == color;
            if (hasQuanCo) {
                do {
                    xMove = a.nextInt(10) + 1;
                    yMove = a.nextInt(9) + 1;

                    canMove = this.banco[x][y].canMoveTo(xMove, yMove, this.banco);
                    if (canMove) this.moveQuanCo(x, y, xMove, yMove);
                    step++;
                }  while ( xMove < 1 || xMove > 10 || yMove < 1 || yMove > 9 || (xMove == x && yMove == y) || (!canMove && step < 10));
            }
        } while ( x < 1 || x > 10 || y < 1 || y > 9 || !hasQuanCo || step == 10);
    }
}
