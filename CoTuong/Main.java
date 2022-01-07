package com.dongchess;

import com.dongchess.base.BanCo;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    private static void PlayGame(int mode, Scanner sc) {
        BanCo banco = new BanCo();
        banco.taoBanCo();
        banco.inBanCo();
        int dem = 0;
        int step = 1;

        System.out.println((mode == 1 ? "Quân trắng" : mode == 2 ? "Bạn" : "Máy trắng") + " đi trước!");
        if (mode == 3) banco.Auto_Play(1);
        else banco.Player_Play(1);

        while(banco.checkKing()) {
            step++;
            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");
            System.out.println("Nước đi thứ: " + step);
            if( step % 2 == 0 ) {
                System.out.println("Đến lượt " + (mode == 1 ? "quân đen!" : mode == 2 ? "máy!" : "máy đen!"));
                if (mode == 1) banco.Player_Play(2);
                else {
//                    dem = sc.nextInt();
                    banco.Auto_Play(2);
                }
            }
            else {
                System.out.println("Đến lượt " + (mode == 1 ? "quân trắng!" : mode == 2 ? "bạn!" : "máy trắng!"));
                if (mode == 3) {
//                    dem = sc.nextInt();
                    banco.Auto_Play(1);
                }
                else banco.Player_Play(1);
            }
        }
        System.out.println("----------------------End game-----------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mode;

        System.out.println("Chọn chế độ chơi: ");
        do {
            System.out.print("1. người vs người            2. người vs máy           3. máy vs máy     :   ");
            mode = sc.nextInt();
        } while (mode > 3);

        PlayGame(mode, sc);
    }
}
