package gitify;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Commit {
    private final Tree tree;
    private final String author;
    private final String message;
    private final Date commitTime;
    private final String hash;

    public Commit(Tree tree, String author, String message) {
        this.tree = tree;
        this.author = author;
        this.message = message;
        this.commitTime = new Date();
        this.hash = calculateHash(tree, author, message, commitTime);
    }

    public String getHash() {
        return hash;
    }

    private String calculateHash(Tree tree, String author, String message, Date commitTime) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            String concatenatedData = tree.getHash() + author + message + commitTime.toString();
            byte[] hashBytes = digest.digest(concatenatedData.getBytes());
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-1 algorithm not available", e);
        }
    }

    public void printContent() {
        System.out.println("Author: " + author);
        System.out.println("Message: " + message);
        System.out.println("Commit Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(commitTime));
        System.out.println("Tree Hash: " + tree.getHash());
        System.out.println("Commit Hash: " + hash);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    public String getAuthor() {
        return author;
    }

    public Tree getTree() {
        return tree;
    }

    public String getMessage() {
        return message;
    }
}

