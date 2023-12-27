package gitify;

import java.util.*;

public class GitLibrary {
    private List<Commit> commits;
    private Map<String, Commit> commitHashMap;

    public GitLibrary() {
        this.commits = new ArrayList<>();
        this.commitHashMap = new HashMap<>();
    }

    public void createCommit(Tree tree, String author, String message) {
        Commit commit = new Commit(tree, author, message);
        commits.add(commit);
        commitHashMap.put(commit.getHash(), commit);
    }

    public List<Commit> listCommits() {
        return Collections.unmodifiableList(commits);
    }

    public Commit findCommitByHash(String hash){
        return commitHashMap.getOrDefault(hash, null);
    }
}
