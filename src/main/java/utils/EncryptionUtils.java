package utils;

import org.apache.commons.codec.binary.Base64;

public class EncryptionUtils {

    public static String encrypt(String property) {
        String encrytedStr = Base64.encodeBase64String(property.getBytes());
        return encrytedStr;
    }

    public static String decrypt(String encryptedProperty) {
        String decryptedStr = new String(Base64.decodeBase64(encryptedProperty));
        return decryptedStr;
    }

    public static void main(String[] args) {
        String en = encrypt("");
        System.out.println(en);
        en = decrypt(en);
        System.out.println(en);
    }

}