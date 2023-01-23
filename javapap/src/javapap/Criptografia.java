package javapap;

import java.util.Base64;
import javax.swing.JOptionPane;

public class Criptografia {

    public static void enc(String pass) {
        String str = pass;
        Base64.Encoder enc = Base64.getEncoder();
        Javapap.encoded = enc.encodeToString(str.getBytes());

    }

    public static void des(String pass) {
        String str = pass;
        Base64.Decoder dec = Base64.getDecoder();
        Javapap.decoded = new String(dec.decode(str));
    }
}