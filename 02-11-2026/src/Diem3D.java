class Diem3D extends Diem2D {
    private double z;

    public Diem3D() {
        super();
        this.z = 0;
    }

    public Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double tinhKhoangCach(Diem3D diem) {
        return Math.sqrt(
            Math.pow(x - diem.x, 2) +
            Math.pow(y - diem.y, 2) +
            Math.pow(z - diem.z, 2)
        );
    }

    @Override
    public Diem3D doiXung() {
        return new Diem3D(-x, -y, -z);
    }

    @Override
    public void hienThi() {
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }
}