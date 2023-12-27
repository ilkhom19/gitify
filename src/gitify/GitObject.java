package gitify;

public class GitObject {
    private final String hash;

    public GitObject(String hash) {
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }
}
