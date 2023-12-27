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

        // The expected hash for the tree with one blob entry: "file.txt6b52fce02d9b8c763f2060ae86738f2048eacbc3"
        String expectedHash = "ae07f1ec20e8d5b631976826601cc9b918e259af";
        assertEquals(expectedHash, tree.getHash());
    }

    @Test
    void testEmptyTreeHash() {
        Tree emptyTree = new Tree();
        String expectedHash = "da39a3ee5e6b4b0d3255bfef95601890afd80709"; // The expected hash for an empty tree
        assertEquals(expectedHash, emptyTree.getHash());
    }

    @Test
    void testTreeMultipleEntriesHash() {
        Blob blob1 = new Blob("File Content 1");
        Blob blob2 = new Blob("File Content 2");
        Tree tree = new Tree();
        tree.addEntry("file1.txt", blob1);
        tree.addEntry("file2.txt", blob2);

        //the expected hash of : "file1.txtf53a407b81fcdf17e18ee15d4e203360c05c7b3efile2.txtb34d10e42694a8cbb64c5a7323b452cc04ddd90a"
        String expectedHash = "57141adb3a5dcdab198c361aa9aa676a785be048";
        assertEquals(expectedHash, tree.getHash());
    }

    @Test
    void testNestedTreesHash() {
        Blob blob = new Blob("File Content");
        Tree nestedTree = new Tree();
        nestedTree.addEntry("file.txt", blob);

        Tree mainTree = new Tree();
        mainTree.addEntry("nested", nestedTree);

        // correct expected hash from "nestedae07f1ec20e8d5b631976826601cc9b918e259af" is 6fbdd35d7b7a943b86bc2313b6c62a6fd495eabd
        String expectedHash = "6fbdd35d7b7a943b86bc2313b6c62a6fd495eabd";
        assertEquals(expectedHash, mainTree.getHash());
    }

    @Test
    void testLargeNumberOfEntriesHash() {
        Tree tree = new Tree();
        for (int i = 0; i < 1000; i++) {
            Blob blob = new Blob("File Content " + i);
            tree.addEntry("file" + i + ".txt", blob);
        }

        String expectedHash = "bd86a74f24fab898dc0dfea2fe0ba360d8cb9e3f";
        assertEquals(expectedHash, tree.getHash());
    }
}
