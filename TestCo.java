package dongcode.viet_lai_cotuong;

import java.util.Scanner;

public class TestCo {

    public static void PlayGame(BanCo b, int n) throws InterruptedException {

        int m=1;

        while( m <= n ) {
            System.out.println("Nuoc di thu: " + m);
            if( m == 1 ) {
                System.out.println("Quan Trang di truoc!");
                //Thread.sleep(2000);
                b.MayTrangdi();
            }
            else if( m%2 == 0 ) {
                System.out.println("Den luot Quan Den!");
                //Thread.sleep(2000);
                b.MayDendi();
            }
            else {
                System.out.println("Den luot Quan Trang!");
                //Thread.sleep(2000);
                b.MayTrangdi();
            }
            m++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        BanCo banco = new BanCo();
        banco.taoBanCo();
        banco.in();
        //System.out.print("\n"+banco.ds);
        System.out.println("Nhap so nuoc di: ");
        int n = sc.nextInt();
        PlayGame(banco,n);
    }
}