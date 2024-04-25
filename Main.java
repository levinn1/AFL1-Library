package AFL;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static PrintWriter writer;
    public static ArrayList<Buku> listBuku = new ArrayList<>();
    public static ArrayList<CD> listCD = new ArrayList<>();
    public static ArrayList<Dosen> listDosen = new ArrayList<>();
    public static ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
    public static ArrayList<Pustakawan> listPustakawan = new ArrayList<>();

    static {
        listBuku.add(new Buku("Calc", 2024, new Pengarang("Kasmir")));
        listBuku.add(new Buku("Web", 2023, new Pengarang("Citra")));
        listBuku.add(new Buku("OOP", 2022, new Pengarang("Ano")));

        listCD.add(new CD("Database", 2024, new Penerbit("Tomi")));
        listCD.add(new CD("Pancasila", 2023, new Penerbit("Wendi")));
        listCD.add(new CD("GPT", 2022, new Penerbit("Tino")));

        listDosen.add(new Dosen("Levin", "0123"));
        listDosen.add(new Dosen("Apriyadi", "0234"));

        listMahasiswa.add(new Mahasiswa("Derick", "0345"));
        listMahasiswa.add(new Mahasiswa("Kemal", "0456"));

        listPustakawan.add(new Pustakawan("P1", "123"));
        listPustakawan.add(new Pustakawan("P2", "000"));

        try {
            writer = new PrintWriter("output.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n--- Perpustakaan ---");
            System.out.println("1. Login sebagai Mahasiswa");
            System.out.println("2. Login sebagai Dosen");
            System.out.println("3. Login sebagai Pustakawan");
            System.out.println("4. Exit");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                case 2:
                    loginGeneric(pilihan);
                    break;
                case 3:
                    if (loginPustakawan()) {
                        showMenu();
                    }
                    break;
                case 4:
                    System.out.println("Terima Kasih");
                    writer.println("Terima Kasih");
                    try {
                        if (writer != null) {
                            writer.flush(); // Ensure all data is flushed to the file
                            writer.close(); // Close the writer to release resources
                        }
                    } finally {
                        if (writer != null) {
                            writer.close();
                        }
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 4);
    }

    private static boolean loginPustakawan() {
        System.out.print("Masukkan Username: ");
        String nama = scanner.next();
        System.out.print("Masukkan Password: ");
        String ID = scanner.next();

        Pustakawan pustakawan = listPustakawan.stream()
            .filter(p -> p.getUsername().equals(nama) && p.getPassword().equals(ID))
            .findFirst().orElse(null);

        if (pustakawan == null) {
            System.out.println("Password atau Username salah");
            writer.println("Username atau Password salah");
            return false;
        } else {
            System.out.println("Login berhasil");
            writer.println("Login Berhasil");
            return true;
        }
    }

    private static void loginGeneric(int role) {
        System.out.print("Masukkan Nama: ");
        String nama = scanner.next();
        System.out.print("Masukkan NIM/NIK: ");
        String ID = scanner.next();

        Object user = null;
        if (role == 1) {
            user = listMahasiswa.stream()
                .filter(m -> m.getNama().equals(nama) && m.getNIM().equals(ID))
                .findFirst().orElse(null);
        } else if (role == 2) {
            user = listDosen.stream()
                .filter(d -> d.getNama().equals(nama) && d.getNIK().equals(ID))
                .findFirst().orElse(null);
        }

        if (user == null) {
            System.out.println("Nama atau NIM/NIK tidak dapat ditemukan");
            writer.println("Nama atau NIM/NIK tidak ditemukan");
            
        } else {
            showMenu();
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Menu  ---");
        System.out.println("1. Lihat data buku");
        System.out.println("2. Lihat data CD");
        System.out.println("3. Pinjam buku");
        System.out.println("4. Pinjam CD");
        System.out.println("5. Exit");
        System.out.print("Pilihan Anda: ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                tampilkanlistBuku();
                break;
            case 2:
                tampilkanlistCD();
                break;
            case 3:
                tampilkanlistBuku();
                pinjamBuku();
                break;
            case 4:
                tampilkanlistCD();
                pinjamCD();
                break;
            case 5:
                System.out.println("Terima Kasih.");
                writer.println("Terima Kasih");
                break;
            default:
                System.out.println("ERROR");
                writer.println("ERROR");
                break;
        }
    }

    private static void tampilkanlistBuku() {
        for (Buku buku : listBuku) {
            System.out.println(buku); // Assuming Buku class has a meaningful toString() method
        }
    }

    private static void tampilkanlistCD() {
        for (CD cd : listCD) {
            System.out.println(cd); // Assuming CD class has a meaningful toString() method
        }
    }

    private static void pinjamBuku(){
        System.out.print("Masukkan judul buku yang ingin dipinjam: ");
        String judul = scanner.next();
        System.out.println(judul + " berhasil dipinjam.");
        writer.println(judul + "berhasil dipinjam");
    }

    private static void pinjamCD(){
        System.out.print("Masukkan judul CD yang ingin dipinjam: ");
        String judul = scanner.next();
        System.out.println(judul + " berhasil dipinjam.");
        writer.println(judul + "berhasil dipinjam");
    }
}