# Git Hands-on Lab 2 – Using `.gitignore`

## 📌 Objectives

In this hands-on lab, you will learn how to:

- Understand the purpose of the `.gitignore` file.
- Ignore unwanted files and folders from Git tracking.
- Configure Git to exclude log files and directories.
- Verify ignored files using Git commands.

---

## 📋 Prerequisites

Before starting this lab, ensure that you have:

- Git installed and configured.
- A local Git repository.
- A remote repository on GitHub or GitLab.
- Notepad++ configured as the default Git editor (optional).

**Estimated Time:** 20 Minutes

---

# Introduction

The `.gitignore` file tells Git which files and directories should **not** be tracked or committed to the repository.

This is useful for excluding:

- Log files
- Temporary files
- Build artifacts
- Cache files
- IDE configuration files
- OS-generated files

---

# Project Structure

Before applying `.gitignore`

```
GitDemo/
│
├── welcome.txt
├── app.log
├── logs/
│   └── error.log
└── .git/
```

---

# Step 1 – Create a Log File

Create a sample log file.

```bash
touch app.log
```

Or

```bash
echo "Application Started" > app.log
```

---

# Step 2 – Create a Log Directory

```bash
mkdir logs
```

Create a log file inside it.

```bash
echo "Error Message" > logs/error.log
```

---

# Step 3 – Create a `.gitignore` File

```bash
touch .gitignore
```

Open it using Notepad++ or any editor.

```bash
notepad++ .gitignore
```

---

# Step 4 – Ignore Log Files and Log Folder

Add the following content to the `.gitignore` file.

```gitignore
# Ignore all log files
*.log

# Ignore log directory
logs/

# Ignore backup files
*.bak

# Ignore temporary files
*.tmp
```

Save the file.

---

# Step 5 – Check Git Status

Run:

```bash
git status
```

### Expected Output

```text
Untracked files:
.gitignore

nothing about app.log
nothing about logs/
```

Notice that:

- `app.log` is ignored.
- `logs/` directory is ignored.
- Only `.gitignore` appears as an untracked file.

---

# Step 6 – Add the `.gitignore` File

```bash
git add .gitignore
```

---

# Step 7 – Commit the Changes

```bash
git commit -m "Added .gitignore file"
```

Example Output

```text
1 file changed
create mode 100644 .gitignore
```

---

# Step 8 – Verify Repository Status

```bash
git status
```

Expected Output

```text
On branch main

nothing to commit, working tree clean
```

---

# Verify Ignored Files

To check which files are ignored:

```bash
git status --ignored
```

Example Output

```text
Ignored files:

app.log
logs/
```

---

# Common `.gitignore` Patterns

| Pattern         | Description                    |
| --------------- | ------------------------------ |
| `*.log`         | Ignore all log files           |
| `*.tmp`         | Ignore temporary files         |
| `*.bak`         | Ignore backup files            |
| `logs/`         | Ignore logs directory          |
| `build/`        | Ignore build folder            |
| `target/`       | Ignore Maven target folder     |
| `node_modules/` | Ignore Node.js dependencies    |
| `.DS_Store`     | Ignore macOS system file       |
| `Thumbs.db`     | Ignore Windows thumbnail cache |

---

# Example Project Structure

```
GitDemo/
│
├── .gitignore
├── welcome.txt
├── app.log          ❌ Ignored
├── logs/            ❌ Ignored
│   └── error.log
└── src/
```

---

# Useful Git Commands

```bash
git status
git status --ignored
git add .gitignore
git commit -m "Added gitignore"
git log --oneline
```

---

# Learning Outcomes

After completing this lab, you will be able to:

- Create a `.gitignore` file.
- Ignore unwanted files and folders.
- Prevent unnecessary files from being committed.
- Verify ignored files using Git commands.
- Maintain a clean and organized Git repository.

---

# Summary

In this lab, you learned how to use the `.gitignore` file to exclude unnecessary files and directories from version control. By ignoring log files and folders, you can keep your Git repository clean and avoid committing temporary or generated files.

```

```
