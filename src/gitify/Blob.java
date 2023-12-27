package gitify;
public class Blob {
    private final String data;
    private final String hash;

    public Blob(String data) {
        this.data = data;
        this.hash = calculateHash(data);
    }

    public String getHash() {
        return hash;
    }

    private String calculateHash(String data) {
        // Implement hash calculation (omitted for brevity)
        return "BlobHash";
    }
}
