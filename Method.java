public class Method {
    
    // Method tanpa parameter dan tanpa return value
    public static void salam() {
        System.out.println("Halo! Selamat datang di pembelajaran Java!");
    }
    
    // Method dengan parameter tapi tanpa return value
    public static void salamPersonal(String nama) {
        System.out.println("Halo " + nama + "! Selamat belajar Java!");
    }
    
    // Method dengan parameter dan return value
    public static int tambah(int a, int b) {
        return a + b;
    }
    
    // Method dengan multiple parameter
    public static double hitungLuasSegitiga(double alas, double tinggi) {
        return 0.5 * alas * tinggi;
    }
    
    // Method overloading - nama sama, parameter berbeda
    public static int perkalian(int a, int b) {
        return a * b;
    }
    
    public static double perkalian(double a, double b) {
        return a * b;
    }
    
    public static int perkalian(int a, int b, int c) {
        return a * b * c;
    }
    
    // Method dengan array sebagai parameter
    public static void tampilkanArray(int[] arr) {
        System.out.print("Isi array: ");
        for (int nilai : arr) {
            System.out.print(nilai + " ");
        }
        System.out.println();
    }
    
    // Method yang mengembalikan array
    public static int[] buatArrayKuadrat(int n) {
        int[] hasil = new int[n];
        for (int i = 0; i < n; i++) {
            hasil[i] = (i + 1) * (i + 1);
        }
        return hasil;
    }
    
    // Method untuk mencari nilai maksimum dalam array
    public static int cariMaksimum(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array tidak boleh kosong");
        }
        
        int maksimum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maksimum) {
                maksimum = arr[i];
            }
        }
        return maksimum;
    }
    
    // Method untuk mengecek bilangan prima
    public static boolean isPrima(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    // Method recursive untuk menghitung faktorial
    public static long faktorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * faktorial(n - 1);
    }
    
    // Method recursive untuk fibonacci
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    // Method untuk validasi input
    public static boolean validasiNilai(int nilai) {
        return nilai >= 0 && nilai <= 100;
    }
    
    // Method untuk konversi grade
    public static String konversiGrade(int nilai) {
        if (!validasiNilai(nilai)) {
            return "Nilai tidak valid";
        }
        
        if (nilai >= 90) return "A";
        else if (nilai >= 80) return "B";
        else if (nilai >= 70) return "C";
        else if (nilai >= 60) return "D";
        else return "E";
    }
    
    // Method dengan parameter varargs (variable arguments)
    public static double hitungRataRata(double... angka) {
        if (angka.length == 0) {
            return 0;
        }
        
        double total = 0;
        for (double nilai : angka) {
            total += nilai;
        }
        return total / angka.length;
    }
    
    // Method untuk menukar nilai (pass by reference simulation)
    public static void tukarNilai(int[] arr, int indeks1, int indeks2) {
        if (indeks1 >= 0 && indeks1 < arr.length && 
            indeks2 >= 0 && indeks2 < arr.length) {
            int temp = arr[indeks1];
            arr[indeks1] = arr[indeks2];
            arr[indeks2] = temp;
        }
    }
    
    // Method untuk sorting array (Bubble Sort)
    public static void urutkanArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tukarNilai(arr, j, j + 1);
                }
            }
        }
    }
    
    // Method untuk pencarian binary search (array harus sudah terurut)
    public static int binarySearch(int[] arr, int target) {
        int kiri = 0;
        int kanan = arr.length - 1;
        
        while (kiri <= kanan) {
            int tengah = kiri + (kanan - kiri) / 2;
            
            if (arr[tengah] == target) {
                return tengah;
            }
            
            if (arr[tengah] < target) {
                kiri = tengah + 1;
            } else {
                kanan = tengah - 1;
            }
        }
        
        return -1; // Tidak ditemukan
    }
    
    // Method untuk menghitung luas dan keliling lingkaran
    public static void hitungLingkaran(double radius) {
        final double PI = 3.14159;
        double luas = PI * radius * radius;
        double keliling = 2 * PI * radius;
        
        System.out.println("Radius: " + radius);
        System.out.println("Luas: " + luas);
        System.out.println("Keliling: " + keliling);
    }
    
    // Main method - titik masuk program
    public static void main(String[] args) {
        
        System.out.println("=== PENGGUNAAN METHOD ===");
        
        // Memanggil method tanpa parameter
        salam();
        
        // Memanggil method dengan parameter
        salamPersonal("Budi");
        salamPersonal("Sari");
        
        // Memanggil method dengan return value
        int hasil = tambah(15, 25);
        System.out.println("15 + 25 = " + hasil);
        
        // Langsung menggunakan hasil method
        System.out.println("10 + 30 = " + tambah(10, 30));
        
        // Method dengan tipe data double
        double luas = hitungLuasSegitiga(10.0, 8.0);
        System.out.println("Luas segitiga (alas=10, tinggi=8): " + luas);
        
        System.out.println("\n=== METHOD OVERLOADING ===");
        
        // Demonstrasi method overloading
        System.out.println("Perkalian int: " + perkalian(5, 6));
        System.out.println("Perkalian double: " + perkalian(5.5, 6.2));
        System.out.println("Perkalian 3 angka: " + perkalian(2, 3, 4));
        
        System.out.println("\n=== METHOD DENGAN ARRAY ===");
        
        // Method dengan array sebagai parameter
        int[] angka = {10, 20, 30, 40, 50};
        tampilkanArray(angka);
        
        // Method yang mengembalikan array
        int[] arrayKuadrat = buatArrayKuadrat(5);
        System.out.print("Array kuadrat: ");
        tampilkanArray(arrayKuadrat);
        
        // Mencari nilai maksimum
        int maksimum = cariMaksimum(angka);
        System.out.println("Nilai maksimum: " + maksimum);
        
        System.out.println("\n=== METHOD BOOLEAN ===");
        
        // Method yang mengembalikan boolean
        int[] angkaUji = {17, 18, 19, 20, 21};
        for (int num : angkaUji) {
            System.out.println(num + " adalah prima: " + isPrima(num));
        }
        
        // Validasi nilai
        int[] nilaiUji = {85, 150, -10, 75};
        for (int nilai : nilaiUji) {
            System.out.println("Nilai " + nilai + " valid: " + validasiNilai(nilai));
            if (validasiNilai(nilai)) {
                System.out.println("Grade: " + konversiGrade(nilai));
            }
        }
        
        System.out.println("\n=== METHOD RECURSIVE ===");
        
        // Faktorial menggunakan recursion
        for (int i = 1; i <= 6; i++) {
            System.out.println("Faktorial " + i + " = " + faktorial(i));
        }
        
        // Fibonacci menggunakan recursion
        System.out.print("Deret Fibonacci: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        
        System.out.println("\n=== METHOD DENGAN VARARGS ===");
        
        // Method dengan variable arguments
        System.out.println("Rata-rata (10, 20, 30): " + hitungRataRata(10, 20, 30));
        System.out.println("Rata-rata (5, 15, 25, 35, 45): " + hitungRataRata(5, 15, 25, 35, 45));
        System.out.println("Rata-rata (100): " + hitungRataRata(100));
        
        System.out.println("\n=== OPERASI ARRAY LANJUTAN ===");
        
        // Sorting dan searching
        int[] dataAcak = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("Sebelum diurutkan: ");
        tampilkanArray(dataAcak);
        
        urutkanArray(dataAcak);
        System.out.print("Setelah diurutkan: ");
        tampilkanArray(dataAcak);
        
        // Binary search
        int cari = 25;
        int indeks = binarySearch(dataAcak, cari);
        if (indeks != -1) {
            System.out.println("Nilai " + cari + " ditemukan di indeks " + indeks);
        } else {
            System.out.println("Nilai " + cari + " tidak ditemukan");
        }
        
        System.out.println("\n=== CONTOH APLIKASI PRAKTIS ===");
        
        // Aplikasi kalkulator sederhana menggunakan method
        System.out.println("=== KALKULATOR SEDERHANA ===");
        System.out.println("5 + 3 = " + tambah(5, 3));
        System.out.println("5 × 3 = " + perkalian(5, 3));
        
        // Menghitung luas dan keliling lingkaran
        System.out.println("\n=== PERHITUNGAN LINGKARAN ===");
        hitungLingkaran(7.0);
        
        // Sistem penilaian
        System.out.println("\n=== SISTEM PENILAIAN ===");
        int[] nilaiSiswa = {95, 78, 85, 92, 67};
        for (int i = 0; i < nilaiSiswa.length; i++) {
            System.out.println("Siswa " + (i + 1) + 
                             " - Nilai: " + nilaiSiswa[i] + 
                             " - Grade: " + konversiGrade(nilaiSiswa[i]));
        }
    }
}
