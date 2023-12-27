import gitify.Blob;
import gitify.Commit;
import gitify.GitLibrary;
import gitify.Tree;

import java.util.List;

public class GitifyDemo {
    public static void main(String[] args) {
        GitLibrary gitLibrary = new GitLibrary();

        // New Blobs
        Blob blob1 = new Blob("File Content 1");
        Blob blob2 = new Blob("File Content 2");

        // New Tree
        Tree tree = new Tree();
        tree.addEntry("file1.txt", blob1);
        tree.addEntry("file2.txt", blob2);

        // New Commit
        gitLibrary.createCommit(tree, "John Doe", "Init Commit");

        // List Commits
        List<Commit> commits = gitLibrary.listCommits();
        for (Commit commit : commits) {
            commit.printContent();
            System.out.println("--------------");
        }

        // Search Commit by Hash
        Commit foundCommit = gitLibrary.findCommitByHash(commits.get(0).getHash());
        if (foundCommit != null) {
            System.out.println("Found Commit:");
            foundCommit.printContent();
        } else {
            System.out.println("Commit not found");
        }
    }
}
