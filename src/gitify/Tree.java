package gitify;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Tree {
    private final Map<String, Object> entries; // Object can be Blob or Tree as stated in the instructions
    private final String hash;

    public Tree() {
        this.entries = new HashMap<>();
        this.hash = calculateHash(entries);
    }

    public void addEntry(String name, Object entry) {
        entries.put(name, entry);
    }

    public String getHash() {
        return hash;
    }

    private String calculateHash(Map<String, Object> entries) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            StringBuilder concatenatedEntries = new StringBuilder();
            entries.forEach((name, entry) -> concatenatedEntries.append(name).append(((GitObject) entry).getHash()));
            byte[] hashBytes = digest.digest(concatenatedEntries.toString().getBytes());
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
