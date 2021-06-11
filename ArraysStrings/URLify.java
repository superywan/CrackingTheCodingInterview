public class URLify {
    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith     ", 13));
    }

    public static String urlify(String str, int trueLength) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < trueLength; i++) {
            if (str.charAt(i) == ' ') {
                result.append("%20");
            } else {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    public static String urlifyCharArr(char[] str, int trueLength) {
        int spaceCount = 0;
        int index;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        index = trueLength + spaceCount * 2; 
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
        return str.toString();
    }
}
