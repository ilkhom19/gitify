package gitify;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Tree extends GitObject {
    private final Map<String, GitObject> entries; // Object can be Blob or Tree
    public Tree() {
        this.entries = new HashMap<>();
    }

    public void addEntry(String name, GitObject entry) {
        entries.put(name, entry);
    }

    @Override
    public String getHash() {
        return calculateHash(entries);
    }

    private String calculateHash(Map<String, GitObject> entries) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            StringBuilder concatenatedEntriesHashes = new StringBuilder();
            entries.forEach((name, entry) -> concatenatedEntriesHashes.append(name).append((entry).getHash()));
            byte[] hashBytes = digest.digest(concatenatedEntriesHashes.toString().getBytes());
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
