import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue antrian = new Queue();   // antrian pelanggan
        Stack riwayat = new Stack();   // riwayat pelanggan yang sudah dilayani
        int pilihan = 0;

        do {
            // Tampilan menu utama
            System.out.println("\n===== SISTEM ANTRIAN PELANGGAN =====");
            System.out.println("1. Tambah Pelanggan ke Antrian (Enqueue)");
            System.out.println("2. Layani Pelanggan (Dequeue + Push ke Stack)");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Tampilkan Stack (Display)");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            // Baca sebagai teks lalu ubah ke angka agar input huruf tidak membuat error
            try {
                pilihan = Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                pilihan = 0;
            }
            System.out.println();

            switch (pilihan) {
                case 1:
                    // Cek batas 5 data sebelum meminta input
                    if (antrian.isFull()) {
                        System.out.println("Antrian penuh! Maksimal " + Queue.MAKS + " pelanggan.");
                        break;
                    }

                    String kode;
                    do {
                        System.out.print("Masukkan Kode Pelanggan: ");
                        kode = input.nextLine().trim();
                        if (kode.isEmpty()) {
                            System.out.println("Kode tidak boleh kosong.");
                        }
                    } while (kode.isEmpty());

                    String nama;
                    do {
                        System.out.print("Masukkan Nama Pelanggan: ");
                        nama = input.nextLine().trim();
                        if (nama.isEmpty()) {
                            System.out.println("Nama tidak boleh kosong.");
                        }
                    } while (nama.isEmpty());

                    // Validasi total: harus angka dan tidak negatif
                    long total = -1;
                    while (total < 0) {
                        System.out.print("Masukkan Total Belanja: ");
                        try {
                            total = Long.parseLong(input.nextLine().trim());
                            if (total < 0) {
                                System.out.println("Total tidak boleh negatif.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Total harus berupa angka.");
                            total = -1;
                        }
                    }

                    antrian.enqueue(kode, nama, total);
                    break;

                case 2:
                    // Jika stack penuh, pelanggan tidak dikeluarkan agar datanya tidak hilang
                    if (riwayat.isFull() && !antrian.isEmpty()) {
                        System.out.println("Stack penuh! Pelanggan belum bisa dilayani.");
                        break;
                    }
                    Node dilayani = antrian.dequeue();
                    if (dilayani != null) {
                        riwayat.push(dilayani);
                    }
                    break;

                case 3:
                    antrian.tampilkan();
                    break;

                case 4:
                    riwayat.display();
                    break;

                case 5:
                    System.out.println("Terima kasih. Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak valid. Pilih angka 1 sampai 5.");
            }
        } while (pilihan != 5);

        input.close();
    }
}
