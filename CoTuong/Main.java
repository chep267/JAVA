package com.dongchess;

import com.dongchess.base.BanCo;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    private static void PlayGame(int mode, Scanner sc) throws InterruptedException {
        BanCo banco = new BanCo();
        banco.taoBanCo();
        banco.inBanCo();
        // int dem = 0;
        int step = 1;
        Random random = new Random();

        System.out.println((mode == 1 ? "Quân trắng" : mode == 2 ? "Bạn" : "Máy trắng") + " đi trước!");
        if (mode == 3) {
            // dem = sc.nextInt();
            sleep(1500);
            banco.Auto_Play(1, random);
        }
        else banco.Player_Play(1, sc);

        while(banco.checkKing()) {
            step++;
            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");
            System.out.println("---------------------------------------------");
            System.out.println("Nước đi thứ: " + step);
            if( step % 2 == 0 ) {
                System.out.println("Đến lượt " + (mode == 1 ? "quân đen!" : mode == 2 ? "máy!" : "máy đen!"));
                if (mode == 1) banco.Player_Play(2, sc);
                else {
                    // dem = sc.nextInt();
                    sleep(1500);
                    banco.Auto_Play(2, random);
                }
            }
            else {
                System.out.println("Đến lượt " + (mode == 1 ? "quân trắng!" : mode == 2 ? "bạn!" : "máy trắng!"));
                if (mode == 3) {
                    // dem = sc.nextInt();
                    sleep(1500);
                    banco.Auto_Play(1, random);
                }
                else banco.Player_Play(1, sc);
            }
        }
        System.out.println("----------------------End game-----------------------");
    }

    public static void main(String[] args) throws InterruptedException {
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
