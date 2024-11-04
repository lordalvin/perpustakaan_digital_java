import java.util.Scanner;

/**
 * Nama: Stanislaus Katska Alvin Parulian Sitanggang
 * Kelas: CCDP-2
 * NIM: 10120249
 */

/**
 * Kelas Main yang berfungsi sebagai titik masuk untuk Sistem Manajemen Perpustakaan.
 * Kelas ini menyediakan antarmuka menu berbasis teks yang memungkinkan pengguna untuk
 * menambahkan, melihat, meminjam, dan mengembalikan buku di perpustakaan.
 */
public class Main {

    /**
     * Metode utama (main) yang menjalankan Sistem Manajemen Perpustakaan.
     * Metode ini menampilkan menu untuk pengguna dan memproses input pengguna
     * untuk melakukan operasi seperti menambah, melihat, meminjam, dan
     * mengembalikan buku.
     *
     * @param args argumen baris perintah (tidak digunakan dalam program ini)
     * @throws java.util.InputMismatchException jika pengguna memasukkan input non-integer saat memilih opsi menu
     * @throws IllegalStateException jika terjadi masalah saat menutup scanner
     */
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Perulangan tak hingga untuk terus menampilkan menu hingga pengguna memilih keluar
        while (true) {
            System.out.println("\n===== Menu Perpustakaan =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Buku");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                scanner.nextLine(); // Mengonsumsi input yang salah
                continue;
            }
            scanner.nextLine(); // Mengonsumsi karakter newline

            switch (choice) {
                case 1:
                    // Menambahkan buku baru ke perpustakaan
                    System.out.print("Masukkan judul buku: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan penulis buku: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Buku berhasil ditambahkan.");
                    break;
                case 2:
                    // Menampilkan daftar buku di perpustakaan
                    library.showBooks();
                    break;
                case 3:
                    // Meminjam buku dari perpustakaan
                    System.out.print("Masukkan judul buku yang ingin dipinjam: ");
                    title = scanner.nextLine();
                    library.borrowBook(title);
                    break;
                case 4:
                    // Mengembalikan buku ke perpustakaan
                    System.out.print("Masukkan judul buku yang ingin dikembalikan: ");
                    title = scanner.nextLine();
                    library.returnBook(title);
                    break;
                case 5:
                    // Keluar dari program
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    scanner.close();
                    return; // Mengakhiri program
                default:
                    // Menangani pilihan menu yang tidak valid
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
