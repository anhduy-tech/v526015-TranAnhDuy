import java.util.Scanner;

public class App {

    public void bai1() {
        System.out.println("Bai tap 1");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so nguyen n: ");
        int n = scanner.nextInt();
        System.out.println("Nhap mang so phan tu n");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap phan tu thu " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        System.out.println("Tong cac phan tu trong mang la: " + sum);
    }

    public void bai2() {
        System.out.println("Bai tap 2");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap mang thu 1:");
        String[] arr1 = scanner.nextLine().split(" ");
        System.out.println("Nhap mang thu 2:");
        String[] arr2 = scanner.nextLine().split(" ");
        System.out.println("Mang tong la: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(Integer.parseInt(arr1[i]) + Integer.parseInt(arr2[i]) + " ");
        }
        System.out.println();
    }

    public void bai3() {
        System.out.println("Bai tap 3");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap mang :");
        String[] arr = scanner.nextLine().split(" ");
        int cout = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            cout++;
            sum += Integer.parseInt(arr[i]);
        }
        System.out.println("So phan tu la: " + cout);
        System.out.println("Tong cac phan tu la: " + sum);
    }

    //Bai tap 1 slide 3
    public void bai4() {
        System.out.println("Bai tap 4 (Bai tap 1 - Duong thang)");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap x, y cua diem A: ");
        Diem a = new Diem(scanner.nextDouble(), scanner.nextDouble());
        System.out.print("Nhap x, y cua diem B: ");
        Diem b = new Diem(scanner.nextDouble(), scanner.nextDouble());

        DuongThang d = new DuongThang(a, b);
        System.out.println("Do dai duong thang AB = " + d.doDai());
    }

    //Bai tap 2 slide 3
    public void bai5() {
        System.out.println("Bai tap 5 (Bai tap 2 - Cac hinh)");

        TamGiac tg1 = new TamGiac(new Diem(0, 0), new Diem(4, 0), new Diem(0, 3));
        TamGiac tg2 = new TamGiac(new Diem(1, 1), new Diem(5, 1), new Diem(3, 4));

        ChuNhat cn1 = new ChuNhat(3, 4);
        ChuNhat cn2 = new ChuNhat(5, 7);

        HinhTron ht1 = new HinhTron(new Diem(0, 0), 2);
        HinhTron ht2 = new HinhTron(new Diem(1, 2), 5);

        System.out.println("Tam giac 1: chu vi = " + tg1.chuVi() + ", dien tich = " + tg1.dienTich());
        System.out.println("Tam giac 2: chu vi = " + tg2.chuVi() + ", dien tich = " + tg2.dienTich());
        System.out.println("Chu nhat 1: chu vi = " + cn1.chuVi() + ", dien tich = " + cn1.dienTich());
        System.out.println("Chu nhat 2: chu vi = " + cn2.chuVi() + ", dien tich = " + cn2.dienTich());
        System.out.println("Hinh tron 1: chu vi = " + ht1.chuVi() + ", dien tich = " + ht1.dienTich());
        System.out.println("Hinh tron 2: chu vi = " + ht2.chuVi() + ", dien tich = " + ht2.dienTich());
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        app.bai1();
        app.bai2();
        app.bai3();
        app.bai4();
        app.bai5();
    }
}

class Diem {
    private double x;
    private double y;

    public Diem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    public double khoangCach(Diem d) {
        double dx = x - d.x;
        double dy = y - d.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

class DuongThang {
    private Diem A;
    private Diem B;

    public DuongThang(Diem A, Diem B) {
        this.A = A;
        this.B = B;
    }

    public Diem getA() { return A; }
    public Diem getB() { return B; }

    public double doDai() {
        return A.khoangCach(B);
    }
}

class TamGiac {
    private Diem A, B, C;

    public TamGiac(Diem A, Diem B, Diem C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public double chuVi() {
        return A.khoangCach(B) + B.khoangCach(C) + C.khoangCach(A);
    }

    public double dienTich() {
        double a = B.khoangCach(C);
        double b = C.khoangCach(A);
        double c = A.khoangCach(B);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

class ChuNhat {
    private double dai;
    private double rong;

    public ChuNhat(double dai, double rong) {
        this.dai = dai;
        this.rong = rong;
    }

    public double chuVi() {
        return 2 * (dai + rong);
    }

    public double dienTich() {
        return dai * rong;
    }
}

class HinhTron {
    private Diem O;
    private double banKinh;

    public HinhTron(Diem O, double banKinh) {
        this.O = O;
        this.banKinh = banKinh;
    }

    public double chuVi() {
        return 2 * Math.PI * banKinh;
    }

    public double dienTich() {
        return Math.PI * banKinh * banKinh;
    }
}