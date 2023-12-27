package gitify;

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
        // Implement hash calculation (omitted for brevity)
        return "CommitHash";
    }

    public void printContent() {
        System.out.println("Author: " + author);
        System.out.println("Message: " + message);
        System.out.println("Commit Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(commitTime));
        System.out.println("Tree Hash: " + tree.getHash());
    }
}
