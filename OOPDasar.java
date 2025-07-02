class Mahasiswa {
    // Atribut/Properties (instance variables)
    private String nama;
    private String nim;
    private int umur;
    private double ipk;
    private String jurusan;
    
    // Static variable - milik class, bukan instance
    private static int jumlahMahasiswa = 0;
    
    // Constructor default (tanpa parameter)
    public Mahasiswa() {
        this.nama = "Belum diisi";
        this.nim = "00000000";
        this.umur = 0;
        this.ipk = 0.0;
        this.jurusan = "Belum ditentukan";
        jumlahMahasiswa++;
    }
    
    // Constructor dengan parameter
    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
        this.umur = 0;
        this.ipk = 0.0;
        this.jurusan = "Belum ditentukan";
        jumlahMahasiswa++;
    }
    
    // Constructor dengan semua parameter
    public Mahasiswa(String nama, String nim, int umur, double ipk, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.umur = umur;
        this.ipk = ipk;
        this.jurusan = jurusan;
        jumlahMahasiswa++;
    }
    
    // Getter methods (Accessor methods)
    public String getNama() {
        return nama;
    }
    
    public String getNim() {
        return nim;
    }
    
    public int getUmur() {
        return umur;
    }
    
    public double getIpk() {
        return ipk;
    }
    
    public String getJurusan() {
        return jurusan;
    }
    
    // Setter methods (Mutator methods)
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setNim(String nim) {
        this.nim = nim;
    }
    
    public void setUmur(int umur) {
        if (umur > 0 && umur < 100) {
            this.umur = umur;
        } else {
            System.out.println("Umur tidak valid!");
        }
    }
    
    public void setIpk(double ipk) {
        if (ipk >= 0.0 && ipk <= 4.0) {
            this.ipk = ipk;
        } else {
            System.out.println("IPK harus antara 0.0 - 4.0!");
        }
    }
    
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    
    // Method untuk menampilkan informasi mahasiswa
    public void tampilkanInfo() {
        System.out.println("=== INFORMASI MAHASISWA ===");
        System.out.println("Nama    : " + nama);
        System.out.println("NIM     : " + nim);
        System.out.println("Umur    : " + umur + " tahun");
        System.out.println("IPK     : " + ipk);
        System.out.println("Jurusan : " + jurusan);
        System.out.println("Predikat: " + getPredikat());
    }
    
    // Method untuk menentukan predikat berdasarkan IPK
    public String getPredikat() {
        if (ipk >= 3.5) {
            return "Cum Laude";
        } else if (ipk >= 3.0) {
            return "Sangat Memuaskan";
        } else if (ipk >= 2.5) {
            return "Memuaskan";
        } else if (ipk >= 2.0) {
            return "Cukup";
        } else {
            return "Kurang";
        }
    }
    
    // Method untuk mengecek apakah mahasiswa lulus
    public boolean isLulus() {
        return ipk >= 2.0;
    }
    
    // Method untuk menambah IPK (simulasi peningkatan nilai)
    public void tambahIpk(double peningkatan) {
        double ipkBaru = this.ipk + peningkatan;
        if (ipkBaru <= 4.0) {
            this.ipk = ipkBaru;
            System.out.println("IPK berhasil ditingkatkan menjadi: " + this.ipk);
        } else {
            System.out.println("IPK tidak dapat melebihi 4.0!");
        }
    }
    
    // Static method - dapat dipanggil tanpa membuat object
    public static int getJumlahMahasiswa() {
        return jumlahMahasiswa;
    }
    
    // Method toString() - untuk representasi string object
    @Override
    public String toString() {
        return "Mahasiswa{" +
                "nama='" + nama + '\'' +
                ", nim='" + nim + '\'' +
                ", umur=" + umur +
                ", ipk=" + ipk +
                ", jurusan='" + jurusan + '\'' +
                '}';
    }
}

// Class untuk merepresentasikan Mobil
class Mobil {
    // Atribut
    private String merk;
    private String model;
    private int tahun;
    private String warna;
    private boolean mesinMenyala;
    private int kecepatan;
    
    // Constructor
    public Mobil(String merk, String model, int tahun, String warna) {
        this.merk = merk;
        this.model = model;
        this.tahun = tahun;
        this.warna = warna;
        this.mesinMenyala = false;
        this.kecepatan = 0;
    }
    
    // Method untuk menyalakan mesin
    public void nyalakanMesin() {
        if (!mesinMenyala) {
            mesinMenyala = true;
            System.out.println("Mesin " + merk + " " + model + " dinyalakan. Vroom!");
        } else {
            System.out.println("Mesin sudah menyala!");
        }
    }
    
    // Method untuk mematikan mesin
    public void matikanMesin() {
        if (mesinMenyala && kecepatan == 0) {
            mesinMenyala = false;
            System.out.println("Mesin " + merk + " " + model + " dimatikan.");
        } else if (!mesinMenyala) {
            System.out.println("Mesin sudah mati!");
        } else {
            System.out.println("Tidak bisa mematikan mesin saat mobil bergerak!");
        }
    }
    
    // Method untuk mempercepat
    public void percepat(int tambahKecepatan) {
        if (mesinMenyala) {
            kecepatan += tambahKecepatan;
            if (kecepatan > 200) {
                kecepatan = 200; // Batas maksimum kecepatan
            }
            System.out.println("Kecepatan sekarang: " + kecepatan + " km/h");
        } else {
            System.out.println("Nyalakan mesin terlebih dahulu!");
        }
    }
    
    // Method untuk mengurangi kecepatan
    public void rem(int kurangKecepatan) {
        if (kecepatan > 0) {
            kecepatan -= kurangKecepatan;
            if (kecepatan < 0) {
                kecepatan = 0;
            }
            System.out.println("Kecepatan sekarang: " + kecepatan + " km/h");
        } else {
            System.out.println("Mobil sudah berhenti!");
        }
    }
    
    // Method untuk menampilkan status mobil
    public void tampilkanStatus() {
        System.out.println("=== STATUS MOBIL ===");
        System.out.println("Merk: " + merk);
        System.out.println("Model: " + model);
        System.out.println("Tahun: " + tahun);
        System.out.println("Warna: " + warna);
        System.out.println("Mesin: " + (mesinMenyala ? "Menyala" : "Mati"));
        System.out.println("Kecepatan: " + kecepatan + " km/h");
    }
    
    // Getter methods
    public String getMerk() { return merk; }
    public String getModel() { return model; }
    public int getTahun() { return tahun; }
    public String getWarna() { return warna; }
    public boolean isMesinMenyala() { return mesinMenyala; }
    public int getKecepatan() { return kecepatan; }
}

// Class untuk mendemonstrasikan konsep static
class Calculator {
    // Static variables
    public static final double PI = 3.14159;
    private static int operasiCount = 0;
    
    // Static methods - dapat dipanggil tanpa membuat object
    public static double tambah(double a, double b) {
        operasiCount++;
        return a + b;
    }
    
    public static double kurang(double a, double b) {
        operasiCount++;
        return a - b;
    }
    
    public static double kali(double a, double b) {
        operasiCount++;
        return a * b;
    }
    
    public static double bagi(double a, double b) {
        operasiCount++;
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Error: Pembagian dengan nol!");
            return Double.NaN;
        }
    }
    
    public static double luasLingkaran(double radius) {
        operasiCount++;
        return PI * radius * radius;
    }
    
    public static int getOperasiCount() {
        return operasiCount;
    }
    
    public static void resetCount() {
        operasiCount = 0;
    }
}

// Main class
public class OOPDasar {
    public static void main(String[] args) {
        
        System.out.println("=== PEMROGRAMAN BERORIENTASI OBJEK ===");
        
        System.out.println("\n=== MEMBUAT OBJECT MAHASISWA ===");
        
        // Membuat object menggunakan constructor default
        Mahasiswa mhs1 = new Mahasiswa();
        System.out.println("Mahasiswa 1 (default constructor):");
        mhs1.tampilkanInfo();
        
        // Membuat object menggunakan constructor dengan parameter
        Mahasiswa mhs2 = new Mahasiswa("Andi Setiawan", "12345678");
        mhs2.setUmur(20);
        mhs2.setIpk(3.75);
        mhs2.setJurusan("Teknik Informatika");
        
        System.out.println("\nMahasiswa 2:");
        mhs2.tampilkanInfo();
        
        // Membuat object dengan constructor lengkap
        Mahasiswa mhs3 = new Mahasiswa("Sari Dewi", "87654321", 19, 3.25, "Sistem Informasi");
        
        System.out.println("\nMahasiswa 3:");
        mhs3.tampilkanInfo();
        
        // Menggunakan method object
        System.out.println("\n=== MENGGUNAKAN METHOD OBJECT ===");
        System.out.println(mhs2.getNama() + " lulus: " + mhs2.isLulus());
        System.out.println(mhs3.getNama() + " lulus: " + mhs3.isLulus());
        
        // Mengubah data menggunakan setter
        System.out.println("\n=== MENGUBAH DATA MAHASISWA ===");
        mhs1.setNama("Budi Prasetyo");
        mhs1.setNim("11111111");
        mhs1.setUmur(21);
        mhs1.setIpk(2.8);
        mhs1.setJurusan("Teknik Elektro");
        
        System.out.println("Mahasiswa 1 setelah diubah:");
        mhs1.tampilkanInfo();
        
        // Menambah IPK
        System.out.println("\n=== MENAMBAH IPK ===");
        System.out.println("IPK " + mhs1.getNama() + " sebelum: " + mhs1.getIpk());
        mhs1.tambahIpk(0.3);
        
        // Menggunakan static method
        System.out.println("\n=== STATIC METHOD ===");
        System.out.println("Total mahasiswa yang dibuat: " + Mahasiswa.getJumlahMahasiswa());
        
        System.out.println("\n=== OBJECT MOBIL ===");
        
        // Membuat object mobil
        Mobil mobil1 = new Mobil("Toyota", "Avanza", 2022, "Putih");
        Mobil mobil2 = new Mobil("Honda", "Civic", 2023, "Hitam");
        
        // Menggunakan method mobil
        mobil1.tampilkanStatus();
        
        System.out.println("\n=== OPERASI MOBIL ===");
        mobil1.nyalakanMesin();
        mobil1.percepat(50);
        mobil1.percepat(30);
        mobil1.rem(20);
        mobil1.tampilkanStatus();
        
        mobil1.rem(60);
        mobil1.matikanMesin();
        
        System.out.println("\n=== STATIC CLASS CALCULATOR ===");
        
        // Menggunakan static methods tanpa membuat object
        System.out.println("Penjumlahan 10 + 5 = " + Calculator.tambah(10, 5));
        System.out.println("Pengurangan 10 - 5 = " + Calculator.kurang(10, 5));
        System.out.println("Perkalian 10 × 5 = " + Calculator.kali(10, 5));
        System.out.println("Pembagian 10 ÷ 5 = " + Calculator.bagi(10, 5));
        System.out.println("Luas lingkaran (r=7) = " + Calculator.luasLingkaran(7));
        
        System.out.println("Total operasi yang dilakukan: " + Calculator.getOperasiCount());
        
        // Menggunakan konstanta PI
        System.out.println("Nilai PI: " + Calculator.PI);
        
        System.out.println("\n=== ARRAY OF OBJECTS ===");
        
        // Membuat array yang berisi object
        Mahasiswa[] daftarMahasiswa = {
            new Mahasiswa("Alice", "111", 20, 3.8, "Informatika"),
            new Mahasiswa("Bob", "222", 19, 3.2, "Sistem Informasi"),
            new Mahasiswa("Charlie", "333", 21, 3.6, "Teknik Komputer")
        };
        
        // Menampilkan semua mahasiswa
        System.out.println("Daftar Semua Mahasiswa:");
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            System.out.println((i + 1) + ". " + daftarMahasiswa[i].getNama() + 
                             " - IPK: " + daftarMahasiswa[i].getIpk() + 
                             " - " + daftarMahasiswa[i].getPredikat());
        }
        
        // Mencari mahasiswa dengan IPK tertinggi
        Mahasiswa mahasiswaTerbaik = daftarMahasiswa[0];
        for (Mahasiswa mhs : daftarMahasiswa) {
            if (mhs.getIpk() > mahasiswaTerbaik.getIpk()) {
                mahasiswaTerbaik = mhs;
            }
        }
        
        System.out.println("\nMahasiswa dengan IPK tertinggi:");
        mahasiswaTerbaik.tampilkanInfo();
        
        System.out.println("\n=== TOSTRING METHOD ===");
        System.out.println("Object mhs2: " + mhs2.toString());
        System.out.println("Object mhs3: " + mhs3); // toString() dipanggil otomatis
        
        System.out.println("\nTotal mahasiswa yang pernah dibuat: " + Mahasiswa.getJumlahMahasiswa());
    }
}
