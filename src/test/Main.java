package test;

import java.util.Scanner;

public class Main {
    public static long factorial(long start, long n) {
        long result = 1;
        for(long i = start ; i <= n; i++){
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        for(int i = 0; i < count; i++) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            System.out.println(factorial(m-n + 1, m)/factorial(2, n));

        }

        sc.close();
    }
}