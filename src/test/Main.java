package test;

import java.util.Scanner;

public class Main {

    public static int factorial(int n) {
        int result = 1;
        for(int i = 2 ; i <= n; i++){
            result += i;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        for(int i = 0; i < count; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println(factorial(n) / (factorial(m-n)*factorial(n)));

        }

        sc.close();
    }
}