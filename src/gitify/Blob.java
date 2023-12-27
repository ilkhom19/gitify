package gitify;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Blob extends GitObject{

    private final String hash;

    public Blob(String data) {
        this.hash = calculateHash(data);
    }

    @Override
    public String getHash() {
        return hash;
    }

    private String calculateHash(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] hashBytes = digest.digest(data.getBytes());
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-1 algorithm not available", e);
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}
