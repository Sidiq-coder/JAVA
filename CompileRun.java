// Kompilasi dan Menjalankan Program Java
// Panduan lengkap untuk compile dan run program Java

/*
=== CARA COMPILE DAN RUN PROGRAM JAVA ===

1. PRASYARAT:
   - Install Java Development Kit (JDK)
   - Set environment variable JAVA_HOME dan PATH
   - Buka Command Prompt atau Terminal

2. STRUKTUR FILE:
   - File Java harus berekstensi .java
   - Nama file harus sama dengan nama class public
   - Contoh: HelloWorld.java harus berisi "public class HelloWorld"

3. LANGKAH-LANGKAH:

   A. COMPILE (Mengubah .java menjadi .class):
      javac NamaFile.java
      
      Contoh:
      javac HelloWorld.java
      
      Hasil: File HelloWorld.class akan terbuat

   B. RUN (Menjalankan program):
      java NamaClass
      
      Contoh:
      java HelloWorld
      
      Note: Tidak perlu ekstensi .class

4. CONTOH LENGKAP:

   File: HelloWorld.java
   ```java
   public class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Hello, World!");
       }
   }
   ```
   
   Command:
   javac HelloWorld.java    // Compile
   java HelloWorld          // Run

5. COMPILE MULTIPLE FILES:
   javac *.java            // Compile semua file .java
   javac File1.java File2.java File3.java    // Compile file tertentu

6. MENJALANKAN DENGAN PARAMETER:
   java HelloWorld param1 param2
   
   Parameter dapat diakses melalui args[] dalam method main

7. CLASSPATH:
   - Jika file .class ada di folder lain:
   java -cp /path/to/classes HelloWorld
   
   - Jika menggunakan library eksternal:
   java -cp "lib/*:." HelloWorld

8. TROUBLESHOOTING UMUM:

   Error: "javac is not recognized"
   Solusi: Install JDK dan set PATH

   Error: "Could not find or load main class"
   Solusi: Pastikan nama class sama dengan nama file

   Error: "Exception in thread main"
   Solusi: Ada error dalam kode program

   Error: "class not found"
   Solusi: Pastikan file .class ada dan nama class benar

9. TIPS:
   - Selalu compile ulang setelah mengubah kode
   - Gunakan IDE seperti VS Code, IntelliJ, atau Eclipse untuk kemudahan
   - File .class dapat dihapus dan di-compile ulang
   - Java case-sensitive (HelloWorld ≠ helloworld)

=== CONTOH BATCH SCRIPT UNTUK WINDOWS ===

Buat file run.bat:
@echo off
echo Compiling Java files...
javac *.java
if %errorlevel% equ 0 (
    echo Compilation successful!
    echo Running program...
    java HelloWorld
) else (
    echo Compilation failed!
)
pause

=== CONTOH BASH SCRIPT UNTUK LINUX/MAC ===

Buat file run.sh:
#!/bin/bash
echo "Compiling Java files..."
javac *.java
if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo "Running program..."
    java HelloWorld
else
    echo "Compilation failed!"
fi

Berikan permission: chmod +x run.sh
Jalankan: ./run.sh
*/

// Contoh program sederhana untuk testing compile dan run
public class CompileRun {
    public static void main(String[] args) {
        System.out.println("=== TEST COMPILE DAN RUN ===");
        System.out.println("Program ini berhasil di-compile dan dijalankan!");
        
        // Menampilkan informasi system
        System.out.println("\nInformasi System:");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("OS Name: " + System.getProperty("os.name"));
        System.out.println("OS Version: " + System.getProperty("os.version"));
        System.out.println("User Name: " + System.getProperty("user.name"));
        System.out.println("User Home: " + System.getProperty("user.home"));
        System.out.println("Working Directory: " + System.getProperty("user.dir"));
        
        // Menampilkan parameter command line
        if (args.length > 0) {
            System.out.println("\nParameter yang diterima:");
            for (int i = 0; i < args.length; i++) {
                System.out.println("args[" + i + "] = " + args[i]);
            }
        } else {
            System.out.println("\nTidak ada parameter yang diberikan.");
            System.out.println("Coba jalankan: java CompileRun param1 param2");
        }
        
        System.out.println("\n=== SELESAI ===");
    }
}
