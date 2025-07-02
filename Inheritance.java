
// Class parent/superclass/base class
class Kendaraan {
    // Atribut protected - dapat diakses oleh subclass
    protected String merk;
    protected String model;
    protected int tahun;
    protected String warna;
    protected boolean mesinHidup;
    
    // Constructor
    public Kendaraan(String merk, String model, int tahun, String warna) {
        this.merk = merk;
        this.model = model;
        this.tahun = tahun;
        this.warna = warna;
        this.mesinHidup = false;
    }
    
    // Method yang dapat di-override oleh subclass
    public void nyalakanMesin() {
        mesinHidup = true;
        System.out.println("Mesin " + merk + " " + model + " dinyalakan");
    }
    
    public void matikanMesin() {
        mesinHidup = false;
        System.out.println("Mesin " + merk + " " + model + " dimatikan");
    }
    
    public void tampilkanInfo() {
        System.out.println("=== INFORMASI KENDARAAN ===");
        System.out.println("Merk: " + merk);
        System.out.println("Model: " + model);
        System.out.println("Tahun: " + tahun);
        System.out.println("Warna: " + warna);
        System.out.println("Status Mesin: " + (mesinHidup ? "Hidup" : "Mati"));
    }
    
    // Method yang akan di-override
    public void bergerak() {
        if (mesinHidup) {
            System.out.println("Kendaraan bergerak");
        } else {
            System.out.println("Nyalakan mesin terlebih dahulu!");
        }
    }
    
    // Getter methods
    public String getMerk() { return merk; }
    public String getModel() { return model; }
    public int getTahun() { return tahun; }
    public String getWarna() { return warna; }
    public boolean isMesinHidup() { return mesinHidup; }
}

// Child class/subclass - extends dari Kendaraan
class Mobil extends Kendaraan {
    // Atribut tambahan khusus mobil
    private int jumlahPintu;
    private String jenisBahanBakar;
    private int kecepatan;
    private final int MAX_SPEED = 200;
    
    // Constructor - harus memanggil constructor parent dengan super()
    public Mobil(String merk, String model, int tahun, String warna, int jumlahPintu, String jenisBahanBakar) {
        super(merk, model, tahun, warna); // Memanggil constructor parent
        this.jumlahPintu = jumlahPintu;
        this.jenisBahanBakar = jenisBahanBakar;
        this.kecepatan = 0;
    }
    
    // Override method dari parent class
    @Override
    public void bergerak() {
        if (mesinHidup) {
            System.out.println("Mobil " + merk + " " + model + " melaju di jalan raya");
        } else {
            System.out.println("Nyalakan mesin mobil terlebih dahulu!");
        }
    }
    
    // Override method tampilkanInfo dengan menambah informasi
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // Memanggil method parent
        System.out.println("Jumlah Pintu: " + jumlahPintu);
        System.out.println("Bahan Bakar: " + jenisBahanBakar);
        System.out.println("Kecepatan: " + kecepatan + " km/h");
    }
    
    // Method khusus mobil
    public void percepat(int tambahKecepatan) {
        if (mesinHidup) {
            kecepatan += tambahKecepatan;
            if (kecepatan > MAX_SPEED) {
                kecepatan = MAX_SPEED;
                System.out.println("Kecepatan maksimum tercapai: " + MAX_SPEED + " km/h");
            } else {
                System.out.println("Kecepatan sekarang: " + kecepatan + " km/h");
            }
        } else {
            System.out.println("Nyalakan mesin terlebih dahulu!");
        }
    }
    
    public void rem(int kurangKecepatan) {
        kecepatan -= kurangKecepatan;
        if (kecepatan < 0) {
            kecepatan = 0;
        }
        System.out.println("Mengerem... Kecepatan: " + kecepatan + " km/h");
    }
    
    public void klakson() {
        System.out.println("BEEP BEEP! Klakson mobil " + merk + " berbunyi");
    }
    
    // Getter untuk atribut baru
    public int getJumlahPintu() { return jumlahPintu; }
    public String getJenisBahanBakar() { return jenisBahanBakar; }
    public int getKecepatan() { return kecepatan; }
}

// Child class lain dari Kendaraan
class Motor extends Kendaraan {
    private String jenisMotor; // Sport, Bebek, Matic
    private int kecepatan;
    private final int MAX_SPEED = 150;
    
    public Motor(String merk, String model, int tahun, String warna, String jenisMotor) {
        super(merk, model, tahun, warna);
        this.jenisMotor = jenisMotor;
        this.kecepatan = 0;
    }
    
    @Override
    public void bergerak() {
        if (mesinHidup) {
            System.out.println("Motor " + merk + " " + model + " melaju dengan lincah");
        } else {
            System.out.println("Starter motor terlebih dahulu!");
        }
    }
    
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis Motor: " + jenisMotor);
        System.out.println("Kecepatan: " + kecepatan + " km/h");
    }
    
    // Method khusus motor
    public void gas(int tambahKecepatan) {
        if (mesinHidup) {
            kecepatan += tambahKecepatan;
            if (kecepatan > MAX_SPEED) {
                kecepatan = MAX_SPEED;
                System.out.println("Kecepatan maksimum motor tercapai: " + MAX_SPEED + " km/h");
            } else {
                System.out.println("Ngebut... Kecepatan: " + kecepatan + " km/h");
            }
        } else {
            System.out.println("Starter motor terlebih dahulu!");
        }
    }
    
    public void rem() {
        kecepatan = Math.max(0, kecepatan - 20);
        System.out.println("Ngerem... Kecepatan: " + kecepatan + " km/h");
    }
    
    public String getJenisMotor() { return jenisMotor; }
    public int getKecepatan() { return kecepatan; }
}

// Contoh inheritance bertingkat
class Truk extends Kendaraan {
    protected double kapasitasMuatan; // dalam ton
    protected double muatanSekarang;
    
    public Truk(String merk, String model, int tahun, String warna, double kapasitasMuatan) {
        super(merk, model, tahun, warna);
        this.kapasitasMuatan = kapasitasMuatan;
        this.muatanSekarang = 0;
    }
    
    @Override
    public void bergerak() {
        if (mesinHidup) {
            if (muatanSekarang <= kapasitasMuatan) {
                System.out.println("Truk " + merk + " bergerak membawa muatan " + muatanSekarang + " ton");
            } else {
                System.out.println("Muatan berlebih! Truk tidak bisa bergerak dengan aman");
            }
        } else {
            System.out.println("Nyalakan mesin truk terlebih dahulu!");
        }
    }
    
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kapasitas Muatan: " + kapasitasMuatan + " ton");
        System.out.println("Muatan Sekarang: " + muatanSekarang + " ton");
        System.out.println("Sisa Kapasitas: " + (kapasitasMuatan - muatanSekarang) + " ton");
    }
    
    public void muatBarang(double berat) {
        if (muatanSekarang + berat <= kapasitasMuatan) {
            muatanSekarang += berat;
            System.out.println("Memuat " + berat + " ton. Total muatan: " + muatanSekarang + " ton");
        } else {
            System.out.println("Tidak bisa memuat! Kapasitas tidak mencukupi");
        }
    }
    
    public void bongkarBarang(double berat) {
        if (muatanSekarang >= berat) {
            muatanSekarang -= berat;
            System.out.println("Membongkar " + berat + " ton. Sisa muatan: " + muatanSekarang + " ton");
        } else {
            System.out.println("Tidak cukup barang untuk dibongkar");
        }
    }
    
    public double getKapasitasMuatan() { return kapasitasMuatan; }
    public double getMuatanSekarang() { return muatanSekarang; }
}

// Subclass dari Truk
class TrukContainer extends Truk {
    private String jenisContainer;
    private boolean containerTerpasang;
    
    public TrukContainer(String merk, String model, int tahun, String warna, 
                        double kapasitasMuatan, String jenisContainer) {
        super(merk, model, tahun, warna, kapasitasMuatan);
        this.jenisContainer = jenisContainer;
        this.containerTerpasang = false;
    }
    
    @Override
    public void bergerak() {
        if (containerTerpasang) {
            super.bergerak();
        } else {
            System.out.println("Pasang container terlebih dahulu!");
        }
    }
    
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis Container: " + jenisContainer);
        System.out.println("Container Terpasang: " + (containerTerpasang ? "Ya" : "Tidak"));
    }
    
    public void pasangContainer() {
        containerTerpasang = true;
        System.out.println("Container " + jenisContainer + " terpasang");
    }
    
    public void lepasContainer() {
        if (muatanSekarang == 0) {
            containerTerpasang = false;
            System.out.println("Container " + jenisContainer + " dilepas");
        } else {
            System.out.println("Kosongkan muatan terlebih dahulu!");
        }
    }
    
    public String getJenisContainer() { return jenisContainer; }
    public boolean isContainerTerpasang() { return containerTerpasang; }
}

// Class untuk demonstrasi konsep polymorphism dasar
class GarageKendaraan {
    public static void servisKendaraan(Kendaraan kendaraan) {
        System.out.println("\n=== SERVIS KENDARAAN ===");
        kendaraan.tampilkanInfo();
        kendaraan.nyalakanMesin();
        kendaraan.bergerak();
        kendaraan.matikanMesin();
    }
}

public class Inheritance {
    public static void main(String[] args) {
        System.out.println("=== INHERITANCE (PEWARISAN) DALAM JAVA ===");
        
        System.out.println("\n=== MEMBUAT OBJECT KENDARAAN ===");
        
        // Membuat object parent class
        Kendaraan kendaraan1 = new Kendaraan("Generic", "Vehicle", 2020, "Putih");
        kendaraan1.tampilkanInfo();
        kendaraan1.nyalakanMesin();
        kendaraan1.bergerak();
        kendaraan1.matikanMesin();
        
        System.out.println("\n=== MEMBUAT OBJECT MOBIL (SUBCLASS) ===");
        
        // Membuat object child class
        Mobil mobil1 = new Mobil("Toyota", "Avanza", 2022, "Silver", 4, "Bensin");
        mobil1.tampilkanInfo();
        mobil1.nyalakanMesin();
        mobil1.bergerak();
        mobil1.percepat(60);
        mobil1.klakson();
        mobil1.rem(20);
        mobil1.matikanMesin();
        
        System.out.println("\n=== MEMBUAT OBJECT MOTOR (SUBCLASS) ===");
        
        Motor motor1 = new Motor("Honda", "CBR250RR", 2023, "Merah", "Sport");
        motor1.tampilkanInfo();
        motor1.nyalakanMesin();
        motor1.bergerak();
        motor1.gas(80);
        motor1.rem();
        motor1.matikanMesin();
        
        System.out.println("\n=== MEMBUAT OBJECT TRUK (SUBCLASS) ===");
        
        Truk truk1 = new Truk("Mitsubishi", "Canter", 2021, "Biru", 5.0);
        truk1.tampilkanInfo();
        truk1.muatBarang(2.5);
        truk1.muatBarang(3.0); // Total akan melebihi kapasitas
        truk1.muatBarang(2.0);
        truk1.nyalakanMesin();
        truk1.bergerak();
        truk1.bongkarBarang(1.5);
        truk1.matikanMesin();
        
        System.out.println("\n=== INHERITANCE BERTINGKAT ===");
        
        TrukContainer trukContainer1 = new TrukContainer("Hino", "500 Series", 2022, "Hijau", 10.0, "Dry Container");
        trukContainer1.tampilkanInfo();
        trukContainer1.bergerak(); // Belum pasang container
        trukContainer1.pasangContainer();
        trukContainer1.muatBarang(8.0);
        trukContainer1.nyalakanMesin();
        trukContainer1.bergerak();
        trukContainer1.bongkarBarang(8.0);
        trukContainer1.lepasContainer();
        
        System.out.println("\n=== POLYMORPHISM SEDERHANA ===");
        
        // Menggunakan reference parent untuk object child (polymorphism)
        Kendaraan[] daftarKendaraan = {
            new Mobil("Honda", "Civic", 2023, "Hitam", 4, "Bensin"),
            new Motor("Yamaha", "NMAX", 2022, "Biru", "Matic"),
            new Truk("Isuzu", "Elf", 2021, "Putih", 3.0)
        };
        
        // Method yang sama dipanggil, tapi perilaku berbeda (polymorphism)
        for (int i = 0; i < daftarKendaraan.length; i++) {
            System.out.println("\nKendaraan " + (i + 1) + ":");
            daftarKendaraan[i].nyalakanMesin();
            daftarKendaraan[i].bergerak(); // Method yang di-override
            daftarKendaraan[i].matikanMesin();
        }
        
        System.out.println("\n=== MENGGUNAKAN INSTANCEOF ===");
        
        // Mengecek tipe object dengan instanceof
        for (Kendaraan k : daftarKendaraan) {
            System.out.println("\nMengecek " + k.getMerk() + " " + k.getModel() + ":");
            
            if (k instanceof Mobil) {
                System.out.println("Ini adalah Mobil");
                Mobil m = (Mobil) k; // Casting ke Mobil
                System.out.println("Jumlah pintu: " + m.getJumlahPintu());
            } else if (k instanceof Motor) {
                System.out.println("Ini adalah Motor");
                Motor mt = (Motor) k; // Casting ke Motor
                System.out.println("Jenis motor: " + mt.getJenisMotor());
            } else if (k instanceof Truk) {
                System.out.println("Ini adalah Truk");
                Truk t = (Truk) k; // Casting ke Truk
                System.out.println("Kapasitas muatan: " + t.getKapasitasMuatan() + " ton");
            }
        }
        
        System.out.println("\n=== GARAGE KENDARAAN (POLYMORPHISM) ===");
        
        // Demonstrasi polymorphism dengan method yang menerima parent class
        GarageKendaraan.servisKendaraan(mobil1);
        GarageKendaraan.servisKendaraan(motor1);
        GarageKendaraan.servisKendaraan(truk1);
        
        System.out.println("\n=== AKSES MODIFIER PROTECTED ===");
        
        // Menunjukkan akses protected dari subclass
        Mobil mobil2 = new Mobil("BMW", "X5", 2023, "Hitam", 4, "Bensin");
        // mobil2.merk dapat diakses karena protected (dalam package yang sama)
        System.out.println("Merk mobil (akses protected): " + mobil2.merk);
        
        System.out.println("\n=== SUMMARY INHERITANCE ===");
        System.out.println("1. Class Kendaraan adalah parent/superclass");
        System.out.println("2. Class Mobil, Motor, Truk adalah child/subclass dari Kendaraan");
        System.out.println("3. Class TrukContainer adalah subclass dari Truk (inheritance bertingkat)");
        System.out.println("4. Subclass mewarisi semua atribut dan method dari parent");
        System.out.println("5. Subclass dapat override method parent untuk perilaku yang berbeda");
        System.out.println("6. Subclass dapat menambah atribut dan method baru");
        System.out.println("7. Polymorphism memungkinkan object subclass diperlakukan sebagai parent");
    }
}
