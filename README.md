# Learning

This repo contains a summary of courses I am learning on my own and at Gatech.

Repo structure

    courses/
        gatech/
        own/
    reading/

(Note Gatech documentation contains what I can publish publicly to meet honor code)

**In Progress**

* Own
  * LL: Python TDD
  * LL: Full Stack Web Dev with Flask
  * Y: AWS Certified Cloud Practitioner
* Gatech
  * Software Architecture (6th class)

**Done**

* LL: IntelliJ Refresher
* LL: Java Essential Training (took in 2021, reviewed in 2022)
* LL: Python with PyCharm
* LL: Learning Python
* LL: Java OOP
* LL: Python with VSC
* LL: Python OOP
* W: Python Koans
* LL: SOLID Principles

**Backlog**

*Java*
* LL: Cucumber Essential Training (completed some)
* LL: Java Algorithms
* LL: Advanced Java Programming
* LL: Java Data Structures
* LL: Java Lambdas and Streams
* LL: Java and Docker
* LL: Java data structures and algorithms (this course is pure theory)
* LL: Java Objects and APIs
* LL: JUnit
* LL: Spring Boot
* LL: Java design patterns
* LL: React and Spring

*Python*

* LL: Python Data Structures and Algorithms

*Data Engineering*

* LL: Data engineering foundations
* LL: Apache Spark Essential Training
* LL: Introduction to Spark SQL and DataFrames
* LL: Apache PySpark by Example
* LL: Big data analytics with Hadoop and Apache Spark
* LL: Architecting big data applications: Batch mode application engineering
* LL: Architecting big data applications: Real time application engineering
* LL: Stream processing design patterns with spark
* LL: Cloud Hadoop: Scaling Apache Spark
* LL: Advanced Snowflake
* LL: Learning Terraform

*AWS*
* LL: Learning AWS for Developers
* LL: Amazon Web Services: Data Analytics
* LL: Amazon Web Services: Data Services

*DevOps*
* LL: Learning Kubernetes

*Analytics*
* LL: Statistics Foundations
* LL: Looker Studio for Beginners
* LL: Tableau Essential Training
* LL: Master SQL for Data Science

*JS*
* LL: JavaScript Essential Training
* LL: Learning the JavaScript Language
* LL: ReactJS Essential Training
* LL: ReactJS Building an Interface
* LL: Creating and Hosting a Full Stack Site
* LL: React Hooks
* LL: Building Modern Projects with React
* LL: React Design Patterns
* LL: React Software Architecture
* LL: React Authentication

Legend

* LL: Linkedin Learning
* ACG: A Cloud Guru
* Y: Youtube
* W: Web Tutorial

## Documenting

I didn't want to create a repo for each course. Instead, documenting all my learning in one big repo following this directory structure:

    Learning
        Course 1
            Code
            Readme
        Course 2
            Code
            Readme

## Course exercises

A course has many sections and each section has many videos. Each video follows an exercise and I have seen these variations:

* An exercise is built iteratively after each section.
* Different exercises are built in each section.
* Different exercises are built in each section's videos.

Organize exercises in packages by course sections, with template `S#_SectionName`. For example: 
`S1_Objects`, `S2_Inheritance`,..., etc.

**Java: Maven project with Cucumber**

Setup a Java project with Maven as seen in the Jetbrains docs [here](https://www.jetbrains.com/help/idea/convert-a-regular-project-into-a-maven-project.html#add_maven_support)

* After creating an IntelliJ project
* In the Project window. Right-click on the root folder
* Select Add Framework Support
* Select Maven

Project structure. Omit the parentheses.

	Course Name/
      README.md
	  Code/
	    src/
            main/
                java/
                    S1_SectionName/ (package)
                        exercise-name/ (package)
                            AJavaClass.java
                            Main.java
                resources/
                    data.txt
            test/
                java/
                    S1_SectionName/ (package)
                        exercise-name/ (package)
                            cucumber/ (package)
                                FeatureNameSteps.java
                                FeatureNameTest.java
                            ExerciseNameTest.java
                resources/
                    features/
                      S1_SectionName/ (directory)
                        exercise-name/ (directory)
                            FeatureName.feature

**Python**

Project structure. Omit the parentheses. Per PEP8. Packages (directories should be lowercase without underscores). Modules (files should be lowercase with underscores).

    Course Name/
        README.md
        Code/
            s1sectionname/ (package)
                exercisename/ (package)
                    app.py
                    __main__.py
                    src/ (package)
                        class-file (py file)
                    tests/ (package)
                    data/ (package, if needed)
                
                otherexercisename/ (package)

            s2othersectionname/
                ...

Inside `app.py` import other packages like this:

    from s1sectionname.exercisename.src.class-file import ClassName

    run():
        pass

Inside `__main__.py`. Enter the following:

    from s1sectionname.exercisename import app
    
    if __name__ == '__main__':
        app.run()


To run the app:

* In IntelliJ
  * Right click/run `__main__.py`

* In VSC
  * Open the terminal, go to the root directory. In above example this would be `cd Code`
  * Run as a module `python -m s1sectionname.exercisename`
  * If you Right click/run `main`, most likely you get `ModuleNotFoundError` if the imports use absolute paths.

* In the Terminal
  * Use absolute paths in the import
  * Run the same as VSC above

See more details about [setting a project in PyCharm](https://github.com/tomordonez/learning/tree/main/python-pycharm#setup-a-project).


## Testing/TDD

So far courses aren't in TDD or don't use testing.

**Learning with TDD**

Follow this learning methodology:

* Play/pause the video and take notes in the corresponding course README
* After the video is done, without looking at it, write the exercise using TDD
* Commit everytime a test passes
* Google things when feeling stuck
* Re-watch the video as a last resource.

**Test methods naming convention**

Use this format `methodName_StateUnderTest_ExpectedBehavior` with the exact letter casing and underscore. Such as:

    void getUsingMod_PositiveIndexInRange_IndexedItem()
    void getUsingMod_PositiveIndexOutOfRange_ModIndexedItem()
    void getUsingMod_NegativeIndex_ModIndexedItem()
    void getUsingMod_IndexIsAString_ExceptionThrown()

It follows the guideline from [this](https://osherove.com/blog/2005/4/3/naming-standards-for-unit-tests.html) blog post by Roy Osherove.

**Setup Java JUnit in IntelliJ**

* Use Maven
* Go to `pom.xml`, type `Alt+Insert` to add a dependency.
* Add `org.junit.jupiter:junit-jupiter`.
* Then reload the maven icon.


**Setup Python unittest in PyCharm**

Create a `tests` package directory

Go to a class. Right-click. `Go to` and select `Test`.

* Create a test case per class
* Import `from unittest import TestCase`
* Import `from unittest.mock import Mock, patch`


**Setup Python unittest in VSC**

Full details in `courses/own/python-tdd/`

## Testing/BDD

**Setup Cucumber in IntelliJ**

I wrote a detailed blog post about it here: [BDD with Cucumber in IntelliJ](https://www.tomordonez.com/bdd-cucumber-intellij/)

## Branches

I went through a few workflows for creating branches. I tried `course/section/summary` but this turns out to be too many branches.

Now I am using a branch per course with dashes separating words, all lower case.

**Branch name**

    course-name

## Commits

**Commit frequency**

Following an answer in Stackoverflow [here](https://softwareengineering.stackexchange.com/a/74765).

Commit every time a new test passes. I would add:

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

### Creating branches

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