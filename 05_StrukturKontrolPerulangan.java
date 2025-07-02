// Struktur Kontrol - Perulangan (Loop)
// File ini mendemonstrasikan berbagai jenis perulangan dalam Java

public class StrukturKontrolPerulangan {
    public static void main(String[] args) {
        
        System.out.println("=== FOR LOOP ===");
        
        // For loop dasar - menghitung dari 1 sampai 5
        System.out.println("Menghitung 1-5:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // For loop dengan step yang berbeda
        System.out.println("Bilangan genap 2-10:");
        for (int i = 2; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // For loop mundur
        System.out.println("Countdown 10-1:");
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // For loop dengan array
        String[] buah = {"Apel", "Jeruk", "Mangga", "Pisang", "Anggur"};
        System.out.println("Daftar buah:");
        for (int i = 0; i < buah.length; i++) {
            System.out.println((i + 1) + ". " + buah[i]);
        }
        
        // Enhanced for loop (for-each)
        System.out.println("Menggunakan for-each:");
        for (String namaBuah : buah) {
            System.out.println("- " + namaBuah);
        }
        
        System.out.println("\n=== WHILE LOOP ===");
        
        // While loop dasar
        System.out.println("Menghitung dengan while loop:");
        int counter = 1;
        while (counter <= 5) {
            System.out.print(counter + " ");
            counter++;
        }
        System.out.println();
        
        // While loop untuk mencari bilangan
        System.out.println("Mencari bilangan yang habis dibagi 7:");
        int angka = 1;
        int ditemukan = 0;
        while (ditemukan < 5) {
            if (angka % 7 == 0) {
                System.out.print(angka + " ");
                ditemukan++;
            }
            angka++;
        }
        System.out.println();
        
        // While loop dengan kondisi boolean
        boolean lanjut = true;
        int hitungan = 1;
        System.out.println("Loop dengan kondisi boolean:");
        while (lanjut) {
            System.out.print(hitungan + " ");
            hitungan++;
            if (hitungan > 5) {
                lanjut = false;
            }
        }
        System.out.println();
        
        System.out.println("\n=== DO-WHILE LOOP ===");
        
        // Do-while loop - minimal dijalankan sekali
        System.out.println("Do-while loop (minimal 1x eksekusi):");
        int nilai = 10;
        do {
            System.out.println("Nilai: " + nilai);
            nilai++;
        } while (nilai <= 12);
        
        // Contoh do-while dengan kondisi yang tidak terpenuhi dari awal
        System.out.println("Do-while dengan kondisi false dari awal:");
        int x = 5;
        do {
            System.out.println("x = " + x + " (tetap dijalankan sekali)");
            x++;
        } while (x < 5);
        
        System.out.println("\n=== NESTED LOOP (LOOP BERSARANG) ===");
        
        // Membuat pola bintang
        System.out.println("Pola segitiga bintang:");
        for (int baris = 1; baris <= 5; baris++) {
            for (int kolom = 1; kolom <= baris; kolom++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        // Tabel perkalian
        System.out.println("Tabel perkalian 1-5:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
        
        System.out.println("\n=== BREAK DAN CONTINUE ===");
        
        // Menggunakan break
        System.out.println("Menggunakan break (berhenti di angka 7):");
        for (int i = 1; i <= 10; i++) {
            if (i == 7) {
                break; // Keluar dari loop
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Menggunakan continue
        System.out.println("Menggunakan continue (skip angka genap):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Lewati iterasi ini
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Break dengan label (untuk nested loop)
        System.out.println("Break dengan label:");
        outerLoop: // Label untuk loop luar
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    break outerLoop; // Keluar dari loop luar
                }
                System.out.print("(" + i + "," + j + ") ");
            }
        }
        System.out.println();
        
        System.out.println("\n=== CONTOH PRAKTIS ===");
        
        // Menghitung faktorial
        int n = 5;
        long faktorial = 1;
        for (int i = 1; i <= n; i++) {
            faktorial *= i;
        }
        System.out.println("Faktorial " + n + " = " + faktorial);
        
        // Mencari bilangan prima
        System.out.println("Bilangan prima 1-20:");
        for (int i = 2; i <= 20; i++) {
            boolean prima = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    prima = false;
                    break;
                }
            }
            if (prima) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // Deret Fibonacci
        System.out.println("Deret Fibonacci 10 suku pertama:");
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < 10; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
        System.out.println();
        
        // Membalik angka
        int bilangan = 12345;
        int balik = 0;
        int temp = bilangan;
        while (temp > 0) {
            balik = balik * 10 + temp % 10;
            temp /= 10;
        }
        System.out.println("Bilangan: " + bilangan + " -> Terbalik: " + balik);
    }
}
