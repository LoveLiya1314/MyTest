package TestCode;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test4 {
    public static void writePrimes(int n, String file) throws IOException {
        int a = 1;
        int sum = 0;
        double ave;
        HashSet<Integer> prime = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            a *= 10;
        }
        for (int i = a/10; i < a; i++) {
            boolean is = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    is = false;
                }
            }
            if (is == true) {
                prime.add(i);
                sum += i;
            }
        }
        ave = (double)sum / prime.size();
        String fname = "file.dat";
        FileOutputStream fout = new FileOutputStream(fname);
        try (ObjectOutputStream out = new ObjectOutputStream(fout)) {

            out.writeObject(prime);
            out.writeObject(ave);
        }
    }
    public static void readPrimes(String file) throws IOException, ClassNotFoundException {
        String fname = "file.dat";
        FileInputStream filein = new FileInputStream(fname);
        try (ObjectInputStream in = new ObjectInputStream(filein)) {
            HashSet<Integer> prime = (HashSet<Integer>) in.readObject();
            System.out.println("prime = " + prime);
            double ave = (double) in.readObject();
            System.out.println("ave = " + ave);
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        try {
            writePrimes(n, "Prime.dat");
        } catch (IOException ex) {
            Logger.getLogger(test4.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            readPrimes("Prime.dat");
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(test4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}