public class OneAway {
    public static void main(String[] args) {
        System.out.println(isOneAway("pale", "ple"));
        System.out.println(isOneAway("pales", "pale"));
        System.out.println(isOneAway("pale", "bale"));
        System.out.println(isOneAway("pale", "bae"));
    }
    
    public static boolean isOneAway(String first, String second) {
        if (first.length() == second.length()) {
            return checkEdit(first, second);
        } else if (first.length() + 1 == second.length()) {
            return checkEdit(first, second);
        } else if (first.length() - 1 == second.length()) {
            return checkEdit(first, second);
        } 
        return false;
    }

    public static boolean checkEdit(String first, String second) {
        String shortString = first.length() < second.length() ? first : second;
        String longString = first.length() > second.length() ? first : second;

        boolean foundDiff = false;
        int firstIndex = 0;
        int secondIndex = 0;

        while (firstIndex != first.length() && secondIndex != second.length()) {
            if (shortString.charAt(firstIndex) != longString.charAt(secondIndex)) {
                if (foundDiff) return false;
                foundDiff = true;
                if (firstIndex != secondIndex) {
                    return false;
                }
                secondIndex++;
            } else {
                firstIndex++;
                secondIndex++;
            }
        }
        return true;
    }
    
    /*
    public static boolean checkEditReplace(String first, String second) {
        boolean foundDiff = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDiff) {
                    return false;
                }
                foundDiff = true;
            }
        }
        return true;
    }

    public static boolean checkEditInsert(String first, String second) {
        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex != first.length() && secondIndex != second.length()) {
            if (first.charAt(firstIndex) != second.charAt(secondIndex)) {
                if (firstIndex != secondIndex) {
                    return false;
                } else {
                    secondIndex++;
                }
            } else {
                firstIndex++;
                secondIndex++;
            }
        }
        return true;
    }
    */
}
