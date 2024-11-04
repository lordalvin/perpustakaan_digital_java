import java.util.ArrayList;

/**
 * Kelas ini merepresentasikan sebuah perpustakaan yang menyimpan dan mengelola koleksi buku.
 */
public class Library {
    private ArrayList<Book> books;

    /**
     * Konstruktor untuk membuat objek Library baru.
     */
    public Library() {
        books = new ArrayList<>();
    }

    /**
     * Menambahkan buku baru ke dalam perpustakaan.
     *
     * @param book Buku yang akan ditambahkan ke perpustakaan.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Menampilkan daftar semua buku yang ada di perpustakaan.
     * Jika tidak ada buku, akan menampilkan pesan bahwa perpustakaan kosong.
     */
    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Tidak ada buku di perpustakaan.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    /**
     * Meminjam buku berdasarkan judul yang diberikan.
     *
     * @param title Judul buku yang ingin dipinjam.
     * @throws IllegalArgumentException jika judul buku tidak ditemukan.
     */
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.borrowBook();
                return;
            }
        }
        System.out.println("Buku tidak ditemukan.");
    }

    /**
     * Mengembalikan buku berdasarkan judul yang diberikan.
     *
     * @param title Judul buku yang ingin dikembalikan.
     * @throws IllegalArgumentException jika judul buku tidak ditemukan.
     */
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Buku tidak ditemukan.");
    }
}
