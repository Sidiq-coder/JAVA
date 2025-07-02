// Array dalam Java
// File ini mendemonstrasikan penggunaan array satu dimensi dan multi dimensi

public class Array {
    public static void main(String[] args) {
        
        System.out.println("=== ARRAY SATU DIMENSI ===");
        
        // Cara mendeklarasikan dan membuat array
        
        // Metode 1: Deklarasi dan inisialisasi terpisah
        int[] angka1;              // Deklarasi
        angka1 = new int[5];       // Membuat array dengan 5 elemen
        
        // Metode 2: Deklarasi dan inisialisasi bersamaan
        int[] angka2 = new int[5];
        
        // Metode 3: Deklarasi dengan nilai langsung
        int[] angka3 = {10, 20, 30, 40, 50};
        
        // Metode 4: Menggunakan new dengan nilai langsung
        int[] angka4 = new int[]{1, 2, 3, 4, 5};
        
        // Mengisi nilai array (untuk angka1 dan angka2)
        angka1[0] = 5;
        angka1[1] = 15;
        angka1[2] = 25;
        angka1[3] = 35;
        angka1[4] = 45;
        
        for (int i = 0; i < angka2.length; i++) {
            angka2[i] = (i + 1) * 10;
        }
        
        // Menampilkan array
        System.out.println("Array angka1:");
        for (int i = 0; i < angka1.length; i++) {
            System.out.print(angka1[i] + " ");
        }
        System.out.println();
        
        System.out.println("Array angka2:");
        for (int nilai : angka2) {  // Enhanced for loop
            System.out.print(nilai + " ");
        }
        System.out.println();
        
        // Array dengan tipe data lain
        String[] nama = {"Andi", "Budi", "Citra", "Dina", "Eko"};
        double[] nilai = {85.5, 90.0, 78.5, 92.0, 88.5};
        boolean[] lulus = {true, true, false, true, true};
        
        System.out.println("\nData Siswa:");
        for (int i = 0; i < nama.length; i++) {
            System.out.println(nama[i] + " - Nilai: " + nilai[i] + 
                             " - Lulus: " + (lulus[i] ? "Ya" : "Tidak"));
        }
        
        System.out.println("\n=== OPERASI PADA ARRAY ===");
        
        int[] data = {45, 23, 78, 12, 67, 34, 89, 56};
        
        // Mencari nilai maksimum
        int maksimum = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > maksimum) {
                maksimum = data[i];
            }
        }
        System.out.println("Nilai maksimum: " + maksimum);
        
        // Mencari nilai minimum
        int minimum = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] < minimum) {
                minimum = data[i];
            }
        }
        System.out.println("Nilai minimum: " + minimum);
        
        // Menghitung rata-rata
        int jumlah = 0;
        for (int nilai_data : data) {
            jumlah += nilai_data;
        }
        double rata_rata = (double) jumlah / data.length;
        System.out.println("Rata-rata: " + rata_rata);
        
        // Mencari elemen tertentu
        int cari = 67;
        int indeks = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == cari) {
                indeks = i;
                break;
            }
        }
        if (indeks != -1) {
            System.out.println("Nilai " + cari + " ditemukan di indeks " + indeks);
        } else {
            System.out.println("Nilai " + cari + " tidak ditemukan");
        }
        
        // Mengurutkan array (Bubble Sort sederhana)
        int[] dataUrut = data.clone(); // Buat salinan array
        System.out.print("Sebelum diurutkan: ");
        for (int val : dataUrut) {
            System.out.print(val + " ");
        }
        System.out.println();
        
        // Bubble sort
        for (int i = 0; i < dataUrut.length - 1; i++) {
            for (int j = 0; j < dataUrut.length - 1 - i; j++) {
                if (dataUrut[j] > dataUrut[j + 1]) {
                    // Tukar posisi
                    int temp = dataUrut[j];
                    dataUrut[j] = dataUrut[j + 1];
                    dataUrut[j + 1] = temp;
                }
            }
        }
        
        System.out.print("Setelah diurutkan: ");
        for (int val : dataUrut) {
            System.out.print(val + " ");
        }
        System.out.println();
        
        System.out.println("\n=== ARRAY MULTI DIMENSI ===");
        
        // Array 2 dimensi (matriks)
        int[][] matriks = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Matriks 3x3:");
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[i].length; j++) {
                System.out.printf("%3d", matriks[i][j]);
            }
            System.out.println();
        }
        
        // Membuat array 2D dengan ukuran dinamis
        int baris = 4, kolom = 3;
        int[][] tabel = new int[baris][kolom];
        
        // Mengisi array 2D
        int nilai_counter = 1;
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                tabel[i][j] = nilai_counter++;
            }
        }
        
        System.out.println("\nTabel 4x3:");
        for (int i = 0; i < tabel.length; i++) {
            for (int j = 0; j < tabel[i].length; j++) {
                System.out.printf("%3d", tabel[i][j]);
            }
            System.out.println();
        }
        
        // Array jagged (baris dengan panjang berbeda)
        int[][] segitiga = new int[4][];
        segitiga[0] = new int[1];
        segitiga[1] = new int[2];
        segitiga[2] = new int[3];
        segitiga[3] = new int[4];
        
        // Mengisi array jagged
        for (int i = 0; i < segitiga.length; i++) {
            for (int j = 0; j < segitiga[i].length; j++) {
                segitiga[i][j] = j + 1;
            }
        }
        
        System.out.println("\nArray Jagged (Segitiga):");
        for (int i = 0; i < segitiga.length; i++) {
            for (int j = 0; j < segitiga[i].length; j++) {
                System.out.print(segitiga[i][j] + " ");
            }
            System.out.println();
        }
        
        // Array 3 dimensi
        int[][][] kubus = new int[2][2][2];
        int nilai_kubus = 1;
        
        for (int i = 0; i < kubus.length; i++) {
            for (int j = 0; j < kubus[i].length; j++) {
                for (int k = 0; k < kubus[i][j].length; k++) {
                    kubus[i][j][k] = nilai_kubus++;
                }
            }
        }
        
        System.out.println("\nArray 3D (2x2x2):");
        for (int i = 0; i < kubus.length; i++) {
            System.out.println("Layer " + i + ":");
            for (int j = 0; j < kubus[i].length; j++) {
                for (int k = 0; k < kubus[i][j].length; k++) {
                    System.out.print(kubus[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        
        System.out.println("=== CONTOH PRAKTIS ===");
        
        // Sistem nilai mahasiswa
        String[] mahasiswa = {"Alice", "Bob", "Charlie", "Diana"};
        String[] matakuliah = {"Matematika", "Fisika", "Kimia"};
        double[][] nilaiMahasiswa = {
            {85.5, 78.0, 92.0},  // Alice
            {76.5, 85.0, 78.5},  // Bob
            {92.0, 88.5, 95.0},  // Charlie
            {68.0, 72.5, 80.0}   // Diana
        };
        
        System.out.println("Laporan Nilai Mahasiswa:");
        System.out.printf("%-10s", "Nama");
        for (String mk : matakuliah) {
            System.out.printf("%12s", mk);
        }
        System.out.printf("%12s%n", "Rata-rata");
        
        for (int i = 0; i < mahasiswa.length; i++) {
            System.out.printf("%-10s", mahasiswa[i]);
            double totalNilai = 0;
            for (int j = 0; j < nilaiMahasiswa[i].length; j++) {
                System.out.printf("%12.1f", nilaiMahasiswa[i][j]);
                totalNilai += nilaiMahasiswa[i][j];
            }
            double rataRata = totalNilai / nilaiMahasiswa[i].length;
            System.out.printf("%12.1f%n", rataRata);
        }
    }
}
