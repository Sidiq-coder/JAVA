// Input dan Output dalam Java
// File ini mendemonstrasikan berbagai cara input dan output di Java

import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputOutput {
    public static void main(String[] args) {
        
        System.out.println("=== INPUT DAN OUTPUT DALAM JAVA ===");
        
        // Scanner untuk input dari user
        Scanner input = new Scanner(System.in);
        
        System.out.println("\n=== BASIC OUTPUT ===");
        
        // Output dasar menggunakan System.out
        System.out.println("Ini adalah output dengan println()");
        System.out.print("Ini dengan print() ");
        System.out.print("(tanpa new line) ");
        System.out.println("Dan ini dengan println() lagi");
        
        // Output dengan format
        String nama = "Budi";
        int umur = 25;
        double tinggi = 175.5;
        
        System.out.println("\n=== FORMATTED OUTPUT ===");
        
        // Menggunakan printf() untuk format output
        System.out.printf("Nama: %s%n", nama);
        System.out.printf("Umur: %d tahun%n", umur);
        System.out.printf("Tinggi: %.1f cm%n", tinggi);
        
        // Format angka
        int angka = 1000000;
        double desimal = 3.14159;
        
        System.out.printf("Angka: %,d%n", angka);           // Dengan pemisah ribuan
        System.out.printf("Desimal: %.2f%n", desimal);      // 2 digit di belakang koma
        System.out.printf("Persen: %.1f%%%n", 85.5);        // Format persen
        
        // Format dengan lebar field
        System.out.printf("%-10s | %5d | %8.2f%n", "Alice", 22, 168.7);
        System.out.printf("%-10s | %5d | %8.2f%n", "Bob", 30, 180.0);
        System.out.printf("%-10s | %5d | %8.2f%n", "Charlie", 27, 175.5);
        
        System.out.println("\n=== BASIC INPUT ===");
        
        // Input string
        System.out.print("Masukkan nama Anda: ");
        String namaUser = input.nextLine();
        
        // Input integer
        System.out.print("Masukkan umur Anda: ");
        int umurUser = input.nextInt();
        
        // Input double
        System.out.print("Masukkan tinggi badan (cm): ");
        double tinggiUser = input.nextDouble();
        
        // Membersihkan buffer setelah nextInt/nextDouble
        input.nextLine();
        
        // Input char
        System.out.print("Masukkan jenis kelamin (L/P): ");
        char jenisKelamin = input.nextLine().charAt(0);
        
        // Menampilkan hasil input
        System.out.println("\n=== HASIL INPUT ===");
        System.out.println("Nama: " + namaUser);
        System.out.println("Umur: " + umurUser + " tahun");
        System.out.println("Tinggi: " + tinggiUser + " cm");
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        
        System.out.println("\n=== INPUT DENGAN VALIDASI ===");
        
        // Input dengan validasi
        int nilai;
        do {
            System.out.print("Masukkan nilai (0-100): ");
            nilai = input.nextInt();
            if (nilai < 0 || nilai > 100) {
                System.out.println("Nilai harus antara 0-100!");
            }
        } while (nilai < 0 || nilai > 100);
        
        String grade;
        if (nilai >= 85) grade = "A";
        else if (nilai >= 70) grade = "B";
        else if (nilai >= 55) grade = "C";
        else if (nilai >= 40) grade = "D";
        else grade = "E";
        
        System.out.println("Nilai: " + nilai + " -> Grade: " + grade);
        
        System.out.println("\n=== INPUT MULTIPLE DATA ===");
        
        input.nextLine(); // Membersihkan buffer
        
        System.out.print("Masukkan beberapa angka (pisahkan dengan spasi): ");
        String inputAngka = input.nextLine();
        String[] arrayAngka = inputAngka.split(" ");
        
        System.out.println("Angka yang dimasukkan:");
        int total = 0;
        for (int i = 0; i < arrayAngka.length; i++) {
            try {
                int angkaInt = Integer.parseInt(arrayAngka[i]);
                System.out.println((i + 1) + ". " + angkaInt);
                total += angkaInt;
            } catch (NumberFormatException e) {
                System.out.println((i + 1) + ". \"" + arrayAngka[i] + "\" bukan angka valid");
            }
        }
        System.out.println("Total: " + total);
        
        System.out.println("\n=== FORMATTING DENGAN DECIMALFORMAT ===");
        
        // Menggunakan DecimalFormat untuk format angka
        DecimalFormat df1 = new DecimalFormat("#,###.##");
        DecimalFormat df2 = new DecimalFormat("0.00%");
        DecimalFormat df3 = new DecimalFormat("Rp #,###");
        
        double angkaBesar = 1234567.89;
        double persentase = 0.856;
        double harga = 150000;
        
        System.out.println("Angka besar: " + df1.format(angkaBesar));
        System.out.println("Persentase: " + df2.format(persentase));
        System.out.println("Harga: " + df3.format(harga));
        
        System.out.println("\n=== FORMAT TANGGAL DAN WAKTU ===");
        
        // Format tanggal
        Date sekarang = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        System.out.println("Format 1: " + sdf1.format(sekarang));
        System.out.println("Format 2: " + sdf2.format(sekarang));
        System.out.println("Format 3: " + sdf3.format(sekarang));
        
        System.out.println("\n=== CONTOH APLIKASI KALKULATOR ===");
        
        // Aplikasi kalkulator sederhana
        System.out.println("=== KALKULATOR SEDERHANA ===");
        System.out.print("Masukkan angka pertama: ");
        double num1 = input.nextDouble();
        
        System.out.print("Masukkan operator (+, -, *, /): ");
        char operator = input.next().charAt(0);
        
        System.out.print("Masukkan angka kedua: ");
        double num2 = input.nextDouble();
        
        double hasil = 0;
        boolean validOperator = true;
        
        switch (operator) {
            case '+':
                hasil = num1 + num2;
                break;
            case '-':
                hasil = num1 - num2;
                break;
            case '*':
                hasil = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    hasil = num1 / num2;
                } else {
                    System.out.println("Error: Pembagian dengan nol!");
                    validOperator = false;
                }
                break;
            default:
                System.out.println("Operator tidak valid!");
                validOperator = false;
                break;
        }
        
        if (validOperator) {
            System.out.printf("%.2f %c %.2f = %.2f%n", num1, operator, num2, hasil);
        }
        
        System.out.println("\n=== CONTOH PROGRAM BIODATA ===");
        
        input.nextLine(); // Membersihkan buffer
        
        // Program input biodata lengkap
        System.out.println("=== INPUT BIODATA ===");
        System.out.print("Nama lengkap: ");
        String namaLengkap = input.nextLine();
        
        System.out.print("Tempat lahir: ");
        String tempatLahir = input.nextLine();
        
        System.out.print("Tanggal lahir (dd/mm/yyyy): ");
        String tanggalLahir = input.nextLine();
        
        System.out.print("Alamat: ");
        String alamat = input.nextLine();
        
        System.out.print("Nomor telepon: ");
        String noTelp = input.nextLine();
        
        System.out.print("Email: ");
        String email = input.nextLine();
        
        System.out.print("Pekerjaan: ");
        String pekerjaan = input.nextLine();
        
        // Menampilkan biodata dengan format yang rapi
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                 BIODATA DIRI");
        System.out.println("=".repeat(50));
        System.out.printf("%-15s: %s%n", "Nama", namaLengkap);
        System.out.printf("%-15s: %s%n", "Tempat Lahir", tempatLahir);
        System.out.printf("%-15s: %s%n", "Tanggal Lahir", tanggalLahir);
        System.out.printf("%-15s: %s%n", "Alamat", alamat);
        System.out.printf("%-15s: %s%n", "No. Telepon", noTelp);
        System.out.printf("%-15s: %s%n", "Email", email);
        System.out.printf("%-15s: %s%n", "Pekerjaan", pekerjaan);
        System.out.println("=".repeat(50));
        
        System.out.println("\n=== MENU INTERAKTIF ===");
        
        // Contoh menu interaktif
        boolean running = true;
        while (running) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Hitung Luas Persegi");
            System.out.println("2. Hitung Luas Lingkaran");
            System.out.println("3. Konversi Suhu");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            
            int pilihan = input.nextInt();
            
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan sisi persegi: ");
                    double sisi = input.nextDouble();
                    double luasPersegi = sisi * sisi;
                    System.out.printf("Luas persegi: %.2f%n", luasPersegi);
                    break;
                    
                case 2:
                    System.out.print("Masukkan jari-jari lingkaran: ");
                    double radius = input.nextDouble();
                    double luasLingkaran = Math.PI * radius * radius;
                    System.out.printf("Luas lingkaran: %.2f%n", luasLingkaran);
                    break;
                    
                case 3:
                    System.out.print("Masukkan suhu dalam Celsius: ");
                    double celsius = input.nextDouble();
                    double fahrenheit = (celsius * 9/5) + 32;
                    double kelvin = celsius + 273.15;
                    System.out.printf("%.1f°C = %.1f°F = %.1f K%n", celsius, fahrenheit, kelvin);
                    break;
                    
                case 4:
                    System.out.println("Terima kasih telah menggunakan program ini!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
        
        System.out.println("\n=== FILE OUTPUT (BONUS) ===");
        
        // Contoh menulis ke file (opsional)
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write("Hasil Program Java\n");
            writer.write("==================\n");
            writer.write("Nama: " + namaUser + "\n");
            writer.write("Umur: " + umurUser + "\n");
            writer.write("Tinggi: " + tinggiUser + "\n");
            writer.write("Nilai: " + nilai + " (Grade: " + grade + ")\n");
            writer.close();
            System.out.println("Data berhasil disimpan ke file 'output.txt'");
        } catch (IOException e) {
            System.out.println("Error saat menulis file: " + e.getMessage());
        }
        
        // Menutup scanner
        input.close();
        
        System.out.println("\n=== PROGRAM SELESAI ===");
        System.out.println("Terima kasih telah belajar Input/Output Java!");
    }
}
