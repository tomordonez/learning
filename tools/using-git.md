# Using Git

## Workflow Summary

1. Work on a branch (named after a topic directory)
   1. Don't modify files that don't belong to the branch/course/topic
   2. Don't forget to switch branches to commit to different course/topic
2. Commit frequently
   1. Commit the changes in the branch before switching branches
3. Push all branches to remote `git push --all origin`
4. In remote, PR and merge all branches
5. Back in local, rebase all branches
   1. Switch to a branch, then `git rebase origin/main`

## Branches

Use a branch per topic directory

## Commits

**Commit frequency**

Commit frequently on the corresponding branch. Don't update files that don't belong to the branch.

* When you modify a class or method
* When you refactor something
* When you add/delete/move a lot of files
* When you pass a test
* When you create/update documentation

**Commit message**

In general:

* One line and less than 50 characters (VSC shows a warning limit)
* Start with an imperative verb (present tense)
* Then short summary

If using JIRA:

* Use the syntax `issue-number: message`

(Optional) if following a course with sections:

* Although the norm is to stick to only changing files that correspond to the branch
* Use the prefix `course-directory/chapter-number: message` such as `java-oop/4: Pass test for add method`

## Creating branches

**CLI**

    (main)$ git checkout -b branch-name 
    (branch-name)$ git add .
    (branch-name)$ git commit -m "Subject line"
    (branch-name)$ git push -u origin branch-name

In GitHub create a PR and merge with main. If updating local main then:

    (branch-name)$ git checkout main
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

**Terminal**

	git checkout my-branch
	git rebase origin/main

If rebase can't be done:

	git checkout main
	git pull
	git checkout my-branch
	git merge main

**IntelliJ**

This doesn't work as expected. I asked in StackOverflow [here](https://stackoverflow.com/questions/75355160/how-to-update-local-branch-with-remote-main-in-intellij), however, one answer didn't work, and the other wasn't related to IntelliJ, just recommended to use the terminal.

1. Go to `main` branch
2. Top menu `Git/pull`
3. Navigate to `my-branch` drop down menu
4. Select `rebase main to my-branch`
5. Switch to `my-branch`