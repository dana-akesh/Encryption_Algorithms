package bzu.computerscience.encryption_alorithms;

public class RailColumnCeaser {
    public static String encrypt(String str, int key) {
        String cipher = "";
        String res = CeaserCipherVowel.encrypt(str, key);
        String finalres = ColumnarCipher.encrypt(res, String.valueOf(key));
        cipher = RailFenceCipher.encrypt(finalres, key);
        return cipher;
    }

    public static String decrypt(String str, int key) {
        String decryptedText = "";
        String res = RailFenceCipher.decrypt(str, key);
        String finalres = ColumnarCipher.decryptFX(res, String.valueOf(key));
        decryptedText = CeaserCipherVowel.decrypt(finalres, key);
        return decryptedText;
    }
}
