package viet_lai_cotuong;

abstract class QuanCo {
    int x,y; //toa do
    int point; //Diem so

    abstract boolean canMoveTo(int x2, int y2);
    abstract void moveTo(int x2 , int y2 );

    //get:
    abstract int getSoluong();
    abstract int getKiHieu();
    abstract int getMauSac();
    abstract int getPoint();
    //set:
    abstract void setSoluong(int n);
    abstract void setKiHieu(int n);
    abstract void setMauSac(int n);
    abstract void setPoint(int n);
}










