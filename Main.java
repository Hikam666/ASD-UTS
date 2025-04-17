import java.util.Scanner;

public class Main {
    static Penilaian[] data = new Penilaian[5];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        isiData();
        int pilihan;

        do {
            System.out.println("\n=== MENU SIAKAD NILAI ===");

            System.out.println("1. Tampilkan Daftar Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mata Kuliah");
            System.out.println("3. Tampilkan Nilai Mahasiswa");
            System.out.println("4. Urutkan Berdasarkan Nilai Akhir");
            System.out.println("5. Cari Mahasiswa berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt(); sc.nextLine();

            switch (pilihan) {
                case 1 -> tampilkanDaftarMahasiswa();
                case 2 -> tampilkanDaftarMataKuliah();
                case 3 -> tampilkanNilai();
                case 4 -> urutkanNilaiAkhir();
                case 5 -> cariMahasiswa();
                case 0 -> System.out.println("Terima kasih telah menggunakan SIAKAD!");
                default -> System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }

    static void isiData() {
        Mahasiswa m1 = new Mahasiswa("Ali Rahman", "22001", "Informatika");
        Mahasiswa m2 = new Mahasiswa("Budi Santoso", "22002", "Informatika");
        Mahasiswa m3 = new Mahasiswa("Citra Dewi", "22003", "Informatika");

        MataKuliah mk1 = new MataKuliah("MK001", "Struktur Data", 3);
        MataKuliah mk2 = new MataKuliah("MK002", "Basis Data", 3);
        MataKuliah mk3 = new MataKuliah("MK003", "Desain Web", 2);

        data[0] = new Penilaian(m1, mk1, 80, 85, 90);
        data[1] = new Penilaian(m1, mk2, 60, 75, 70);
        data[2] = new Penilaian(m2, mk1, 75, 70, 80);
        data[3] = new Penilaian(m3, mk2, 85, 90, 95);
        data[4] = new Penilaian(m3, mk3, 80, 90, 65);
    }

    static void tampilkanDaftarMahasiswa() {
        System.out.println("\nDAFTAR MAHASISWA:");
        for (Penilaian p : data) {
            p.mahasiswa.tampilMahasiswa();
        }
    }

    static void tampilkanDaftarMataKuliah() {
        System.out.println("\nDAFTAR MATA KULIAH:");
        for (Penilaian p : data) {
            p.mataKuliah.tampilMatakuliah();
        }
    }

    static void tampilkanNilai() {
        System.out.println("\nDATA NILAI MAHASISWA:");
        for (Penilaian p : data) {
            System.out.println("NIM: " + p.mahasiswa.nim +
                    " | Nama: " + p.mahasiswa.nama +
                    " | Mata Kuliah: " + p.mataKuliah.namaMK +
                    " | Nilai Akhir: " + String.format("%.2f", p.hitungNilaiAkhir()));
        }
    }

   