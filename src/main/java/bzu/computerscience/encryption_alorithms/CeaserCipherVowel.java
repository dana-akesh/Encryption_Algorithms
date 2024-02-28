package bzu.computerscience.encryption_alorithms;

public class CeaserCipherVowel {
    public static void main(String[] args) {
        String text = "Meet me by the lake at midnight. Bring shovel. We will dig up the treasure.";
        int s = 5;

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
        char[] charArray = consonantCharacterSet();
        for (int i = 0; i < charArray.length; i++) {
            if (c == charArray[i]) {
                return charArray[(i + key) % 118];
            }
        }
        return c;
    }

    public static char decodeConsonant(char c, int key) {
        char[] charArray = consonantCharacterSet();
        for (int i = 0; i < charArray.length; i++) {
            if (c == charArray[i]) {
                return charArray[(i - key + 118) % 118];
            }
        }
        return c;
    }

    public static char[] consonantCharacterSet() {
        char[] allCharacters = new char[128];
        for (char c = 0; c < 128; c++) {
            allCharacters[c] = c;
        }
        char[] excludedCharacters = {'A', 'U', 'O', 'E', 'I', 'a', 'u', 'o', 'e', 'i'};
        char[] resultArray = removeVowel(allCharacters, excludedCharacters);
        return resultArray;
    }

    private static char[] removeVowel(char[] sourceArray, char[] charactersToRemove) {
        StringBuilder result = new StringBuilder();
        for (char c : sourceArray) {
            boolean isExcluded = false;
            for (char excludedChar : charactersToRemove) {
                if (c == excludedChar) {
                    isExcluded = true;
                    break;
                }
            }
            if (!isExcluded) {
                result.append(c);
            }
        }
        char[] resultArray = new char[result.length()];
        result.getChars(0, result.length(), resultArray, 0);
        return resultArray;
    }

    public static boolean isVowel(char c) {
        return c == 'A' || c == 'a' || c == 'U' || c == 'u' || c == 'O' || c == 'o' || c == 'E' || c == 'e' || c == 'I' || c == 'i';
    }

}
