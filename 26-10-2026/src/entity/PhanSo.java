package entity;

public class PhanSo {
    private int tuSo;
    private int mauSo;

    // Constructor mặc định
    public PhanSo() {
        this.tuSo = 0;
        this.mauSo = 1;
    }

    // Constructor có đối
    public PhanSo(int tuSo, int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mẫu số không được bằng 0");
        }
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        rutGon();
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
        rutGon();
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mẫu số không được bằng 0");
        }
        this.mauSo = mauSo;
        rutGon();
    }

    @Override
    public String toString() {
        if (mauSo == 1) {
            return String.valueOf(tuSo);
        }
        return tuSo + "/" + mauSo;
    }

    // Tìm UCLN
    private int ucln(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public void rutGon() {
        if (mauSo < 0) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
        int u = ucln(tuSo, mauSo);
        tuSo /= u;
        mauSo /= u;
    }

    public PhanSo cong(PhanSo ps) {
        int tu = this.tuSo * ps.mauSo + ps.tuSo * this.mauSo;
        int mau = this.mauSo * ps.mauSo;
        return new PhanSo(tu, mau);
    }

    public PhanSo tru(PhanSo ps) {
        int tu = this.tuSo * ps.mauSo - ps.tuSo * this.mauSo;
        int mau = this.mauSo * ps.mauSo;
        return new PhanSo(tu, mau);
    }

    public PhanSo nhan(PhanSo ps) {
        return new PhanSo(this.tuSo * ps.tuSo, this.mauSo * ps.mauSo);
    }

    public PhanSo chia(PhanSo ps) {
        if (ps.tuSo == 0) {
            throw new ArithmeticException("Không thể chia cho phân số có tử số = 0");
        }
        return new PhanSo(this.tuSo * ps.mauSo, this.mauSo * ps.tuSo);
    }

    public int soSanh(PhanSo ps) {
        long left  = (long) this.tuSo * ps.mauSo;
        long right = (long) ps.tuSo * this.mauSo;
        return Long.compare(left, right);
    }

    public boolean laSoNguyen() {
        return mauSo == 1;
    }
}