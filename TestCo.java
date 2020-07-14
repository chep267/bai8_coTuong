package viet_lai_cotuong;

import java.util.Scanner;

public class TestCo{
    public static void PlayGame(BanCo b, int n) throws InterruptedException {
        int m=1;
        while(m<=n){
            System.out.print("\nNuoc di thu: "+m);
            if(m==1){
                System.out.print("\nQuan Trang di truoc!");
                //Thread.sleep(2000);
                b.MayTrangdi();
            }
            else if(m%2==0){
                System.out.print("\nDen luot Quan Den!");
                //Thread.sleep(2000);
                b.MayDendi();
            }
            else{
                System.out.print("\nDen luot Quan Trang!");
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

//        System.out.print("\nXoa o vt: ");
//        int x2 = sc.nextInt(); int y2 = sc.nextInt();
//        banco.delete(banco.taoquan(x2,y2));
//        banco.in();


        System.out.print("\nNhap so nuoc di: ");
        int n = sc.nextInt();
        PlayGame(banco,n);
    }
}