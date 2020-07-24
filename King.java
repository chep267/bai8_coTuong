package dongcode.viet_lai_cotuong;

import static java.lang.Math.abs;

class King extends QuanCo {

    int sl = 1;
    int kh = 1;
    int ms;
    int point = 1000000;

    @Override
    boolean canMoveTo(int x2, int y2) {
        if( (y2 < 4)   ||   (y2 > 6) ) {
            return false;
        }
        if( (x2 > 3) && (x2 < 8) ) {
            return false;
        }
        //Vua trang di:
        if(getMauSac() == 1) {
            //di ngang:
            if(x == x2   &&   abs(y-y2) == 1) {
                return true;
            }
            //di doc:
            if (y == y2   &&    abs(x-x2) == 1) {
                return true;
            }
            //di cheo:
            if( ( (x==1 && y==4) || (x==3 && y==4)  || (x==1 && y==6) || (x==3 && y==6) ) && (x2==2 && y2==5) ) {
                return true;
            }
            if( (x==2 && y==5)   &&   ( (x2==1 && y2==4) || (x2==3 && y2==4)  || (x2==1 && y2==6) || (x2==3 && y2==6) ) ) {
                return true;
            }
        }
        //Vua den di:
        else if(getMauSac() == 2 ) {
            //di ngang:
            if((x == x2) && (abs(y-y2) == 1)) {
                return true;
            }
            //di doc:
            if ((y == y2) && (abs(x-x2) == 1)) {
                return true;
            }
            //di cheo:
            if( ( (x==10 && y==4) || (x==8 && y==4)  || (x==10 && y==6) || (x==8 && y==6))   &&   (x2==9 && y2==5) ) {
                return true;
            }
            if( (x==9 && y==5)   &&   ((x2==10 && y2==4) || (x2==8 && y2==4)  || (x2==10 && y2==6) || (x2==8 && y2==6)) ) {
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