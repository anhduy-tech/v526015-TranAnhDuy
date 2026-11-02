
import java.util.Scanner;

class Nguoi {
    protected String hoTen;
    protected int tuoi;

    public void nhap(Scanner sc) {
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        tuoi = Integer.parseInt(sc.nextLine());
    }

    public void xuat() {
        System.out.println("Ho ten: " + hoTen);
        System.out.println("Tuoi: " + tuoi);
    }
}