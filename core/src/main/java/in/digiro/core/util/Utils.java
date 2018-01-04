package in.digiro.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by corechain on 04/01/18.
 */

public class Utils {

    public static String genRandomHex(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 32) {
            sb.append(Integer.toHexString(random.nextInt()));
        }
        return sb.toString();
    }

    public static String getSHA256Digest(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(value.trim().getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException exc) {
            return null;
        }
    }
}
