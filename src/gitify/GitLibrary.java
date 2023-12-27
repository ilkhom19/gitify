package gitify;

import java.util.*;

public class GitLibrary {
    private List<Commit> commits;
    private Map<String, Commit> commitHashMap;
    private Map<String, List<Commit>> authorHashMap;
    private Map<String, List<Commit>> treeHashMap;

    public GitLibrary() {
        this.commits = new ArrayList<>();
        this.commitHashMap = new HashMap<>();
        this.authorHashMap = new HashMap<>();
        this.treeHashMap = new HashMap<>();
    }

    public void createCommit(Tree tree, String author, String message) {

        if (treeHashMap.containsKey(tree.getHash())) {
            return;
        }

        Commit commit = new Commit(tree, author, message);
        commits.add(commit);
        commitHashMap.put(commit.getHash(), commit);

        authorHashMap.putIfAbsent(author, new ArrayList<>());
        authorHashMap.get(author).add(commit);

        treeHashMap.putIfAbsent(tree.getHash(), new ArrayList<>());
        treeHashMap.get(tree.getHash()).add(commit);
    }

    public List<Commit> listCommits() {
        return Collections.unmodifiableList(commits);
    }

    public Commit findCommitByHash(String hash){
        return commitHashMap.getOrDefault(hash, null);
    }
    public List<Commit> findCommitsByAuthor(String author){
        return authorHashMap.getOrDefault(author, null);
    }

    public List<Commit> findCommitsByTree(String tree){
        return treeHashMap.getOrDefault(tree, null);
    }
}
