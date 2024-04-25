package AFL;

public class Buku {
    private String judul;
    private int tahun;
    private Pengarang pengarang;

    public Buku(String judul, int tahun, Pengarang pengarang) {
        this.judul = judul;
        this.tahun = tahun;
        this.pengarang = pengarang;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public Pengarang getPengarang() {
        return pengarang;
    }

    public void setPengarang(Pengarang pengarang) {
        this.pengarang = pengarang;
    }

    @Override
    public String toString() {
        return "Judul: " + judul + ", Tahun: " + tahun + ", Pengarang: " + pengarang.getNama();
    }
}
