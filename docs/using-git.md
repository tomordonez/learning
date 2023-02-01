# Using Git

## Branches

I went through a few workflows for creating branches. I tried `course/section/summary` but this turns out to be too many branches. Now I am using a branch per course with dashes separating words, all lower case `course-name`

## Commits

**Commit frequency**

Following an answer in Stackoverflow [here](https://softwareengineering.stackexchange.com/a/74765), it recommends to commit every time a new test passes. Here is my guideline:

* When you modify a class or method
* When you refactor something
* When you add/delete/move a lot of files
* When you pass a test

**Commit message**

Use the subject only in one line with a shorter `issue-number` and a total of less than 50 characters (VSC shows a warning for this limit). Follow this template:

    issue-number: Imperative verb then short summary < 50 chars

Such as:

    java-OOP/4: Pass test for add method

Where:

* The issue number follows `branch/section_number`
* Then a colon `:`
* Action verb. For example `Pass`
* Then a summary in less than 50 characters

## Creating branches

**CLI**

    (main)$ git checkout -b branch-name 
    (react-BMP)$ git add .
    (react-BMP)$ git commit -m "Subject line"
    (react-BMP)$ git push -u origin branch-name

In GitHub create a PR and merge with main. If updating local main then:

    (react-BMP)$ git checkout main
    (main)$ git pull

**IntelliJ/PyCharm**

* Bottom right, click on `main`, click New Branch
* Make changes
* Left margin, click on tab `commit`
* Select files under Changes and Unversioned files
* Enter a message. Subject line, empty line, Body of commit
* Click Commit
* Top menu Git/Push

**VSC**

* Bottom left
* Click current branch
* On the overlay popup. Create new branch. Enter a name, press Enter.

## Made changes to wrong branch before committing

As seen in StackOverflow [here](https://stackoverflow.com/questions/7217894/moving-changed-files-to-another-branch-for-check-in). Use `git stash`.

	# worked on code...oops wrong branch, didn't commit yet
	git stash
	git checkout correct-branch
	git stash pop

The answer says that there is no need to use `stash` and instead use `git checkout -b correct-branch`. However, this doesn't work on the IntelliJ UI.

## Update local branch with remote main

Trying to figure out if this workflow makes sense or if it's incorrect:

1. My main branch is restricted (can't commit/push directly to remote)
2. Work on local feature branch `B1`, commit, push to remote, create PR
3. In GitHub, merge PR with main
4. Some changes were made to main, now my local `B1` is behind
5. How to update `B1` with remote main?
   * Do I switch to `main`, update with `git pull`, switch to `B1` and do `git merge main` or `git rebase main`?
   * Do I stay in `B1` and update with `git fetch; git rebase origin/main` or `git pull --rebase`?