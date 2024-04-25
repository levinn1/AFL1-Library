package AFL;

public class CD {
    private String judul;
    private int tahun;
    private Penerbit penerbit;

    public CD(String judul, int tahun, Penerbit penerbit) {
        this.judul = judul;
        this.tahun = tahun;
        this.penerbit = penerbit;
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

    public Penerbit getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(Penerbit penerbit) {
        this.penerbit = penerbit;
    }

    @Override
    public String toString() {
        return "Judul: " + judul + ", Tahun: " + tahun + ", Penerbit: " + penerbit.getNama();
    }
}


