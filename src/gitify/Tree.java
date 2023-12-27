package gitify;

import java.util.HashMap;
import java.util.Map;

public class Tree {
    private final Map<String, Object> entries; // Object can be Blob or Tree
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
        // Implement hash calculation (omitted for brevity)
        return "TreeHash";
    }
}
