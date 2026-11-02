
class Diem2D {
    protected double x;
    protected double y;

    public Diem2D() {
        this.x = 0;
        this.y = 0;
    }

    public Diem2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double tinhKhoangCach(Diem2D diem) {
        return Math.sqrt(
            Math.pow(x - diem.x, 2) +
            Math.pow(y - diem.y, 2)
        );
    }

    public Diem2D doiXung() {
        return new Diem2D(-x, -y);
    }

    public void hienThi() {
        System.out.println("(" + x + ", " + y + ")");
    }
}