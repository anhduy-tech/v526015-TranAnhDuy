import entity.PhanSo;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PhanSo> danhSach = new ArrayList<>();
        danhSach.add(new PhanSo(1, 2));
        danhSach.add(new PhanSo(3, 4));
        danhSach.add(new PhanSo(5, 1));
        danhSach.add(new PhanSo(2, 3));
        danhSach.add(new PhanSo(7, 2));
        danhSach.add(new PhanSo(4, 6));
        danhSach.add(new PhanSo(-1, 3));

        System.out.println("Danh sách phân số:");
        for (PhanSo ps : danhSach) {
            System.out.print(ps + "  ");
        }
        System.out.println("\n");

        PhanSo max = danhSach.get(0);
        for (PhanSo ps : danhSach) {
            if (ps.soSanh(max) > 0) {
                max = ps;
            }
        }
        System.out.println("Phân số lớn nhất: " + max);

        PhanSo tong = new PhanSo(0, 1);
        for (PhanSo ps : danhSach) {
            tong = tong.cong(ps);
        }
        System.out.println("Tổng các phân số: " + tong);

        int dem = 0;
        for (PhanSo ps : danhSach) {
            if (!ps.laSoNguyen()) {
                dem++;
            }
        }
        System.out.println("Số phân số không phải số nguyên: " + dem);
    }
}