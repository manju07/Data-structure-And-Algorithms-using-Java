package datastructure.string;

/**
 * Minimize the string
 * @author Manjunath Asundi
 */
public class EncryptString {

    public static String encryptStringUtil(String string) {
        StringBuilder encryptedString = new StringBuilder();
        int j;
        for (int i = 0; i < string.length(); i = j) {
            j = i + 1;
            while (j < string.length() && string.charAt(i) == string.charAt(j))
                j++;
            if ((j - i) > 1)
                encryptedString.append("" + (j - i) + string.charAt(i));
            else
                encryptedString.append("" + string.charAt(i));
        }
        return encryptedString.toString();
    }

    public static void main(String[] args) {
        String string = "aaaaaaaaaabbbcccbbaaabc";
        System.out.println("Input String: " + string);
        System.out.println("Output String: " + encryptStringUtil(string));
    }
}