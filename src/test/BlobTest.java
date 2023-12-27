package test;

import gitify.Blob;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlobTest {

    @Test
    void testBlobHash() {
        Blob blob = new Blob("File Content");
        String expectedHash = "6b52fce02d9b8c763f2060ae86738f2048eacbc3"; // The expected sha-1 hash for "File Content" str

        assertEquals(expectedHash, blob.getHash());
    }
}
