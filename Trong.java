package viet_lai_cotuong;

class Trong extends QuanCo {
    int sl;
    int kh = 0;
    int ms;
    int point = 0;

    @Override
    boolean canMoveTo(int x2, int y2) {
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