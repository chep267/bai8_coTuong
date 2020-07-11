package viet_lai_cotuong;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;


public class BanCo {
    ArrayList<QuanCo> ds = new ArrayList<QuanCo>();

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
        System.out.print("\n-----------------------------------------\n1.  |");

        for (int i=0; i<90; i++){
            if(i>0 && i%9==0){
                int n = 11-(i%10);
                System.out.print("\n-----------------------------------------\n");
                if(n<10) System.out.print(n+".  |");
                if(n==10) System.out.print(n+". |");

            }
           // System.out.print(ds.get(i).x+","+ds.get(i).y+" | ");
            System.out.print(" "+ds.get(i).getMauSac()+" |");
        }
        System.out.print("\n-----------------------------------------\n");
        System.out.print("      1   2   3   4   5   6   7   8   9   \n");
    }

    //chechViTri:
    QuanCo checkViTri(int x2, int y2){
        QuanCo c = null;
        for( int i=0; i<90; i++){
            if(ds.get(i).x == x2 && ds.get(i).y == y2){
                c = ds.get(i);
            }
        }
        return c;
    }
}