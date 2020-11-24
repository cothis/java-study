package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static class StringSearch {
        public StringSearch() {
            System.out.println("String Search Test");
            List<Integer> searched = search("hello nice to meet nice you", "nice");
            System.out.println(searched);
            System.out.println();

        }

        List<Integer> search(String whole, String part) {
            int wholeLength = whole.length();
            int partLength = part.length();

            List<Integer> result = new LinkedList<>();

            for(int i = 0 ; i <  wholeLength - partLength; i++){
                if (whole.substring(i, i + partLength).equals(part)) {
                    result.add(i);
                }
            }


            return result;
        }
    }

    static class LongestCommonSubstring {
        private LongestCommonSubstring() {
            System.out.println("Longest Common Substring Test");
            int a = calcLcs("ABCACDFD", "AECD");
            System.out.println(a);
        }


        private int calcLcs(String x, String y) {
            int answer = 0;
            x = "\0" + x;
            y = "\0" + y;
            int[][] LCS = new int[x.length()][y.length()];

            for(int i = 1; i < x.length(); i++) {
                for(int j = 1; j < y.length(); j++) {
                    if(x.charAt(i) == y.charAt(j)) {
                        LCS[i][j] = LCS[i-1][j-1] + 1;

                        if(answer < LCS[i][j]) {
                            answer = LCS[i][j];
                        }
                    }
                }
            }
            return answer;
        }
    }

    static class CutRod {
        private CutRod() {
            System.out.println("Cut Rod Test");
            int[] price = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };

            System.out.println(cutRod(price, 2));
            System.out.println(cutRod(price, 3));
            System.out.println(cutRod(price, 4));
            System.out.println(cutRod(price, 7));
            System.out.println();
        }
        private int cutRod(int[] p, int n) {
            int[] r = new int[n+1];

            for(int i = 1; i <= n; i++) {
                int q = -1;
                for(int j = 1; j <= i; j++) {
                    q = Math.max(q, p[j] + r[i - j]);
                }
                r[i] = q;
            }
            return r[n];
        }
    }

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        for(int i = 0; i <= 30; i++) {
            list1.add(i);
        }

        List<Integer> list2 = list1.stream().filter(el -> el > 15).collect(Collectors.toList());
        System.out.println(list1);
        System.out.println(list2);

        /*
        Main main = new Main();

        new StringSearch();

        new CutRod();

        new LongestCommonSubstring();
        /**/

    }
}
