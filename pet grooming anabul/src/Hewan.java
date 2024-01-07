import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Hewan implements Transaksi{

    Date hariSekarang = new Date();
    SimpleDateFormat tanggal = new SimpleDateFormat("E, dd/MM/yyy");
    SimpleDateFormat waktu = new SimpleDateFormat("HH:mm:ss zzz");

    public String faktur;
    public String namaPelanggan;
    public String noHp;
    public int jumlahHewan=0;
    public String[] jenisHewan;
    public int[] nomorHewan;
    public String[] jenisLayanan;
    public int[] nomorLayanan;
    public int[] harga;
    public int totalBayar=0;
    public String namaKasir;

    public Hewan(){
    }

    public Hewan(String faktur, String namaPelanggan, String noHp){
        this.faktur = faktur;
        this.namaPelanggan = namaPelanggan;
        this.noHp = noHp;
    }

    @Override
    public void inputFaktur(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nMasukkan nomor faktur : ");
        faktur = scanner.nextLine();
    }

    @Override
    public void inputPelanggan(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nMasukkan nama pelanggan : ");
        namaPelanggan = scanner.nextLine();
        System.out.print("\nMasukkan nomor HP pelanggan : ");
        noHp = scanner.nextLine();
    }

    @Override
    public void inputHewan(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nMasukkan jumlah hewan : ");
        jumlahHewan = scanner.nextInt();

        jenisHewan = new String[jumlahHewan];
        nomorHewan = new int[jumlahHewan];
        jenisLayanan = new String[jumlahHewan];
        nomorLayanan = new int[jumlahHewan];
        harga = new int[jumlahHewan];

        scanner.nextLine();
    }

    public void proses() {
        Scanner scanner = new Scanner(System.in);
    
        for (int a = 0; a < jumlahHewan; a++) {
            try {
                System.out.println("\n1. Kucing");
                System.out.println("2. Anjing");
                System.out.print("Pilih jenis hewan : ");
                nomorHewan[a] = scanner.nextInt();
    
                if (nomorHewan[a] == 1) {
                    jenisHewan[a] = "Kucing";
                } else if (nomorHewan[a] == 2) {
                    jenisHewan[a] = "Anjing";
                } else {
                    throw new IllegalArgumentException("Pilihan jenis hewan tidak valid");
                }
    
                System.out.println("\n1. Basic grooming");
                System.out.println("2. Full grooming");
                System.out.print("Masukkan jenis layanan : ");
                nomorLayanan[a] = scanner.nextInt();
    
                if (nomorLayanan[a] == 1) {
                    jenisLayanan[a] = "Basic grooming";
                } else if (nomorLayanan[a] == 2) {
                    jenisLayanan[a] = "Full grooming";
                } else {
                    throw new IllegalArgumentException("Pilihan jenis layanan tidak valid");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Masukkan harus berupa angka.");
                scanner.nextLine(); // Membersihkan buffer
                a--; // Mengulang iterasi untuk input yang gagal
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine(); // Membersihkan buffer
                a--; // Mengulang iterasi untuk input yang gagal
            }
        }
    }
    

    @Override
    public void hitungTotalBayar(){
        for (int a=0; a<jumlahHewan; a++){
            if (nomorHewan[a] ==1){
                Kucing kcg = new Kucing();
                harga[a] = kcg.hitungBiaya(nomorLayanan[a]);
            } else if (nomorHewan[a] ==2){
                Anjing ajg = new Anjing();
                harga[a] = ajg.hitungBiaya(nomorLayanan[a]);
            }
            totalBayar += harga[a];
        }
        System.out.println("\nTotal bayar : " + totalBayar);
    }

    @Override
    public void inputKasir(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nMasukkan nama kasir : ");
        namaKasir = scanner.nextLine();
    }

    @Override
    public void tampilkanStruk(){
        System.out.println();
        System.out.println("                  PET GROOMING ANABUL                    ");
        System.out.println("---------------------------------------------------------");
        System.out.println("Tanggal\t : " + tanggal.format(hariSekarang));
        System.out.println("Waktu\t : " + waktu.format(hariSekarang));
        System.out.println("=========================================================");
        System.out.println("                     DATA PELANGGAN                      ");
        System.out.println("---------------------------------------------------------");
        System.out.println("Nomor faktur\t : " + faktur);
        System.out.println("---------------------------------------------------------");
        System.out.println("Nama Pelanggan\t : " + namaPelanggan.toUpperCase());
        System.out.println("Nomor HP\t : " + noHp);
        System.out.println("=========================================================");
        System.out.println("                  DATA HEWAN PELANGGAN                   ");
        System.out.println("---------------------------------------------------------");
        System.out.println("Jumlah hewan\t : " + jumlahHewan);
        for (int a=0; a<jumlahHewan; a++){
            System.out.println("Jenis hewan\t : " + jenisHewan[a].toUpperCase());
            System.out.println("Jenis layanan\t : " + jenisLayanan[a].toUpperCase());
            System.out.println("Harga layanan\t : " + harga[a]);
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("TOTAL BAYAR\t : " + totalBayar);
        System.out.println("=========================================================");
        System.out.println("Kasir\t\t : " + namaKasir.toUpperCase());
    }
}
