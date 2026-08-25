import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            int n = s.length();
            int mid = n / 2;

            int[] freq = new int[26];

            // Count characters in the first half
            for (int i = 0; i < mid; i++) {
                freq[s.charAt(i) - 'a']++;
            }

            // Subtract characters in the second half
            for (int i = (n + 1) / 2; i < n; i++) {
                freq[s.charAt(i) - 'a']--;
            }

            boolean isLapindrome = true;

            for (int count : freq) {
                if (count != 0) {
                    isLapindrome = false;
                    break;
                }
            }

            System.out.println(isLapindrome ? "YES" : "NO");
        }

        sc.close();
    }
}