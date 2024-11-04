/**
 * Kelas ini merepresentasikan sebuah buku.
 */
public class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    /**
     * Konstruktor untuk membuat objek Buku dengan judul dan penulis tertentu.
     *
     * @param title  Judul buku
     * @param author Penulis buku
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    /**
     * Mengambil judul buku.
     *
     * @return Judul buku
     */
    public String getTitle() {
        return title;
    }

    /**
     * Mengambil penulis buku.
     *
     * @return Penulis buku
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Mengecek apakah buku sedang dipinjam.
     *
     * @return true jika buku sedang dipinjam, false jika tidak
     */
    public boolean isBorrowed() {
        return isBorrowed;
    }

    /**
     * Meminjam buku. Jika buku sudah dipinjam, akan menampilkan pesan bahwa buku sudah dipinjam.
     *
     * @throws IllegalStateException jika buku sudah dipinjam
     */
    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
        } else {
            System.out.println("Buku sudah dipinjam.");
            throw new IllegalStateException("Buku sudah dipinjam.");
        }
    }

    /**
     * Mengembalikan buku. Jika buku belum dipinjam, akan menampilkan pesan bahwa buku belum dipinjam.
     *
     * @throws IllegalStateException jika buku belum dipinjam
     */
    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
        } else {
            System.out.println("Buku belum dipinjam.");
            throw new IllegalStateException("Buku belum dipinjam.");
        }
    }

    /**
     * Mengembalikan representasi string dari objek Buku.
     *
     * @return Representasi string dari buku, termasuk judul, penulis, dan status peminjaman
     */
    @Override
    public String toString() {
        return "Judul: " + title + ", Penulis: " + author + ", Status: " + (isBorrowed ? "Dipinjam" : "Tersedia");
    }
}
