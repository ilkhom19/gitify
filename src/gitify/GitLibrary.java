package gitify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GitLibrary {
    private final List<Commit> commits;

    public GitLibrary() {
        this.commits = new ArrayList<>();
    }

    public void createCommit(Tree tree, String author, String message) {
        Commit commit = new Commit(tree, author, message);
        commits.add(commit);
    }

    public List<Commit> listCommits() {
        return Collections.unmodifiableList(commits);
    }

    public Commit findCommitByHash(String hash) {
        for (Commit commit : commits) {
            if (commit.getHash().equals(hash)) {
                return commit;
            }
        }
        return null;
    }
}
