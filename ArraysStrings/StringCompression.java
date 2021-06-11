public class StringCompression {
    public static void main(String[] args) {
        System.out.println(stringCompression("aaabbcccc"));
    }
    
    public static String stringCompression(String str) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                result.append(str.charAt(i));
                result.append(count);
                count = 0;
            }
        }
        return result.toString();
    }
}
