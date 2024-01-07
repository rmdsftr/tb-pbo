import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Database database = new Database();

        while (true) {
            System.out.println("\n=== PET GROOMING ANABUL ===");
            System.out.println("1. Input Transaksi");
            System.out.println("2. Tampilkan Semua Transaksi");
            System.out.println("3. Update Nama Pelanggan");
            System.out.println("4. Hapus Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Hewan hewan = new Hewan();
                    hewan.inputFaktur();
                    hewan.inputPelanggan();
                    hewan.inputHewan();
                    hewan.proses();
                    hewan.hitungTotalBayar();
                    hewan.inputKasir();
                    hewan.tampilkanStruk();
                    database.createPelanggan(hewan);
                    break;
                case 2:
                    System.out.println("=== SEMUA TRANSAKSI ===");
                    for (Hewan transaksi : database.getAllPelanggan()) {
                        System.out.println("Nomor faktur: " + transaksi.faktur +
                                            ", Nama pelanggan: " + transaksi.namaPelanggan +
                                           ", No. HP: " + transaksi.noHp);
                    }
                    break;
                case 3:
                    System.out.print("Masukkan nomor faktur yang ingin diupdate : ");
                    String fakturUpdate = scanner.nextLine();
                    System.out.print("Masukkan nama pelanggan yang baru : ");
                    String newName = scanner.nextLine();
                    database.updatePelanggan(fakturUpdate, newName);
                    break;
                case 4:
                    System.out.print("Masukkan nomor faktur yang ingin dihapus: ");
                    String fakturDelete = scanner.nextLine();
                    database.deletePelanggan(fakturDelete);
                    break;
                case 0:
                    System.out.println("Terima kasih! Keluar dari aplikasi.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
            }
        }
    }
}
