package viet_lai_cotuong;

import static java.lang.Math.abs;

class Tot extends QuanCo {
    int sl = 5;
    int kh = 7;
    int ms;
    int point = 10;

    @Override
    boolean canMoveTo(int x2, int y2) {
        //Tot trang di:
        if(getMauSac()==1)
        {
            if (x<=5){
                if (x2==x+1 && y2==y){
                    return true;
                }
            }
            else if (x>5){
                if (x2==x+1 && y2==y){
                    return true;
                }
                if (x2==x && abs(y-y2)==1){
                    return true;
                }
            }
        }

        //Tot den di:
        if(getMauSac()==2) {
            if (x>=6){
                if (x2==x+1 && y2==y){
                    return true;
                }
            }
            if (x<6){
                if (x2==x-1 && y2==y){
                    return true;
                }
                if (x2==x && abs(y-y2)==1){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    void moveTo(int x1, int y1) {
        x = x1;
        y = y1;
    }

    @Override
    int getSoluong() {
        return sl;
    }

    @Override
    int getKiHieu() {
        return kh;
    }

    @Override
    int getMauSac() {
        return ms;
    }

    @Override
    int getPoint() {
        return point;
    }

    @Override
    void setSoluong(int n) {
        sl = n;
    }

    @Override
    void setKiHieu(int n) {
        kh = n;
    }

    @Override
    void setMauSac(int n) {
        ms = n;
    }

    @Override
    void setPoint(int n) {
        point = n;
    }
}