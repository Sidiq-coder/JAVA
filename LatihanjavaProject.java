// Latihan dan Contoh Project Java
// File ini berisi berbagai latihan untuk mempraktikkan konsep yang telah dipelajari

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

// ========== PROJECT 1: PROGRAM KASIR SEDERHANA ==========

class Produk {
    private String nama;
    private double harga;
    private int stok;
    
    public Produk(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }
    
    // Getter methods
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
    
    // Method untuk mengurangi stok
    public boolean kurangiStok(int jumlah) {
        if (stok >= jumlah) {
            stok -= jumlah;
            return true;
        }
        return false;
    }
    
    public void tampilkanInfo() {
        System.out.printf("%-15s | Rp %,10.0f | Stok: %3d%n", nama, harga, stok);
    }
}

class ItemBelanja {
    private Produk produk;
    private int jumlah;
    
    public ItemBelanja(Produk produk, int jumlah) {
        this.produk = produk;
        this.jumlah = jumlah;
    }
    
    public double getSubtotal() {
        return produk.getHarga() * jumlah;
    }
    
    public void tampilkanItem() {
        System.out.printf("%-15s | %3d x Rp %,8.0f = Rp %,10.0f%n", 
                         produk.getNama(), jumlah, produk.getHarga(), getSubtotal());
    }
    
    public Produk getProduk() { return produk; }
    public int getJumlah() { return jumlah; }
}

class KasirSederhana {
    private Produk[] daftarProduk;
    private ArrayList<ItemBelanja> keranjang;
    private Scanner input;
    
    public KasirSederhana() {
        // Inisialisasi produk
        daftarProduk = new Produk[] {
            new Produk("Beras 5kg", 65000, 50),
            new Produk("Minyak Goreng", 25000, 30),
            new Produk("Gula 1kg", 15000, 40),
            new Produk("Telur 1kg", 28000, 25),
            new Produk("Susu UHT", 12000, 60),
            new Produk("Roti Tawar", 8000, 35),
            new Produk("Sabun Mandi", 5000, 45),
            new Produk("Pasta Gigi", 15000, 20)
        };
        
        keranjang = new ArrayList<>();
        input = new Scanner(System.in);
    }
    
    public void tampilkanDaftarProduk() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    DAFTAR PRODUK");
        System.out.println("=".repeat(60));
        System.out.printf("%-3s | %-15s | %-12s | %-8s%n", "No", "Nama Produk", "Harga", "Stok");
        System.out.println("-".repeat(60));
        
        for (int i = 0; i < daftarProduk.length; i++) {
            System.out.printf("%2d. | ", (i + 1));
            daftarProduk[i].tampilkanInfo();
        }
        System.out.println("=".repeat(60));
    }
    
    public void tambahKeKeranjang() {
        tampilkanDaftarProduk();
        System.out.print("Pilih produk (1-" + daftarProduk.length + "): ");
        int pilihan = input.nextInt();
        
        if (pilihan >= 1 && pilihan <= daftarProduk.length) {
            Produk produkDipilih = daftarProduk[pilihan - 1];
            System.out.print("Masukkan jumlah: ");
            int jumlah = input.nextInt();
            
            if (produkDipilih.kurangiStok(jumlah)) {
                keranjang.add(new ItemBelanja(produkDipilih, jumlah));
                System.out.println("Produk berhasil ditambahkan ke keranjang!");
            } else {
                System.out.println("Stok tidak mencukupi!");
            }
        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }
    
    public void tampilkanKeranjang() {
        if (keranjang.isEmpty()) {
            System.out.println("Keranjang kosong!");
            return;
        }
        
        System.out.println("\n" + "=".repeat(70));
        System.out.println("                        KERANJANG BELANJA");
        System.out.println("=".repeat(70));
        
        double total = 0;
        for (ItemBelanja item : keranjang) {
            item.tampilkanItem();
            total += item.getSubtotal();
        }
        
        System.out.println("-".repeat(70));
        System.out.printf("%-40s Rp %,10.0f%n", "TOTAL:", total);
        System.out.println("=".repeat(70));
    }
    
    public void checkout() {
        if (keranjang.isEmpty()) {
            System.out.println("Keranjang kosong! Tidak ada yang bisa di-checkout.");
            return;
        }
        
        tampilkanKeranjang();
        
        double total = 0;
        for (ItemBelanja item : keranjang) {
            total += item.getSubtotal();
        }
        
        System.out.print("Masukkan jumlah pembayaran: Rp ");
        double bayar = input.nextDouble();
        
        if (bayar >= total) {
            double kembalian = bayar - total;
            System.out.println("\n" + "=".repeat(50));
            System.out.println("                STRUK BELANJA");
            System.out.println("=".repeat(50));
            System.out.printf("Total Belanja  : Rp %,12.0f%n", total);
            System.out.printf("Bayar          : Rp %,12.0f%n", bayar);
            System.out.printf("Kembalian      : Rp %,12.0f%n", kembalian);
            System.out.println("=".repeat(50));
            System.out.println("    Terima kasih telah berbelanja!");
            System.out.println("=".repeat(50));
            
            keranjang.clear();
        } else {
            System.out.println("Pembayaran kurang! Transaksi dibatalkan.");
        }
    }
    
    public void jalankan() {
        System.out.println("=== SELAMAT DATANG DI KASIR SEDERHANA ===");
        
        boolean running = true;
        while (running) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Lihat Daftar Produk");
            System.out.println("2. Tambah ke Keranjang");
            System.out.println("3. Lihat Keranjang");
            System.out.println("4. Checkout");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            
            int pilihan = input.nextInt();
            
            switch (pilihan) {
                case 1:
                    tampilkanDaftarProduk();
                    break;
                case 2:
                    tambahKeKeranjang();
                    break;
                case 3:
                    tampilkanKeranjang();
                    break;
                case 4:
                    checkout();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan kasir sederhana!");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
    }
}

// ========== PROJECT 2: GAME TEBAK ANGKA ==========

class GameTebakAngka {
    private int angkaRahasia;
    private int kesempatan;
    private Scanner input;
    private Random random;
    
    public GameTebakAngka() {
        random = new Random();
        input = new Scanner(System.in);
    }
    
    public void mulaiGame() {
        System.out.println("=== GAME TEBAK ANGKA ===");
        System.out.println("Tebak angka antara 1-100!");
        
        boolean mainLagi = true;
        while (mainLagi) {
            System.out.println("\nPilih tingkat kesulitan:");
            System.out.println("1. Mudah (10 kesempatan)");
            System.out.println("2. Sedang (7 kesempatan)");
            System.out.println("3. Sulit (5 kesempatan)");
            System.out.print("Pilih (1-3): ");
            
            int tingkat = input.nextInt();
            
            switch (tingkat) {
                case 1:
                    kesempatan = 10;
                    break;
                case 2:
                    kesempatan = 7;
                    break;
                case 3:
                    kesempatan = 5;
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Menggunakan tingkat sedang.");
                    kesempatan = 7;
                    break;
            }
            
            angkaRahasia = random.nextInt(100) + 1;
            boolean berhasil = false;
            
            System.out.println("\nAnda memiliki " + kesempatan + " kesempatan!");
            
            for (int i = kesempatan; i > 0; i--) {
                System.out.print("Tebakan Anda (sisa " + i + " kesempatan): ");
                int tebakan = input.nextInt();
                
                if (tebakan == angkaRahasia) {
                    System.out.println("🎉 SELAMAT! Anda berhasil menebak angka " + angkaRahasia + "!");
                    System.out.println("Anda menebak dengan benar dalam " + (kesempatan - i + 1) + " percobaan!");
                    berhasil = true;
                    break;
                } else if (tebakan < angkaRahasia) {
                    System.out.println("📈 Terlalu kecil! Coba angka yang lebih besar.");
                } else {
                    System.out.println("📉 Terlalu besar! Coba angka yang lebih kecil.");
                }
                
                // Berikan hint tambahan
                if (i > 1) {
                    int selisih = Math.abs(tebakan - angkaRahasia);
                    if (selisih <= 5) {
                        System.out.println("🔥 Sangat dekat!");
                    } else if (selisih <= 15) {
                        System.out.println("🌡️ Dekat!");
                    } else {
                        System.out.println("❄️ Masih jauh!");
                    }
                }
            }
            
            if (!berhasil) {
                System.out.println("😔 Kesempatan habis! Angka yang benar adalah: " + angkaRahasia);
            }
            
            System.out.print("\nMain lagi? (y/n): ");
            char jawab = input.next().charAt(0);
            mainLagi = (jawab == 'y' || jawab == 'Y');
        }
        
        System.out.println("Terima kasih telah bermain!");
    }
}

// ========== PROJECT 3: KALKULATOR SCIENTIFIC ==========

class KalkulatorScientific {
    private Scanner input;
    
    public KalkulatorScientific() {
        input = new Scanner(System.in);
    }
    
    public double tambah(double a, double b) { return a + b; }
    public double kurang(double a, double b) { return a - b; }
    public double kali(double a, double b) { return a * b; }
    public double bagi(double a, double b) { 
        if (b != 0) return a / b;
        else throw new ArithmeticException("Pembagian dengan nol!");
    }
    public double pangkat(double a, double b) { return Math.pow(a, b); }
    public double akarKuadrat(double a) { 
        if (a >= 0) return Math.sqrt(a);
        else throw new ArithmeticException("Akar kuadrat bilangan negatif!");
    }
    public double sin(double a) { return Math.sin(Math.toRadians(a)); }
    public double cos(double a) { return Math.cos(Math.toRadians(a)); }
    public double tan(double a) { return Math.tan(Math.toRadians(a)); }
    public double log(double a) { 
        if (a > 0) return Math.log10(a);
        else throw new ArithmeticException("Logaritma bilangan non-positif!");
    }
    public double ln(double a) { 
        if (a > 0) return Math.log(a);
        else throw new ArithmeticException("Logaritma natural bilangan non-positif!");
    }
    
    public void tampilkanMenu() {
        System.out.println("\n=== KALKULATOR SCIENTIFIC ===");
        System.out.println("1. Penjumlahan (+)");
        System.out.println("2. Pengurangan (-)");
        System.out.println("3. Perkalian (×)");
        System.out.println("4. Pembagian (÷)");
        System.out.println("5. Pangkat (^)");
        System.out.println("6. Akar Kuadrat (√)");
        System.out.println("7. Sinus (sin)");
        System.out.println("8. Cosinus (cos)");
        System.out.println("9. Tangen (tan)");
        System.out.println("10. Logaritma 10 (log)");
        System.out.println("11. Logaritma natural (ln)");
        System.out.println("12. Keluar");
    }
    
    public void jalankan() {
        boolean running = true;
        
        while (running) {
            tampilkanMenu();
            System.out.print("Pilih operasi (1-12): ");
            int pilihan = input.nextInt();
            
            try {
                switch (pilihan) {
                    case 1: case 2: case 3: case 4: case 5:
                        System.out.print("Masukkan angka pertama: ");
                        double a = input.nextDouble();
                        System.out.print("Masukkan angka kedua: ");
                        double b = input.nextDouble();
                        double hasil = 0;
                        
                        switch (pilihan) {
                            case 1: hasil = tambah(a, b); System.out.printf("%.2f + %.2f = %.6f%n", a, b, hasil); break;
                            case 2: hasil = kurang(a, b); System.out.printf("%.2f - %.2f = %.6f%n", a, b, hasil); break;
                            case 3: hasil = kali(a, b); System.out.printf("%.2f × %.2f = %.6f%n", a, b, hasil); break;
                            case 4: hasil = bagi(a, b); System.out.printf("%.2f ÷ %.2f = %.6f%n", a, b, hasil); break;
                            case 5: hasil = pangkat(a, b); System.out.printf("%.2f ^ %.2f = %.6f%n", a, b, hasil); break;
                        }
                        break;
                        
                    case 6:
                        System.out.print("Masukkan angka: ");
                        double angka = input.nextDouble();
                        double hasilAkar = akarKuadrat(angka);
                        System.out.printf("√%.2f = %.6f%n", angka, hasilAkar);
                        break;
                        
                    case 7: case 8: case 9:
                        System.out.print("Masukkan sudut (derajat): ");
                        double sudut = input.nextDouble();
                        double hasilTrigon = 0;
                        
                        switch (pilihan) {
                            case 7: hasilTrigon = sin(sudut); System.out.printf("sin(%.2f°) = %.6f%n", sudut, hasilTrigon); break;
                            case 8: hasilTrigon = cos(sudut); System.out.printf("cos(%.2f°) = %.6f%n", sudut, hasilTrigon); break;
                            case 9: hasilTrigon = tan(sudut); System.out.printf("tan(%.2f°) = %.6f%n", sudut, hasilTrigon); break;
                        }
                        break;
                        
                    case 10: case 11:
                        System.out.print("Masukkan angka: ");
                        double angkaLog = input.nextDouble();
                        double hasilLog = 0;
                        
                        switch (pilihan) {
                            case 10: hasilLog = log(angkaLog); System.out.printf("log(%.2f) = %.6f%n", angkaLog, hasilLog); break;
                            case 11: hasilLog = ln(angkaLog); System.out.printf("ln(%.2f) = %.6f%n", angkaLog, hasilLog); break;
                        }
                        break;
                        
                    case 12:
                        System.out.println("Terima kasih telah menggunakan kalkulator!");
                        running = false;
                        break;
                        
                    default:
                        System.out.println("Pilihan tidak valid!");
                        break;
                }
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: Input tidak valid!");
                input.nextLine(); // Membersihkan buffer
            }
        }
    }
}

// ========== MAIN CLASS ==========

public class LatihanjavaProject {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== KUMPULAN PROJECT JAVA ===");
        System.out.println("Pilih project yang ingin Anda jalankan:");
        System.out.println("1. Program Kasir Sederhana");
        System.out.println("2. Game Tebak Angka");
        System.out.println("3. Kalkulator Scientific");
        System.out.println("4. Keluar");
        System.out.print("Pilih (1-4): ");
        
        int pilihan = input.nextInt();
        
        switch (pilihan) {
            case 1:
                KasirSederhana kasir = new KasirSederhana();
                kasir.jalankan();
                break;
                
            case 2:
                GameTebakAngka game = new GameTebakAngka();
                game.mulaiGame();
                break;
                
            case 3:
                KalkulatorScientific kalkulator = new KalkulatorScientific();
                kalkulator.jalankan();
                break;
                
            case 4:
                System.out.println("Terima kasih!");
                break;
                
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
        
        input.close();
    }
}
