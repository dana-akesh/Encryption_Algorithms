package bzu.computerscience.encryption_alorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColumnarCipher {
    public static void main(String[] args) {
        String plainText = "meet me by the lake";
        String key = "321";
        String cipherText = encrypt(plainText, key);
        System.out.println("Encrypted text: " + cipherText);
        decrypt(cipherText, key);
    }

    public static String encrypt(String text, String key) {

        List<List<Character>> matrix = new ArrayList<>(); //2d list

        int pointer = 0;//index
        // # of columns
        int col = (int) Math.ceil((double) text.replaceAll("\\s+", "").length() / key.length());

        for (int i = 0; i <= col; i++) {
            List<Character> temp = new ArrayList<>();
            for (int j = 0; j < key.length(); j++) {
                if (pointer < text.length()) {
                    temp.add(text.charAt(pointer));
                    pointer++;
                } else {
                    temp.add('_');
                }
            }
            matrix.add(temp);
        }

        StringBuilder encryptedText = new StringBuilder();
        List<Character> keyList = new ArrayList<>();
        for (char c : key.toCharArray()) {
            keyList.add(c);
        }
        Collections.sort(keyList);

        for (char i : keyList) {
            int index = key.indexOf(i);
            for (List<Character> characters : matrix) {
                encryptedText.append(characters.get(index));
            }
        }

        StringBuilder matrixString = new StringBuilder();

        System.out.println("Encrypted matrix: ");
        for (List<Character> row : matrix) {
            System.out.println(row);
            matrixString.append(row).append("\n");
        }

        return encryptedText + "\n" + matrixString;
    }

    public static void decrypt(String text, String key) {
        List<List<Character>> matrix = new ArrayList<>();
        int pointer = 0;
        int col = (int) Math.ceil((double) text.length() / key.length());

        for (int i = 0; i < key.length(); i++) {
            List<Character> temp = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                if(pointer < text.length())
                temp.add(text.charAt(pointer));
                pointer++;
            }
            matrix.add(temp);
        }

        StringBuilder decryptedText = new StringBuilder();
        List<Character> keyList = new ArrayList<>();
        for (char c : key.toCharArray()) {
            keyList.add(c);
        }
        Collections.sort(keyList);

        for (int i = 0; i < col; i++) {
            for (char j : key.toCharArray()) {
                int index = keyList.indexOf(j);
                if (matrix.get(index).get(i) != '_') {
                    decryptedText.append(matrix.get(index).get(i));
                }
            }
        }
        System.out.println("Decrypted text: " + decryptedText.toString());
    }

    public static String decryptFX(String text, String key) {
        List<List<Character>> matrix = new ArrayList<>();
        int pointer = 0;
        int col = (int) Math.ceil((double) text.length() / key.length());

        for (int i = 0; i < key.length(); i++) {
            List<Character> temp = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                temp.add(text.charAt(pointer));
                pointer++;
            }
            matrix.add(temp);
        }

        StringBuilder decryptedText = new StringBuilder();
        List<Character> keyList = new ArrayList<>();
        for (char c : key.toCharArray()) {
            keyList.add(c);
        }
        Collections.sort(keyList);

        for (int i = 0; i < col; i++) {
            for (char j : key.toCharArray()) {
                int index = keyList.indexOf(j);
                if (matrix.get(index).get(i) != '_') {
                    decryptedText.append(matrix.get(index).get(i));
                }
            }
        }
        return decryptedText.toString();
    }
}
