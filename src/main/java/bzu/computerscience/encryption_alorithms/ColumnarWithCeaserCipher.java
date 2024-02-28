package bzu.computerscience.encryption_alorithms;

public class ColumnarWithCeaserCipher {
    public static String encrypt(String str, int key) {
        String cipher = "";
        String res = CeaserCipherVowel.encrypt(str, key);
        cipher = ColumnarCipher.encrypt(res, String.valueOf(key));
        return cipher;
    }

    public static String decrypt(String str, int key) {
        String decryptedText = "";
        String res = CeaserCipherVowel.decrypt(str, key);
        decryptedText = ColumnarCipher.decryptFX(res, String.valueOf(key));
        return decryptedText;
    }
}
