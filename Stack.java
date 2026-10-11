// Class Stack: riwayat pelanggan terlayani dengan prinsip LIFO (masuk terakhir, keluar pertama)
public class Stack {
    private Node top;  // node paling atas tumpukan
    private int size;  // jumlah data dalam stack
    public static final int MAKS = 5; // batas maksimal data

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return size >= MAKS;
    }

    // Push: menaruh data pelanggan di puncak tumpukan
    public boolean push(Node data) {
        // Validasi: jumlah data tidak boleh lebih dari 5
        if (isFull()) {
            System.out.println("Stack penuh! Maksimal " + MAKS + " data.");
            return false;
        }

        // Buat node baru agar tidak terikat dengan node dari antrian
        Node baru = new Node(data.kode, data.nama, data.total);
        baru.next = top; // node baru menunjuk ke puncak lama
        top = baru;      // node baru menjadi puncak
        size++;
        System.out.println("Data " + baru.nama + " dimasukkan ke stack (push).");
        return true;
    }

    // Display: menampilkan isi stack dari puncak ke dasar
    public void display() {
        System.out.println("Isi Stack (puncak ke dasar):");
        if (isEmpty()) {
            System.out.println("(Stack kosong)");
        }
        int no = 1;
        Node bantu = top;
        while (bantu != null) {
            System.out.println(no + ". Kode: " + bantu.kode + " | Nama: " + bantu.nama
                    + " | Total: Rp" + bantu.total);
            no++;
            bantu = bantu.next;
        }
        System.out.println("Jumlah data stack: " + size + " dari " + MAKS);
    }
}
