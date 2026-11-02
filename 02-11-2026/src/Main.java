
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

        sc.close();
    }
}