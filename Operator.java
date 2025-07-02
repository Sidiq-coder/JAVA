// Operator dalam Java
// File ini mendemonstrasikan berbagai jenis operator yang tersedia

public class Operator {
    public static void main(String[] args) {
        // Deklarasi variabel untuk contoh
        int a = 10;
        int b = 3;
        double x = 5.5;
        double y = 2.2;
        
        System.out.println("=== OPERATOR ARITMATIKA ===");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Penjumlahan (a + b): " + (a + b));
        System.out.println("Pengurangan (a - b): " + (a - b));
        System.out.println("Perkalian (a * b): " + (a * b));
        System.out.println("Pembagian (a / b): " + (a / b));           // Hasil integer
        System.out.println("Pembagian desimal (x / y): " + (x / y));   // Hasil double
        System.out.println("Modulus/Sisa bagi (a % b): " + (a % b));
        
        System.out.println("\n=== OPERATOR PENUGASAN ===");
        int c = 15;
        System.out.println("Nilai awal c: " + c);
        
        c += 5;  // sama dengan c = c + 5
        System.out.println("Setelah c += 5: " + c);
        
        c -= 3;  // sama dengan c = c - 3
        System.out.println("Setelah c -= 3: " + c);
        
        c *= 2;  // sama dengan c = c * 2
        System.out.println("Setelah c *= 2: " + c);
        
        c /= 4;  // sama dengan c = c / 4
        System.out.println("Setelah c /= 4: " + c);
        
        c %= 3;  // sama dengan c = c % 3
        System.out.println("Setelah c %= 3: " + c);
        
        System.out.println("\n=== OPERATOR INCREMENT DAN DECREMENT ===");
        int d = 10;
        System.out.println("Nilai awal d: " + d);
        
        // Pre-increment (++d): tambah dulu, baru gunakan
        System.out.println("Pre-increment (++d): " + (++d));
        System.out.println("Nilai d sekarang: " + d);
        
        // Post-increment (d++): gunakan dulu, baru tambah
        System.out.println("Post-increment (d++): " + (d++));
        System.out.println("Nilai d sekarang: " + d);
        
        // Pre-decrement (--d): kurang dulu, baru gunakan
        System.out.println("Pre-decrement (--d): " + (--d));
        System.out.println("Nilai d sekarang: " + d);
        
        // Post-decrement (d--): gunakan dulu, baru kurang
        System.out.println("Post-decrement (d--): " + (d--));
        System.out.println("Nilai d sekarang: " + d);
        
        System.out.println("\n=== OPERATOR PERBANDINGAN ===");
        int num1 = 10;
        int num2 = 20;
        System.out.println("num1 = " + num1 + ", num2 = " + num2);
        System.out.println("num1 == num2: " + (num1 == num2));  // Sama dengan
        System.out.println("num1 != num2: " + (num1 != num2));  // Tidak sama dengan
        System.out.println("num1 > num2: " + (num1 > num2));    // Lebih besar
        System.out.println("num1 < num2: " + (num1 < num2));    // Lebih kecil
        System.out.println("num1 >= num2: " + (num1 >= num2));  // Lebih besar atau sama
        System.out.println("num1 <= num2: " + (num1 <= num2));  // Lebih kecil atau sama
        
        System.out.println("\n=== OPERATOR LOGIKA ===");
        boolean p = true;
        boolean q = false;
        System.out.println("p = " + p + ", q = " + q);
        System.out.println("p && q (AND): " + (p && q));        // Kedua kondisi harus true
        System.out.println("p || q (OR): " + (p || q));         // Salah satu kondisi true
        System.out.println("!p (NOT): " + (!p));                // Kebalikan dari p
        System.out.println("!q (NOT): " + (!q));                // Kebalikan dari q
        
        // Contoh penggunaan dalam kondisi
        int umur = 18;
        boolean punyaSIM = true;
        boolean bisaMenyetir = (umur >= 17) && punyaSIM;
        System.out.println("Bisa menyetir: " + bisaMenyetir);
        
        System.out.println("\n=== OPERATOR TERNARY (KONDISIONAL) ===");
        // Format: kondisi ? nilaiJikaTrue : nilaiJikaFalse
        int nilai = 85;
        String hasil = (nilai >= 75) ? "Lulus" : "Tidak Lulus";
        System.out.println("Nilai: " + nilai + " -> " + hasil);
        
        // Contoh lain
        int angka = -5;
        String jenis = (angka >= 0) ? "Positif" : "Negatif";
        System.out.println("Angka " + angka + " adalah: " + jenis);
        
        System.out.println("\n=== OPERATOR BITWISE (TINGKAT LANJUT) ===");
        int m = 12;  // dalam biner: 1100
        int n = 10;  // dalam biner: 1010
        System.out.println("m = " + m + " (biner: " + Integer.toBinaryString(m) + ")");
        System.out.println("n = " + n + " (biner: " + Integer.toBinaryString(n) + ")");
        System.out.println("m & n (AND): " + (m & n));   // 1000 = 8
        System.out.println("m | n (OR): " + (m | n));    // 1110 = 14
        System.out.println("m ^ n (XOR): " + (m ^ n));   // 0110 = 6
        System.out.println("~m (NOT): " + (~m));         // Komplemen
        System.out.println("m << 1 (Shift Left): " + (m << 1));  // 11000 = 24
        System.out.println("m >> 1 (Shift Right): " + (m >> 1)); // 110 = 6
    }
}
