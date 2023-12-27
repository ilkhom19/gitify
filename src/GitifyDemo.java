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
        gitLibrary.createCommit(tree, "John Doe", "Second Commit"); // Duplicate Commit, will be ignored

        Blob blob3 = new Blob("File Content 3");
        Tree tree2 = new Tree();
        tree2.addEntry("file3.txt", blob3);
        tree2.addEntry("tree", tree);
        gitLibrary.createCommit(tree2, "John Doe", "Third Commit");

        // List Commits
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("List Commits");
        System.out.println("++++++++++++++++++++++++++++++\n");

        List<Commit> commits = gitLibrary.listCommits();
        for (Commit commit : commits) {
            commit.printContent();
            System.out.println("--------------");
        }

        // Search Commit by Hash
        System.out.println("\n++++++++++++++++++++++++++++++");
        System.out.println("Search Commit by Hash: " + commits.get(0).getHash());
        System.out.println("++++++++++++++++++++++++++++++\n");

        Commit foundCommit = gitLibrary.findCommitByHash(commits.get(0).getHash());
        if (foundCommit != null) {
            foundCommit.printContent();
        } else {
            System.out.println("Commit not found");
        }

        // Search Commit by Author
        System.out.println("\n++++++++++++++++++++++++++++++");
        System.out.println("Search Commit by Author: John Doe");
        System.out.println("++++++++++++++++++++++++++++++\n");

        List<Commit> foundCommits = gitLibrary.findCommitsByAuthor("John Doe");
        if (foundCommits != null) {
            for (Commit commit : foundCommits) {
                commit.printContent();
                System.out.println("--------------");
            }
        } else {
            System.out.println("Commit not found");
        }

        // Search Commit by Tree
        System.out.println("\n++++++++++++++++++++++++++++++");
        System.out.println("Search Commit by Tree: " + tree.getHash());
        System.out.println("++++++++++++++++++++++++++++++\n");

        foundCommits = gitLibrary.findCommitsByTree(tree.getHash());
        if (foundCommits != null) {
            for (Commit commit : foundCommits) {
                commit.printContent();
                System.out.println("--------------");
            }
        } else {
            System.out.println("Commit not found");
        }
    }
}
