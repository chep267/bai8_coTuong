package dongcode.viet_lai_cotuong;

class Phao extends QuanCo {

    int sl = 2;
    int kh = 5;
    int ms;
    int point = 100;

    @Override
    boolean canMoveTo(int x0, int y0) {
        return true;
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