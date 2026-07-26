# Git Hands-on Lab 3 – Branching and Merging

## 📌 Objectives

In this hands-on lab, you will learn how to:

- Understand Git branching and merging.
- Create and switch between branches.
- Make changes in a separate branch.
- Merge changes into the master branch.
- View commit history.
- Delete merged branches.
- Learn the basics of Branch Requests and Merge Requests in GitLab.

---

## 📋 Prerequisites

Before starting this lab, ensure that you have:

- Git installed and configured.
- A local Git repository.
- A remote GitHub/GitLab repository.
- P4Merge installed for visual comparison (optional).

**Estimated Time:** 30 Minutes

---

# Introduction

Git branches allow developers to work on new features or bug fixes independently without affecting the main branch. Once the work is completed, the changes can be merged back into the main branch.

---

# Branching Workflow

```text
          master
             │
             │
      git branch GitNewBranch
             │
             ▼
      GitNewBranch
             │
       Add Changes
             │
      git commit
             │
             ▼
      git checkout master
             │
      git merge GitNewBranch
             │
             ▼
          master
```

---

# Step 1 – Create a New Branch

Create a new branch named **GitNewBranch**.

```bash
git branch GitNewBranch
```

---

# Step 2 – View Available Branches

List all local branches.

```bash
git branch
```

Expected Output

```text
* master
  GitNewBranch
```

The `*` symbol indicates the currently active branch.

To view both local and remote branches:

```bash
git branch -a
```

---

# Step 3 – Switch to the New Branch

```bash
git checkout GitNewBranch
```

Or (Git 2.23+)

```bash
git switch GitNewBranch
```

Verify the current branch:

```bash
git branch
```

Expected Output

```text
  master
* GitNewBranch
```

---

# Step 4 – Create a New File

Create a sample file.

```bash
echo "This file belongs to GitNewBranch" > branch.txt
```

Verify:

```bash
cat branch.txt
```

---

# Step 5 – Stage the Changes

```bash
git add .
```

---

# Step 6 – Commit the Changes

```bash
git commit -m "Added branch.txt in GitNewBranch"
```

---

# Step 7 – Verify Repository Status

```bash
git status
```

Expected Output

```text
On branch GitNewBranch

nothing to commit, working tree clean
```

---

# Step 8 – Switch Back to Master

```bash
git checkout master
```

Or

```bash
git switch master
```

---

# Step 9 – Compare Branches

Display the differences between the master branch and the new branch.

```bash
git diff master GitNewBranch
```

This command shows all changes that exist in **GitNewBranch** but not in **master**.

---

# Step 10 – Visual Comparison (Optional)

If **P4Merge** is installed, configure Git to use it as a merge and diff tool.

Example:

```bash
git difftool master GitNewBranch
```

P4Merge opens and visually displays the differences between the two branches.

---

# Step 11 – Merge the Branch

Merge the changes into the master branch.

```bash
git merge GitNewBranch
```

Expected Output

```text
Updating xxxx..xxxx

Fast-forward

branch.txt
```

---

# Step 12 – View Commit History

Display the commit history in graph format.

```bash
git log --oneline --graph --decorate
```

Example Output

```text
* 9f2ab1c Added branch.txt
* a34cd21 Initial Commit
```

---

# Step 13 – Delete the Merged Branch

Delete the local branch after it has been successfully merged.

```bash
git branch -d GitNewBranch
```

Verify:

```bash
git branch
```

Expected Output

```text
* master
```

---

# Useful Git Commands

| Command | Description |
|----------|-------------|
| `git branch` | List local branches |
| `git branch -a` | List local and remote branches |
| `git checkout branchName` | Switch branch |
| `git switch branchName` | Switch branch (new command) |
| `git add .` | Stage all changes |
| `git commit -m "message"` | Commit changes |
| `git diff branch1 branch2` | Compare two branches |
| `git merge branchName` | Merge a branch |
| `git log --oneline --graph --decorate` | Display commit history |
| `git branch -d branchName` | Delete a merged branch |

---

# Git Branch Lifecycle

```text
master
   │
   ├──────────────┐
   │              │
   ▼              │
GitNewBranch      │
   │              │
Develop Feature   │
   │              │
Commit Changes    │
   │              │
   └──────Merge───┘
          │
          ▼
        master
```

---

# Branch Request (GitLab)

A **Branch Request** is the process of creating a new branch to develop a feature or fix a bug without affecting the main branch.

Typical workflow:

1. Create a branch.
2. Develop the feature.
3. Commit the changes.
4. Push the branch to the remote repository.

Example:

```bash
git push origin GitNewBranch
```

---

# Merge Request (GitLab)

A **Merge Request (MR)** is used to request that changes from one branch be merged into another branch.

Typical workflow:

1. Push the branch.

```bash
git push origin GitNewBranch
```

2. Open GitLab.
3. Create a **Merge Request**.
4. Review the changes.
5. Merge into the **master** branch.

---

# Learning Outcomes

After completing this lab, you will be able to:

- Create Git branches.
- Switch between branches.
- Commit changes independently.
- Compare branches.
- Merge branches into the master branch.
- View Git history using graph view.
- Delete merged branches.
- Understand GitLab Branch Requests and Merge Requests.

---

# Summary

In this lab, you learned how to create and manage Git branches, make isolated changes, compare differences, merge branches into the master branch, and delete merged branches. You also explored the concepts of Branch Requests and Merge Requests used in GitLab for collaborative development.