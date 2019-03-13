package me.mupu.ibikehda.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class HashPasswordEncoder {
    // increasing it will slow down process drastically
    private final static int ITERATION_FIGURES_COUNT = 5;

    // size need to be iterationfigurescount + salt size (usually 32)
    // unique number list ranging from 1 - 512
    private static int[] RANDOM_POS = {342, 419, 123, 152, 351, 121, 277, 459, 499, 316, 416, 373, 50, 320, 106, 258, 434, 29, 145, 12, 284, 460, 494, 171, 186, 180, 274, 82, 146, 181, 115, 268, 490, 232, 495, 255, 160};

    public final boolean matches(String rawPassword, String encodedPassword) {
        try {
            String[] parts = extractIterationsAndSalt(encodedPassword).split(":");
            int iterations = Integer.parseInt(parts[0]);
            byte[] salt = fromHex(parts[1]);
            byte[] hash = fromHex(parts[2]);
            return toHex(encode(rawPassword.toCharArray(), salt, iterations)).equals(toHex(hash));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("ERROR_WHILE_ENCODING");
        return false;
    }

    public String encode(CharSequence rawPassword) {
        double figuresMultiplier = Math.pow(10, ITERATION_FIGURES_COUNT - 1);
        try {
            int iterations = (int) (Math.random() * 9 * figuresMultiplier) + (int) figuresMultiplier;
            char[] chars = rawPassword.toString().toCharArray();
            byte[] salt = getSalt();
            return injectIterationsAndSalt(iterations, toHex(salt), toHex(encode(chars, salt, iterations)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("ERROR_WHILE_ENCODING");
        return "ERROR_WHILE_ENCODING";
    }

    private byte[] encode(char[] chars, byte[] salt, int iterations) {
        try {
            PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 32);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static byte[] fromHex(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

    private static String toHex(byte[] array) {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    private String injectIterationsAndSalt(int iterations, String salt, String rawPassword) {
        String iterationsString = String.valueOf(iterations);

        if (RANDOM_POS.length != ITERATION_FIGURES_COUNT + salt.length())
            return null;

        ArrayList<Character> chars = new ArrayList<>();
        rawPassword.chars().forEach(c -> chars.add((char) c));

        for (int i = 0; i < RANDOM_POS.length; i++) {
            char cur;
            if (i < ITERATION_FIGURES_COUNT)
                // inject iterations
                cur = iterationsString.charAt(i);
            else
                // inject salt
                cur = salt.charAt(i - ITERATION_FIGURES_COUNT);

            // inject into rawPassword
            chars.add(RANDOM_POS[i] + i, cur);
        }

        return chars.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private String extractIterationsAndSalt(String encodedPassword) {
        StringBuilder iterations = new StringBuilder();
        StringBuilder salt = new StringBuilder();

        ArrayList<Character> chars = new ArrayList<>();
        encodedPassword.chars().forEach(c -> chars.add((char) c));

        for (int i = RANDOM_POS.length - 1; i >= 0; i--) {
            if (i < ITERATION_FIGURES_COUNT)
                // inject iterations
                iterations.append(chars.remove(RANDOM_POS[i] + i));
            else
                // inject salt
                salt.append(chars.remove(RANDOM_POS[i] + i));
        }

        return iterations.reverse().toString() + ":" + salt.reverse().toString() + ":" + chars.stream().map(String::valueOf).collect(Collectors.joining());
    }

}
