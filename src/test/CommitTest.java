package test;

import gitify.Blob;
import gitify.Commit;
import gitify.Tree;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class CommitTest {

    @Test
    void testCommitContent() {
        Blob blob = new Blob("File Content");
        Tree tree = new Tree();
        tree.addEntry("file.txt", blob);

        Commit commit = new Commit(tree, "John Doe", "Initial Commit");

        String expectedContent = "Author: John Doe\n" +
                "Message: Initial Commit\n" +
                "Commit Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n" +
                "Tree Hash: " + tree.getHash() + "\n" +
                "Commit Hash: " + commit.getHash();

        assertEquals(expectedContent, getCommitContent(commit));
    }

    private String getCommitContent(Commit commit) {
        // Redirect System.out to capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Print commit content to console
        commit.printContent();
        System.setOut(System.out);
        return outContent.toString().trim();
    }
}
