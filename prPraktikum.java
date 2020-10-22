import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class prPraktikum {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int choice;
        double rata;
        boolean exit = true;
        do {
            System.out.println(".:MENU:.");
            System.out.println(" 1. Input Mahasiswa");
            System.out.println(" 2. View Mahasiswa");
            System.out.println(" 3. Exit");
            System.out.println("Pilihan: ");
            choice = input.nextInt();
            int kaliEnter = 1;
            double antono = 0;
            switch (choice) {
                case 1:
                    input.nextLine();
                    FileWriter write = new FileWriter("file.txt", true);
                    System.out.print("Nama Mahasiswa: ");
                    String nama = input.nextLine();
                    System.out.print("NRP: ");
                    String nrp = input.nextLine();
                    System.out.print("IPK: ");
                    Double ipk = input.nextDouble();
                    antono = ipk;
                    input.nextLine();
                    System.out.println("Apakah anda ingin menambahkan data mahasiswa ke dalam file?(Y/N)");
                    String YatauN = input.nextLine();
                    String Y = "Y";
                    if (YatauN.equalsIgnoreCase(Y)) {
                        write.append("Nama Mahasiswa: " + nama + "\n" +
                                "NRP: " + nrp + "\n" +
                                "IPK: \n" + ipk + "\n");
                    } else {
                        break;
                    }

                    write.close();
                    exit = true;
                    break;
                case 2:
                    double d;
                    double total = 0;
                    int counterPembagiIPK = 0;
                    File file = new File("file.txt");
                    Scanner sc = null;
                    try {
                        sc = new Scanner(file);
                        while (sc.hasNext()) {

                            System.out.println(sc.nextLine());
                            System.out.println(sc.nextLine());
                            System.out.println(sc.nextLine());
                            d = Double.parseDouble(sc.nextLine());
                            System.out.println(d);
                            if (d >= 0) {
                                counterPembagiIPK++;
                                total += d;
                                System.out.println(total);
                                System.out.println(counterPembagiIPK);
                            }
                        }

                        double average = total / counterPembagiIPK;
                        System.out.println("Rata - rata IPK : " + average);
                        sc.close();
                    } catch (NumberFormatException e) {
                        System.out.println("haiz");
                    }

                    exit = true;
                    break;
                case 3:
                    System.out.println("Anda berhasil keluar");
                    exit = false;
                    break;
            }
        } while (exit);
    }
}