// Class Queue: antrian pelanggan dengan prinsip FIFO (masuk pertama, keluar pertama)
public class Queue {
    private Node front; // node paling depan (yang akan keluar lebih dulu)
    private Node rear;  // node paling belakang (tempat data baru masuk)
    private int size;   // jumlah data dalam antrian
    public static final int MAKS = 5; // batas maksimal data

    public boolean isEmpty() {
        return front == null;
    }

    public boolean isFull() {
        return size >= MAKS;
    }

    // Enqueue: menambah pelanggan di belakang antrian
    public void enqueue(String kode, String nama, long total) {
        // Validasi: jumlah data tidak boleh lebih dari 5
        if (isFull()) {
            System.out.println("Antrian penuh! Maksimal " + MAKS + " pelanggan.");
            return;
        }

        Node baru = new Node(kode, nama, total);
        if (isEmpty()) {
            front = baru;
            rear = baru;
        } else {
            rear.next = baru; // sambungkan ke belakang
            rear = baru;
        }
        size++;
        System.out.println("Pelanggan " + nama + " masuk antrian.");
    }

    // Dequeue: mengeluarkan pelanggan terdepan, mengembalikan datanya
    public Node dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada pelanggan yang dilayani.");
            return null;
        }

        Node keluar = front;
        front = front.next;
        if (front == null) {
            rear = null; // antrian menjadi kosong
        }
        keluar.next = null; // lepaskan dari antrian
        size--;
        System.out.println("Pelanggan dilayani: " + keluar.kode + " | " + keluar.nama
                + " | Total: Rp" + keluar.total);
        return keluar;
    }

    // Menampilkan isi antrian dari depan ke belakang
    public void tampilkan() {
        System.out.println("Isi Antrian (depan ke belakang):");
        if (isEmpty()) {
            System.out.println("(Antrian kosong)");
        }
        int no = 1;
        Node bantu = front;
        while (bantu != null) {
            System.out.println(no + ". Kode: " + bantu.kode + " | Nama: " + bantu.nama
                    + " | Total: Rp" + bantu.total);
            no++;
            bantu = bantu.next;
        }
        System.out.println("Jumlah antrian: " + size + " dari " + MAKS);
    }
}
