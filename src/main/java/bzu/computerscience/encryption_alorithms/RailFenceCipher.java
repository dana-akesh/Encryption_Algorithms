package bzu.computerscience.encryption_alorithms;

public class RailFenceCipher {
    public static void main(String[] args) {
        String text = "Istabraq";
        int s = 2;

        System.out.println("Plain Text  : " + text);
        System.out.println("Key : " + s);
        String encryptedText = encrypt(text, s);
        System.out.println("Cipher Text: " + encryptedText);
        String decryptedText = decrypt(encryptedText, s);
        System.out.println("Plain Text After Decryption: " + decryptedText);
    }

    public static String encrypt(String str, int key) {
        String cipher = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isVowel(ch)) {
                cipher = cipher + encodeVowel(ch, key);
            } else {
                cipher = cipher + encodeConsonant(ch, key);
            }
        }
        return cipher;
    }

    public static String decrypt(String str, int key) {
        String decryptedText = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isVowel(ch)) {
                decryptedText = decryptedText + decodeVowel(ch, key);
            } else {
                decryptedText = decryptedText + decodeConsonant(ch, key);
            }
        }
        return decryptedText;
    }

    public static char encodeVowel(char c, int key) {
        char[] charArray = {'A', 'U', 'O', 'E', 'I', 'a', 'u', 'o', 'e', 'i'};
        for (int i = 0; i < charArray.length; i++) {
            if (c == charArray[i]) {
                return charArray[(i + key) % 10];
            }
        }
        return c;
    }

    public static char decodeVowel(char c, int key) {
        char[] charArray = {'A', 'U', 'O', 'E', 'I', 'a', 'u', 'o', 'e', 'i'};
        for (int i = 0; i < charArray.length; i++) {
            if (c == charArray[i]) {
                return charArray[(i - key + 10) % 10];
            }
        }
        return c;
    }

    public static char encodeConsonant(char c, int key) {
        char[] charArray = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
                            'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y',
                            'Z', 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
                            'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x',
                            'y', 'z'};
        for (int i = 0; i < charArray.length; i++) {
            if (c == charArray[i]) {
                return charArray[(i + key) % 42];
            }
        }
        return c;
    }

    public static char decodeConsonant(char c, int key) {
        char[] charArray = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
                            'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y',
                            'Z', 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
                            'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x',
                            'y', 'z'};
        for (int i = 0; i < charArray.length; i++) {
            if (c == charArray[i]) {
                return charArray[(i - key + 42) % 42];
            }
        }
        return c;
    }

    public static boolean isVowel(char c) {
        char[] charArray = {'A', 'U', 'O', 'E', 'I', 'a', 'u', 'o', 'e', 'i'};
        for (int i = 0; i < charArray.length; i++) {
            if (c == charArray[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean isConsonant(char c) {
        char[] charArray = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
                            'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y',
                            'Z', 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
                            'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x',
                            'y', 'z'};
        for (int i = 0; i < charArray.length; i++) {
            if (c == charArray[i]) {
                return true;
            }
        }
        return false;
    }
}
