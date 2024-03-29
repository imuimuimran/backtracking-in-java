public class printAllPermutations {
    public static void printPermutation(String str, String permutation, int idx) {
        if(str.length() == 0) {
            System.out.println(permutation);
            return;
        }
        for(int i = 0; i < str.length(); i++) {
            char crrChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPermutation(newStr, permutation + crrChar, idx + 1);
        }
    }

    public static void main(String[] args) {
        String str = "ABC";

        printPermutation(str, "", 0);
    }
}