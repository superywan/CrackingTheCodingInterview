public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(isPermutationOfPalindrome("Tact Coa"));

    }

    public static boolean isPermutationOfPalindrome(String str) {
        int bitVector = 0;
        for (char c : str.toCharArray()) {
            int val = getCharIndex(c);
            bitVector = toggle(bitVector, val);
        }
        return bitVector == 0 || (bitVector & (bitVector -1)) == 0; 
    }

    public static int getCharIndex(char c) {
        int curr = Character.getNumericValue(c);
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        if (a <= curr && curr <= z) {
            return curr - a;
        }
        return -1;
    }

    public static int toggle(int bitVector, int val) {
        if (val < 0) return bitVector;
        int mask = 1 << val;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }
}
