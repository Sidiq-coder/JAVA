import java.util.Scanner;

public class StrukturKontrolPercabangan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== STRUKTUR IF-ELSE ===");
        
        // Contoh IF sederhana
        int umur = 20;
        if (umur >= 18) {
            System.out.println("Anda sudah dewasa");
        }
        
        // Contoh IF-ELSE
        int nilai = 75;
        if (nilai >= 75) {
            System.out.println("Selamat! Anda lulus");
        } else {
            System.out.println("Maaf, Anda belum lulus");
        }
        
        // Contoh IF-ELSE IF-ELSE (Multiple conditions)
        int skor = 85;
        String grade;
        
        if (skor >= 90) {
            grade = "A";
        } else if (skor >= 80) {
            grade = "B";
        } else if (skor >= 70) {
            grade = "C";
        } else if (skor >= 60) {
            grade = "D";
        } else {
            grade = "E";
        }
        
        System.out.println("Skor: " + skor + " -> Grade: " + grade);
        
        // Nested IF (IF bersarang)
        boolean hujan = false;
        boolean adaPayung = true;
        
        if (hujan) {
            if (adaPayung) {
                System.out.println("Bisa jalan-jalan meski hujan");
            } else {
                System.out.println("Tunggu hujan reda");
            }
        } else {
            System.out.println("Cuaca cerah, bisa jalan-jalan");
        }
        
        System.out.println("\n=== STRUKTUR SWITCH ===");
        
        // Switch dengan integer
        int hari = 3;
        String namaHari;
        
        switch (hari) {
            case 1:
                namaHari = "Senin";
                break;
            case 2:
                namaHari = "Selasa";
                break;
            case 3:
                namaHari = "Rabu";
                break;
            case 4:
                namaHari = "Kamis";
                break;
            case 5:
                namaHari = "Jumat";
                break;
            case 6:
                namaHari = "Sabtu";
                break;
            case 7:
                namaHari = "Minggu";
                break;
            default:
                namaHari = "Hari tidak valid";
                break;
        }
        
        System.out.println("Hari ke-" + hari + " adalah: " + namaHari);
        
        // Switch dengan String
        String bulan = "Januari";
        int jumlahHari;
        
        switch (bulan) {
            case "Januari":
            case "Maret":
            case "Mei":
            case "Juli":
            case "Agustus":
            case "Oktober":
            case "Desember":
                jumlahHari = 31;
                break;
            case "April":
            case "Juni":
            case "September":
            case "November":
                jumlahHari = 30;
                break;
            case "Februari":
                jumlahHari = 28; // atau 29 untuk tahun kabisat
                break;
            default:
                jumlahHari = 0;
                System.out.println("Bulan tidak valid");
                break;
        }
        
        if (jumlahHari > 0) {
            System.out.println("Bulan " + bulan + " memiliki " + jumlahHari + " hari");
        }
        
        // Switch dengan char
        char operator = '+';
        double a = 10.5;
        double b = 3.2;
        double hasil = 0;
        
        switch (operator) {
            case '+':
                hasil = a + b;
                System.out.println(a + " + " + b + " = " + hasil);
                break;
            case '-':
                hasil = a - b;
                System.out.println(a + " - " + b + " = " + hasil);
                break;
            case '*':
                hasil = a * b;
                System.out.println(a + " × " + b + " = " + hasil);
                break;
            case '/':
                if (b != 0) {
                    hasil = a / b;
                    System.out.println(a + " ÷ " + b + " = " + hasil);
                } else {
                    System.out.println("Error: Pembagian dengan nol!");
                }
                break;
            default:
                System.out.println("Operator tidak dikenali");
                break;
        }
        
        System.out.println("\n=== CONTOH INTERAKTIF ===");
        System.out.print("Masukkan nilai (0-100): ");
        int nilaiInput = input.nextInt();
        
        // Validasi input
        if (nilaiInput < 0 || nilaiInput > 100) {
            System.out.println("Nilai harus antara 0-100");
        } else {
            // Menentukan predikat berdasarkan nilai
            String predikat;
            if (nilaiInput >= 85) {
                predikat = "Sangat Baik";
            } else if (nilaiInput >= 70) {
                predikat = "Baik";
            } else if (nilaiInput >= 55) {
                predikat = "Cukup";
            } else {
                predikat = "Kurang";
            }
            
            System.out.println("Nilai: " + nilaiInput);
            System.out.println("Predikat: " + predikat);
            
            // Pesan tambahan menggunakan ternary operator
            String pesan = (nilaiInput >= 60) ? "Selamat, Anda lulus!" : "Belajar lebih giat lagi!";
            System.out.println(pesan);
        }
        
        input.close();
    }
}
