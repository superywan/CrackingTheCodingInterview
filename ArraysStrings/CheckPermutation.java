public class CheckPermutation {
    public static void main(String[] args) {
        System.out.println(checkPermutation("old", "dol"));
        System.out.println(checkPermutation("oldd", "old"));
        System.out.println(checkPermutationArray("old", "dol"));
    }

    public static boolean checkPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        return sort(str1).equals(sort(str2)); 
    }

    public static String sort(String str) {
        char[] content = str.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public static boolean checkPermutationArray(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        int[] char_set = new int[128];
        for (char c : str1.toCharArray()) {
            char_set[c]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            char_set[str2.charAt(i)]--;
            if (char_set[str2.charAt(i)] < 0) return false;
        }

        return true;
    }
}
