# Gitify

Gitify is a simple Java/Kotlin library implementing basic Git functionality. The library allows you to create commits, manage trees, and work with blobs, mimicking core Git features. This project is designed for educational purposes and to enhance practical skills in working with version control concepts.

## Features

### 1. Create Commits

- Use the library to create new commits with metadata such as author, timestamp, and commit message.
- Duplicate commits are automatically detected and ignored.

```java
gitLibrary.createCommit(tree, "John Doe", "Init Commit");
gitLibrary.createCommit(tree, "John Doe", "Second Commit"); // Duplicate Commit, will be ignored
```

### 2. List Commits

- Retrieve a chronological list of all commits made using the library.

```java
List<Commit> commits = gitLibrary.listCommits();
for (Commit commit : commits) {
    commit.printContent();
    System.out.println("--------------");
}
```

### 3. Search Commits

#### By Hash

- Search for a specific commit by its hash.

```java
Commit foundCommit = gitLibrary.findCommitByHash(commits.get(0).getHash());
if (foundCommit != null) {
    foundCommit.printContent();
} else {
    System.out.println("Commit not found");
}
```

#### By Author

- Search for commits by a specific author.

```java
List<Commit> foundCommits = gitLibrary.findCommitsByAuthor("John Doe");
if (foundCommits != null) {
    for (Commit commit : foundCommits) {
        commit.printContent();
        System.out.println("--------------");
    }
} else {
    System.out.println("Commit not found");
}
```

#### By Tree

- Search for commits associated with a particular tree.

```java
foundCommits = gitLibrary.findCommitsByTree(tree.getHash());
if (foundCommits != null) {
    for (Commit commit : foundCommits) {
        commit.printContent();
        System.out.println("--------------");
    }
} else {
    System.out.println("Commit not found");
}
```

## Getting Started

### Installation

Clone the repository:

```bash
git clone https://github.com/ilkhom19/gitify.git
```

### Usage

1. Import the Gitify library into your Java or Kotlin project.
2. Create blobs, trees, and commits using the library's API.
3. List commits and search for specific commits as needed.

Example:

```java
import gitify.Blob;
import gitify.Commit;
import gitify.GitLibrary;
import gitify.Tree;

public class GitifyDemo {
    public static void main(String[] args) {
        GitLibrary gitLibrary = new GitLibrary();
        
        // Create blobs, trees and etc.
    }
}
```

## Demo Scenarios

Explore the provided `GitifyDemo` class for sample scenarios demonstrating library usage.


## Acknowledgments

- Done for the [JetBrains Internship Application](https://internship.jetbrains.com/).
---