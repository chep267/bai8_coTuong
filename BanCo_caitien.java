package viet_lai_cotuong;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;

class BanCo{
    ArrayList<QuanCo> ds = new ArrayList<QuanCo>();
    int vua =2;
    void taoBanCo(){
        int[][] bc = new int[][]{   { 4, 6, 3, 2, 1, 2, 3, 6, 4  },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0  },
                { 0, 5, 0, 0, 0, 0, 0, 5, 0  },
                { 7, 0, 7, 0, 7, 0, 7, 0, 7  },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0  },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0  },
                { 7, 0, 7, 0, 7, 0, 7, 0, 7  },
                { 0, 5, 0, 0, 0, 0, 0, 5, 0  },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0  },
                { 4, 6, 3, 2, 1, 2, 3, 6, 4  }
        };


        //Tao khung:
        int n=0; QuanCo q = new Trong();
        ds.add(q);
        for(int i=0; i<10; i++){
            for (int j=0; j<9; j++){
                if(bc[i][j]==0){
                    q = new Trong();
                    q.x = i+1; q.y = j+1;
                    q.setMauSac(0);

                }
                else if(bc[i][j]==1){
                    q = new King();
                    q.x = i+1; q.y = j+1;
                    if(i<=4) q.setMauSac(1);
                    else q.setMauSac(2);
                }
                else if(bc[i][j]==2){
                    q = new Si();
                    q.x = i+1; q.y = j+1;
                    if(i<=4) q.setMauSac(1);
                    else q.setMauSac(2);
                }
                else if(bc[i][j]==3){
                    q = new Tuong();
                    q.x = i+1; q.y = j+1;
                    if(i<=4) q.setMauSac(1);
                    else q.setMauSac(2);
                }
                else if(bc[i][j]==4){
                    q = new Xe();
                    q.x = i+1; q.y = j+1;
                    if(i<=4) q.setMauSac(1);
                    else q.setMauSac(2);
                }
                else if(bc[i][j]==5){
                    q = new Phao();
                    q.x = i+1; q.y = j+1;
                    if(i<=4) q.setMauSac(1);
                    else q.setMauSac(2);
                }
                else if(bc[i][j]==6){
                    q = new Ma();
                    q.x = i+1; q.y = j+1;
                    if(i<=4) q.setMauSac(1);
                    else q.setMauSac(2);
                }
                else if(bc[i][j]==7){
                    q = new Tot();
                    q.x = i+1; q.y = j+1;
                    if(i<=4) q.setMauSac(1);
                    else q.setMauSac(2);
                }
                ds.add(q);
            }
        }

    }





    //Co them dc quan co vao ban co khong:
    boolean canAdd(QuanCo q){
        int dem =0;
        for(int i=0; i<90; i++){
            if(q.getKiHieu()==ds.get(i).getKiHieu()){
                dem++;
            }
        }
        switch (q.getKiHieu()){
            case 1:
                if(q.getSoluong() < 1) return true;
                break;
            case 2:
                if(q.getSoluong() < 2) return true;
                break;
            case 3:
                if(q.getSoluong() < 2) return true;
                break;
            case 4:
                if(q.getSoluong() < 2) return true;
                break;
            case 5:
                if(q.getSoluong() < 2) return true;
                break;
            case 6:
                if(q.getSoluong() < 2) return true;
                break;
            case 7:
                if(q.getSoluong() < 5) return true;
                break;
        }
        return false;
    }

    //Xoa quan co:
    void delete(QuanCo q){
        q.setMauSac(0);
        q.setKiHieu(0);
    }

    //Them quan co:
    void add(QuanCo q){
        for(int i=0; i<90; i++){
            if(ds.get(i).getKiHieu()==0){
                ds.add(i,q);
            }
        }
    }

    //Tao ban:
    public void in(){
        System.out.print("\n      1   2   3   4   5   6   7   8   9   ");

        int n = 1, m=1;
        for (int i=1; i<=90; i++){
            if(i%9==1){
                System.out.print("\n---------------------------------------------\n");
                if(n<10) System.out.print(n+".  |");
                if(n==10) System.out.print(n+". |");
                n++;
            }
            System.out.print(" "+ds.get(i).getKiHieu()+","+ds.get(i).getMauSac()+" |");
            if(ds.get(i).y == 9){
                if(m<10) System.out.print("  ."+m);
                if(m==10) System.out.print(" ."+m);
                m++;
            }

        }
        System.out.print("\n---------------------------------------------\n");
        System.out.print("      1   2   3   4   5   6   7   8   9   \n");
    }

    //Tao quan trung gian:
    QuanCo taoquan(int x2, int y2){
        int n = (x2-1)*9+y2;
        QuanCo c = ds.get(n);
        return c;
    }

    //Co the di chuyen khong:
    boolean canMoveTo(int x1, int y1, int x2, int y2) {
        QuanCo c1 = taoquan(x1,y1);
        QuanCo c2 = taoquan(x2,y2);
        if(x1==x2 && y1==y2){
            return false;
        }
        if (c1.getMauSac() == c2.getMauSac()){
            return false;
        }
        else {
            int n=0;
            //Vua di:
            if (c1.getKiHieu()==1) {
                c1.canMoveTo(x2,y2);
            }
            //Si di:
            else if (c1.getKiHieu()==2){
                c1.canMoveTo(x2,y2);
            }
            //Tuong di:
            else if (c1.getKiHieu()==3) {
                //Tuong Trang di:
                if (c1.getMauSac()==1 && abs(x2-x1)==2 && abs(y2-y1)==2){
                    if (x2>5){
                        return false;
                    }
                    n = ((x1+x2)/2-1)*9 + (y1+y2)/2;
                    if (ds.get(n).getKiHieu()!=0) return false;

                    return true;
                }
                //Tuong den di:
                if (c1.getMauSac()==2 && abs(x2-x1)==2 && abs(y2-y1)==2){
                    if (x2<6){
                        return false;
                    }
                    n = ((x1+x2)/2-1)*9 + (y1+y2)/2;
                    if (ds.get(n).getKiHieu()!=0) return false;

                    return true;
                }
                return false;
            }

            //Xe di:
            else if(c1.getKiHieu()==4){
                //di ngang:
                if(x1==x2){
                    //Sang trai:
                    if(y1>y2){
                        for (int i = y1-1; i >y2; i--) {
                            n = (x1-1)*9 + i;
                            if (ds.get(n).getKiHieu()!=0) return false;
                        }
                        return true;
                    }
                    //Sang phai:
                    if(y1<y2){
                        for (int i = y1+1; i <y2; i++) {
                            n = (x1-1)*9 + i;
                            if (ds.get(n).getKiHieu()!=0) return false;
                        }
                        return true;
                    }
                }
                //di doc:
                if(y1==y2){
                    //len:
                    if(x1>x2){
                        for (int i = x1-1; i >x2; i--) {
                            n = (i-1)*9 + y1;
                            if (ds.get(n).getKiHieu()!=0) return false;
                        }
                        return true;
                    }
                    //xuong:
                    if(x1<x2){
                        for (int i = x1+1; i<x2; i++) {
                            n = (i-1)*9 + y1;
                            if (ds.get(n).getKiHieu()!=0) return false;
                        }
                        return true;
                    }
                }
                return false;
            }

            //Phao di:
            else if(c1.getKiHieu()==5){
                if (c2.getKiHieu()==0){
                    //di ngang:
                    if(x1==x2){
                        //Sang trai:
                        if(y1>y2){
                            for (int i = y1-1; i >y2; i--) {
                                n = (x1-1)*9 + i;
                                if (ds.get(n).getKiHieu()!=0) return false;
                            }
                            return true;
                        }
                        //Sang phai:
                        if(y1<y2){
                            for (int i = y1+1; i <y2; i++) {
                                n = (x1-1)*9 + i;
                                if (ds.get(n).getKiHieu()!=0) return false;
                            }
                            return true;
                        }
                    }
                    //di doc:
                    if(y1==y2){
                        //xuong:
                        if(x1>x2){
                            for (int i = x1-1; i >x2; i--) {
                                n = (i-1)*9 + y1;
                                if (ds.get(n).getKiHieu()!=0) return false;
                            }
                            return true;
                        }
                        //len:
                        if(x1<x2){
                            for (int i = x1+1; i<x2; i++) {
                                n = (i-1)*9 + y1;
                                if (ds.get(n).getKiHieu()!=0) return false;
                            }
                            return true;
                        }
                    }
                    return false;
                }
                else if(c2.getKiHieu()!=0){
                    int dem;
                    //di ngang:
                    if(x1==x2){
                        if (abs(y1-y2)==1){
                            return false;
                        }
                        if(y1>y2){
                            dem = 0;
                            for (int i = y1-1; i >y2; i--) {
                                n = (x1-1)*9 + i;
                                if (ds.get(n).getKiHieu()!=0){
                                    dem++;
                                    if(dem>1) return false;
                                }
                            }
                            if (dem==1) return true;
                        }
                        if(y1<y2){
                            dem = 0;
                            for (int i = y1+1; i <y2; i++) {
                                n = (x1-1)*9 + i;
                                if (ds.get(n).getKiHieu()!=0){
                                    dem++;
                                    if(dem>1) return false;
                                }
                            }
                            if (dem==1) return true;
                        }
                        return false;
                    }
                    //di doc:
                    if(y2==y1){
                        if (abs(x1-x2)==1){
                            return false;
                        }
                        if(x1>x2){
                            dem = 0;
                            for (int i = x1-1; i >x2; i--) {
                                n = (i-1)*9 + y1;
                                if (ds.get(n).getKiHieu()!=0){
                                    dem++;
                                    if(dem>1) return false;
                                }
                            }
                            if (dem==1) return true;
                        }
                        if(x1<x2){
                            dem = 0;
                            for (int i = x1+1; i<x2; i++) {
                                n = (i-1)*9 + y1;
                                if (ds.get(n).getKiHieu()!=0){
                                    dem++;
                                    if(dem>1) return false;
                                }
                            }
                            if (dem==1) return true;
                        }
                        return false;
                    }
                }
                return false;
            }

            //ma di:
            else if(c2.getKiHieu()==6) {
                //di 1:
                if (abs(x2 - x1) == 2 && abs(y2 - y1) == 1) {
                    QuanCo c3 = taoquan((x1+x2)/2, y1);
                    if (c3.getKiHieu()!=0){
                        return false;
                    } else return true;
                }
                //di 2:
                else if (abs(x2-x1)==1 && abs(y2-y1)==2){
                    QuanCo c3 = taoquan(x1, (y1+y2)/2);
                    if (c3.getKiHieu()!=0){
                        return false;
                    } else return true;
                }
                return false;
            }

            //Tot di:
            else if (c1.getKiHieu()==7){
                c1.canMoveTo(x2,y2);
            }
            return false;
        }
    }

    //di chuyen toi:
    void moveTo(int x1, int y1, int x2, int y2) {
        int n = (x1-1)*9+y1;
        int m = (x2-1)*9+y2;
        QuanCo c1 = taoquan(x1,y1);
        QuanCo c2 = taoquan(x2,y2);
        if(c2.getKiHieu() != 0){
            switch (c2.getKiHieu()){
                case 1:
                    System.out.print("\nAn Vua! Ket thuc Game!");
                    if (c2.getMauSac()==2){
                        System.out.println("\nBen Trang Win!");
                    }else System.out.println("\nBen Den Win!");
                    vua--;
                    break;
                case 2:
                    System.out.print("\nAn Si!");
                    break;
                case 3:
                    System.out.print("\nAn Tuong!");
                    break;
                case 4:
                    System.out.print("\nAn Xe!");
                    break;
                case 5:
                    System.out.print("\nAn Phao!");
                    break;
                case 6:
                    System.out.print("\nAn Ma!");
                    break;
                case 7:
                    System.out.print("\nAn Tot!");
                    break;
            }
        }
        ds.get(m).setMauSac(c1.getMauSac());
        ds.get(m).setKiHieu(c1.getKiHieu());
        ds.get(m).setPoint(c1.getPoint());
        ds.get(n).setMauSac(0);
        ds.get(n).setKiHieu(0);
        ds.get(n).setPoint(0);

    }
    //check king co du 2 hay khong:
    boolean checkKing(){
        int dem=0;
        for(int i=0; i<90; i++){
            if(ds.get(i).getKiHieu()==1){
                dem++;
            }
        }
        if(dem <2){
            return true;
        }
        return false;
    }

    //May choi:
    public void MayTrangdi(){
        Random a = new Random();

        int x1,y1,x2=0,y2=0; int n;
        int max, diem;
        do{
            max = diem =-1;
            do {
                x1 = a.nextInt(10)+1;
                y1 = a.nextInt(9)+1;
                n = (x1-1)*9+y1;
            } while (ds.get(n).getKiHieu() == 0 || ds.get(n).getMauSac() == 2);

            for(int i=1; i<91; i++){
                if(canMoveTo(x1,y1,ds.get(i).x,ds.get(i).y)){
                    diem = ds.get(i).getPoint();
                    if(diem>max){
                        max = diem;
                        x2 = ds.get(i).x;
                        y2= ds.get(i).y;
                    }
                }
            }
        }while (diem==-1 || x2==0 || y2==0);

        System.out.println("\nc2: " +x2+","+y2);
        System.out.println("\nmax: " +max);

        moveTo(x1,y1,x2,y2);
        System.out.println("\nMay trang di: "+ "("+x1+","+y1+")  den  "+ "("+x2+","+y2+")");
        in();
        System.out.println("\n----------------------------------------------------\n");
        if (vua<2){
            System.exit(0);
        }
    }



    public void MayDendi(){
        Random a = new Random();

        int x1,y1,x2=0,y2=0; int n;
        int max, diem;
        do{
            max = diem =-1;
            do {
                x1 = a.nextInt(10)+1;
                y1 = a.nextInt(9)+1;
                n = (x1-1)*9+y1;
            } while (ds.get(n).getKiHieu() == 0 || ds.get(n).getMauSac() == 1);

            for(int i=1; i<91; i++){
                if(canMoveTo(x1,y1,ds.get(i).x,ds.get(i).y)){
                    diem = ds.get(i).getPoint();
                    if(diem>max){
                        max = diem;
                        x2 = ds.get(i).x;
                        y2= ds.get(i).y;
                    }
                }
            }
        }while (diem==-1 || x2==0 || y2==0);

        System.out.println("\nc2: " +x2+","+y2);
        System.out.println("\nmax: " +max);

        moveTo(x1,y1,x2,y2);
        System.out.println("\nMay den di: "+ "("+x1+","+y1+")  den  "+ "("+x2+","+y2+")");
        in();
        System.out.println("\n----------------------------------------------------\n");
        if (vua<2){
            System.exit(0);
        }
    }


}
