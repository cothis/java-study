package day018.baseball_singleton;

import java.util.Scanner;

public class ScannerSingle {
    public Scanner sc;

    private ScannerSingle() {
        sc = new Scanner(System.in);
    }
    static class ScannerLoader {
        private static final ScannerSingle scanner = new ScannerSingle();
    }

    public static Scanner getScanner() {
        return ScannerLoader.scanner.sc;
    }
}