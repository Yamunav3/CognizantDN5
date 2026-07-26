# Git Hands-on Lab 1 – Git Setup and Basic Operations

## 📌 Objectives

In this hands-on lab, you will learn how to:

- Configure Git on your local machine.
- Set up your Git username and email.
- Configure Notepad++ as the default Git editor.
- Create a local Git repository.
- Add files to the repository.
- Commit changes.
- Push and pull changes from a remote repository.

---

## 📋 Prerequisites

Before starting this lab, ensure that:

- Git Bash is installed on your machine.
- Notepad++ is installed (optional but recommended).
- You have a GitHub or GitLab account.
- Basic knowledge of Command Line is helpful.

**Estimated Time:** 30 Minutes

---

# Step 1 – Configure Git

## 1. Verify Git Installation

Open **Git Bash** and execute:

```bash
git --version
```

### Expected Output

```text
git version 2.xx.x.windows.x
```

---

## 2. Configure Username

```bash
git config --global user.name "Your Name"
```

Example

```bash
git config --global user.name "yamunav3"
```

---

## 3. Configure Email

```bash
git config --global user.email "your_email@example.com"
```

Example

```bash
git config --global user.email "yamunav32006@gmail.com"
```

---

## 4. Verify Configuration

```bash
git config --global --list
```

Expected Output

```text
user.name=yamunav3
user.email=yamuna@gmail.com
```

---

# Step 2 – Configure Notepad++ as Git Editor

## 1. Verify Notepad++ Installation

Run

```bash
notepad++
```

If Git Bash cannot recognize the command:

- Open **Control Panel**
- Go to **System**
- Open **Advanced System Settings**
- Click **Environment Variables**
- Edit the **Path** variable
- Add the Notepad++ installation directory

Example

```
C:\Program Files\Notepad++
```

Restart Git Bash.

---

## 2. Configure Notepad++ as Default Editor

```bash
git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst -nosession"
```

If installed in Program Files (x86):

```bash
git config --global core.editor "'C:/Program Files (x86)/Notepad++/notepad++.exe' -multiInst -nosession"
```

---

## 3. Verify Default Editor

```bash
git config --global --edit
```

The configuration file should open in Notepad++.

---

## 4. Verify Git Configuration

```bash
git config --global --list
```

Expected Output

```text
user.name=Your Name
user.email=your_email@example.com
core.editor='C:/Program Files/Notepad++/notepad++.exe'
```

---

# Step 3 – Create a Local Repository

## 1. Create a Project Directory

```bash
mkdir GitDemo
cd GitDemo
```

---

## 2. Initialize Git Repository

```bash
git init
```

Expected Output

```text
Initialized empty Git repository...
```

---

## 3. Verify Repository

```bash
ls -la
```

You should see the hidden **.git** directory.

---

# Step 4 – Create a File

Create a file named **welcome.txt**

```bash
echo "Welcome to Git" > welcome.txt
```

---

## Verify the File

```bash
ls
```

---

## View File Content

```bash
cat welcome.txt
```

Expected Output

```text
Welcome to Git
```

---

# Step 5 – Check Repository Status

```bash
git status
```

Expected Output

```text
Untracked files:
welcome.txt
```

---

# Step 6 – Stage the File

```bash
git add welcome.txt
```

Or stage all files

```bash
git add .
```

---

# Step 7 – Commit Changes

Commit the staged changes.

```bash
git commit -m "Added welcome.txt"
```

Example Output

```text
1 file changed
create mode 100644 welcome.txt
```

---

# Step 8 – Verify Status

```bash
git status
```

Expected Output

```text
nothing to commit, working tree clean
```

---

# Step 9 – Connect to Remote Repository

Create a repository named **GitDemo** on GitHub or GitLab.

Add the remote repository.

```bash
git remote add origin https://github.com/username/GitDemo.git
```

Verify

```bash
git remote -v
```

---

# Step 10 – Pull Remote Repository

```bash
git pull origin master
```

or

```bash
git pull origin main
```

---

# Step 11 – Push Local Repository

```bash
git push origin master
```

or

```bash
git push origin main
```

---

# Common Git Commands Used

| Command         | Description                 |
| --------------- | --------------------------- |
| `git init`      | Initialize a Git repository |
| `git status`    | Show repository status      |
| `git add`       | Stage files                 |
| `git commit`    | Save changes                |
| `git pull`      | Download latest changes     |
| `git push`      | Upload commits              |
| `git config`    | Configure Git               |
| `git remote -v` | View remote repositories    |
| `ls -la`        | Display hidden files        |
| `cat filename`  | View file contents          |

---

# Repository Workflow

```
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
git push
        │
        ▼
Remote Repository (GitHub/GitLab)
```

---

# Learning Outcomes

After completing this lab, you will be able to:

- Install and configure Git.
- Configure Git username and email.
- Use Notepad++ as the default Git editor.
- Initialize a Git repository.
- Create and track files.
- Stage and commit changes.
- Connect to a remote repository.
- Push and pull changes using Git.

---

# Summary

In this lab, you learned how to configure Git, set up a default editor, create a local repository, track files, commit changes, and synchronize your local repository with a remote GitHub/GitLab repository using essential Git commands.
