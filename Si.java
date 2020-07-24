package dongcode.viet_lai_cotuong;

class Si extends QuanCo {

    int sl = 2;
    int kh = 2;
    int ms;
    int point = 50;

    @Override
    boolean canMoveTo(int x2, int y2) {
        //Si di:
        if( (y2 < 4) || (y2 > 6) ) {
            return false;
        }
        if( (x2 > 3) && (x2 < 8) ) {
            return false;
        }
        //Si trang di:
        if( getMauSac() == 1 ) {
            //di cheo:
            if( ( (x==1 && y==4) || (x==3 && y==4)  || (x==1 && y==6) || (x==3 && y==6) ) && (x2==2 && y2==5)){
                return true;
            }
            if( (x==2 && y==5) && ( (x2==1 && y2==4) || (x2==3 && y2==4)  || (x2==1 && y2==6) || (x2==3 && y2==6) ) ) {
                return true;
            }
        }
        //Si den di:
        else if( getMauSac() == 2) {
            //di cheo:
            if( ( (x==10 && y==4) || (x==8 && y==4)  || (x==10 && y==6) || (x==8 && y==6) ) && (x2==9 && y2==5) ) {
                return true;
            }
            if( (x==9 && y==5) && ( (x2==10 && y2==4) || (x2==8 && y2==4)  || (x2==10 && y2==6) || (x2==8 && y2==6) ) ) {
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