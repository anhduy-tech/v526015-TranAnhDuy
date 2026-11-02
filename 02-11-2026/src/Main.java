
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so luong nhan vien: ");
        int n = Integer.parseInt(sc.nextLine());

        Nhanvien[] ds = new Nhanvien[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhap nhan vien thu " + (i + 1));
            ds[i] = new Nhanvien();
            ds[i].nhap(sc);
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            if (ds[i].getSnct() > ds[max].getSnct()) {
                max = i;
            }
        }

        System.out.println("\nNHAN VIEN CO SO NAM CONG TAC NHIEU NHAT");
        ds[max].xuat();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ds[i].tinhTienLuong() < ds[j].tinhTienLuong()) {
                    Nhanvien temp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = temp;
                }
            }
        }

        // In danh sach sau khi sap xep
        System.out.println("\nDANH SACH NHAN VIEN THEO LUONG GIAM DAN");

        for (int i = 0; i < n; i++) {
            System.out.println("\nNhan vien thu " + (i + 1));
            ds[i].xuat();
        }

        System.out.println("\nBAI 2 - DIEM 2D VA DIEM 3D");
        System.out.println("\nDIEM 2D");

        Diem2D diemA = new Diem2D(3, 4);
        Diem2D diemB = new Diem2D(6, 8);

        System.out.print("Diem A: ");
        diemA.hienThi();

        System.out.print("Diem B: ");
        diemB.hienThi();

        System.out.println(
            "Khoang cach AB: " + diemA.tinhKhoangCach(diemB)
        );

        System.out.print("Diem doi xung cua A: ");
        diemA.doiXung().hienThi();

        System.out.println("\nDIEM 3D");

        Diem3D diemC = new Diem3D(1, 2, 3);
        Diem3D diemD = new Diem3D(4, 5, 6);

        System.out.print("Diem C: ");
        diemC.hienThi();

        System.out.print("Diem D: ");
        diemD.hienThi();

        System.out.println(
            "Khoang cach CD: " + diemC.tinhKhoangCach(diemD)
        );

        System.out.print("Diem doi xung cua C: ");
        diemC.doiXung().hienThi();

        sc.close();
    }
}