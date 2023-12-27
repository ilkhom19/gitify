package test;

import gitify.Blob;
import gitify.Tree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void testTreeHash() {
        Blob blob = new Blob("File Content");
        Tree tree = new Tree();
        tree.addEntry("file.txt", blob);

        String expectedHash = "ae07f1ec20e8d5b631976826601cc9b918e259af"; // The expected hash for the tree with one blob entry: "file.txt6b52fce02d9b8c763f2060ae86738f2048eacbc3"
        assertEquals(expectedHash, tree.getHash());
    }
}
