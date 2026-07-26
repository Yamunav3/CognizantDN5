# Git Hands-on Lab 4 – Merge Conflict Resolution

## 📌 Objectives

In this hands-on lab, you will learn how to:

- Understand why merge conflicts occur.
- Create conflicting changes in different branches.
- Identify merge conflicts.
- Resolve conflicts using Git and a 3-way merge tool (P4Merge).
- Commit the resolved changes.
- Ignore backup files using `.gitignore`.
- Delete merged branches and verify the repository history.

---

## 📋 Prerequisites

Before starting this lab, ensure that you have:

- Completed **Git Hands-on Lab 3 (Branching and Merging)**.
- Git installed and configured.
- A local Git repository.
- P4Merge (or any Git merge tool) installed for conflict visualization.

**Estimated Time:** 30 Minutes

---

# Introduction

A **merge conflict** occurs when Git cannot automatically merge changes because the same part of a file has been modified in different branches.

Git pauses the merge process and asks the developer to manually resolve the conflict.

---

# Merge Conflict Workflow

```text
                master
                   │
                   │
      git branch GitWork
                   │
        ┌──────────┘
        │
        ▼
     GitWork
        │
 Modify hello.xml
        │
 git commit
        │
        ▼
      master
        │
 Modify hello.xml
        │
 git commit
        │
        ▼
 git merge GitWork
        │
   Merge Conflict
        │
 Resolve Conflict
        │
 git add
        │
 git commit
```

---

# Step 1 – Verify Repository Status

Ensure that the master branch is clean.

```bash
git status
```

Expected Output

```text
On branch master

nothing to commit, working tree clean
```

---

# Step 2 – Create a New Branch

Create a branch named **GitWork**.

```bash
git branch GitWork
```

Switch to the branch.

```bash
git checkout GitWork
```

---

# Step 3 – Create `hello.xml`

Create a new file.

```bash
echo "<message>Hello from GitWork</message>" > hello.xml
```

Verify the file.

```bash
cat hello.xml
```

---

# Step 4 – Stage and Commit

```bash
git add hello.xml
```

Commit the changes.

```bash
git commit -m "Added hello.xml in GitWork"
```

---

# Step 5 – Switch to Master

```bash
git checkout master
```

---

# Step 6 – Modify the Same File

Create or edit the file with different content.

```bash
echo "<message>Hello from Master</message>" > hello.xml
```

---

# Step 7 – Commit the Changes

```bash
git add hello.xml
git commit -m "Updated hello.xml in master"
```

---

# Step 8 – View Commit History

Display the commit graph.

```bash
git log --oneline --graph --decorate --all
```

Example Output

```text
* abc1234 Updated hello.xml in master
| * def5678 Added hello.xml in GitWork
|/
* 123abcd Initial Commit
```

---

# Step 9 – Compare the Branches

Compare the differences between **master** and **GitWork**.

```bash
git diff master GitWork
```

---

# Step 10 – Visual Comparison (Optional)

If P4Merge is installed, compare visually.

```bash
git difftool master GitWork
```

---

# Step 11 – Merge the Branch

Merge **GitWork** into **master**.

```bash
git merge GitWork
```

Git reports a merge conflict.

Example Output

```text
Auto-merging hello.xml

CONFLICT (content): Merge conflict in hello.xml

Automatic merge failed.
```

---

# Step 12 – Observe the Conflict Markers

Open **hello.xml**.

Git inserts conflict markers.

```xml
<<<<<<< HEAD
<message>Hello from Master</message>
=======
<message>Hello from GitWork</message>
>>>>>>> GitWork
```

---

# Step 13 – Resolve the Conflict

Edit the file manually or use a **3-way merge tool**.

Resolved version:

```xml
<message>Hello from Master and GitWork</message>
```

Save the file.

---

# Step 14 – Commit the Resolved Merge

Stage the resolved file.

```bash
git add hello.xml
```

Commit the merge.

```bash
git commit -m "Resolved merge conflict"
```

---

# Step 15 – Ignore Backup Files

Create or edit the **.gitignore** file.

```bash
notepad++ .gitignore
```

Add:

```gitignore
*.bak
```

Save the file.

Stage it.

```bash
git add .gitignore
```

Commit the change.

```bash
git commit -m "Added backup files to .gitignore"
```

---

# Step 16 – View Repository Status

```bash
git status
```

Expected Output

```text
On branch master

nothing to commit, working tree clean
```

---

# Step 17 – List All Branches

```bash
git branch
```

Example Output

```text
* master
  GitWork
```

---

# Step 18 – Delete the Merged Branch

```bash
git branch -d GitWork
```

Verify.

```bash
git branch
```

Expected Output

```text
* master
```

---

# Step 19 – View Final Commit History

```bash
git log --oneline --graph --decorate
```

Example Output

```text
* Merge branch 'GitWork'
* Resolved merge conflict
* Updated hello.xml in master
* Added hello.xml in GitWork
* Initial Commit
```

---

# Useful Git Commands

| Command | Description |
|----------|-------------|
| `git status` | View repository status |
| `git branch` | List branches |
| `git checkout branch` | Switch branches |
| `git add file` | Stage changes |
| `git commit -m "message"` | Commit changes |
| `git merge branch` | Merge a branch |
| `git diff` | Compare file differences |
| `git difftool` | Open visual comparison tool |
| `git log --oneline --graph --decorate --all` | Display commit graph |
| `git branch -d branch` | Delete merged branch |

---

# Merge Conflict Resolution Process

```text
Master
   │
   ├──────────────┐
   │              │
   ▼              ▼
Modify File    Modify Same File
   │              │
Commit        Commit
   │              │
   └──────Merge──────┐
                     │
             Merge Conflict
                     │
         Resolve Conflict
                     │
               git add
                     │
             git commit
                     │
                Merge Complete
```

---

# Learning Outcomes

After completing this lab, you will be able to:

- Understand merge conflicts.
- Create conflicting changes in Git.
- Compare branches using `git diff`.
- Resolve conflicts manually or with a merge tool.
- Complete a merge after conflict resolution.
- Ignore backup files using `.gitignore`.
- Manage and delete merged branches.

---

# Summary

In this lab, you learned how merge conflicts occur when different branches modify the same file. You practiced creating a conflict, resolving it manually or with a 3-way merge tool, committing the resolved changes, updating `.gitignore` for backup files, and cleaning up the repository by deleting merged branches.