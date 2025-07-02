// Tipe Data dan Variabel dalam Java
// File ini mendemonstrasikan berbagai tipe data yang tersedia di Java

public class TipeDataVariabel {
    public static void main(String[] args) {
        // TIPE DATA PRIMITIF
        
        // Tipe data untuk bilangan bulat
        byte angkaByte = 127;           // -128 hingga 127
        short angkaShort = 32767;       // -32,768 hingga 32,767
        int angkaInt = 2147483647;      // -2,147,483,648 hingga 2,147,483,647
        long angkaLong = 9223372036854775807L; // L di akhir menandakan long
        
        // Tipe data untuk bilangan desimal
        float angkaFloat = 3.14f;       // f di akhir menandakan float
        double angkaDouble = 3.141592653589793;
        
        // Tipe data untuk karakter
        char huruf = 'A';
        char unicode = '\u0041';        // Representasi unicode untuk 'A'
        
        // Tipe data boolean (true/false)
        boolean benar = true;
        boolean salah = false;
        
        // TIPE DATA NON-PRIMITIF (Reference)
        
        // String - untuk teks
        String nama = "Budi Setiawan";
        String alamat = "Jakarta, Indonesia";
        
        // Array - kumpulan data dengan tipe yang sama
        int[] angkaArray = {1, 2, 3, 4, 5};
        String[] namaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        
        // Menampilkan semua variabel
        System.out.println("=== TIPE DATA PRIMITIF ===");
        System.out.println("Byte: " + angkaByte);
        System.out.println("Short: " + angkaShort);
        System.out.println("Int: " + angkaInt);
        System.out.println("Long: " + angkaLong);
        System.out.println("Float: " + angkaFloat);
        System.out.println("Double: " + angkaDouble);
        System.out.println("Char: " + huruf);
        System.out.println("Unicode: " + unicode);
        System.out.println("Boolean benar: " + benar);
        System.out.println("Boolean salah: " + salah);
        
        System.out.println("\n=== TIPE DATA NON-PRIMITIF ===");
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.print("Array angka: ");
        for (int i = 0; i < angkaArray.length; i++) {
            System.out.print(angkaArray[i] + " ");
        }
        System.out.println();
        
        System.out.print("Array hari: ");
        for (String hari : namaHari) {
            System.out.print(hari + " ");
        }
        System.out.println();
        
        // KONSTANTA - variabel yang nilainya tidak dapat diubah
        final double PI = 3.14159;
        final String NAMA_APLIKASI = "Program Belajar Java";
        
        System.out.println("\n=== KONSTANTA ===");
        System.out.println("Nilai PI: " + PI);
        System.out.println("Nama Aplikasi: " + NAMA_APLIKASI);
    }
}
