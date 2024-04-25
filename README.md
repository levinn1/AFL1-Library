Perpustakaan - Library Management System
This project implements a simple library management system in Java. It allows users to login as students (Mahasiswa), faculty (Dosen), or librarians (Pustakawan) and perform basic library actions.

Features:

User Login with different roles (Mahasiswa, Dosen, Pustakawan)
Students can borrow books and view book data
Faculty can borrow CDs and view CD data (functionality can be extended)
Librarians (future functionality) can manage the library (add/remove books/CDs, etc.)
Project Structure:

The project consists of eight separate Java classes:

Buku.java: Represents a book with title (judul), year (tahun), and author (pengarang) information.
CD.java: Represents a CD with title (judul), year (tahun), and publisher (penerbit) information.
Dosen.java: Stores faculty member data with name (nama) and employee ID (NIK).
Mahasiswa.java: Stores student data with name (nama) and student ID (NIM).
Penerbit.java: Stores publisher data with name (nama).
Pengarang.java: Stores author data with name (nama).
Pustakawan.java: Stores librarian data with username and password (functionality not yet implemented).
Main.java: The main program class handling user interaction, login, and menu options.
Running the Program:

Compile the Java files using a Java compiler (e.g., javac Main.java Buku.java CD.java ...).
Run the program using Main.java
Pre-defined Data:

The code includes pre-defined data for books, CDs, students, faculty, and librarians for testing purposes. This data is stored in the respective class constructors within the static block of the Main.java class.

Note:

The librarian functionality is currently not implemented but can be extended in the future to include library management features.

Output:

The program uses a file named "output.txt" to store login success/failure messages for librarians and students (if login fails).
