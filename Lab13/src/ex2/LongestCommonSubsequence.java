package ex2;

public class LongestCommonSubsequence {
    public static char[] lcs(String s1, String s2) {
        int[][] subMatrix = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++)
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    subMatrix[i][j] = subMatrix[i - 1][j - 1] + 1;
                else
                    subMatrix[i][j] = Math.max(subMatrix[i - 1][j], subMatrix[i][j - 1]);

            printMatrix(s1, s2, subMatrix);
        }

        char[] lcs = findSubsequence(s1, s2, subMatrix);
        printResult(s1, s2, lcs);

        return lcs;
    }

    private static void printMatrix(String s1, String s2, int[][] subMatrix) {
        System.out.print("   ");

        for (int i = 0; i < s2.length(); i++)
            System.out.print(" " + s2.charAt(i));

        System.out.println();

        for (int i = 0; i <= s1.length(); i++) {
            System.out.print(i > 0 ? s1.charAt(i - 1) + " " : "  ");

            for (int j = 0; j <= s2.length(); j++)
                System.out.print(subMatrix[i][j] + " ");

            System.out.println();
        }

        System.out.println();
    }

    private static char[] findSubsequence(String s1, String s2, int[][] subMatrix) {
        int temp = subMatrix[s1.length()][s2.length()];
        char[] lcs = new char[temp];
        int i = s1.length();
        int j = s2.length();

        while (i > 0 && j > 0)
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs[temp - 1] = s1.charAt(i - 1);

                i--;
                j--;
                temp--;
            } else if (subMatrix[i - 1][j] > subMatrix[i][j - 1])
                i--;
            else
                j--;

        return lcs;
    }

    private static void printResult(String s1, String s2, char[] lcs) {
        System.out.print("Longest common subsequence of \"" + s1 + "\" & \"" + s2 + "\": " + "\"");

        for (char lc : lcs) System.out.print(lc);

        System.out.println("\"\n\n-------------------------\n");
    }
}
