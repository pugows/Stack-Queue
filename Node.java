// Class Node: menyimpan data satu pelanggan
public class Node {
    String kode;
    String nama;
    long total;  // total belanja pelanggan
    Node next;   // penunjuk ke node berikutnya

    // Constructor: mengisi data pelanggan
    public Node(String kode, String nama, long total) {
        this.kode = kode;
        this.nama = nama;
        this.total = total;
        this.next = null;
    }
}
