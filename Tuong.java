package viet_lai_cotuong;

import static java.lang.Math.abs;

class Tuong extends QuanCo {
    int sl = 2;
    int kh = 3;
    int ms;
    int point = 50;

    @Override
    boolean canMoveTo(int x2, int y2) {
        //Tuong Trang di:
        if (getMauSac()==1 && abs(x2-x)==2 && abs(y2-y)==2){
            if (x2<=5){
                return true;
            }
        }
        //Tuong den di:
        if (getMauSac()==2 && abs(x2-x)==2 && abs(y2-y)==2){
            if (x2>=6){
                return true;
            }
        }
        return false;
    }
    @Override
    void moveTo(int x2, int y2) {
        x = x2;
        y = y2;
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