# Git Hands-on Lab 5 – Cleanup and Push to Remote Repository

## 📌 Objectives

In this hands-on lab, you will learn how to:

- Verify the status of your local repository.
- Ensure the master branch is clean.
- View available Git branches.
- Pull the latest changes from the remote repository.
- Push pending commits to the remote repository.
- Verify that changes are successfully reflected in the remote repository.

---

## 📋 Prerequisites

Before starting this lab, ensure that you have:

- Completed **Git Hands-on Lab 4 – Merge Conflict Resolution**.
- Git installed and configured.
- A local Git repository.
- A remote repository on GitHub or GitLab.
- Internet connectivity.

**Hands-on ID:** Git-T03-HOL_002

**Estimated Time:** 10 Minutes

---

# Introduction

After completing development and resolving merge conflicts, the final step is to synchronize your local repository with the remote repository.

This lab demonstrates how to:

- Verify that the repository is clean.
- Pull the latest changes from the remote repository.
- Push local commits to the remote repository.
- Confirm that the remote repository is updated successfully.

---

# Git Synchronization Workflow

```text
Local Repository
       │
       │ git status
       ▼
Working Tree Clean
       │
       │ git pull
       ▼
Update Local Repository
       │
       │ git push
       ▼
Remote Repository
       │
       ▼
Verify Changes
```

---

# Step 1 – Verify Repository Status

Ensure that the **master** branch has no pending changes.

```bash
git status
```

### Expected Output

```text
On branch master

nothing to commit, working tree clean
```

---

# Step 2 – View Available Branches

Display all local branches.

```bash
git branch
```

Example Output

```text
* master
```

To display both local and remote branches:

```bash
git branch -a
```

Example Output

```text
* master
  remotes/origin/master
```

---

# Step 3 – Pull the Latest Changes

Fetch and merge the latest changes from the remote repository.

```bash
git pull origin master
```

> **Note:** If your repository uses the `main` branch, run:

```bash
git pull origin main
```

### Expected Output

```text
Already up to date.
```

or

```text
Updating 7a4b2d..91d8fa
Fast-forward
```

---

# Step 4 – Push Local Changes

Push all pending commits to the remote repository.

```bash
git push origin master
```

For repositories using the `main` branch:

```bash
git push origin main
```

### Expected Output

```text
Enumerating objects...
Counting objects...
Writing objects...
To https://github.com/username/GitDemo.git
```

---

# Step 5 – Verify the Remote Repository

Open your remote repository on **GitHub** or **GitLab** and verify that:

- Latest commits are visible.
- Newly added or modified files are present.
- Commit history matches your local repository.

You can also verify using Git:

```bash
git log --oneline --decorate
```

Example Output

```text
5e3a9b2 Updated README
9bc7f31 Resolved merge conflict
73ef4b2 Added hello.xml
```

---

# Useful Git Commands

| Command | Description |
|----------|-------------|
| `git status` | Check repository status |
| `git branch` | List local branches |
| `git branch -a` | List local and remote branches |
| `git pull origin master` | Pull latest changes from remote |
| `git push origin master` | Push local commits to remote |
| `git log --oneline` | Display commit history |
| `git remote -v` | View configured remote repositories |

---

# Git Push Workflow

```text
Working Directory
        │
        ▼
git add
        │
        ▼
Staging Area
        │
        ▼
git commit
        │
        ▼
Local Repository
        │
        ▼
git pull
        │
        ▼
Merge Latest Changes
        │
        ▼
git push
        │
        ▼
Remote Repository
```

---

# Verification Checklist

- ✅ Working tree is clean.
- ✅ Current branch is `master` (or `main`).
- ✅ Latest changes have been pulled.
- ✅ Local commits have been pushed.
- ✅ Remote repository contains the latest updates.
- ✅ Commit history is synchronized.

---

# Learning Outcomes

After completing this lab, you will be able to:

- Verify the cleanliness of your Git repository.
- List local and remote branches.
- Synchronize with the remote repository using `git pull`.
- Upload local commits using `git push`.
- Verify that changes are successfully reflected in the remote repository.
- Understand the final synchronization workflow in Git.

---

# Summary

In this lab, you learned how to complete the Git workflow by ensuring the repository is in a clean state, checking available branches, pulling the latest updates from the remote repository, pushing pending commits, and verifying that all changes have been successfully synchronized with the remote repository.