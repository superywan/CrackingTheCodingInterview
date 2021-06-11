public class IsUnique {
    public static void main(String[] args) {
        System.out.println(isUnique("abcd"));
    }

    public static boolean isUnique(String str) {
        int bitVector = 0;
        for (char c : str.toCharArray()) {
            int val = c - 'a';
            if ((bitVector & (1 << val)) > 0) {
                return false;
            }
            bitVector |= (1 << val);
        }
        return true;
    }

    public static boolean isUniqueCharSet(String str) {
        if (str > 128) return false;
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }
}
